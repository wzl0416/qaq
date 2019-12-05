package com.qy105.aaa.service;

import com.qy105.aaa.BookInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceHystrixImpl implements BookService {
    @Override
    public List<BookInfo> getAllBook() {
        System.out.println("服务降级中");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("大主宰");
        ArrayList<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(bookInfo);
        return bookInfos;
    }
}