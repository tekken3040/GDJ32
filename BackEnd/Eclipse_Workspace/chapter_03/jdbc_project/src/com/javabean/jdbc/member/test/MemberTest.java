package com.javabean.jdbc.member.test;

import java.sql.Date;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;
import com.javabean.jdbc.member.domain.MemberVo;

/**
 * getMember 메서드 단위 테스트 케이스(Unit Test) <br></br>
 *  : 개별 회원정보 조회<br></br>
 * 
 * @author LimeParfait
 */

public class MemberTest 
{
    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();

        // DB 비교 대상 (MemberVo)
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
        // 날짜 입력
        member.setMemberJoinDate(Date.valueOf("2021-03-12"));
        
        String result = "";
        if(member.equals(dao.getMember("java")))
            result = "회원정보 조회 성공";
        else
            result = "회원정보 조회 실패";

        System.out.println(result);
    }
}
