#!/usr/bin/env bash

OUTPUT="classes"

javac src/*.java -d ${OUTPUT} && java -cp ${OUTPUT} App
