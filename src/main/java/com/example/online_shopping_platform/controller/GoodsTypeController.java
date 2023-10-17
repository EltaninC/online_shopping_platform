package com.example.online_shopping_platform.controller;

import com.example.online_shopping_platform.po.GoodsTypes;
import com.example.online_shopping_platform.service.GoodsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsTypeController {
    @Autowired
    GoodsTypesService goodsTypeService;

    //显示所有商品类型
    @RequestMapping("/find_goods_type")
    public String FindGoodsType(Model model){
        List<GoodsTypes> goodsTypeList = goodsTypeService.SelectGoodsTypes();
        model.addAttribute("GoodsTypeList",goodsTypeList);
        return "goods_type_management";
    }

    //新建商品类型
    @RequestMapping("goods_types_add")
    public String InsertGoodsTypes(GoodsTypes goodsTypes){
        goodsTypeService.InsertGoodsTypes(goodsTypes);
        return "redirect:find_goods_type";
    }

    //页面跳转（新建商品类型）
    @RequestMapping("to_goods_types_add")
    public String ToInsertGoodsTypes(){
        return "goods_types_add";
    }

    //商品类型删除
    @RequestMapping("/delete_goods_types")
    public String DeleteGoodsTypes(int type_id){
        goodsTypeService.DeleteGoodsTypes(type_id);
        return "redirect:find_goods_type";
    }

    //商品类型信息更新
    @RequestMapping("/goods_types_update")
    public String UpdateGoodsTypes(GoodsTypes goodsTypes){
        goodsTypeService.UpdateGoodsTypes(goodsTypes);
        return "redirect:find_goods_type";
    }

    //页面跳转（商品类型更新)
    @RequestMapping("to_goods_types_update")
    public String ToUpdateGoodsTypes(int type_id,String type_name,Model model){
        model.addAttribute("type_id",type_id);
        model.addAttribute("type_name",type_name);
        return "goods_types_update";
    }
}
