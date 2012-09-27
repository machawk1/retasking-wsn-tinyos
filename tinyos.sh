#! /usr/bin/env bash
# Here we setup the environment
# variables needed by the tinyos 
# make system

echo "Setting up for retasking-wsn-tinyos (2.1.2)"
export TOSROOT=
export TOSDIR=
export MAKERULES=

TOSROOT="/opt/retasking-wsn-tinyos"
TOSDIR="$TOSROOT/tos"
CLASSPATH=$CLASSPATH:$TOSROOT/support/sdk/java
MAKERULES="$TOSROOT/support/make/Makerules"

export TOSROOT
export TOSDIR
export CLASSPATH
export MAKERULES

