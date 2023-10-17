package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
@Data
public class Goods {
    private int goods_id;
    private int type_id;
    private String name;
    private BigDecimal cash;
    private String infos;
    private String pic;
    private int nums;
}
