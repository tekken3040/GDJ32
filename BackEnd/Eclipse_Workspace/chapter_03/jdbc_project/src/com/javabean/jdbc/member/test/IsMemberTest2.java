package com.javabean.jdbc.member.test;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;

public class IsMemberTest2 
{
    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();

        if(dao.isMember("java1234"))
        {
            System.out.println(dao.isMember("java1234", "#Spring1234"));
        }
        else
        {
            System.out.println("해당 사용자는 회원이 아닙니다.");
        }
    }
}
