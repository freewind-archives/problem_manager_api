#!/bin/bash
mkdir -p logs
nohup ./bin/problem_manager_api -Dhttp.port=10001 >/dev/null 2>&1 &
# You can provide all the -Dsettings you need to set for your application here :-)
