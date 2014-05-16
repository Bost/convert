#!/bin/bash -x

find ~/vircurex -name *.xml > allfiles.txt
sed 's/\(.*\)/"\1"/' < allfiles.txt > allfiles.str.txt
# head allfiles.str.txt > allfiles.str.head.txt
# cat begin allfiles.str.head.txt end > allfiles.clj
cat begin allfiles.str.txt end > allfiles.clj
lein run
