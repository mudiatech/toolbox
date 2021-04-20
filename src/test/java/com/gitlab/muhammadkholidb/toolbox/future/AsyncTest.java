package com.gitlab.muhammadkholidb.toolbox.future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import org.testng.annotations.Test;

public class AsyncTest {

    @Test
    void testSupply_shouldReturnCompletableFuture() throws InterruptedException, ExecutionException {
        Supplier<Integer> supplier = () -> 1;
        CompletableFuture<Integer> result = Async.supply(supplier);
        assertThat(result, not(nullValue()));
        assertThat(result.get(), is(1));
    }

    @Test
    void testSupply_throwsException_shouldReturnCompletableFuture() throws InterruptedException, ExecutionException {
        Supplier<Integer> supplier = () -> {
            throw new NullPointerException();
        };
        CompletableFuture<Integer> result = Async.supply(supplier);
        assertThat(result, not(nullValue()));
        assertThat(result.get(), is(nullValue()));
    }

    @Test
    void testRun_shouldReturnCompletableFuture() throws InterruptedException, ExecutionException {
        Runnable runnable = () -> {
        };
        CompletableFuture<Void> result = Async.run(runnable);
        assertThat(result, not(nullValue()));
        assertThat(result.get(), is(nullValue()));
    }

    @Test
    void testRun_throwsException_shouldReturnCompletableFuture() throws InterruptedException, ExecutionException {
        Runnable runnable = () -> {
            throw new NullPointerException();
        };
        CompletableFuture<Void> result = Async.run(runnable);
        assertThat(result, not(nullValue()));
        assertThat(result.get(), is(nullValue()));
    }

}
