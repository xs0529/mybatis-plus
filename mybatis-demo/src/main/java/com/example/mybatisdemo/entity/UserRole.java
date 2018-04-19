package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xieshuang
 * @since 2018-04-19
 */
@TableName("t_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private Long userId;
    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", id=" + id +
        "}";
    }
}
