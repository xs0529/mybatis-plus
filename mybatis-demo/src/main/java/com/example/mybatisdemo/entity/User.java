package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;
    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;
    /**
     * 部门ID
     */
    @TableField("DEPT_ID")
    private Long deptId;
    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;
    /**
     * 联系电话
     */
    @TableField("MOBILE")
    private String mobile;
    /**
     * 状态 0锁定 1有效
     */
    @TableField("STATUS")
    private String status;
    /**
     * 创建时间
     */
    @TableField("CRATE_TIME")
    private Date crateTime;
    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;
    /**
     * 最近访问时间
     */
    @TableField("LAST_LOGIN_TIME")
    private Date lastLoginTime;
    /**
     * 性别 0男 1女
     */
    @TableField("SSEX")
    private String ssex;
    /**
     * 主题
     */
    @TableField("THEME")
    private String theme;
    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;
    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private String description;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", deptId=" + deptId +
        ", email=" + email +
        ", mobile=" + mobile +
        ", status=" + status +
        ", crateTime=" + crateTime +
        ", modifyTime=" + modifyTime +
        ", lastLoginTime=" + lastLoginTime +
        ", ssex=" + ssex +
        ", theme=" + theme +
        ", avatar=" + avatar +
        ", description=" + description +
        "}";
    }
}
