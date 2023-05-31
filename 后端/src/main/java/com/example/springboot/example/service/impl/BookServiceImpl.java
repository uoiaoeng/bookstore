package com.example.springboot.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.example.entity.Book;
import com.example.springboot.example.mapper.BookMapper;
import com.example.springboot.example.service.BookService;
import com.example.springboot.example.vo.BookUser;
import com.example.springboot.example.utils.DateTool;
import com.example.springboot.example.utils.JwtUtil;
import com.example.springboot.sys.entity.Dictype;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private HttpServletRequest request;
//    @Autowired
//    private UserService userService;

    @Override
    public Boolean addOrUpdate(Book book) {

        if(StringUtils.isNullOrEmpty(book.getId())){
            book.setUseful(true);
            book.setCreateTime(DateTool.getCurrTime());

//            String token = request.getHeader("token");
//            String userId = JwtUtil.validateToken(token);
//            book.setUserId(userId);

            this.save(book);
        }else {
            this.updateById(book);
        }

        return true;
    }

    @Override
    public Book getByName(String name) {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.eq("name",name);
        return this.getOne(bookQueryWrapper);
    }

    @Override
    public void deleteByIds(String ids) {
        List<String> listIds = new ArrayList<>();
        String[] arrIds = ids.split(",");
        for(String id : arrIds){
            listIds.add(id);
        }
        this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids,Boolean useful) {
        String[] arrIds = ids.split(",");
        for(String id : arrIds){
            Book book = new Book();
            book.setUseful(useful);

            UpdateWrapper<Book> bookUpdateWrapper = new UpdateWrapper<>();
            bookUpdateWrapper.eq("id",id);

            this.update(book,bookUpdateWrapper);
        }
    }

    @Override
    public List<Book> list(String name,Double priceMin, Double priceMax) {

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.ge("price",priceMin);
        queryWrapper.le("price",priceMax);

        return this.list(queryWrapper);
    }

    @Override
    public List<Book> AllList() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }

    @Override
    public Page<Book> page(Integer pageNum, Integer pageSize, String name) {
        Page<Book> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        return this.page(page,queryWrapper);
    }

    @Override
    public Page<Book> pageList(Integer pageNum, Integer pageSize) {
        Page<Book> page = new Page(pageNum,pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("price",0);
        return this.page(page,queryWrapper);
    }

    @Override
    public Page<BookUser> pageByUsername(Integer pageNum, Integer pageSize, String username) {
        Page<BookUser> page = new Page<>(pageNum,pageSize);
        return baseMapper.pageByUsername(page,username);

//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.like("name",username);
//        List<User> userList = userService.list(userQueryWrapper);
//        List<String> userIdList = new ArrayList<>();
//        for(User user : userList){
//            userIdList.add(user.getId());
//        }
//        Page<Book> page = new Page<>(pageNum,pageSize);
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.in("user_id",userIdList);
//        return this.page(page,queryWrapper);
    }
}
