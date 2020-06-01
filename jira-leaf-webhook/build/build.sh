#! /bin/bash
work=target

config=config

if [ -d "$work" ]; then
	rm -r $work/*
fi


mkdir -p $work/bin
mkdir -p $work/config
mkdir -p $work/logs

cp bin/* $work/bin/
cp $config/* $work/config/

mvn clean package -f maven/pom.xml
