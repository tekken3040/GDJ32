package com.javateam.jdbc.member.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javateam.jdbc.member.dao.MemberDao;
import com.javateam.jdbc.member.domain.MemberVo;
import com.javateam.jdbc.member.util.DbUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDaoImpl instance = new MemberDaoImpl();
	private static DbUtil dbUtil = new DbUtil();
	
	@Override
	public boolean insertMember(MemberVo member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVo> getAllMembers() {
		// TODO Auto-generated method stub
		List<MemberVo> members = new ArrayList<MemberVo>();
		Connection conn = this.getDbUtil().connect();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member";
		ResultSet rs = null;
		
		MemberVo member = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				member = new MemberVo();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPassword(rs.getString("member_password"));
				member.setMemberNickname(rs.getString("member_nickname")); 
				member.setMemberName(rs.getString("member_name"));
				member.setMemberGender(rs.getString("member_gender"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberPhone(rs.getString("member_phone")); 
				member.setMemberBirth(rs.getDate("member_birth"));
				member.setMemberZip(rs.getString("member_zip"));
				member.setMemberAddressBasic(rs.getString("member_address_basic"));
				member.setMemberAddressDetail(rs.getString("member_address_detail"));
				member.setMemberJoindate(rs.getDate("member_joindate"));
				
				members.add(member);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			this.getDbUtil().close(conn, pstmt, rs);
		}
		
		return members;
	}

	@Override
	public MemberVo getMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMember(MemberVo member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMember(String memberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String isMember(String memberId, String memberPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVo> getMembersByPaging(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnableEmail(String memberEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnableEmail(String memberId, String memberEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnablePhone(String memberPhone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnablePhone(String memberId, String memberPhone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVo> getMembersBySearching(String searchKey, String searchValue, boolean isEquivalentSearch,
			String sortDirection, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public static MemberDao getInstance() 
	{
		if(instance == null)
			instance = new MemberDaoImpl();
		
		return instance;
	}

	public static DbUtil getDbUtil()
	{
		if(dbUtil == null)
			dbUtil = new DbUtil();
		
		return dbUtil;
	}
}
