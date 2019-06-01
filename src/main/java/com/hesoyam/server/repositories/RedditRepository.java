package com.hesoyam.server.repositories;

import com.hesoyam.server.models.Reddit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RedditRepository extends MongoRepository<Reddit, String> {

    Reddit findRedditBy_id(ObjectId _id);

    @Query("{subreddit : ?0, created_utc : {$gt: ?1, $lt: ?2}}")
    List<Reddit>findBySubredditAndCreatedUtcBetween(String subreddit, int startDate, int endDate);
}
