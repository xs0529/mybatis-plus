package com.example.mybatisdemo.common.enums;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 11:06
 */
public enum ResultEnum {
    NAME_NOT_EXIST(10,"用户名不存在"),
    PASSWORD_ERROR(11,"密码错误"),
    ACCOUNT_IS_LOCKED(12,"账号已被锁定,请联系管理员!"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
