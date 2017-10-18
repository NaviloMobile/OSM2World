if [[ $# -ne 2 ]]; then
	echo "Usage: $0 texture_config_file gameplay_material_file"
	exit -1
fi

texture_config_file=$1
gameplay_material_file=$2

> "${gameplay_material_file}"
grep material_ "${texture_config_file}"|grep texture0_file|sed 's/material_//;s/_texture0_file//;s/.\/textures/res\/textures/'|awk '{print "material " $1 "_0 : textured\n{\n\tsampler u_diffuseTexture\n\t{\n\t\tpath = " $3 "\n\t}\n}\n"}' >> "${gameplay_material_file}"
grep material_ "${texture_config_file}"|grep texture1_file|sed 's/material_//;s/_texture1_file//;s/.\/textures/res\/textures/'|awk '{print "material " $1 "_1 : textured\n{\n\tsampler u_diffuseTexture\n\t{\n\t\tpath = " $3 "\n\t}\n}\n"}' >> "${gameplay_material_file}"
grep material_ "${texture_config_file}"|grep color|sed 's/material_//;s/_color//;s/#/0x/'|gawk '{r=rshift(strtonum($3),16)/255; g=and(rshift(strtonum($3),8),0xff)/255; b=and(strtonum($3),0xff)/255; print "material " $1 "_0 : colored\n{\n\t u_diffuseColor = " r ", " g ", " b ", 1\n}\n"}' >> "${gameplay_material_file}"
