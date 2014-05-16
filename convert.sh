#!/bin/bash -x

files=(
/home/bost/vircurex/2013/08/22/vircurex.2013-08-22_05-30-07.xml
/home/bost/vircurex/2013/08/13/vircurex.2013-08-13_12-15-05.xml
)

# for f in ${files[@]}; do
#     echo $f
# done

# lein run ${files[@]}
# lein run $files[0]
lein run /home/bost/vircurex/2013/08/22/vircurex.2013-08-22_05-30-07.xml /home/bost/vircurex/2013/08/13/vircurex.2013-08-13_12-15-05.xml
