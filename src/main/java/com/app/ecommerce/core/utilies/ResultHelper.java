package com.app.ecommerce.core.utilies;

import com.app.ecommerce.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultData<T> notFound(T data) {
        return new ResultData<>(false, Msg.NOT_FOUND_ERROR, "404", data);
    }

    public static <T> ResultData<T> unsupportedMediaType(T data) {
        return new ResultData<>(false, Msg.UNSUPPORTED_MEDIA_TYPE, "415", data);
    }

    public static <T> ResultData<T> accessDenied(T data) {
        return new ResultData<>(false, Msg.ACCESS_DENIED, "403", data);
    }

    public static <T> ResultData<T> badRequest(T data) {
        return new ResultData<>(false, Msg.BAD_REQUEST, "400", data);
    }

    public static <T> ResultData<T> internalServerError(T data) {
        return new ResultData<>(false, Msg.INTERNAL_SERVER_ERROR, "500", data);
    }

    public static <T> ResultData<T> conflictError(T data) {
        return new ResultData<>(false, Msg.CONFLICT_ERROR, "409", data);
    }

    public static <T> ResultData<T> unauthorized(T data) {
        return new ResultData<>(false, Msg.UNAUTHORIZED_ERROR, "401", data);
    }

    public static <T> ResultData<T> generalError(T data) {
        return new ResultData<>(false, Msg.GENERAL_ERROR, "500", data);
    }
}

