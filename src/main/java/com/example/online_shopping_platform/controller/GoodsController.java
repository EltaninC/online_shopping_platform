package com.example.online_shopping_platform.controller;

import com.example.online_shopping_platform.po.Goods;
import com.example.online_shopping_platform.service.FileService;
import com.example.online_shopping_platform.service.GoodsService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    FileService fileService;
    //显示所有商品
    @RequestMapping("/find_goods")
    public String FindGoods(Model model, HttpSession session){
        PageInfo<Goods> pageInfo = goodsService.SelectGoods(1,6);
        List<Goods> goodsList = pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page",pageInfo);
        session.setAttribute("FindGoodsTag","all");
        //return "goods_management";
        return "goods_management";
    }

    //上下页
    @RequestMapping("/goods_switch")
    public String Switch(HttpServletRequest request, Model model, HttpSession session){
        int page = Integer.parseInt(request.getParameter("pageNum"));
        if(page == 0){
            page = 1;
        }
        PageInfo<Goods> pageInfo;
        if(session.getAttribute("FindGoodsTag").equals("all")){
            pageInfo = goodsService.SelectGoods(page,6);
        }
        else {
            pageInfo = goodsService.SelectGoodsByName((String) session.getAttribute("FindGoodsTag"), page,6);
        }
        List<Goods> goodsList = pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page",pageInfo);
        //return "goods_management";
        return "goods_management";
    }

    //新增商品
    @RequestMapping("/insert_goods")
    public String InsertGoods(Goods goods, @RequestParam("file") MultipartFile file){
        System.out.println(goods);
        String pic = fileService.handlerFormUpload(file);
        goods.setPic(pic);
        goodsService.InsertGoods(goods);
        return "redirect:find_goods";
    }

    //页面跳转（商品增加页面）
    @RequestMapping("to_goods_add")
    public String ToGoodsAdd(){
        return "goods_add";
    }


    //删除商品
    @RequestMapping("delete_goods")
    public String DeleteGoods(int goods_id, int pageNum, RedirectAttributes redirectAttributes){
        goodsService.DeleteGoods(goods_id);
        //通过前端获取当前页面号，再利用重定向携带参数，保证进行数据操作后返回原来界面
        redirectAttributes.addAttribute("pageNum",pageNum);
        return "redirect:goods_switch";
    }

    //页面跳转（商品信息修改页面）
    @RequestMapping("to_goods_update")
    public String ToGoodsUpdate(int goods_id, Model model, int pageNum){
        Goods goods = goodsService.SelectGoodsById(goods_id);
        model.addAttribute("Goods",goods);
        ///重定向携带页面参数
        model.addAttribute("pageNum",pageNum);
        return "goods_update";
    }

    //商品信息更改
    @RequestMapping("/update_goods")
    public String UpdateGoods(Goods goods, @RequestParam("file") MultipartFile file,
                              @RequestParam("pageNum")int pageNum, RedirectAttributes redirectAttributes){
        System.out.println(pageNum);
        String pic = fileService.handlerFormUpload(file);
        goods.setPic(pic);
        goodsService.UpdateGoods(goods);
        ///重定向携带页面参数
        redirectAttributes.addAttribute("pageNum",pageNum);
        return "redirect:goods_switch";
    }

    //通过商品名模糊查询
    @RequestMapping("/find_goods_by_name")
    public String FindGoodsByName(String name, Model model, HttpSession session){
        PageInfo<Goods> pageInfo = goodsService.SelectGoodsByName(name,1,6);
        List<Goods> goodsList = pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page",pageInfo);
        session.setAttribute("FindGoodsTag",name);
        //return "goods_management";
        return "goods_management";
    }



    /*
    以下代码
    ：by进宝
     */

    @RequestMapping("/findGoodById")
    public String findGoodById(int goods_id,Model model) {
        Goods good= goodsService.findGoodById(goods_id);
        model.addAttribute("good",good);
        return "buy";

    }

    //团购商品详情
    @RequestMapping("/findGroupById")
    public String findGroupById(int goods_id,Model model) {
        Goods good= goodsService.findGoodById(goods_id);
        model.addAttribute("good",good);
        return "group_detail";

    }


    //跳转Id商品信息
    @RequestMapping("/togood_detail")
    public String togood_detail() {
        // TODO Auto-generated method stub
        return "good_detail";
    }
    //模糊查询商品信息
    @RequestMapping("/findGoodLikeinfos")
    public String findGoodsLikeinfos(String infos,Model model) {
        List<Goods> goodlist= goodsService.findGoodLikeinfos(infos);
        for(Goods good:goodlist) {
            System.out.println(good);
        }
        model.addAttribute("goodlist",goodlist);
        return "goodsearch";


    }

    //跳转Id商品信息
    @RequestMapping("/togoodslist")
    public String togoods() {
        // TODO Auto-generated method stub
        return "goodslist";
    }
    //查询符合价格范围的商品
    public String findGoodBetweenCash(String low, String high,Model model){
        List<Goods> goodbetween= goodsService.findGoodBetweenCash(low, high);
        model.addAttribute("goodbetween",goodbetween);
        for(Goods good:goodbetween) {
            System.out.println(good);
        }

        return "goodslist";
    }

    //分页查询
    @RequestMapping("/findAllGoods")
    public String fengye(HttpSession session, Model model) {
        PageInfo<Goods> pageInfo = this.goodsService.findGoodByLimit(1,6);
        List<Goods> goodsList=pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page", pageInfo);
        session.setAttribute("FindTag", "all");

        for(Goods good:goodsList) {
            System.out.println(good);
        }
        return "goodslimit";


    }

    @RequestMapping({"/switch"})
    public String SwitchGoods(HttpServletRequest request, Model model, HttpSession session) {
        int page = Integer.parseInt(request.getParameter("page"));
        if (page == 0) {
            page = 1;
        }

        PageInfo pageInfo;

        pageInfo = this.goodsService.findGoodByLimit(page, 6);


        List<Goods> goodsList = pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page", pageInfo);
        return "recommend";
    }


    @RequestMapping("/findGoodByTypename")
    public String findGoodByType_name(HttpServletRequest request, Model model){
        String type_name=request.getParameter("type_name");
        int type_id= goodsService.findGoodTypeByName(type_name);
        List<Goods> goodsList= goodsService.findGoodByType(type_id);
        model.addAttribute("goodslist",goodsList);
        model.addAttribute("type",type_name);
        return "goods_type";
    }

    @RequestMapping("/togoodtype")
    public String togoodtype() {
        // TODO Auto-generated method stub
        return "goods_type";
    }


    @RequestMapping("/tohome")
    public String tohome(){
        return "home";
    }

    @RequestMapping("/toclassification")
    public String toclassification(){
        return "classification";
    }

    @RequestMapping("/torecommend")
    public String torecommend(Model model,HttpSession session){
        PageInfo<Goods> pageInfo = this.goodsService.findGoodByLimit(1,6);
        List<Goods> goodsList=pageInfo.getList();
        model.addAttribute("GoodsList", goodsList);
        model.addAttribute("page", pageInfo);
        session.setAttribute("FindTag", "all");

        for(Goods good:goodsList) {
            System.out.println(good);
        }

        return "recommend";
    }

    @RequestMapping("countgood")
    public String countGood(Model model){
        int countgood= goodsService.countGood();
        model.addAttribute("countgood",countgood);
        return "count";
    }

    @RequestMapping("/tocount")
    public  String tocount(){
        return "count";
    }





}
