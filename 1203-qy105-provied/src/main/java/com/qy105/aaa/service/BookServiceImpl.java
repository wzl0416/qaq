package com.qy105.aaa.service;

import com.qy105.aaa.BookInfo;
import com.qy105.aaa.BookService;
import com.qy105.aaa.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookInfo> getAllBook() {
         List<BookInfo>bookInfos = bookMapper.getAllBook();
        if (null==bookInfos) {

            return null;
        }
        return bookInfos;
    }
}
