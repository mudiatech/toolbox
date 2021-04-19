package com.gitlab.muhammadkholidb.gearbox.exception;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class ExceptionsTest {

    @Test
    void testGetMessage_shouldReturnMessage() {
        Exception ex = new Exception("message");
        String message = Exceptions.getMessage(ex);
        assertThat(message, is("message"));
    }

    @Test
    void testGetMessage_withNullMessage_shouldReturnMessage() {
        Exception ex = new Exception();
        String message = Exceptions.getMessage(ex);
        assertThat(message, is(ex.toString()));
    }

    @Test
    void testGetMessageOrDefault_shouldReturnExeptionMessage() {
        Exception ex = new Exception("message");
        String message = Exceptions.getMessageOrDefault(ex, null);
        assertThat(message, is("message"));
    }

    @Test
    void testGetMessageOrDefault_withNullExceptionMessage_shouldReturnDefaultMessage() {
        Exception ex = new Exception();
        String message = Exceptions.getMessageOrDefault(ex, "default message");
        assertThat(message, is("default message"));
    }

}
