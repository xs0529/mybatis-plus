package com.example.mybatisdemo.web;

import com.example.mybatisdemo.common.exception.MyException;
import com.example.mybatisdemo.common.utils.MD5Utils;
import com.example.mybatisdemo.common.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 9:32
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(String username,String password,Boolean rememberMe){
        password = MD5Utils.encrypt(username.toLowerCase(),password);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
            SecurityUtils.getSubject().login(token);
            return Result.ok();

    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @RequiresPermissions("job:run")
    @GetMapping("/test")
    @ResponseBody
    public Object test (){
        return "66666";
    }

    @RequiresPermissions("job:777")
    @GetMapping("/test1")
    @ResponseBody
    public Object test1 (){
        return "7777777777";
    }
}
