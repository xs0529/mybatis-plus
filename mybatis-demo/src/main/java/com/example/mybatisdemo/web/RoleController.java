package com.example.mybatisdemo.web;
import com.example.mybatisdemo.common.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.service.IRoleService;
import com.example.mybatisdemo.common.utils.Result;
import com.example.mybatisdemo.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  @description : Role 控制器
 *  ---------------------------------
 *   @author xieshuang
 *  @since 2018-04-19
 */
@RestController
@RequestMapping("/role")
public class RoleController {
private final Logger logger = LoggerFactory.getLogger(RoleController.class);
@Autowired
public IRoleService roleService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getRoleList",method = RequestMethod.POST)
public Object getRoleList(Role param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
@RequestParam(value = "length") Integer length,
@RequestParam(value = "start") Integer start) {
            return null;
        }

/**
 * @description : 通过id获取Role
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getRoleById",method = RequestMethod.GET)
public Object getRoleById(String id) {
        try {
            Role param= roleService.selectById(id);
            return Result.ok().put(StringUtil.toLowerCaseFirstOne("Role"),param);
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id删除Role
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/deleteRoleById",method = RequestMethod.GET)
public Object deleteRoleById(String id) {
        try{
            if (roleService.deleteById(id)){
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
 * @description : 通过id更新Role
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/updateRoleById",method = RequestMethod.POST)
public Object updateRoleById(Role param) {
        try{
            if (roleService.updateById(param)){
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
 * @description : 添加Role
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/addRole",method = RequestMethod.POST)
public Object addRole(Role param) {
        try{
            if (roleService.insert(param)){
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