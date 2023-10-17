package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.MemberMapper;
import com.example.online_shopping_platform.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;
    @Override
    public boolean hasMatchMember(int uid, String password) {
        return memberMapper.GetCountMember(uid,password) == 1;
    }

    @Override
    public void InsertMember(Member member) {
        memberMapper.InsertMember(member);
    }

    @Override
    public Member SelectMember(int id) {
        return memberMapper.SelectMemberById(id);
    }

    /*
     by:进宝
     */
    public void updateMember(Member member) {

        memberMapper.updateMember(member);
    }

    @Override
    public void buyGroup(BigDecimal balance, int member_id) {
        memberMapper.buyGroup(balance,member_id);
    }

    @Override
    public int countmember() {
        return memberMapper.countmember();
    }
}
