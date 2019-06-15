#!/usr/bin/env bash


DATE_FROM_UTC=1530403200
DATE_TO_UTC=1532908800
HOST="54.93.39.245"
USER="gd2"
PASSWORD="javaee"
mongoexport --host ${HOST} -u ${USER} -p ${PASSWORD} --db assets -c bittrex \
            --query '{date : {$gt: 1530856800,$lt: 1531213200}}'\
            --out bittrex.json --jsonArray

mongoexport --host ${HOST} -u ${USER} -p ${PASSWORD} --db assets -c reddit \
            --query '{created_utc : {$gt: 1530856800,$lt: 1531213200}}'\
            --out reddit.json --jsonArray