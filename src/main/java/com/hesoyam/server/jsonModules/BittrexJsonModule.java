package com.hesoyam.server.jsonModules;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hesoyam.server.models.Bittrex;
import com.hesoyam.server.serializers.BittrexSerializer;

public class BittrexJsonModule extends SimpleModule {
    public BittrexJsonModule(){
        this.addSerializer(Bittrex.class, new BittrexSerializer());
    }
}
