package com.example.online_shopping_platform.mapper;

import com.example.online_shopping_platform.po.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Select("select * from orders")
    List<Orders> SelectOrders();

    @Select("select * from orders where order_id=#{order_id}")
    List<Orders> SelectOrdersById(int order_id);

    @Update("update orders set status = #{status} where order_id=#{order_id}")
    void UpdateOrders(int status, int order_id);

    @Select("select * from orders where member_id=#{Uid}")
    List<Orders> SelectOrdersByUid(int Uid);

    @Insert("insert into orders(status,countcash,phone,name,addr,order_time,member_id,order_id) " +
            "values(#{orders.status},#{orders.countcash},#{orders.phone},#{orders.name},#{orders.addr},#{orders.order_time},#{orders.member_id}" +
            ",#{orders.order_id})")
    void InsertOrders(@Param("orders") Orders orders);
    @Select("select Max(order_id) from orders")
    int GetMaxId();

    @Select("select count(*) from orders")
    int countorder();
}
