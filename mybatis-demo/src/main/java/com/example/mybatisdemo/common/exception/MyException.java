package com.example.mybatisdemo.common.exception;

import com.example.mybatisdemo.common.enums.ResultEnum;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 11:05
 */
public class MyException extends RuntimeException {
    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
