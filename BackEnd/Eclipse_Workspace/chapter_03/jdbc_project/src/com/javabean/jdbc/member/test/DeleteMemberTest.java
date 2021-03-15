package com.javabean.jdbc.member.test;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;

/**
 * deleteMember 단위 테스트 케이스<br><br>
 * : 회원정보 삭제 테스트<br>
 * 
 * @author javateam
 */
public class DeleteMemberTest 
{
    public static void main(String[] args) 
    {
		MemberDao dao = MemberDaoImpl.getInstance();
		dao.deleteMember("java");
	}
}