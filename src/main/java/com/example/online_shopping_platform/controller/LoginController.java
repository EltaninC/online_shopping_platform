package com.example.online_shopping_platform.controller;

import com.example.online_shopping_platform.po.Member;
import com.example.online_shopping_platform.service.FileService;
import com.example.online_shopping_platform.service.MemberService;
import com.example.online_shopping_platform.service.TbManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    TbManagerService tbManagerService;
    @Autowired
    MemberService memberService;
    @Autowired
    FileService fileService;

    //登录
    @PostMapping("/login")
    public String login(@RequestParam("user_id") int user_id, @RequestParam("password") String password,
                        @RequestParam("role") String role, Map<String, Object> map,HttpSession session){
        if(role.equals("b") && tbManagerService.hasMatchAdmin(user_id, password)){
            session.setAttribute("Uid",user_id);
            session.setAttribute("role",role);
            return "redirect:/find_goods";
        } else if (role.equals("c") && memberService.hasMatchMember(user_id, password)) {
            session.setAttribute("Uid",user_id);
            session.setAttribute("role",role);
            return "redirect:/tohome";
        } else {
            map.put("msg","账号或密码错误");
            return "login";
        }

    }

    //注册
    @RequestMapping("/enroll")
    public String Enroll(int id, String phone, String passwd, String role){
        if(role.equals("b")){
            tbManagerService.InsertManager(id,passwd);
        }
        else {
            Member member = new Member();
            member.setMember_id(id);
            member.setPasswd(passwd);
            member.setPhone(phone);
            memberService.InsertMember(member);
        }
        return "login";
    }


    /* 老版
    //管理员注册
    @PostMapping("/enroll_manager")
    public String EnrollManager(TbManager manager){
        tbManagerService.InsertManager(manager.getLogin_name(),manager.getPasswd());
        return "index";
    }

    @RequestMapping("/path_enroll_manager")
    public String PathToEnrollManager(){
        return "enroll_manager";
    }


    //用户注册
    @PostMapping("/enroll_member")
    public String EnrollMember(Member member, @RequestParam("file") MultipartFile multipartFile){
        String head = fileService.handlerFormUpload(multipartFile);
        member.setHead(head);
        memberService.InsertMember(member);
        return "index";
    }

    @RequestMapping("/path_enroll_member")
    public String PathToEnrollMember(){
        return "enroll_member";
    }
     */

}
