package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Menu;
import com.example.mybatisdemo.mapper.MenuMapper;
import com.example.mybatisdemo.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xieshuang
 * @since 2018-04-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuByUserName(String userName) {
        return menuMapper.findMenuByUserName(userName);
    }
}
