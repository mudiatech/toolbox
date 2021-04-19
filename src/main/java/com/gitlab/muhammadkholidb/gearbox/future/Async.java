package com.gitlab.muhammadkholidb.gearbox.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.gitlab.muhammadkholidb.gearbox.exception.Exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Async {

    private Async() {
    }

    public static <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier).exceptionally(ex -> {
            log.error("Supply async error: " + Exceptions.getMessage(ex.getCause()), ex);
            return null;
        });
    }

    public static CompletableFuture<Void> run(Runnable runnable) {
        return CompletableFuture.runAsync(runnable).exceptionally(ex -> {
            log.error("Run async error: " + Exceptions.getMessage(ex.getCause()), ex);
            return null;
        });
    }

}
