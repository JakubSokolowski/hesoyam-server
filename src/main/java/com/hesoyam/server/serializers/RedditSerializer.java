package com.hesoyam.server.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hesoyam.server.models.Reddit;

import java.io.IOException;

public class RedditSerializer extends JsonSerializer<Reddit> {
    @Override
    public void serialize(Reddit reddit, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException{
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", reddit.get_id());
        jsonGenerator.writeStringField("title", reddit.getTitle());
        jsonGenerator.writeStringField("date", reddit.getDate());
        jsonGenerator.writeStringField("full_link", reddit.getFull_link());
        jsonGenerator.writeEndObject();
    }
}
