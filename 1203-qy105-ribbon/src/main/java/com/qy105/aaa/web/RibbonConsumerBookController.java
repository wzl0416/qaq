package com.qy105.aaa.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qy105.aaa.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class RibbonConsumerBookController {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "15000")})
    @GetMapping("getAllBookFromRibbon")
    public List<BookInfo> getAllBook(){
        LinkedList<BookInfo> forObject = restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
        return forObject;
    }
    public List<BookInfo> error() {
        System.out.println("服务熔断");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("大主宰");
        ArrayList<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(bookInfo);
        return bookInfos;
    }
}
