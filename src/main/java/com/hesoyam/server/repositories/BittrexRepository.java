package com.hesoyam.server.repositories;

import com.hesoyam.server.models.Bittrex;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BittrexRepository extends MongoRepository<Bittrex, String> {
    Bittrex findBy_id(ObjectId _id);

    List<Bittrex>findDistinctBittrexBySymbol(String symbol, Sort sort);

    List<Bittrex>findDistinctBittrexBySymbolAndDateBetween(String symbol, int startDate, int endDate);
}