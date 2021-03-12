package com.javabean.jdbc.member.test;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;
import com.javabean.jdbc.member.domain.MemberVo;

/**
 * UpdateMember 메서드 단위 테스트 케이스(Unit TestCase)<br></br>
 * 회원정보 갱신 테스트<br></br>
 * 
 * @author LimeParfait
 */
public class UpdateMemberTest 
{
    public static void main(String[] args) 
    {
        // DAO 객체 생성
        MemberDao dao = MemberDaoImpl.getInstance();

        // 생성할 회원정보 생성(MemberVo)
        MemberVo member = new MemberVo();
        
        member.setMemberPassword("1234");
        member.setMemberZip("12345");
        member.setMemberAddressBasic("서울 금천구 가산");
        member.setMemberAddressDetail("구디아카데미");
        member.setMemberId("java");

        // UpdateMember 테스트(true/false)
        String result = "";
        if(dao.updateMember(member))
        {
            result = "갱신성공";
        }
        else
        {
            result = "갱신실패";
        }
        System.out.println(result);
    }
}
