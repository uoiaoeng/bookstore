package com.example.springboot.sys.controller;

import com.example.springboot.example.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.springboot.sys.entity.Dictype;
import com.example.springboot.sys.service.DictypeService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guoxiaofeng
 * @since 2022-12-09
 */
@RestController
@RequestMapping("/sys/dictype")
public class DictypeController {
    @Autowired
    private DictypeService dictypeService;

    @ApiOperation(value = "保存Dictype信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody Dictype dictype) {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        dictypeService.addOrUpdate(dictype);
        result.success("保存成功");
        return result;
    }

    @ApiOperation(value = "批量删除记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",required = true,paramType = "query",value = "需要删除的多个id，用逗号,隔开")
    })
    @RequestMapping(method = RequestMethod.POST,value = "/deleteByIds")
    public Result deleteByIds(String ids) {
        Result result = new Result();
        dictypeService.deleteByIds(ids);
        result.success("删除成功");
        return result;
    }


    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public Result list(  ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(dictypeService.list());
        return result;
    }

    @ApiOperation(value = "分页获取记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",required = true,paramType = "query",value = "当前页码"),
        @ApiImplicitParam(name = "pageSize",required = true,paramType = "query",value = "每页记录数")
    })
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(dictypeService.page(pageNum,pageSize));
        return result;
    }
}
