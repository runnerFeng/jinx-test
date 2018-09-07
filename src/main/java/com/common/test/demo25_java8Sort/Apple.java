package com.common.test.demo25_java8Sort;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jinx
 * @date 2018/9/6 11:29
 * Desc:
 */
@Data
public class Apple {
    private String id;
    private String name;
    private BigDecimal price;
    private long count;
    private Integer type;

    public Apple() {
    }

    public Apple(String id, String name, BigDecimal price, long count, Integer type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.type = type;
    }
}
