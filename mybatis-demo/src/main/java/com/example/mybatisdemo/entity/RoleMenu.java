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
@TableName("t_role_menu")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;
    /**
     * 菜单/按钮ID
     */
    @TableField("MENU_ID")
    private Long menuId;
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
        return "RoleMenu{" +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        ", id=" + id +
        "}";
    }
}
