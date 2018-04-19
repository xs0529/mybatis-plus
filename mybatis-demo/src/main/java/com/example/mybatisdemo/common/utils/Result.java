package com.example.mybatisdemo.common.utils;

import java.util.HashMap;

/**
 * @Auther: 谢霜
 * @Date: 2018/4/19 0019 20:40
 * @Description:
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 0;
    // 警告
    private static final Integer WARN = 1;
    // 异常 失败
    private static final Integer FAIL = 500;

    public Result() {
        put("code", SUCCESS);
        put("msg", "操作成功");
    }

    public static Result error(Object msg) {
        Result Result = new Result();
        Result.put("code", FAIL);
        Result.put("msg", msg);
        return Result;
    }

    public static Result warn(Object msg) {
        Result Result = new Result();
        Result.put("code", WARN);
        Result.put("msg", msg);
        return Result;
    }

    public static Result ok(Object msg) {
        Result Result = new Result();
        Result.put("code", SUCCESS);
        Result.put("msg", msg);
        return Result;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result error() {
        return Result.error("");
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
