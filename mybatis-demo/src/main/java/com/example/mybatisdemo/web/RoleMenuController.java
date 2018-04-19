package com.example.mybatisdemo.web;
import com.example.mybatisdemo.common.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.service.IRoleMenuService;
import com.example.mybatisdemo.common.utils.Result;
import com.example.mybatisdemo.entity.RoleMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *  @description : RoleMenu 控制器
 *  ---------------------------------
 *   @author xieshuang
 *  @since 2018-04-19
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
private final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);
@Autowired
public IRoleMenuService roleMenuService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getRoleMenuList",method = RequestMethod.POST)
public Object getRoleMenuList(RoleMenu param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
@RequestParam(value = "length") Integer length,
@RequestParam(value = "start") Integer start) {
            return null;
        }

/**
 * @description : 通过id获取RoleMenu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getRoleMenuById",method = RequestMethod.GET)
public Object getRoleMenuById(String id) {
        try {
            RoleMenu param= roleMenuService.selectById(id);
            return Result.ok().put(StringUtil.toLowerCaseFirstOne("RoleMenu"),param);
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id删除RoleMenu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/deleteRoleMenuById",method = RequestMethod.GET)
public Object deleteRoleMenuById(String id) {
        try{
            if (roleMenuService.deleteById(id)){
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
 * @description : 通过id更新RoleMenu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/updateRoleMenuById",method = RequestMethod.POST)
public Object updateRoleMenuById(RoleMenu param) {
        try{
            if (roleMenuService.updateById(param)){
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
 * @description : 添加RoleMenu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/addRoleMenu",method = RequestMethod.POST)
public Object addRoleMenu(RoleMenu param) {
        try{
            if (roleMenuService.insert(param)){
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