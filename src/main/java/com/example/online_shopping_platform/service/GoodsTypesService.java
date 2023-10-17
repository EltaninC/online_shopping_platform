package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.po.GoodsTypes;

import java.util.List;

public interface GoodsTypesService {
    List<GoodsTypes> SelectGoodsTypes();
    void InsertGoodsTypes(GoodsTypes goodsTypes);
    void DeleteGoodsTypes(int type_id);
    void UpdateGoodsTypes(GoodsTypes goodsTypes);
}
