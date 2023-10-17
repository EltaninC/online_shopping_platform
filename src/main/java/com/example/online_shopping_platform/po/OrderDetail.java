package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class OrderDetail {
    private int order_id;
    private int goods_id;
    private BigDecimal cash;
    private int nums;
}
