#!/bin/sh
set -eu
cd "$(dirname "$0")"
mkdir -p out
find src test -name '*.java' > out/sources.txt
javac -encoding UTF-8 --release 17 -d out @out/sources.txt
java -cp out "${1:-Main}"
