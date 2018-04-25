package com.example.mybatisdemo.common.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.mybatisdemo.common.enums.ResultEnum;
import com.example.mybatisdemo.common.exception.MyException;
import com.example.mybatisdemo.entity.Menu;
import com.example.mybatisdemo.entity.Role;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.service.IMenuService;
import com.example.mybatisdemo.service.IRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 谢霜
 * @Description
 * @date 2018/4/25 10:00
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    IRoleService iRoleService;
    @Autowired
    IMenuService iMenuService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUsername();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //设置角色
        List<Role> roleList = iRoleService.findByUserName(userName);
        Set<String> roles = new HashSet<String>();
        for (Role role : roleList) {
            roles.add(role.getRoleName());
        }
        simpleAuthorizationInfo.setRoles(roles);
        //设置权限
        List<Menu> menuList = iMenuService.findMenuByUserName(userName);
        Set<String> menus = new HashSet<String>();
        for (Menu menu:menuList){
            menus.add(menu.getPerms());
        }
        simpleAuthorizationInfo.setStringPermissions(menus);
        return simpleAuthorizationInfo;
    }

    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        User user = new User();
        List<User> users = user.selectList(new EntityWrapper(user).eq("USERNAME", userName));
        if (users.size() < 1) {
            throw new MyException(ResultEnum.NAME_NOT_EXIST);//用户名不存在
        }
        user = users.get(0);
        if (!password.equals(user.getPassword())) {
            throw new MyException(ResultEnum.PASSWORD_ERROR);//密码错误
        }
        if ("0".equals(user.getStatus())) {
            throw new MyException(ResultEnum.ACCOUNT_IS_LOCKED);//账号已被锁定
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
