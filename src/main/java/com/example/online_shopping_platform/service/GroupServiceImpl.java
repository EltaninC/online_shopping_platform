package com.example.online_shopping_platform.service;


import com.example.online_shopping_platform.mapper.GroupMapper;
import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.po.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GroupServiceImpl implements GroupSerivice{

    @Autowired
    private GroupMapper groupMapper;
    @Override
    public List<Goods> findGroupGoods() {
        return groupMapper.findGroupGoods();
    }

    @Override
    public Groups findGroupIdByGood(int goods_id) {
        return groupMapper.findGroupIdByGood(goods_id);
    }

    @Override
    public void insertGroup(int goods_id, int group_status,int buyer_id) {
        groupMapper.insertGroup(goods_id,group_status,buyer_id);

    }

    @Override
    public void updateGroup(int group_id) {
        groupMapper.updateGroup(group_id);
    }

    @Override
    public void cancelGroup(int group_id) {
        groupMapper.cancelGroup(group_id);
    }

    @Override
    public List<Groups> findGroupByBuyerId(int buyer_id) {
        return groupMapper.findGroupByBuyerId(buyer_id);
    }
}
