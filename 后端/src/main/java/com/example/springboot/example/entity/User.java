package com.example.springboot.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName User
 * @Description: TODO
 * @Author linjiangyi
 * @Date 8/29/22
 * @Version V1.0
 **/
@Data
@TableName("user")
@ApiModel(value = "User",description = "用户表")
public class User extends BaseEntity {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户的角色 0普通用户 1管理员 2超级管理员  默认为0")
    private Integer role;

    @ApiModelProperty(value = "用户旗下的商店id")
    private String storeId;

    @ApiModelProperty(value = "用户联系方式")
    private String telephone;

    @ApiModelProperty(value = "用户的邮箱地址")
    private String email;

    @ApiModelProperty(value = "收藏的书本id")
    private String likeBookId;

    @ApiModelProperty(value = "用户的创建时间 YYYY-MM-DD hh:mm:ss")
    private String createTime;
}
