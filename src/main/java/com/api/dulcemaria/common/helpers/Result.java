package com.api.dulcemaria.common.helpers;

import java.util.Optional;

public class Result<T> {
    private final Optional<T> value;
    private final Optional<Error> error;
    private final boolean isSuccess;

    public Result(T value) {
        this.value = Optional.of(value);
        this.error = Optional.empty();
        this.isSuccess = true;
    }

    public Result(Error error) {
        this.value = Optional.empty();
        this.error = Optional.of(error);
        this.isSuccess = false;
    }
}
