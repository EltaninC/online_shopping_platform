package com.example.online_shopping_platform.mapper;

import com.example.online_shopping_platform.po.GoodsTypes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsTypesMapper {
    @Select("select * from goods_types")
    List<GoodsTypes> SelectGoodsTypes();
    @Insert("insert into goods_types(type_name) values(#{goodsTypes.type_name})")
    void InsertGoodsTypes(@Param("goodsTypes") GoodsTypes goodsTypes);
    @Delete("delete from goods_types where type_id=#{type_id}")
    void DeleteGoodsTypes(int type_id);
    @Update("update goods_types set type_name=#{goodsTypes.type_name} where type_id=#{goodsTypes.type_id}")
    void UpdateGoodsTypes(@Param("goodsTypes") GoodsTypes goodsTypes);
}
