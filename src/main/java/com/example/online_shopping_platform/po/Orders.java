package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Component
public class Orders {
    private int order_id;
    private int member_id;
    private LocalDateTime order_time;
    private String addr;
    private String name;
    private String phone;
    private BigDecimal countcash;
    private int status;
}
