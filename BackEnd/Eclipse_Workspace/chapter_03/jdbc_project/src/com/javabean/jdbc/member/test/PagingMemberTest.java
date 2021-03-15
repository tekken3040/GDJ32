package com.javabean.jdbc.member.test;

import java.util.List;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;
import com.javabean.jdbc.member.domain.MemberVo;

public class PagingMemberTest 
{
    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();
        List<MemberVo> tempMember = dao.getMembersByPaging(1, 10);
        for (int i = 0; i < tempMember.size(); i++)
            System.out.println(tempMember.get(i));
    }
}
