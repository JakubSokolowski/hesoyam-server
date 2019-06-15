FROM mongo

COPY bittrex.json /bittrex.json
COPY reddit.json /reddit.json
CMD mongo assets --eval "db.dropDatabase();"
CMD mongoimport --host mongodb --mode upsert --db assets --collection bittrex --type json --file /bittrex.json --jsonArray
CMD mongoimport --host mongodb --mode upsert --db assets --collection reddit --type json --file /reddit.json --jsonArray