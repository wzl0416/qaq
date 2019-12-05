package com.qy105.aaa.web;

import com.qy105.aaa.BookInfo;
import com.qy105.aaa.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    private int i = 1;

    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook() {
        List<BookInfo> allBook = bookService.getAllBook();
        if (null == allBook) {
            return null;
        }
        for (BookInfo bookInfo : allBook) {
            System.out.println(bookInfo);
        }if (++i % 2==0){
            System.out.println(1/0);
        }
        return allBook;
    }

}
