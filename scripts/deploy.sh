#!/bin/bash

cd $WORKSPACE
play clean compile stage

deploy=~/scala_workshop_publish/problem_manager_api
mkdir -p $deploy

cd $deploy
test -f scripts/stop.sh && ./scripts/stop.sh || true
rm -rf *

cd $deploy
cp -r $WORKSPACE/target/universal/stage/* $deploy

BUILD_ID=dontKillMe ./scripts/start.sh
