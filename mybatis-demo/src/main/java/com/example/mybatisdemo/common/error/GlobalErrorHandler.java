package com.example.mybatisdemo.common.error;

import com.example.mybatisdemo.common.exception.MyException;
import com.example.mybatisdemo.common.utils.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 谢霜
 * @Description 统一异常处理类
 * @date 2018/4/20 18:06
 */
@ControllerAdvice
public class GlobalErrorHandler {

    private final static String DEFAULT_ERROR_VIEW = "error";//错误信息页

    @Autowired
    private ErrorInfoBuilder errorInfoBuilder;//错误信息的构建工具\

    //处理自定义runtime异常
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Result handlerSellerException(MyException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    //统一处理所有异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Throwable error,Exception e) {
        //1.若为AJAX请求,则返回异常信息(JSON)
        if (isAjaxRequest(request)) {
            return errorInfoBuilder.getErrorInfo(request,error);
        }
        //2.其余请求,则返回指定的异常信息页(View).
        return new ModelAndView(DEFAULT_ERROR_VIEW, "errorInfo", errorInfoBuilder.getErrorInfo(request, error));
    }

    private boolean isAjaxRequest(HttpServletRequest request) {

        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }


}
