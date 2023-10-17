package com.example.online_shopping_platform.mapper;

import com.example.online_shopping_platform.po.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /*分页查询
    @Select("select * from goods where goods_id >= " +
            "(select goods_id from goods order by goods_id limit #{max},1) limit 10")
    */
    @Select("select * from goods")
    List<Goods> SelectGoods();
    @Select("select * from goods where goods_id=#{goods_id}")
    Goods SelectGoodsById(int goods_id);
    @Select("select * from goods where name Like concat('%',#{name},'%')")
    List<Goods> SelectGoodsByName(String name);
    @Insert("insert into goods(type_id,name,cash,infos,pic,nums) Values(#{goods.type_id},#{goods.name},#{goods.cash}" +
            ",#{goods.infos},#{goods.pic},#{goods.nums})")
    void InsertGoods(@Param("goods") Goods goods);

    @Delete("delete from goods where goods_id=#{goods_id}")
    void DeleteGoods(int goods_id);

    @Update("update goods set type_id=#{goods.type_id},name=#{goods.name},cash=#{goods.cash}," +
            "infos=#{goods.infos},pic=#{goods.pic},nums=#{goods.nums} where goods_id=#{goods.goods_id}")
    void UpdateGoods(@Param("goods") Goods goods);

    /*
    以下代码
    ：by进宝
    */

    //根据Id查询商品信息
    //	public Goods findGoodById(int id) ;

    @Select({"select * from goods where goods_id=#{goods_id}"})
    Goods findGoodById(int id) ;

    //根据信息模糊查询商品信息
    @Select({"select * from goods where  infos like concat('%',#{infos},'%')"})
    List<Goods> findGoodLikeinfos(String infos);

    //查询符合价格范围的商品
    @Select({"select * from goods where cash between #{low} and #{high}"})
    List<Goods> findGoodBetweenCash(String low,String high);

    //分页查询
    @Select({" select * from goods "})
    public List<Goods> findGoodByLimit();

    //


    @Select({"select * from goods where  type_id=#{type_id}"})
    List<Goods> findGoodByType(int type_id);


    @Select({"select type_id from goods_types where type_name=#{type_name}"})
    int findGoodTypeByName(String type_name);

    //
    @Update({"update goods set nums=nums-#{num} where goods_id=#{goods_id}"})
    void updateGoodNums(@Param("num") int num,@Param("goods_id") int goods_id);


    @Select({"select count(*) from goods "})
    public int countGood();

}
