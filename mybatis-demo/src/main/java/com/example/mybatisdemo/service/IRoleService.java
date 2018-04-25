package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Role;
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
public interface IRoleService extends IService<Role> {
    List<Role> findByUserName(String userName);
}
