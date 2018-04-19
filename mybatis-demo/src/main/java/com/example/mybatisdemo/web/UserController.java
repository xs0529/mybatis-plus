package com.example.mybatisdemo.web;
import com.example.mybatisdemo.common.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.service.IUserService;
import com.example.mybatisdemo.common.utils.Result;
import com.example.mybatisdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  @description : User 控制器
 *  ---------------------------------
 *   @author xieshuang
 *  @since 2018-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
private final Logger logger = LoggerFactory.getLogger(UserController.class);
@Autowired
public IUserService userService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getUserList",method = RequestMethod.POST)
public Object getUserList(User param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
@RequestParam(value = "length") Integer length,
@RequestParam(value = "start") Integer start) {
            return null;
        }

/**
 * @description : 通过id获取User
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getUserById",method = RequestMethod.GET)
public Object getUserById(String id) {
        try {
            User param= userService.selectById(id);
            return Result.ok().put(StringUtil.toLowerCaseFirstOne("User"),param);
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id删除User
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/deleteUserById",method = RequestMethod.GET)
public Object deleteUserById(String id) {
        try{
            if (userService.deleteById(id)){
                return Result.ok();
            }else {
                return Result.error();
            }
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id更新User
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
public Object updateUserById(User param) {
        try{
            if (userService.updateById(param)){
                return Result.ok();
            }else {
                return Result.error();
            }
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 添加User
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/addUser",method = RequestMethod.POST)
public Object addUser(User param) {
        try{
            if (userService.insert(param)){
                return Result.ok();
            }else {
            return Result.error();
            }
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }
}