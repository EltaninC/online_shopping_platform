package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.OrderDetailMapper;
import com.example.online_shopping_platform.po.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public OrderDetail SelectOrderDetailById(int order_id) {
        return orderDetailMapper.SelectOrderDetail(order_id);
    }
}
