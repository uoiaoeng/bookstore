package com.example.springboot.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.sys.entity.Dictype;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author guoxiaofeng
* @since 2022-12-09
*/
public interface DictypeService extends IService<Dictype> {


    Boolean addOrUpdate(Dictype dictype);
    void deleteByIds(String ids);
    List<Dictype> list();
    Page<Dictype> page(Integer pageNum,Integer pageSize);
}