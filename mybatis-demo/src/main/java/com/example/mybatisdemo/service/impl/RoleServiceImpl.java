package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Role;
import com.example.mybatisdemo.mapper.RoleMapper;
import com.example.mybatisdemo.mapper.UserRoleMapper;
import com.example.mybatisdemo.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByUserName(String userName) {
        return roleMapper.findByUserName(userName);
    }
}
