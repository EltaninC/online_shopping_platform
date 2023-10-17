package com.example.online_shopping_platform.mapper;


import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.po.Groups;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper {

    //团购商品
    @Select({"select goods.* from goods,shop.groups where goods.goods_id=groups.goods_id and groups.group_status=-1"})
    List<Goods> findGroupGoods();

    //该商品是否有人已发起拼团
    @Select({"select * from shop.groups where goods_id=#{goods_id} and group_status=0 "})
    Groups findGroupIdByGood(int goods_id);

    //参与拼团
    @Insert({"insert into shop.groups (goods_id,group_status,buyer_id) values(#{goods_id},#{group_status},#{buyer_id})"})
    void insertGroup(@Param("goods_id") int goods_id,@Param("group_status") int group_status,@Param("buyer_id")  int buyer_id);


    //修改拼团信息
    @Update({"update shop.groups set group_status=1 where group_id=#{group_id}"})
    void updateGroup(int group_id);

    //取消拼团
    @Delete({"delete * from shop.groups where group_id=#{group_id}"})
    void cancelGroup(int group_id);

    //用户的拼团订单
    @Select("select * from shop.groups where buyer_id=#{buyer_id}")
    List<Groups> findGroupByBuyerId(int buyer_id);
}
