package com.example.mybatisdemo.daotest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.mybatisdemo.MybatisDemoApplicationTests;
import com.example.mybatisdemo.entity.User;
import org.junit.Test;

import java.util.List;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 10:38
 */
public class UserMapperTest extends MybatisDemoApplicationTests {
    @Test
    public void userTest(){
        User user = new User();
        List<User> users = user.selectList(new EntityWrapper(user).eq("USERNAME","xieshuang"));
        System.out.println(users);
    }
}
