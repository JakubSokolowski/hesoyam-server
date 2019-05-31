package com.hesoyam.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hesoyam.server.jsonModules.RedditJsonModule;
import com.hesoyam.server.models.Reddit;
import com.hesoyam.server.repositories.RedditRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<String> getRedditDataByDate(@PathVariable("subreddit") String subreddit,
                                            @PathVariable("start_date") int startDate,
                                            @PathVariable("end_date") int endDate) throws JsonProcessingException {
        List<Reddit> data = repository.findBySubredditAndCreatedUtcBetween(subreddit, startDate, endDate);
        return serialize(data);
    }


    private List<String> serialize(List<Reddit> data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new RedditJsonModule());
        List<String> response = new ArrayList<>();

        for(Reddit r : data)
        {
            response.add(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(r));
        }
        return response;
    }
}
