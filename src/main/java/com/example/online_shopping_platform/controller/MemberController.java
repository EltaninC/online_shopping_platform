package com.example.online_shopping_platform.controller;

import com.example.online_shopping_platform.po.Member;
import com.example.online_shopping_platform.service.FileService;
import com.example.online_shopping_platform.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/toupdateMember")
    public String toupdateMember(){
       return "member_detail";
    }


    //个人信息更新
    @RequestMapping("/path_update_member")
    public String PathToUpdateMember(HttpSession session,Model model){
        Member member = memberService.SelectMember((Integer) session.getAttribute("Uid"));
        model.addAttribute("Member",member);
        return "update_member";
    }

    @RequestMapping("/update_member")
    public String updateMember(Member member, Model model, HttpSession session, @RequestParam("file") MultipartFile file){
        member.setMember_id((Integer) session.getAttribute("Uid"));
        String head = fileService.handlerFormUpload(file);
        member.setHead(head);
        System.out.println(member);
        memberService.updateMember(member);
        return "redirect:path_update_member";
    }

    @RequestMapping("path_to_faq")
    public String PathToHelp(){
        return "faq";
    }

    @RequestMapping("countmember")
    public String countMember(Model model){
        int countmember= memberService.countmember();
        model.addAttribute("countmember",countmember);
        return "count";
    }
}
