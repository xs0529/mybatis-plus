package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xieshuang
 * @since 2018-04-19
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findByUserName(String userName);
}
