package com.javabean.jdbc.member.test;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;

public class MemberBySearchingTest 
{
    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();
        System.out.println(dao.getMembersBySearching("member_name", "%순%", true, "ASC", 1, 10));
    }
}
