package com.api.dulcemaria.common.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record Error(
    String code,
    String description,
    ErrorType type,
    Optional<Map<String, Object>> metada
) {

    public static Error Failure(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Failure", "Se ha producido un fallo.", ErrorType.Failure, Optional.of(map));
    }

    public static Error Unexpected(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Unexpected", "Se ha producido un error inesperado.", ErrorType.Unexpected, Optional.empty());
    }

    public static Error Validation(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Validation", "Se ha producido un error de validación.", ErrorType.Validation, Optional.of(map));
    }

    public static Error Conflict(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Conflict", "Se ha producido un error de conflicto.", ErrorType.Conflict, Optional.of(map));
    }

    public static Error NotFound(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.NotFound", "Se ha producido un error 'No encontrado'.", ErrorType.NotFound, Optional.of(map));
    }

    public static Error Unauthorized(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Unauthorized", "Se ha producido un error 'No autorizado'.", ErrorType.Unauthorized, Optional.of(map));
    }

    public static Error Forbidden(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Errors", obj);
        return new Error("General.Forbidden", "Se ha producido un error de 'Prohibido'.", ErrorType.Forbidden, Optional.of(map));
    }
}
