package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GoodsTypes {
    private int type_id;
    private String type_name;
}
