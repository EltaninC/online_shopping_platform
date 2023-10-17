package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.po.Member;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface MemberService {
    public boolean hasMatchMember(int uid, String password);
    public void InsertMember(Member member);
    public Member SelectMember(int id);
    public void updateMember(Member member);
    void buyGroup(@Param("balance") BigDecimal balance, @Param("member_id") int member_id);
    int countmember();
}
