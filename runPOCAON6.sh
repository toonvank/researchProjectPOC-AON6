#!/bin/bash
git pull
java -jar backend/POC-0.0.1-SNAPSHOT.jar > backend/application.log 2>&1 &
cd /home/seshwoods/Documents/researchProjectPOC-AON6/frontend
npm run build
nohup serve -s dist -l 5173 &
