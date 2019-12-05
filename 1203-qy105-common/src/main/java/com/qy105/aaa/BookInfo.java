package com.qy105.aaa;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BookInfo  implements Serializable {
    private Long bookId;
    private String bookName;
    private Integer bookStore;
    private BigDecimal bookPrice;
}