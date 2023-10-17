package com.example.online_shopping_platform.controller;

import com.example.online_shopping_platform.po.Orders;
import com.example.online_shopping_platform.service.OrderDetailService;
import com.example.online_shopping_platform.service.OrdersService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrderDetailService orderDetailService;

    //查看所有订单
    @RequestMapping("/find_orders")
    public String FindOrders(Model model, HttpSession session){
        PageInfo<Orders> pageInfo = ordersService.SelectOrders(1,6);
        List<Orders> ordersList = pageInfo.getList();
        model.addAttribute("OrdersList", ordersList);
        model.addAttribute("page",pageInfo);
        session.setAttribute("FindOrdersTag","all");
        //return "orders_management";
        return "orders_management";
    }

    //搜索订单
    @RequestMapping("/find_orders_by_id")
    public String FindOrdersById(Model model, HttpSession session, int order_id){
        PageInfo<Orders> pageInfo = ordersService.SelectOrdersById(order_id);
        List<Orders> ordersList = pageInfo.getList();
        model.addAttribute("OrdersList", ordersList);
        model.addAttribute("page",pageInfo);
        session.setAttribute("FindOrdersTag","all");
        return "orders_management";
    }

    //上下页
    @RequestMapping("/orders_switch")
    public String Switch(HttpServletRequest request, Model model, HttpSession session){
        int page = Integer.parseInt(request.getParameter("pageNum"));
        if(page == 0){
            page = 1;
        }
        PageInfo<Orders> pageInfo;
        if(session.getAttribute("FindOrdersTag").equals("all")){
            pageInfo = ordersService.SelectOrders(page,6);
        }
        else {
            pageInfo = ordersService.SelectOrders(page,6);
            //pageInfo = ordersService.SelectOrderById((String) session.getAttribute("FindTag"), page,10);
        }
        List<Orders> ordersList = pageInfo.getList();
        model.addAttribute("OrdersList", ordersList);
        model.addAttribute("page",pageInfo);
        return "orders_management";
    }

    //查看订单详情
    @RequestMapping("find_order_detail")
    public String FindOrderDetail(int order_id, Model model){
        model.addAttribute("OrderDetail", orderDetailService.SelectOrderDetailById(order_id));
        return "order_detail";
    }

    //发货
    @RequestMapping("send")
    public String Send(int order_id){
        ordersService.UpdateOrders(3,order_id);
        return "redirect:find_orders";
    }

    //查看订单通过用户id
    @RequestMapping("/find_orders_by_Uid")
    public String FindOrdersByUId(Model model, HttpSession session){
        PageInfo<Orders> pageInfo = ordersService.SelectOrdersByUId((Integer) session.getAttribute("Uid"));
        List<Orders> ordersList = pageInfo.getList();
        model.addAttribute("OrdersList", ordersList);
        model.addAttribute("page",pageInfo);
        session.setAttribute("FindOrdersTag","all");
        return "order_list";
    }
    @RequestMapping("/insert_order")
    public String InsertOrders(@Param("goodsNum") int goodsNum, @Param("goods_id") int goods_id, HttpSession session){
        System.out.println(session.getAttribute("Uid"));
        ordersService.InsertOrders((Integer) session.getAttribute("Uid"),goods_id,goodsNum);
        return "redirect:/torecommend";
    }


    @RequestMapping("countorder")
    public String countOrder(Model model){
        int countorder=ordersService.countorder();
        model.addAttribute("countorder",countorder);
        return "count";
    }

}
