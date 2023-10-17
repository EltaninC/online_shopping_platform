package com.example.online_shopping_platform.service;


import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.po.Groups;

import java.util.List;

public interface GroupSerivice {

    //查询团购商品
    List<Goods> findGroupGoods();

    //参团时判断是否已经有人发起此拼团
    Groups findGroupIdByGood(int goods_id);

    void insertGroup(int goods_id,int group_status,int buyer_id);

    void updateGroup(int group_id);

    void cancelGroup(int group_id);

    List<Groups> findGroupByBuyerId(int buyer_id);
}
