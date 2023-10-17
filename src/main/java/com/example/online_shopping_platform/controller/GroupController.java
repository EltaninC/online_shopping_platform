package com.example.online_shopping_platform.controller;


import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.po.Groups;
import com.example.online_shopping_platform.service.GoodsService;
import com.example.online_shopping_platform.service.GroupSerivice;
import com.example.online_shopping_platform.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private GroupSerivice groupSerivice;
    @Autowired
    Goods goods;
    @Autowired
    MemberService memberService;
    @Autowired
    GoodsService goodsService;



    //团购商品
    @RequestMapping("/findGroupGood")
    public String findGroupGood(Model model){
        List<Goods> GroupList=groupSerivice.findGroupGoods();
        model.addAttribute("groupList",GroupList);
        return "group_list";

    }

   //参与拼团
   @RequestMapping("/insertGroup")
    public String insertGroup(Model model ,int goods_id,HttpSession session){
        int Uid = (int) session.getAttribute("Uid");
        Groups firstGroup=groupSerivice.findGroupIdByGood(goods_id);
        Goods good = goodsService.findGoodById(goods_id);
        //还未有人发起拼团
        if(firstGroup==null){
             groupSerivice.insertGroup(goods_id,0,Uid);
             model.addAttribute("msg","还差一人即可拼团成功");
              //  System.out.println(firstGroup);
        }else {
             groupSerivice.updateGroup(firstGroup.getGroup_id());
            groupSerivice.insertGroup(goods_id,1,Uid);
            model.addAttribute("msg","拼团成功");
        }
       BigDecimal chen= BigDecimal.valueOf(0.80);
       BigDecimal freeprice=good.getCash().multiply(chen);
       memberService.buyGroup(freeprice,Uid);
       goodsService.updateGoodNums(1,goods_id);
       return "redirect:findGroupGood";
   }

   //取消团购
   @RequestMapping("/cancelGroup")
    public void cancelGroup(Model model,int group_id){
        groupSerivice.cancelGroup(group_id);

   }

   //用户团购订单

   @RequestMapping("/groupDetail")
    public String groupDetail(Model model,HttpSession session){
        List<Groups> groupsList=groupSerivice.findGroupByBuyerId((Integer) session.getAttribute("Uid"));
        model.addAttribute("groupList",groupsList);
        return "index_2";

   }




}
