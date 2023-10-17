package com.example.online_shopping_platform.po;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TbManager {
    private int manager_id;
    private String login_name;
    private String passwd;
}
