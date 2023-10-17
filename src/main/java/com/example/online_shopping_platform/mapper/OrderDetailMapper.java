package com.example.online_shopping_platform.mapper;

import com.example.online_shopping_platform.po.OrderDetail;
import com.example.online_shopping_platform.po.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    @Select("select * from order_detail where order_id=#{order_id}")
    OrderDetail SelectOrderDetail(int order_id);

    @Insert("insert into order_detail(nums,cash,goods_id,order_id) values(#{orderDetail.nums},#{orderDetail.cash},#{orderDetail.goods_id}," +
            "#{orderDetail.order_id})")
    void InsertOrderDetail(@Param("orderDetail") OrderDetail orderDetail);
}
