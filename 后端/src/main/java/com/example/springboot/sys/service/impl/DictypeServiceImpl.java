package com.example.springboot.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.sys.mapper.DictypeMapper;
import com.example.springboot.sys.entity.Dictype;
import com.example.springboot.sys.service.DictypeService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author guoxiaofeng
* @since 2022-12-09
*/
@Service
public class DictypeServiceImpl extends ServiceImpl<DictypeMapper,Dictype> implements DictypeService {


    @Override
    public Boolean addOrUpdate(Dictype dictype) {
        if(StringUtils.isNullOrEmpty(dictype.getId())){
            this.save(dictype);
        }else {
            this.updateById(dictype);
        }
        return true;
    }

    @Override
    public void deleteByIds(String ids) {
        List<String> listIds = new ArrayList<>();
        String[] aryIds = ids.split(",");
        for(String id: aryIds){
            listIds.add(id);
        }
        this.removeByIds(listIds);
    }

    @Override
    public List<Dictype> list( ) {
        return this.list();
    }

    @Override
    public Page<Dictype> page(Integer pageNum,Integer pageSize) {
        Page<Dictype> page = new Page(pageNum,pageSize);
        return this.page(page);
    }
}