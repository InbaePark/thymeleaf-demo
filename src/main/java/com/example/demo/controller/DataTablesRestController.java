package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.demo.dto.Book;
import com.example.demo.form.Account;
import com.example.demo.model.Booktable;
import com.example.demo.service.BookService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTablesRestController {
    
    @Autowired
    BookService bookService;

    @RequestMapping("/getaccountlist")
    public List<Account> getuserlist() {

        List<Account> list = new ArrayList<>();
        Account a = new Account();
        a.setEmail("admin@localhost");
        a.setUsername("admin");
        Account b = new Account();
        b.setEmail("user@localhost");
        b.setUsername("user");
        list.add(a);
        list.add(b);
        return list;
    }

    @RequestMapping("/getbooklist")
    public List<Book> getBookList() {
        
        List<Book> bookList = bookService.getBookList()
                                    .stream().map(new Function<Booktable, Book>(){
                                        @Override
                                        public Book apply(Booktable book) {
                                            Book b = new Book();
                                            BeanUtils.copyProperties(book, b);
                                            return b;
                                        }
                                    }).collect(Collectors.toList());

        return bookList;
    }
    
}
