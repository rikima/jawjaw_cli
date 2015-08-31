#!/bin/sh
cur=$(dirname $0)
jars=$cur/target/jawjaw_cli-1.0-SNAPSHOT.jar
for jar in $(ls $cur/lib/*.jar) ; do
    jars=$jars:$jar
done

java -cp $jars com.masakir.nlp.JawJawCli $*
