package com.example.managesystem.Entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("sys_user")
public class SysUserEntity {
    private int id;
    private String userName;
    private String password;
    private String nickName;
    private String mobile;
    //逻辑删除
    @TableLogic
    private int isDeleted=0;
    private int accountType;
    private int accountState;
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private String userRole;
    private String updateUser;
    private String createUser;

}
