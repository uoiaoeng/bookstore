package com.example.springboot.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data  //代替get、set方法
@TableName("book")  //与数据库中的实体对应
@ApiModel(value = "Book实体",description = "书籍表")
public class Book extends BaseEntity {
    @ApiModelProperty(value = "书名")
    private String name;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "是否可用，0不可用 1可用")
    private Boolean useful;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "书本图片的路径")
    private String imageUrl;

    @ApiModelProperty(value = "书本的库存")
    private Integer inventory;

    @ApiModelProperty(value = "书本的简介")
    private String introduction;

    @ApiModelProperty(value = "书本的作者")
    private String author;

    @ApiModelProperty(value = "书籍的创建者的id")
    private String userId;

    @ApiModelProperty(value = "创建时间 YYYY-MM-DD hh:mm:ss")
    private String createTime;

}
