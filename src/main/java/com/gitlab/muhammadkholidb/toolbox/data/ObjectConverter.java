package com.gitlab.muhammadkholidb.toolbox.data;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjectConverter {

    private ObjectMapper mapper;

    public <T> T convertObject(Object object, Class<T> c) {
        return mapper.convertValue(object, c);
    }

    public <T> T convertOptional(Optional<?> optional, Class<T> c) {
        return optional.map(o -> convertObject(o, c)).orElse(null);
    }

    public <T, X extends Exception> T convertOptionalOrThrow(Optional<?> optional, Class<T> c, X x) throws X {
        return optional.map(o -> convertObject(o, c)).orElseThrow(() -> x);
    }

    public <T> List<T> convertList(List<?> list, Class<T> c) {
        return mapper.convertValue(list, mapper.getTypeFactory().constructCollectionType(List.class, c));
    }

    public <K, V> Map<K, V> convertToMap(Object object) {
        return mapper.convertValue(object, new TypeReference<Map<K, V>>(){});
    }

}
