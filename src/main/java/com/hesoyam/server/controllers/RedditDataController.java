package com.hesoyam.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hesoyam.server.models.Reddit;
import com.hesoyam.server.repositories.RedditRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reddit")
public class RedditDataController {
    @Autowired
    private final RedditRepository repository;

    public RedditDataController(RedditRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Reddit getByid(@PathVariable("id") ObjectId id){
        return repository.findRedditBy_id(id);
    }

    @RequestMapping(value = "/{subreddit}/{start_date}/{end_date}", method = RequestMethod.GET)
    public List<Reddit> getRedditDataByDate(@PathVariable("subreddit") String subreddit,
                                            @PathVariable("start_date") int startDate,
                                            @PathVariable("end_date") int endDate) throws JsonProcessingException {
        return repository.findBySubredditAndCreatedUtcBetween(subreddit, startDate, endDate);
    }

    @RequestMapping(value = "/newposts", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> saveRedditPosts(@RequestBody List<Reddit> redditPosts){
        for(Reddit r : redditPosts){
            repository.save(r);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping("/subreddits")
    public List<String> getPossibleSubreddits(){
        return repository.getPossibleSubreddits();
    }

    @RequestMapping(value = "/newest/{subreddit}", method = RequestMethod.GET)
    public Reddit getNewestPost(@PathVariable("subreddit") String subreddit){
        return repository.findTopBySubredditOrderByCreatedUtcDesc(subreddit);
    }
}
