package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.po.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {
    PageInfo<Goods> SelectGoods(int page, int pageSize);
    void InsertGoods(Goods goods);
    void DeleteGoods(int goods_id);
    Goods SelectGoodsById(int goods_id);
    void UpdateGoods(Goods goods);
    PageInfo<Goods> SelectGoodsByName(String name, int page, int pageSize);

    /*
    以下代码
    ：by进宝
    */

    //根据Id查询商品信息
    Goods findGoodById(int id) ;

    //根据信息模糊查询商品信息
    List<Goods> findGoodLikeinfos(String infos);

    //查询符合价格范围的商品
    List<Goods> findGoodBetweenCash(String low,String high);

    //分页查询总商品
    PageInfo<Goods> findGoodByLimit(int page, int pageSize);



    List<Goods> findGoodByType(int type_id);

    int findGoodTypeByName(String type_name);
    void updateGoodNums(int num,int goods_id);

    //薛靖宇

    //查询总商品数
    int countGood();
}
