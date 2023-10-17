package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.GoodsMapper;
import com.example.online_shopping_platform.po.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public PageInfo<Goods> SelectGoods(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goods> goodsList = goodsMapper.SelectGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    @Override
    public void InsertGoods(Goods goods) {
        goodsMapper.InsertGoods(goods);
    }

    @Override
    public void DeleteGoods(int goods_id) {
        goodsMapper.DeleteGoods(goods_id);
    }

    @Override
    public Goods SelectGoodsById(int goods_id) {
        return goodsMapper.SelectGoodsById(goods_id);
    }

    @Override
    public void UpdateGoods(Goods goods) {
        goodsMapper.UpdateGoods(goods);
    }

    @Override
    public PageInfo<Goods> SelectGoodsByName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goods> goodsList = goodsMapper.SelectGoodsByName(name);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }


    /*
    以下代码
    ：by进宝
    */

    @Override
    //根据Id查询商品信息
    public Goods findGoodById(int id) {
        // TODO Auto-generated method stub
        return goodsMapper.findGoodById(id);
    }

    @Override
    //根据信息模糊查询商品信息
    public List<Goods> findGoodLikeinfos(String infos) {
        // TODO Auto-generated method stub
        return goodsMapper.findGoodLikeinfos(infos);
    }

    @Override
    //查询符合价格范围的商品
    public List<Goods> findGoodBetweenCash(String low, String high) {
        // TODO Auto-generated method stub
        return goodsMapper.findGoodBetweenCash(low, high);
    }

    @Override
    public PageInfo<Goods> findGoodByLimit(int page, int pageSize) {

        // TODO Auto-generated method stub
        PageHelper.startPage(page, pageSize);
        List<Goods> goodsList = this.goodsMapper.findGoodByLimit();
        PageInfo<Goods> pageInfo = new PageInfo(goodsList);
        return pageInfo;
    }

    @Override
    public int countGood() {
        // TODO Auto-generated method stub
        return goodsMapper.countGood();
    }

    @Override
    public List<Goods> findGoodByType(int type_id) {
        return goodsMapper.findGoodByType(type_id);
    }

    @Override
    public int findGoodTypeByName(String type_name) {
        return goodsMapper.findGoodTypeByName(type_name);
    }


    @Override
    public void updateGoodNums(int num,int goods_id) {
        goodsMapper.updateGoodNums(num,goods_id);
    }
}
