package com.api.dulcemaria.common.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Error {
    private final String code;
    private final String description;

    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
