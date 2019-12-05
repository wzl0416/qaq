package com.qy105.aaa.service;


import com.qy105.aaa.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {


    @GetMapping("/getAllBook")
    List<BookInfo> getAllBook();
}
