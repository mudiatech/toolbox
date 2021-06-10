package com.gitlab.muhammadkholidb.toolbox.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;

import java.util.Map;

import org.testng.annotations.Test;

public class MapBuilderTest {

    @Test
    void testBuild_shouldSucced() {
        Map<String, String> result = new MapBuilder<String, String>().put("key1", "value1").put("key2", "value2")
                .build();
        assertThat(result, notNullValue());
        assertThat(result, aMapWithSize(2));
        assertThat(result, allOf(hasEntry("key1", "value1"), hasEntry("key2", "value2")));
    }

}
