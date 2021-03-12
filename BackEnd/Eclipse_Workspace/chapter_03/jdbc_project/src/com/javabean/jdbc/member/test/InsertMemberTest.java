package com.javabean.jdbc.member.test;

import java.sql.Date;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;
import com.javabean.jdbc.member.domain.MemberVo;

/**
 * InsertMember 메서드 단위 테스트 케이스(Unit TestCase)<br></br>
 * 회원정보 생성 테스트<br></br>
 * 
 * @author LimeParfait
 */
public class InsertMemberTest 
{
    public static void main(String[] args) 
    {
        // DAO 객체 생성
        MemberDao dao = MemberDaoImpl.getInstance();

        // 생성할 회원정보 생성(MemberVo)
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

        // InsertMember 테스트(true/false)
        String result = "";
        if(dao.insertMember(member))
        {
            result = "저장성공";
        }
        else
        {
            result = "저장실패";
        }
        System.out.println(result);
    }
}
