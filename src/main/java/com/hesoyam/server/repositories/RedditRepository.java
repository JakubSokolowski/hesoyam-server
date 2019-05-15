package com.hesoyam.server.repositories;

import com.hesoyam.server.models.Reddit;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RedditRepository extends MongoRepository<Reddit, String> {
    Reddit findRedditBy_id(ObjectId _id);

    List<Reddit>findRedditBySubredditAndDateBetween(String subreddit, int startDate, int endDate, Sort sort);

    List<Reddit>findRedditBySubreddit(String subreddit);
}
