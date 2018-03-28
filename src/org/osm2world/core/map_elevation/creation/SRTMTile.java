package org.osm2world.core.map_elevation.creation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;

/**
 * a single SRTM data tile.
 * 
 * Multiple such tiles are used by {@link SRTMData} to build coverage
 * for larger regions.
 */
class SRTMTile {

	/** value indicating a lack of data */
	public static final short BLANK_VALUE = -32768;
	
	/** Possible values for the number of pixels of the SRTM tile */
	static final int N_PIXELS_30M = 3601;
	static final int N_PIXELS_90M = 1201;
	
	/** length of each dimension of an SRTM tile in pixels */
	static int PIXELS = N_PIXELS_90M; //Safety net
		
	public final File file;
	private final ShortBuffer data;
	
	public SRTMTile(File file) throws IOException {
		
		this.file = file;
		
		data = loadDataFromFile(file);
				
	}

	private static ShortBuffer loadDataFromFile(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();
		//Set dimension size depending on size of SRTM file:
		switch ((int)fc.size()) {
			case N_PIXELS_30M * N_PIXELS_30M * 2:
				PIXELS = N_PIXELS_30M;
				System.out.println("SRTM file contains 30m data");
				break;
			case N_PIXELS_90M * N_PIXELS_90M * 2:
				System.out.println("SRTM file contains 90m data");
				PIXELS = N_PIXELS_90M;
				break;
			default:
				System.err.println("Warning: size of SRTM file: " + file.getName() + " is: " + fc.size() + " bytes, which doesn't correspond with 30m or 90m SRTM data");
				fc.close();
				fis.close();
				throw new IOException();
		}
		ByteBuffer bb = ByteBuffer.allocateDirect((int) fc.size());
		while (bb.remaining() > 0) fc.read(bb);
		fc.close();
		fis.close();
		
		bb.flip();
		
		// choose the right endianness
		return bb.order(ByteOrder.BIG_ENDIAN).asShortBuffer();
		
	}
	
	public final short getData(int x, int y) {
		assert 0 <= x && x < PIXELS && 0 <= y && y < PIXELS;
		return data.get((PIXELS - 1 - y) * PIXELS + x);
	}
	
	@Override
	public String toString() {
		return file.getName();
	}
	
}
