package com.gitlab.muhammadkholidb.toolbox.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import com.gitlab.muhammadkholidb.toolbox.exception.Exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncUtils {

    private AsyncUtils() {
    }

    public static <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier).exceptionally(new Function<Throwable, T>() {
            @Override
            public T apply(Throwable ex) {
                log.error("Supply async error: " + Exceptions.getMessage(ex.getCause()), ex);
                return null;
            }
        });
    }

    public static CompletableFuture<Void> run(Runnable runnable) {
        return CompletableFuture.runAsync(runnable).exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable ex) {
                log.error("Run async error: " + Exceptions.getMessage(ex.getCause()), ex);
                return null;
            }
        });
    }

}
