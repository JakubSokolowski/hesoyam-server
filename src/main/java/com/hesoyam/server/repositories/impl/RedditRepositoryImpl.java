package com.hesoyam.server.repositories.impl;

import com.hesoyam.server.repositories.RedditRepositoryCustom;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

public class RedditRepositoryImpl implements RedditRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;
    private static final String COLLECTION = "reddit";

    @Override
    public List<String> getPossibleSubreddits() {
        DistinctIterable<String> subreddits = mongoTemplate.getCollection(COLLECTION).distinct("subreddit", String.class);

        MongoCursor<String> cursor = subreddits.iterator();
        List<String> subreddit = new ArrayList<>();
        while (cursor.hasNext()) {
            subreddit.add(cursor.next());
        }
        return subreddit;
    }
}
