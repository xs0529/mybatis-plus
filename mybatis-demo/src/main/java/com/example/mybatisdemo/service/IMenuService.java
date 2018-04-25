package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xieshuang
 * @since 2018-04-19
 */
public interface IMenuService extends IService<Menu> {
    List<Menu> findMenuByUserName(String userName);
}
