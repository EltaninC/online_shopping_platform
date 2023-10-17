package com.example.online_shopping_platform.mapper;

import com.example.online_shopping_platform.po.Member;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface MemberMapper {
    @Select("select count(*) from member where member_id = #{id} and passwd = #{password}")
    int GetCountMember(int id, String password);

    /*老版
    @Insert("insert into member(head,postcode,phone,member_email,addr,name,passwd,login_name,balance) " +
            "value (#{member.head},#{member.postcode},#{member.phone},#{member.member_email},#{member.addr}," +
            "#{member.name},#{member.passwd},#{member.login_name},0)")
    void InsertMember(@Param("member") Member member);
     */

    @Insert("insert into member(phone,passwd,member_id) value (#{member.phone},#{member.passwd},#{member.member_id})")
    void InsertMember(@Param("member") Member member);

    @Select("select * from member where member_id=#{member_id}")
    Member SelectMemberById(int member_id);

    @Update({"UPDATE member SET login_name =#{member.login_name},passwd =#{member.passwd},addr=#{member.addr}," +
            "phone=#{member.phone},member_email=#{member.member_email},postcode=#{member.postcode}" +
            ", head=#{member.head} where member_id=#{member.member_id}  "})
    void updateMember(@Param("member") Member member);
    @Update({"update member set balance=balance+#{cash} where member_id=#{member_id}"})
    void cancelGroup(@Param("cash") BigDecimal cash, @Param("member_id") int member_id);

    @Update({"update member set balance=balance-#{cash} where member_id=#{member_id}"})
    void buyGroup(@Param("cash") BigDecimal cash,@Param("member_id") int member_id);

    @Select("select count(*) from member")
    int countmember();
}
