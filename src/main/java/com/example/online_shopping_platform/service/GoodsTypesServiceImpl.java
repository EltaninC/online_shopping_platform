package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.GoodsTypesMapper;
import com.example.online_shopping_platform.po.GoodsTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsTypesServiceImpl implements GoodsTypesService {
    @Autowired
    GoodsTypesMapper goodsTypeMapper;
    @Override
    public List<GoodsTypes> SelectGoodsTypes() {
        return goodsTypeMapper.SelectGoodsTypes();
    }

    @Override
    public void InsertGoodsTypes(GoodsTypes goodsTypes) {
        goodsTypeMapper.InsertGoodsTypes(goodsTypes);
    }

    @Override
    public void DeleteGoodsTypes(int type_id) {
        goodsTypeMapper.DeleteGoodsTypes(type_id);
    }

    @Override
    public void UpdateGoodsTypes(GoodsTypes goodsTypes) {
        goodsTypeMapper.UpdateGoodsTypes(goodsTypes);
    }
}
