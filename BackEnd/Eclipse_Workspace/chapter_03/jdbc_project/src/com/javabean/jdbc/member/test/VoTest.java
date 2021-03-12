package com.javabean.jdbc.member.test;

import java.sql.Date;

import com.javabean.jdbc.member.domain.MemberVo;

public class VoTest 
{
    public static void main(String[] args) 
    {
        MemberVo member = new MemberVo();
        member.setMemberId("java");
        member.setMemberPassword("1234");
        member.setMemberNickname("LimeParfait");
        member.setMemberName("KJH");
        member.setMemberGender("M");
        member.setMemberEmail("asdf@asdf.com");
        member.setMemberPhone("010-1234-5678");
        member.setMemberBirth(Date.valueOf("1987-07-14"));
        member.setMemberZip("12345");
        member.setMemberAddressBasic("서울 금천구 가산");
        member.setMemberAddressDetail("구디아카데미");
        member.setMemberJoinDate(new Date(System.currentTimeMillis()));

        System.out.println(member);
    }
}
