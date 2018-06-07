#!/bin/bash

# retrieve VM parameters

vmparams="-Xmx2G"

if [[ $1 == --vm-params=* ]]
  then
    vmparams=${1:12}
    shift
fi

# choose path for the native JOGL libs depending on system and java version

MACHINE_TYPE=`uname -m`
KERNEL_NAME=`uname -s`

if [ ${KERNEL_NAME} == 'Darwin' ]; then
lpsolvepath="lib/lp_solve/mac"
else
if [ `java -version 2>&1|grep -c 64-Bit` -gt 0 ]; then
lpsolvepath="lib/lp_solve/win64"
  else
lpsolvepath="lib/lp_solve/win32"
  fi
fi

# run OSM2World

# export LD_LIBRARY_PATH=$lpsolvepath
export PATH=$lpsolvepath:$PATH

#Try to compile OSM2World.jar if it doesn't exist
if ! test -e build/OSM2World.jar; then
    ant
fi

java -Djava.awt.headless=false -Djava.library.path=$lpsolvepath $vmparams -jar build/OSM2World.jar --config texture_config.properties $@
