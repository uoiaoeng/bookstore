package com.example.springboot.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.example.entity.Book;
import com.example.springboot.example.vo.BookUser;

import java.util.List;

public interface BookService extends IService<Book> {

    Boolean addOrUpdate(Book book);

    Book getByName(String name);

    void deleteByIds(String ids);

    void updateUsefulByIds(String ids,Boolean useful);

    List<Book> list(String name,Double priceMin, Double priceMax);

    Page<Book> page(Integer pageNum, Integer pageSize, String name);

    Page<BookUser> pageByUsername(Integer pageNum, Integer pageSize, String username);

    Page<Book> pageList(Integer pageNum, Integer pageSize);

    List<Book> AllList();
}
