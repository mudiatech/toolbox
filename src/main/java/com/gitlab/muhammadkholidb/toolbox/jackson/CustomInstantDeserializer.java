package com.gitlab.muhammadkholidb.toolbox.jackson;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.gitlab.muhammadkholidb.toolbox.data.DateTimeUtils;

public class CustomInstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        return DateTimeUtils.toInstant(jp.getText());
    }

}
