package com.example.mybatisdemo.service;

import com.example.mybatisdemo.MybatisDemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 11:46
 */
public class IRoleServiceTest extends MybatisDemoApplicationTests{

    @Autowired
    IRoleService iRoleService;

    @Test
    public void roleServiceTest(){
        System.out.println(iRoleService.findByUserName("xieshuang"));
    }
}