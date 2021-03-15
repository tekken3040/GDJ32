package com.javabean.jdbc.member.test;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;

public class IsMemberTest 
{
    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();

        if(dao.isMember("java1234"))
        {
            System.out.println("해당 사용자는 이미 가입된 회원입니다.");
        }
        else
        {
            System.out.println("해당 사용자는 회원이 아닙니다.");
        }
    }    
}
