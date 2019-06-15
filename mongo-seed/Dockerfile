FROM mongo

COPY bittrex.json /bittrex.json
COPY reddit.json /reddit.json
CMD mongoimport --host mongodb --mode upsert --db assets --collection reddit --type json --file /reddit.json --jsonArray && mongoimport --host mongodb --mode upsert --db assets --collection bittrex --type json --file /bittrex.json --jsonArray
