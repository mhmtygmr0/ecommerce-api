package com.app.ecommerce.core.utilies;

import com.app.ecommerce.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }
}
