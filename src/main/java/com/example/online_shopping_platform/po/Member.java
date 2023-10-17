package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class Member {
    private int member_id;
    private String login_name;
    private String passwd;
    private String name;
    private String addr;
    private String member_email;
    private String phone;
    private String postcode;
    private String Head;
    private BigDecimal balance;
}
