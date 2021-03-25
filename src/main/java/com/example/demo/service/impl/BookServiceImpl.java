package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.mapper.BooktableMapper;
import com.example.demo.model.Booktable;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BooktableMapper booktableMapper;

    @Override
    @Transactional
    public List<Booktable> getBookList() {
        List<Booktable> list = booktableMapper.selectByExample(null);
        return list;
    }
    
}
