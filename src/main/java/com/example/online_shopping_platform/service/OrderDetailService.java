package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.po.OrderDetail;

public interface OrderDetailService {
    public OrderDetail SelectOrderDetailById(int order_id);
}
