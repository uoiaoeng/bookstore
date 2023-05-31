package com.example.springboot.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.example.entity.Book;
import com.example.springboot.example.vo.BookUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookMapper extends BaseMapper<Book> {
    @Select("select book.*,user.name as username from book,user where book.user_id=user.id and book.user_id in (select user.id from user where user.name like \"%${username}%\")")
    Page<BookUser> pageByUsername(@Param("page") Page<BookUser> page, @Param("username") String username);
}
