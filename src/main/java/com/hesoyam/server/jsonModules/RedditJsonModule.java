package com.hesoyam.server.jsonModules;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hesoyam.server.models.Reddit;
import com.hesoyam.server.serializers.RedditSerializer;

public class RedditJsonModule extends SimpleModule {
    public RedditJsonModule(){
        this.addSerializer(Reddit.class, new RedditSerializer());
    }
}
