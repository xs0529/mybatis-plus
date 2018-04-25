package com.example.mybatisdemo.web;
import com.example.mybatisdemo.common.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.service.IMenuService;
import com.example.mybatisdemo.common.utils.Result;
import com.example.mybatisdemo.entity.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *  @description : Menu 控制器
 *  ---------------------------------
 *   @author xieshuang
 *  @since 2018-04-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
private final Logger logger = LoggerFactory.getLogger(MenuController.class);
@Autowired
public IMenuService menuService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getMenuList",method = RequestMethod.POST)
public Object getMenuList(Menu param , @RequestParam(value = "draw",defaultValue = "0") Integer draw,
@RequestParam(value = "length") Integer length,
@RequestParam(value = "start") Integer start) {
            return null;
        }

/**
 * @description : 通过id获取Menu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/getMenuById",method = RequestMethod.GET)
public Object getMenuById(String id) {
        try {
            Menu param= menuService.selectById(id);
            return Result.ok().put(StringUtil.toLowerCaseFirstOne("Menu"),param);
        }catch (Exception e) {
            logger.info("异常信息:{}"+e.getMessage());
            return Result.error("异常信息:{"+e.getClass().getName()+"}");
        }
    }

/**
 * @description : 通过id删除Menu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/deleteMenuById",method = RequestMethod.GET)
public Object deleteMenuById(String id) {
        try{
            if (menuService.deleteById(id)){
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
 * @description : 通过id更新Menu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/updateMenuById",method = RequestMethod.POST)
public Object updateMenuById(Menu param) {
        try{
            if (menuService.updateById(param)){
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
 * @description : 添加Menu
 * ---------------------------------
 * @author : xieshuang
 * @since : Create in 2018-04-19
 */
@RequestMapping(value = "/addMenu",method = RequestMethod.POST)
public Object addMenu(Menu param) {
        try{
            if (menuService.insert(param)){
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
     * 随机抛出异常
     */
    private void randomException() throws Exception {
        Exception[] exceptions = { //异常集合
                new NullPointerException(),
                new ArrayIndexOutOfBoundsException(),
                new NumberFormatException(),
                new SQLException()};
        //发生概率
        double probability = 0.75;
        if (Math.random() < probability) {
            //情况1：要么抛出异常
            throw exceptions[(int) (Math.random() * exceptions.length)];
        } else {
            //情况2：要么继续运行
        }

    }

    /**
     * 模拟用户数据访问
     */
    @GetMapping("/")
    @ResponseBody
    public List index() throws Exception {
        randomException();
        return Arrays.asList("正常用户数据1!", "正常用户数据2! 请按F5刷新!!");
    }
}