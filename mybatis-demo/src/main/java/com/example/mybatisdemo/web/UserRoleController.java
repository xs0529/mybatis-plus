package com.example.mybatisdemo.web;
import com.example.mybatisdemo.common.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.service.IUserRoleService;
import com.example.mybatisdemo.common.utils.Result;
import com.example.mybatisdemo.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  @description : UserRole 控制器
 *  ---------------------------------
 *   @author xieshuang
 *  @since 2018-04-19
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
private final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
@Autowired
public IUserRoleService userRoleService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getUserRoleList",method = RequestMethod.POST)
public Object getUserRoleList(UserRole param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
@RequestParam(value = "length") Integer length,
@RequestParam(value = "start") Integer start) {
            return null;
        }

/**
 * @description : 通过id获取UserRole
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getUserRoleById",method = RequestMethod.GET)
public Object getUserRoleById(String id) {
        try {
            UserRole param= userRoleService.selectById(id);
            return Result.ok().put(StringUtil.toLowerCaseFirstOne("UserRole"),param);
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id删除UserRole
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/deleteUserRoleById",method = RequestMethod.GET)
public Object deleteUserRoleById(String id) {
        try{
            if (userRoleService.deleteById(id)){
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
 * @description : 通过id更新UserRole
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/updateUserRoleById",method = RequestMethod.POST)
public Object updateUserRoleById(UserRole param) {
        try{
            if (userRoleService.updateById(param)){
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
 * @description : 添加UserRole
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/addUserRole",method = RequestMethod.POST)
public Object addUserRole(UserRole param) {
        try{
            if (userRoleService.insert(param)){
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