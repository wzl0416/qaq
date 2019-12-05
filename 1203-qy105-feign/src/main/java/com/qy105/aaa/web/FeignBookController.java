
package com.qy105.aaa.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qy105.aaa.BookInfo;
import com.qy105.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignBookController {
    @Autowired
    private BookService bookService;

    @HystrixCommand
    @GetMapping("feignGetAllBook")
    public List<BookInfo> getAllBook(){
        List<BookInfo> allBook = bookService.getAllBook();
        System.out.println("feign "+allBook.size());
        return allBook;
    }
}
