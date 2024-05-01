#!/bin/bash
git pull
java -jar backend/POC-0.0.1-SNAPSHOT.jar > backend/application.log 2>&1 &
