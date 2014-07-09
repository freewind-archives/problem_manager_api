#!/bin/bash -x

PROJECT=$1

heroku apps:destroy -a $PROJECT --confirm $PROJECT
heroku apps:create $PROJECT

# commit build_version in another branch
git branch -D heroku 2>/dev/null
git branch heroku
git checkout heroku

git add build_version -f
git commit -m "update build_version file"

# push latest code to heroku with build_version
git remote add heroku git@heroku.com:${PROJECT}.git 2>/dev/null
#git push heroku master
git push -u heroku heroku:master

# ckeckout to master and remove heorku branch
git checkout master
git branch -D heroku
