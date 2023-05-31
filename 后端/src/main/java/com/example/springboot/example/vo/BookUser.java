package com.example.springboot.example.vo;

import com.example.springboot.example.entity.Book;
import lombok.Data;

@Data
public class BookUser extends Book {
    private String username;
}
