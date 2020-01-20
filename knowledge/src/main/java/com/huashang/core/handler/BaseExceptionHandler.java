package com.huashang.core.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;

@ControllerAdvice
@ResponseBody
public class BaseExceptionHandler {
	/**
	 * 捕捉全局异常RuntimeException
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = RuntimeException.class)
    public Result runtimeException(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.TOKENERROR, e.getMessage());
    }

}

