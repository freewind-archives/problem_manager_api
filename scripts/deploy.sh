#!/bin/bash

heroku apps:destroy problem-manager-api --confirm
heroku apps:create problem-manager-api

git checkout master
git add build_version
git commit -m "update build_version file"

git remote add heroku git@heroku.com:problem-manager-api.git
git push heroku master
