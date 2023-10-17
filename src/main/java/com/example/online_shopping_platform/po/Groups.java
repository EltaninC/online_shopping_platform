package com.example.online_shopping_platform.po;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Groups {
    private int group_id;
    private int goods_id;
    private int group_status;
    private int buyer_id;
}
