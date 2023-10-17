package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.GoodsMapper;
import com.example.online_shopping_platform.mapper.MemberMapper;
import com.example.online_shopping_platform.mapper.OrderDetailMapper;
import com.example.online_shopping_platform.mapper.OrdersMapper;
import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.po.Member;
import com.example.online_shopping_platform.po.OrderDetail;
import com.example.online_shopping_platform.po.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public PageInfo<Orders> SelectOrders(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Orders> ordersList =  ordersMapper.SelectOrders();
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(ordersList);
        return ordersPageInfo;
    }

    @Override
    public void UpdateOrders(int status, int order_id) {
        ordersMapper.UpdateOrders(status,order_id);
    }

    @Override
    public PageInfo<Orders> SelectOrdersById(int order_id) {
        PageHelper.startPage(1,8);
        List<Orders> ordersList =  ordersMapper.SelectOrdersById(order_id);
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(ordersList);
        return ordersPageInfo;
    }

    @Override
    public PageInfo<Orders> SelectOrdersByUId(int Uid) {
        PageHelper.startPage(1,10);
        List<Orders> ordersList =  ordersMapper.SelectOrdersByUid(Uid);
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(ordersList);
        return ordersPageInfo;
    }

    @Override
    @Transactional
    public void InsertOrders(int Uid, int goods_id, int nums) {
        Member member = memberMapper.SelectMemberById(Uid);
        Goods goods = goodsMapper.SelectGoodsById(goods_id);
        int order_id = ordersMapper.GetMaxId() + 1;
        Orders orders = new Orders();
        OrderDetail orderDetail = new OrderDetail();
        orders.setPhone(member.getPhone());
        orders.setAddr(member.getAddr());
        orders.setCountcash(goods.getCash().multiply(BigDecimal.valueOf(nums)));
        orders.setName(member.getName());
        orders.setOrder_time(LocalDateTime.now());
        orders.setStatus(1);
        orders.setMember_id(member.getMember_id());
        orders.setOrder_id(order_id);
        orderDetail.setCash(goods.getCash());
        orderDetail.setNums(nums);
        orderDetail.setGoods_id(goods_id);
        orderDetail.setOrder_id(order_id);
        ordersMapper.InsertOrders(orders);
        orderDetailMapper.InsertOrderDetail(orderDetail);
    }

    @Override
    public int countorder() {
        return ordersMapper.countorder();
    }
}
