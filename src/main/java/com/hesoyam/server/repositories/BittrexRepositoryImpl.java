package com.hesoyam.server.repositories;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BittrexRepositoryImpl implements BittrexRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;
    private static final String COLLECTION = "bittrex";

    @Override
    public List<String> getPossibleSymbols() {
        DistinctIterable<String> symbols = mongoTemplate.getCollection(COLLECTION).distinct("symbol", String.class);

        MongoCursor<String> cursor = symbols.iterator();
        List<String> symbol = new ArrayList<>();
        while (cursor.hasNext()) {
            symbol.add(cursor.next());
        }
        return symbol;
    }
}
