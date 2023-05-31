package com.example.springboot.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot.common.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author guoxiaofeng
 * @since 2022-12-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)

@TableName("dictype")
@ApiModel(value="Dictype对象", description="")
public class Dictype extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典类型名称")
    private String name;

    @ApiModelProperty(value = "字典类型值")
    private String value;


}
