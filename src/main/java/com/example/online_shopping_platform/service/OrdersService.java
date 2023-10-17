package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.po.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrdersService {
    public PageInfo<Orders> SelectOrders(int page, int pageSize);
    public void UpdateOrders(int status, int order_id);
    public PageInfo<Orders> SelectOrdersById(int order_id);
    public PageInfo<Orders> SelectOrdersByUId(int Uid);
    public void InsertOrders(int Uid, int goods_id, int nums);

    int countorder();
}
