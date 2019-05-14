package com.hesoyam.server.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hesoyam.server.models.Bittrex;

import java.io.IOException;

public class BittrexSerializer extends JsonSerializer<Bittrex> {
    @Override
    public void serialize(Bittrex bittrex, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException{
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("d", bittrex.getDate());
        jsonGenerator.writeStringField("o", bittrex.getOpen());
        jsonGenerator.writeStringField("h", bittrex.getHigh());
        jsonGenerator.writeStringField("l", bittrex.getLow());
        jsonGenerator.writeStringField("c", bittrex.getClose());
        jsonGenerator.writeEndObject();
    }
}