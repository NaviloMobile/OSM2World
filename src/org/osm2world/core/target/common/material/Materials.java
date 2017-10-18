package org.osm2world.core.target.common.material;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.Configuration;
import org.openstreetmap.josm.plugins.graphview.core.data.Tag;
import org.osm2world.core.target.common.TextureData;
import org.osm2world.core.target.common.TextureData.Wrap;
import org.osm2world.core.target.common.material.Material.AmbientOcclusion;
import org.osm2world.core.target.common.material.Material.Interpolation;
import org.osm2world.core.target.common.material.Material.Shadow;
import org.osm2world.core.target.common.material.Material.Transparency;
import org.osm2world.core.util.ConfigUtil;
import org.osm2world.core.world.creation.WorldModule;

/**
 * this class defines materials that can be used by all {@link WorldModule}s
 */
public final class Materials {
	
	/** prevents instantiation */
	private Materials() {}
	
	/** material for "empty" ground */
	public static final ConfMaterial TERRAIN_DEFAULT =
		new ConfMaterial(Interpolation.SMOOTH, Color.GREEN);
	
	public static final ConfMaterial WATER =
		new ConfMaterial(Interpolation.FLAT, Color.BLUE);
	public static final ConfMaterial PURIFIED_WATER =
			new ConfMaterial(Interpolation.FLAT, Color.BLUE);
	
	public static final ConfMaterial ASPHALT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.3f, 0.3f));
	public static final ConfMaterial BRICK =
		new ConfMaterial(Interpolation.FLAT, new Color(1.0f, 0.5f, 0.25f));
	public static final ConfMaterial COBBLESTONE =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.3f, 0.3f));
	public static final ConfMaterial CONCRETE =
		new ConfMaterial(Interpolation.FLAT, new Color(0.55f, 0.55f, 0.55f));
	public static final ConfMaterial EARTH =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0, 0));
	public static final ConfMaterial GLASS =
		new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial GRASS =
		new ConfMaterial(Interpolation.FLAT, new Color(0.0f, 0.8f, 0.0f));
	public static final ConfMaterial GRASS_PAVER =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.5f, 0.3f));
	public static final ConfMaterial SCRUB =
		new ConfMaterial(Interpolation.FLAT, new Color(0.0f, 0.8f, 0.0f));
	public static final ConfMaterial GRAVEL =
		new ConfMaterial(Interpolation.FLAT, new Color(0.4f, 0.4f, 0.4f));
	public static final ConfMaterial PAVING_STONE =
			new ConfMaterial(Interpolation.FLAT, new Color(0.4f, 0.4f, 0.4f));
	public static final ConfMaterial PEBBLESTONE =
			new ConfMaterial(Interpolation.FLAT, new Color(0.4f, 0.4f, 0.4f));
	public static final ConfMaterial PLASTIC =
			new ConfMaterial(Interpolation.FLAT, new Color(0, 0, 0));
	public static final ConfMaterial PLASTIC_GREY =
			new ConfMaterial(Interpolation.FLAT, new Color(184, 184, 184));
	public static final ConfMaterial SAND =
		new ConfMaterial(Interpolation.FLAT, new Color(241, 233, 80));
	public static final ConfMaterial STEEL =
		new ConfMaterial(Interpolation.FLAT, new Color(200, 200, 200));
	public static final ConfMaterial WOOD =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial WOOD_WALL =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial TARTAN =
		new ConfMaterial(Interpolation.FLAT, new Color(206, 109, 90));
	
	public static final ConfMaterial ROAD_MARKING =
		new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_DASHED =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_ZEBRA =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_CROSSING =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_ARROW_THROUGH =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_ARROW_THROUGH_RIGHT =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_ARROW_RIGHT =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ROAD_MARKING_ARROW_RIGHT_LEFT =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial RED_ROAD_MARKING =
			new ConfMaterial(Interpolation.FLAT, new Color(0.6f, 0.3f, 0.3f));
	public static final ConfMaterial KERB =
			new ConfMaterial(Interpolation.FLAT, new Color(0.4f, 0.4f, 0.4f));
	public static final ConfMaterial STEPS_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.DARK_GRAY);
	public static final ConfMaterial HANDRAIL_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.LIGHT_GRAY);
		
	public static final ConfMaterial RAIL_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.LIGHT_GRAY);
	public static final ConfMaterial RAIL_SLEEPER_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial RAIL_BALLAST_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.DARK_GRAY);
	
	public static final ConfMaterial BUILDING_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, new Color(1f, 0.9f, 0.55f));
	public static final ConfMaterial BUILDING_WINDOWS =
		new ConfMaterial(Interpolation.FLAT, new Color(1f, 0.9f, 0.55f));
	public static final ConfMaterial ROOF_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.8f, 0, 0));
	public static final ConfMaterial GLASS_ROOF =
			new ConfMaterial(Interpolation.FLAT, new Color(0.9f, 0.9f, 0.9f));
	public static final ConfMaterial ENTRANCE_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.2f, 0, 0));
	public static final ConfMaterial GARAGE_DOORS =
			new ConfMaterial(Interpolation.FLAT, new Color(1f, 0.9f, 0.55f));
	
	public static final ConfMaterial WALL_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.GRAY);
	public static final ConfMaterial WALL_GABION =
		new ConfMaterial(Interpolation.FLAT, Color.GRAY);
	
	public static final ConfMaterial HEDGE =
		new ConfMaterial(Interpolation.FLAT, new Color(0,0.5f,0));
	
	public static final ConfMaterial FENCE_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial SPLIT_RAIL_FENCE =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial CHAIN_LINK_FENCE =
		new ConfMaterial(Interpolation.FLAT, new Color(188, 198, 204));
	public static final ConfMaterial METAL_FENCE =
		new ConfMaterial(Interpolation.FLAT, new Color(188, 198, 204));
	public static final ConfMaterial METAL_FENCE_POST =
		new ConfMaterial(Interpolation.FLAT, new Color(188, 198, 204));
		
	public static final ConfMaterial BRIDGE_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.GRAY);
	public static final ConfMaterial BRIDGE_PILLAR_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.GRAY);
	
	public static final ConfMaterial TUNNEL_DEFAULT =
		new ConfMaterial(Interpolation.FLAT, Color.GRAY, 0.2f, 0.5f,
				Transparency.FALSE, Collections.<TextureData>emptyList());
	
	public static final ConfMaterial TREE_TRUNK =
		new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.2f, 0.2f));
	public static final ConfMaterial TREE_CROWN =
		new ConfMaterial(Interpolation.SMOOTH, new Color(0, 0.5f, 0));
	public static final ConfMaterial TREE_BILLBOARD_BROAD_LEAVED =
		new ConfMaterial(Interpolation.FLAT, new Color(0, 0.5f, 0), 1f, 0f,
				Transparency.FALSE, Collections.<TextureData>emptyList());
	public static final ConfMaterial TREE_BILLBOARD_BROAD_LEAVED_FRUIT =
		new ConfMaterial(Interpolation.FLAT, new Color(0, 0.5f, 0), 1f, 0f,
				Transparency.FALSE, Collections.<TextureData>emptyList());
	public static final ConfMaterial TREE_BILLBOARD_CONIFEROUS =
		new ConfMaterial(Interpolation.FLAT, new Color(0, 0.5f, 0), 1f, 0f,
				Transparency.FALSE, Collections.<TextureData>emptyList());
	
	public static final ConfMaterial POWER_TOWER_VERTICAL =
		new ConfMaterial(Interpolation.FLAT, new Color(.7f, .7f, .7f), 1f, 0f,
				Transparency.BINARY, Collections.<TextureData>emptyList());
	public static final ConfMaterial POWER_TOWER_HORIZONTAL =
			new ConfMaterial(Interpolation.FLAT, new Color(.7f, .7f, .7f), 1f, 0f,
					Transparency.BINARY, Collections.<TextureData>emptyList());
	
	public static final ConfMaterial ADVERTISING_POSTER =
		new ConfMaterial(Interpolation.FLAT, new Color(1, 1, 0.8f));
	
	public static final ConfMaterial BUS_STOP_SIGN =
		new ConfMaterial(Interpolation.FLAT, new Color(0.98f, 0.90f, 0.05f));
	
	public static final ConfMaterial SIGN_DE_250 =
		new ConfMaterial(Interpolation.FLAT, Color.RED);

	public static final ConfMaterial SIGN_DE_206 =
		new ConfMaterial(Interpolation.FLAT, Color.RED);
	
	public static final ConfMaterial SIGN_DE_625_11 =
		new ConfMaterial(Interpolation.FLAT, Color.WHITE);
	
	public static final ConfMaterial SIGN_DE_625_21 =
			new ConfMaterial(Interpolation.FLAT, Color.WHITE);
	
	public static final ConfMaterial GRITBIN_DEFAULT =
			new ConfMaterial(Interpolation.FLAT, new Color(0.3f, 0.5f, 0.4f));
	
	public static final ConfMaterial POSTBOX_DEUTSCHEPOST =
			new ConfMaterial(Interpolation.FLAT, new Color(1f, 0.8f, 0f));
	public static final ConfMaterial POSTBOX_ROYALMAIL =
			new ConfMaterial(Interpolation.FLAT, new Color(0.8f, 0, 0));
	public static final ConfMaterial TELEKOM_MANGENTA =
			new ConfMaterial(Interpolation.FLAT, new Color(0.883f, 0f, 0.453f));
	
	public static final ConfMaterial FIREHYDRANT =
		new ConfMaterial(Interpolation.FLAT, new Color(0.8f, 0, 0));

	public static final ConfMaterial SOLAR_PANEL =
			new ConfMaterial(Interpolation.FLAT, Color.BLUE);
	
	public static final ConfMaterial SKYBOX =
		new ConfMaterial(Interpolation.FLAT, new Color(0, 0, 1),
				1, 0, Transparency.FALSE, null);
	
	//Additional materials for aligning colours with 2D maps (from https://github.com/gravitystorm/openstreetmap-carto/blob/master/landcover.mss)
	// --- Parks, woods, other green things ---
	/*public static final ConfMaterial GRASS =
			new ConfMaterial(Interpolation.FLAT, new Color(0xcdebb0));*/ // also meadow, common, garden, village_green
	public static final ConfMaterial FOREST =
			new ConfMaterial(Interpolation.FLAT, new Color(0xadd19e));
	public static final ConfMaterial FOREST_TEXT =
			new ConfMaterial(Interpolation.FLAT, new Color(0x46673b));
	public static final ConfMaterial PARK =
			new ConfMaterial(Interpolation.FLAT, new Color(0xc8facc));         // Lch(94,30,145) also recreation_ground
	public static final ConfMaterial PLAYGROUND =
			new ConfMaterial(Interpolation.FLAT, new Color(0xc8facc));
	public static final ConfMaterial ORCHARD =
			new ConfMaterial(Interpolation.FLAT, new Color(0xaedfa3)); // also vineyard, plant_nursery
	// --- "Base" landuses ---
	public static final ConfMaterial RESIDENTIAL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe0dfdf));      // Lch(89,0,0)
	public static final ConfMaterial RESIDENTIAL_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xb9b9b9)); // Lch(75,0,0)
	public static final ConfMaterial RETAIL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xffd6d1));           // Lch(89,16,30)
	public static final ConfMaterial RETAIL_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd99c95));      // Lch(70,25,30)
	public static final ConfMaterial COMMERCIAL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf2dad9));       // Lch(89,8.5,25)
	public static final ConfMaterial COMMERCIAL_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd1b2b0));  // Lch(75,12,25)
	public static final ConfMaterial INDUSTRIAL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xebdbe8));       // Lch(89,9,330) (Also used for railway)
	public static final ConfMaterial POWER =
			new ConfMaterial(Interpolation.FLAT, new Color(0xebdbe8));
	public static final ConfMaterial RAILWAY =
			new ConfMaterial(Interpolation.FLAT, new Color(0xebdbe8));
	public static final ConfMaterial INDUSTRIAL_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xc6b3c3));  // Lch(75,11,330) (Also used for railway-line)
	public static final ConfMaterial RAILWAY_LINE = 
			new ConfMaterial(Interpolation.FLAT, new Color(0xc6b3c3));
	public static final ConfMaterial POWER_LINE = 
			new ConfMaterial(Interpolation.FLAT, new Color(0xc6b3c3));
	public static final ConfMaterial FARMLAND =
			new ConfMaterial(Interpolation.FLAT, new Color(0xfbecd7));         // Lch(94,12,80)
	public static final ConfMaterial FARMLAND_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd6c4ab));    // Lch(80,15,80)
	public static final ConfMaterial FARMYARD =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf5dcba));         // Lch(89,20,80)
	public static final ConfMaterial FARMYARD_LINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd1b48c));    // Lch(75,25,80)
	// --- Transport ----
	public static final ConfMaterial AERODROME =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe9e7e2));
	public static final ConfMaterial APRON =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe9d1ff));
	public static final ConfMaterial GARAGES =
			new ConfMaterial(Interpolation.FLAT, new Color(0xdfddce));
	public static final ConfMaterial PARKING =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf7efb7));
	public static final ConfMaterial REST_AREA =
			new ConfMaterial(Interpolation.FLAT, new Color(0xefc8c8)); // also services
	public static final ConfMaterial STATION =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd4aaaa));
	// --- Other ----
	public static final ConfMaterial ALLOTMENTS =
			new ConfMaterial(Interpolation.FLAT, new Color(0xeecfb3));       // Lch(85,19,70)
	public static final ConfMaterial BARE_GROUND =
			new ConfMaterial(Interpolation.FLAT, new Color(0xeee5dc));
	public static final ConfMaterial CAMPSITE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xdef6c0)); // also caravan_site, picnic_site
	public static final ConfMaterial CEMETERY =
			new ConfMaterial(Interpolation.FLAT, new Color(0xaacbaf)); // also grave_yard
	public static final ConfMaterial CONSTRUCTION =
			new ConfMaterial(Interpolation.FLAT, new Color(0xc7c7b4)); // also brownfield
	public static final ConfMaterial DANGER_AREA =
			new ConfMaterial(Interpolation.FLAT, Color.PINK);
	public static final ConfMaterial HEATH =
			new ConfMaterial(Interpolation.FLAT, new Color(0xd6d99f));
	public static final ConfMaterial MUD =
			new ConfMaterial(Interpolation.FLAT, new Color(203,177,154,(int)(0.3*255))); // produces #e6dcd1 over public static final ConfMaterial land
	public static final ConfMaterial PLACE_OF_WORSHIP =
			new ConfMaterial(Interpolation.FLAT, new Color(0xcdccc9));
	public static final ConfMaterial PLACE_OF_WORSHIP_OUTLINE =
			new ConfMaterial(Interpolation.FLAT, new Color(0x111));
	/*public static final ConfMaterial SAND =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf5e9c6));*/
	public static final ConfMaterial SOCIETAL_AMENITIES =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf0f0d8));
	public static final ConfMaterial STADIUM =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf0f0d8)); // also fitness_centre and sports_centre
	public static final ConfMaterial TOURISM =
			new ConfMaterial(Interpolation.FLAT, new Color(0x734a08));
	public static final ConfMaterial QUARRY =
			new ConfMaterial(Interpolation.FLAT, new Color(0xc5c3c3));
	public static final ConfMaterial MILITARY =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf55));
	public static final ConfMaterial BEACH =
			new ConfMaterial(Interpolation.FLAT, new Color(0xfff1ba));
	// --- Sports ---
	public static final ConfMaterial PITCH =
			new ConfMaterial(Interpolation.FLAT, new Color(0xaae0cb)); // also track
	public static final ConfMaterial TRACK = 
			new ConfMaterial(Interpolation.FLAT, new Color(0xaae0cb));
	public static final ConfMaterial GOLF_COURSE =
			new ConfMaterial(Interpolation.FLAT, new Color(0xb5e3b5));
	// From https://github.com/gravitystorm/openstreetmap-carto/blob/master/road-colors-generated.mss
	// and https://github.com/gravitystorm/openstreetmap-carto/blob/master/roads.mss
	public static final ConfMaterial MOTORWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe892a2));
	public static final ConfMaterial TRUNK_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf9b29c));
	public static final ConfMaterial PRIMARY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xfcd6a4));
	public static final ConfMaterial SECONDARY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xf7fabf));
	public static final ConfMaterial TERTIARY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xffffff));
	public static final ConfMaterial RESIDENTIAL_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xffffff));
	public static final ConfMaterial RESIDENTIAL_AREA_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe0dfdf));
	public static final ConfMaterial SERVICE_FILL = 
			new ConfMaterial(Interpolation.FLAT, new Color(0xffffff));
	public static final ConfMaterial LIVING_STREET_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xededed));
	public static final ConfMaterial PEDESTRIAN_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xededed));
	public static final ConfMaterial RACEWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, Color.PINK);
	public static final ConfMaterial FOOTWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xff8c69)); //salmon
	public static final ConfMaterial CYCLEWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, Color.BLUE);
	public static final ConfMaterial BRIDLEWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, Color.GREEN);
	public static final ConfMaterial TRACK_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xe2c5bb));
	public static final ConfMaterial AEROWAY_FILL =
			new ConfMaterial(Interpolation.FLAT, new Color(0xbbc));
	
	private static final Map<String, ConfMaterial> surfaceMaterialMap =
		new HashMap<String, ConfMaterial>();
	private static final Map<ConfMaterial, String> fieldNameMap =
		new HashMap<ConfMaterial, String>();
	
	static {
		
		surfaceMaterialMap.put("asphalt", ASPHALT);
		surfaceMaterialMap.put("cobblestone", COBBLESTONE);
		surfaceMaterialMap.put("compacted", GRAVEL);
		surfaceMaterialMap.put("concrete", CONCRETE);
		surfaceMaterialMap.put("grass", GRASS);
		surfaceMaterialMap.put("gravel", GRAVEL);
		surfaceMaterialMap.put("grass_paver", GRASS_PAVER);
		surfaceMaterialMap.put("ground", EARTH);
		surfaceMaterialMap.put("paved", ASPHALT);
		surfaceMaterialMap.put("paving_stones", PAVING_STONE);
		surfaceMaterialMap.put("pebblestone", PEBBLESTONE);
		surfaceMaterialMap.put("sand", SAND);
		surfaceMaterialMap.put("steel", STEEL);
		surfaceMaterialMap.put("tartan", TARTAN);
		surfaceMaterialMap.put("unpaved", EARTH);
		surfaceMaterialMap.put("wood", WOOD);
		surfaceMaterialMap.put("scrub", SCRUB);
		//The ones from landcover.mss
		surfaceMaterialMap.put("grass", GRASS);
		surfaceMaterialMap.put("scrub", SCRUB);
		surfaceMaterialMap.put("forest", FOREST);
		surfaceMaterialMap.put("forest-text", FOREST_TEXT);
		surfaceMaterialMap.put("park", PARK);
		surfaceMaterialMap.put("orchard", ORCHARD);
		surfaceMaterialMap.put("residential", RESIDENTIAL);
		surfaceMaterialMap.put("residential-line", RESIDENTIAL_LINE);
		surfaceMaterialMap.put("retail", RETAIL);
		surfaceMaterialMap.put("retail-line", RETAIL_LINE);
		surfaceMaterialMap.put("commercial", COMMERCIAL);
		surfaceMaterialMap.put("commercial-line", COMMERCIAL_LINE);
		surfaceMaterialMap.put("industrial", INDUSTRIAL);
		surfaceMaterialMap.put("industrial-line", INDUSTRIAL_LINE);
		surfaceMaterialMap.put("farmland", FARMLAND);
		surfaceMaterialMap.put("farmland-line", FARMLAND_LINE);
		surfaceMaterialMap.put("farmyard", FARMYARD);
		surfaceMaterialMap.put("farmyard-line", FARMLAND_LINE);
		surfaceMaterialMap.put("aerodrome", AERODROME);
		surfaceMaterialMap.put("apron", APRON);
		surfaceMaterialMap.put("garages", GARAGES);
		surfaceMaterialMap.put("parking", PARKING);
		surfaceMaterialMap.put("railway", RAILWAY);
		surfaceMaterialMap.put("railway-line", RAILWAY_LINE);
		surfaceMaterialMap.put("rest_area", REST_AREA);
		surfaceMaterialMap.put("station", STATION);
		surfaceMaterialMap.put("allotments", ALLOTMENTS);
		surfaceMaterialMap.put("bare_ground", BARE_GROUND);
		surfaceMaterialMap.put("campsite", CAMPSITE);
		surfaceMaterialMap.put("cemetery", CEMETERY);
		surfaceMaterialMap.put("construction", CONSTRUCTION);
		surfaceMaterialMap.put("danger_area", DANGER_AREA);
		surfaceMaterialMap.put("heath", HEATH);
		surfaceMaterialMap.put("mud", MUD);
		surfaceMaterialMap.put("place_of_worship", PLACE_OF_WORSHIP);
		surfaceMaterialMap.put("place_of_worship_outline", PLACE_OF_WORSHIP_OUTLINE);
		surfaceMaterialMap.put("playground", PLAYGROUND);
		surfaceMaterialMap.put("power", POWER);
		surfaceMaterialMap.put("power-line", POWER_LINE);
		surfaceMaterialMap.put("sand", SAND);
		surfaceMaterialMap.put("societal_amenities", SOCIETAL_AMENITIES);
		surfaceMaterialMap.put("tourism", TOURISM);
		surfaceMaterialMap.put("quarry", QUARRY);
		surfaceMaterialMap.put("military", MILITARY);
		surfaceMaterialMap.put("beach", BEACH);
		surfaceMaterialMap.put("pitch", PITCH);
		surfaceMaterialMap.put("track", TRACK);
		surfaceMaterialMap.put("stadium", STADIUM);
		surfaceMaterialMap.put("golf_course", GOLF_COURSE);
		
		surfaceMaterialMap.put("motorway", MOTORWAY_FILL);
		surfaceMaterialMap.put("trunk", TRUNK_FILL);
		surfaceMaterialMap.put("primary", PRIMARY_FILL);
		surfaceMaterialMap.put("secondary", SECONDARY_FILL);
		surfaceMaterialMap.put("tertiary", TERTIARY_FILL);
		surfaceMaterialMap.put("residential", RESIDENTIAL_FILL);
		surfaceMaterialMap.put("residential_area", RESIDENTIAL_AREA_FILL);
		surfaceMaterialMap.put("service", SERVICE_FILL);
		surfaceMaterialMap.put("living-street", LIVING_STREET_FILL);
		surfaceMaterialMap.put("pedestrian", PEDESTRIAN_FILL);
		surfaceMaterialMap.put("raceway", RACEWAY_FILL);
		surfaceMaterialMap.put("footway", FOOTWAY_FILL);
		surfaceMaterialMap.put("cycleway", CYCLEWAY_FILL);
		surfaceMaterialMap.put("bridleway", BRIDLEWAY_FILL);
		surfaceMaterialMap.put("track", TRACK_FILL);
		surfaceMaterialMap.put("aeroway", AEROWAY_FILL);		
		
		
		try {
			for (Field field : Materials.class.getFields()) {
				if (field.getType().equals(ConfMaterial.class)) {
					fieldNameMap.put(
							(ConfMaterial)field.get(null),
							field.getName());
				}
			}
		} catch (Exception e) {
			throw new Error(e);
		}
		
	}

	/** assumptions about default surfaces for certain tags */
	public static final Map<Tag, String> defaultSurfaceMap
		= new HashMap<Tag, String>();
	
	static {
		defaultSurfaceMap.put(new Tag("leisure", "pitch"), "ground");
		defaultSurfaceMap.put(new Tag("landuse", "construction"), "ground");
		defaultSurfaceMap.put(new Tag("golf", "bunker"), "sand");
		defaultSurfaceMap.put(new Tag("golf", "green"), "grass");
		defaultSurfaceMap.put(new Tag("natural", "sand"), "sand");
		defaultSurfaceMap.put(new Tag("natural", "beach"), "sand");
		defaultSurfaceMap.put(new Tag("landuse", "meadow"), "grass");
		defaultSurfaceMap.put(new Tag("landuse", "grass"), "grass");
		defaultSurfaceMap.put(new Tag("natural", "scrub"), "scrub");
		//Trying to copy the colours/materials in http://wiki.openstreetmap.org/wiki/Standard_tile_layer/Key
		//and https://github.com/gravitystorm/openstreetmap-carto/blob/master/landcover.mss :
		defaultSurfaceMap.put(new Tag("natural", "wood"), "forest");
		defaultSurfaceMap.put(new Tag("natural", "grassland"), "grass");
		defaultSurfaceMap.put(new Tag("natural", "heath"), "heath");
		defaultSurfaceMap.put(new Tag("natural", "sand"), "sand");
		defaultSurfaceMap.put(new Tag("natural", "beach"), "beach");
		defaultSurfaceMap.put(new Tag("natural", "bare_rock"), "bare_ground");
		defaultSurfaceMap.put(new Tag("natural", "scree"), "bare_ground");
		defaultSurfaceMap.put(new Tag("natural", "shingle"), "bare_ground");
		defaultSurfaceMap.put(new Tag("wetland", "bog"), "heath");
		defaultSurfaceMap.put(new Tag("wetland", "string_bog"), "heath");
		defaultSurfaceMap.put(new Tag("wetland", "wet_meadow"), "grass");
		defaultSurfaceMap.put(new Tag("wetland", "fen"), "grass");
		defaultSurfaceMap.put(new Tag("wetland", "marsh"), "grass");
		defaultSurfaceMap.put(new Tag("landuse", "residential"), "residential_area");
		defaultSurfaceMap.put(new Tag("landuse", "garages"), "residential_area");
		defaultSurfaceMap.put(new Tag("landuse", "allotments"), "allotments");
		defaultSurfaceMap.put(new Tag("landuse", "forest"), "forest");
		defaultSurfaceMap.put(new Tag("landuse", "farmyard"), "farmyard");
		defaultSurfaceMap.put(new Tag("landuse", "farm"), "farmland");
		defaultSurfaceMap.put(new Tag("landuse", "farmland"), "farmland");
		defaultSurfaceMap.put(new Tag("landuse", "greenhouse_horticulture"), "farmland");
		defaultSurfaceMap.put(new Tag("landuse", "recreation_ground"), "grass");
		defaultSurfaceMap.put(new Tag("landuse", "village_green"), "grass");
		defaultSurfaceMap.put(new Tag("landuse", "retail"), "retail");
		defaultSurfaceMap.put(new Tag("landuse", "industrial"), "industrial");
		defaultSurfaceMap.put(new Tag("landuse", "railway"), "railway");
		defaultSurfaceMap.put(new Tag("landuse", "commercial"), "commercial");
		defaultSurfaceMap.put(new Tag("landuse", "brownfield"), "construction");
		defaultSurfaceMap.put(new Tag("landuse", "construction"), "construction");
		defaultSurfaceMap.put(new Tag("landuse", "cemetery"), "cemetery");
		defaultSurfaceMap.put(new Tag("landuse", "orchard"), "orchard");
		defaultSurfaceMap.put(new Tag("landuse", "vineyard"), "orchard");
		defaultSurfaceMap.put(new Tag("landuse", "plant_nursery"), "orchard");
		defaultSurfaceMap.put(new Tag("landuse", "quarry"), "quarry");
		defaultSurfaceMap.put(new Tag("aeroway", "apron"), "apron");
		defaultSurfaceMap.put(new Tag("aeroway", "aerodrome"), "aerodrome");
		defaultSurfaceMap.put(new Tag("amenity", "parking"), "parking");
		defaultSurfaceMap.put(new Tag("leisure", "common"), "grass");
		defaultSurfaceMap.put(new Tag("leisure", "garden"), "grass");
		defaultSurfaceMap.put(new Tag("leisure", "swimming_pool"), "water");
		defaultSurfaceMap.put(new Tag("leisure", "playground"), "playground");
		defaultSurfaceMap.put(new Tag("wetland", "mud"), "mud");
		defaultSurfaceMap.put(new Tag("wetland", "tidalflat"), "mud");
		
		defaultSurfaceMap.put(new Tag("highway", "motorway"), "motorway");
		defaultSurfaceMap.put(new Tag("highway", "motorway_link"), "motorway");
		defaultSurfaceMap.put(new Tag("highway", "trunk"), "trunk");
		defaultSurfaceMap.put(new Tag("highway", "trunk_link"), "trunk");
		defaultSurfaceMap.put(new Tag("highway", "primary"), "primary");
		defaultSurfaceMap.put(new Tag("highway", "primary_link"), "primary");
		defaultSurfaceMap.put(new Tag("highway", "secondary"), "secondary");
		defaultSurfaceMap.put(new Tag("highway", "secondary_link"), "secondary");
		defaultSurfaceMap.put(new Tag("highway", "tertiary"), "tertiary");
		defaultSurfaceMap.put(new Tag("highway", "tertiary_link"), "tertiary");
		defaultSurfaceMap.put(new Tag("highway", "unclassified"), "tertiary");
		defaultSurfaceMap.put(new Tag("highway", "residential"), "residential");
		defaultSurfaceMap.put(new Tag("highway", "service"), "service");
		defaultSurfaceMap.put(new Tag("highway", "living-street"), "living-street");
		defaultSurfaceMap.put(new Tag("highway", "pedestrian"), "pedestrian");
		defaultSurfaceMap.put(new Tag("highway", "raceway"), "raceway");
		defaultSurfaceMap.put(new Tag("highway", "footway"), "footway");
		defaultSurfaceMap.put(new Tag("highway", "cycleway"), "cycleway");
		defaultSurfaceMap.put(new Tag("highway", "bridleway"), "bridleway");
		defaultSurfaceMap.put(new Tag("highway", "track"), "track");
		defaultSurfaceMap.put(new Tag("highway", "aeroway"), "aeroway");
	}
	/** returns all materials defined here */
	public static final Collection<ConfMaterial> getMaterials() {
		return fieldNameMap.keySet();
	}

	/** returns a material defined here based on its field name */
	public static final ConfMaterial getMaterial(String fieldName) {
		for (Entry<ConfMaterial, String> entry : fieldNameMap.entrySet()) {
			if (entry.getValue().equals(fieldName)) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/** returns a material for a surface value; null if none is found */
	public static final Material getSurfaceMaterial(String value) {
		return getSurfaceMaterial(value, null);
	}
	
	/** same as {@link #getSurfaceMaterial(String)}, but with fallback value */
	public static final Material getSurfaceMaterial(String value,
			Material fallback) {
		Material material = surfaceMaterialMap.get(value);
		if (material != null) {
			return material;
		} else {
			return fallback;
		}
	}
	
	/**
	 * returns a human-readable, unique name for a material defined
	 * within this class, null for all other materials.
	 */
	public static final String getUniqueName(Material material) {
		return fieldNameMap.get(material);
	}
	
	private static final String CONF_KEY_REGEX =
			"material_(.+)_(color|specular|shininess|shadow|ssao|transparency|texture\\d*_(?:file|width|height|bumpmap))";
	
	/**
	 * configures the attributes of the materials within this class
	 * based on external configuration settings
	 */
	public static final void configureMaterials(Configuration config) {
		
		// unchecked type parameter necessary due to Apache libs' old interface
		@SuppressWarnings("unchecked")
		Iterator<String> keyIterator = config.getKeys();
		
		while (keyIterator.hasNext()) {
			
			String key = keyIterator.next();
			
			Matcher matcher = Pattern.compile(CONF_KEY_REGEX).matcher(key);
			
			if (matcher.matches()) {
				
				String materialName = matcher.group(1);
				ConfMaterial material = getMaterial(materialName);
				
				if (material != null) {
				
					String attribute = matcher.group(2);
					
					if ("color".equals(attribute)) {
						
						Color color = ConfigUtil.parseColor(
								config.getString(key));
						
						if (color != null) {
							material.setColor(color);
						} else {
							System.err.println("incorrect color value: "
									+ config.getString(key));
						}
						
					} else if ("specular".equals(attribute)) {
						
						float specular = config.getFloat(key);
						material.setSpecularFactor(specular);
						
					} else if ("shininess".equals(attribute)) {
						
						int shininess = config.getInt(key);
						material.setShininess(shininess);
						
					} else if ("shadow".equals(attribute)) {
						
						String value = config.getString(key).toUpperCase();
						Shadow shadow = Shadow.valueOf(value);
						
						if (shadow != null) {
							material.setShadow(shadow);
						}
						
					} else if ("ssao".equals(attribute)) {
						
						String value = config.getString(key).toUpperCase();
						AmbientOcclusion ao = AmbientOcclusion.valueOf(value);
						
						if (ao != null) {
							material.setAmbientOcclusion(ao);
						}
						
					} else if ("transparency".equals(attribute)) {
						
						String value = config.getString(key).toUpperCase();
						Transparency transparency = Transparency.valueOf(value);
						
						if (transparency != null) {
							material.setTransparency(transparency);
						}
						
					} else if (attribute.startsWith("texture")) {
						
						List<TextureData> textureDataList =
							new ArrayList<TextureData>();
						
						for (int i = 0; i < 32; i++) {
							
							String fileKey = "material_" + materialName + "_texture" + i + "_file";
							String widthKey = "material_" + materialName + "_texture" + i + "_width";
							String heightKey = "material_" + materialName + "_texture" + i + "_height";
							String wrapKey = "material_" + materialName + "_texture" + i + "_wrap";
							String coordFunctionKey = "material_" + materialName + "_texture" + i + "_coord_function";
							String colorableKey = "material_" + materialName + "_texture" + i + "_colorable";
							String bumpmapKey = "material_" + materialName + "_texture" + i + "_bumpmap";

							if (config.getString(fileKey) == null) break;
							
							File file = new File(config.getString(fileKey));
							
							double width = config.getDouble(widthKey, 1);
							double height = config.getDouble(heightKey, 1);
							boolean colorable = config.getBoolean(colorableKey, false);
							boolean isBumpMap = config.getBoolean(bumpmapKey, false);
							
							String wrapString = config.getString(wrapKey);
							Wrap wrap = Wrap.REPEAT;
							if ("clamp_to_border".equalsIgnoreCase(wrapString)) {
								wrap = Wrap.CLAMP_TO_BORDER;
							} else if ("clamp".equalsIgnoreCase(wrapString)) {
								wrap = Wrap.CLAMP;
							}
							
							String coordFunctionString = config.getString(coordFunctionKey);
							TexCoordFunction coordFunction = null;
							if (coordFunctionString != null) {
								coordFunction = NamedTexCoordFunction.valueOf(
										coordFunctionString.toUpperCase());
							}
							
							// bumpmaps are only supported in the shader implementation, skip for others
							if (!isBumpMap || "shader".equals(config.getString("joglImplementation"))) {
								TextureData textureData = new TextureData(
										file, width, height, wrap, coordFunction, colorable, isBumpMap);
								textureDataList.add(textureData);
							}
							
						}
						
						material.setTextureDataList(textureDataList);
							
					} else {
						System.err.println("unknown material attribute: "
								+ attribute);
					}
				
				} else {
					System.err.println("unknown material: " + materialName);
				}
				
			}
			
		}
		
	}
	
}
