package com.javabean.jdbc.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.domain.MemberVo;
import com.javabean.jdbc.member.util.DbUtil;
import com.javabean.jdbc.member.util.ExceptionMetadata;

/**
 * MemberDao의 구현 클래스(concrete class)<br></br>
 * usage) MemberDao dao = MemberDaoImpl.getInstance():<br></br>
 *  : 싱글턴(singleton : 독신자) 패턴 적용 &rarr; 보안<br></br>
 * 
 * @author LimeParfait
 */
public class MemberDaoImpl implements MemberDao
{
    // 싱글턴 생성 패턴 적용
    /**
     * DAO 객체 : 싱글턴(singleton) 생성 패턴 적용
     */
    private static MemberDaoImpl instance = null;

    private MemberDaoImpl() {
    }
    
    /**
     * 싱글턴 객체(DAO singleton object) 생성 매서드
     * 
     * @return DAO 객체
     */
    public static final MemberDaoImpl getInstance()
    {
        if (instance == null)
        {
            instance = new MemberDaoImpl();
        }

        return instance;
    }

    @Override
    public boolean insertMember(MemberVo member) 
    {
        // TODO Auto-generated method stub
        boolean result = false;

        ExceptionMetadata emd = new ExceptionMetadata(new Exception().getStackTrace()[0]);
        Connection con = DbUtil.connect();                          // DB 연결
        PreparedStatement stmt = null;                              // SQL 처리 객체
        String sql = "INSERT INTO member VALUES" + 
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";       // SQL 구문
        
        try 
        {
            stmt = con.prepareStatement(sql);                       // SQL 인자(선)처리
            // stmt = con.createStatement();                        // SQL 인자(후)처리
            stmt.setString(1, member.getMemberId());                // ID
            stmt.setString(2, member.getMemberPassword());          // Password
            stmt.setString(3, member.getMemberNickname());          // Nickname
            stmt.setString(4, member.getMemberName());              // Name
            stmt.setString(5, member.getMemberGender());            // Gender
            stmt.setString(6, member.getMemberEmail());             // Email
            stmt.setString(7, member.getMemberPhone());             // Phone
            stmt.setDate(8, member.getMemberBirth());               // Birthday
            stmt.setString(9, member.getMemberZip());               // ZipCode
            stmt.setString(10, member.getMemberAddressBasic());     // AddressBasic
            stmt.setString(11, member.getMemberAddressDetail());    // AddressDetail

            if(stmt.executeUpdate() == 1)                           // 1:DML 성공한 행(tuple, record)의 수
            {
                System.out.println("회원정보 저장에 성공하였습니다.");
                result = true;
            }
            else
            {
                System.out.println("회원정보 저장에 실패하였습니다.");
                result = false;
            }
        } 
        catch (SQLException e) 
        {
            //TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
            emd.printErr(e, con, true);
        }
        finally
        {
            DbUtil.close(con, stmt, null);
        }

        return result;
    }

    @Override
    public List<MemberVo> getAllMembers() 
    {
        // 리턴(반환값) 처리
        List<MemberVo> members = new ArrayList<>();

        // 개별회원 정보 객체
        MemberVo member = null;

        ExceptionMetadata emd = new ExceptionMetadata(new Exception().getStackTrace()[0]);

        // 실행 메서드 명
        String methodName = new Exception().getStackTrace()[0].getMethodName();

        // DB 연결
        Connection con = DbUtil.connect();

        // SQL 연결객체
        PreparedStatement pstmt = null;

        // SQL 결과셋 객체(DQL:select)
        ResultSet rs = null;

        // SQL 구문
        String sql = "SELECT * FROM member";
        try 
        {
            // SQL 처리
            pstmt = con.prepareStatement(sql);
            // SQL 결과셋 객체 생성
            rs = pstmt.executeQuery();
            // 결과셋에서 다음 행을 조회 방식(iterator)
            while(rs.next())
            {
                // 개별 회원정보 생성
                // 주의) VO 객체 이 구문에서 선언시 특정 개별 회원들만 여러행 출력됨
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
                member.setMemberJoinDate(rs.getDate("member_joinDate"));

                // VO -> List(add) : 개별 회원정보 추가
                members.add(member);
            }
        } 
        catch (SQLException e) 
        {
            emd.printErr(e, con, false);
        }
        finally
        {
            DbUtil.close(con, pstmt, rs);
        }
        // SQL 인자 (선)처리
        // SQL 실행, 예외처리
        // 자원반납
        // 리턴(반환)
        return members;
    }

    @Override
    public MemberVo getMember(String memberId) 
    {
        // TODO Auto-generated method stub
        // 리턴 (반환값) 처리
        MemberVo member = new MemberVo();

        // 실행 메서드명
        String methodName = new Exception().getStackTrace()[0].getMethodName();

        // DB 연결
        Connection con = DbUtil.connect();

        // SQL 처리 객체
        PreparedStatement pstmt = null;

        // SQL 결과셋 객체
        ResultSet rs = null;

        // SQL 구문
        String sql = "SELECT * FROM member WHERE member_id=?";

        try 
        {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            // SQL 실행 
            rs = pstmt.executeQuery();

            if (rs.next()) {
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
                member.setMemberJoinDate(rs.getDate("member_joindate"));
            }
        } 
        catch (SQLException e) 
        {
            System.err.println(methodName + " : " + e.getMessage());
        } 
        finally 
        {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		}
		
		// 리턴(반환)
        return member;
    }

    @Override
    public boolean updateMember(MemberVo member) 
    {
        // TODO Auto-generated method stub
        boolean result = false;

        Connection con = DbUtil.connect();                          // DB 연결
        PreparedStatement stmt = null;                              // SQL 처리 객체
        String sql = "UPDATE member SET " + 
                "member_password=?," +
                "member_zip=?," + 
                "member_address_basic=?," + 
                "member_address_detail=?," + 
                "WHERE member_id=?";                                // SQL 구문
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE member SET ");
        sqlBuilder.append("member_password=?,");
        sqlBuilder.append("member_zip=?,");
        sqlBuilder.append("member_address_basic=?,");
        sqlBuilder.append("member_address_detail=?,");
        sqlBuilder.append("WHERE member_id=?");
        try 
        {
            stmt = con.prepareStatement(sql);                       // SQL 인자(선)처리
            // stmt = con.createStatement();                        // SQL 인자(후)처리
            stmt.setString(1, member.getMemberPassword());          // Password
            stmt.setString(2, member.getMemberZip());               // ZipCode
            stmt.setString(3, member.getMemberAddressBasic());      // AddressBasic
            stmt.setString(4, member.getMemberAddressDetail());     // AddressDetail
            stmt.setString(5, member.getMemberId());                // ID

            if(stmt.executeUpdate() == 1)                           // 1:DML 성공한 행(tuple, record)의 수
            {
                System.out.println("회원정보 갱신에 성공하였습니다.");
                result = true;
            }
            else
            {
                System.out.println("회원정보 갱신에 실패하였습니다.");
                result = false;
            }
        } 
        catch (SQLException e) 
        {
            //TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            DbUtil.close(con, stmt, null);
        }

        return result;
    }

    @Override
    public boolean deleteMember(String memberId) 
    {
        boolean result = false;

        Connection con = DbUtil.connect(); // DB 연결
        PreparedStatement stmt = null; // SQL 처리 객체
        String sql = "DELETE member WHERE member_id=?"; // SQL 구문

        try {
            stmt = con.prepareStatement(sql); // SQL 인자(선)처리
            // stmt = con.createStatement();                        // SQL 인자(후)처리
            stmt.setString(1, memberId); // ID

            if (stmt.executeUpdate() == 1) // 1:DML 성공한 행(tuple, record)의 수
            {
                System.out.println("회원정보 삭제에 성공하였습니다.");
                result = true;
            } else {
                System.out.println("회원정보 삭제에 실패하였습니다.");
                result = false;
            }
        } catch (SQLException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            DbUtil.close(con, stmt, null);
        }

        return result;
    }

    @Override
    public boolean isMember(String memberId) 
    {
        // 리턴 (반환값) 처리
        boolean isMember = false;
        //MemberVo member = new MemberVo();

        // 실행 메서드명
        String methodName = new Exception().getStackTrace()[0].getMethodName();

        // DB 연결
        Connection con = DbUtil.connect();

        // SQL 처리 객체
        PreparedStatement pstmt = null;

        // SQL 결과셋 객체
        ResultSet rs = null;

        // SQL 구문
        String sql = "SELECT count(*) FROM member WHERE member_id=?";

        try 
        {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            // SQL 실행 
            rs = pstmt.executeQuery();

            if (rs.next()) 
            {
                isMember = rs.getInt(1) == 1 ? true : false;
            }
            else
            {
                isMember = false;
            }
        } 
        catch (SQLException e) 
        {
            System.err.println(methodName + " : " + e.getMessage());
            e.printStackTrace();
        } 
        finally 
        {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		}
		
		// 리턴(반환)
        return isMember;
    }

    @Override
    public String isMember(String memberId, String memberPassword) 
    {
        // 리턴 (반환값) 처리
        String isMember = "";
        //MemberVo member = new MemberVo();

        // 실행 메서드명
        String methodName = new Exception().getStackTrace()[0].getMethodName();

        // DB 연결
        Connection con = DbUtil.connect();

        // SQL 처리 객체
        PreparedStatement pstmt = null;

        // SQL 결과셋 객체
        ResultSet rs = null;

        // SQL 구문
        String sql = "SELECT count(*) FROM member WHERE member_id=? AND member_password=?";

        try {
            if (isMember(memberId)) {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, memberId);
                pstmt.setString(2, memberPassword);
                // SQL 실행 
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1) == 1) {
                        isMember = "로그인에 성공하였습니다.";
                        System.out.println("로그인에 성공하였습니다.");
                    } else {
                        isMember = "회원정보가 일치하지 않습니다.";
                        System.out.println("회원정보가 일치하지 않습니다.");
                    }
                } else {
                    System.out.println("회원정보가 없습니다.");
                }
            } else {
                System.out.println("회원 정보가 없습니다.");
            }
        } catch (SQLException e) {
            System.err.println(methodName + " : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 자원 반납
            DbUtil.close(con, pstmt, rs);
        }

        // 리턴(반환)
        return isMember;
    }

    @Override
    public List<MemberVo> getMembersByPaging(int page, int limit) 
    {
        // 리턴(반환값) 처리
        List<MemberVo> pagingMembers = new ArrayList<>();
        // 개별 회원정보 객체 선언
        MemberVo member = null;
		// 주의) VO 객체 이 구문에서 선언 -> 
		// 특정 개별 회원들만 여러행 출력 (X)
		// 대책) VO 객체를 외부에서 선언 !
		 
		// 실행 메서드명  
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		// DB 연결
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		// SQL 결과셋 객체 (DQL:select)
		ResultSet rs = null;
		// SQL 구문
        //String sql = "SELECT * FROM (" + 
        //             "SELECT ROWNUM, m.*, FLOOR((ROWNUM - 1) / ? + 1) page" + 
        //             "FROM ( SELECT * FROM member ORDER BY member_id ASC) m" + 
        //             ") WHERE page=?";
        String sql = "SELECT * FROM (SELECT ROWNUM, m.*, FLOOR((ROWNUM - 1) / ? + 1) page FROM ( SELECT * FROM member ORDER BY member_id ASC) m) WHERE page=?";
        try 
        {
            // SQL 처리
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, page);
            // SQL 결과셋 객체 생성
            rs = pstmt.executeQuery();
            // 결과셋에서 다음 행을 조회 방식(iterator)
            while(rs.next())
            {
                // 개별 회원정보 생성
                // member = new MemberVo(); // (O)
                // SQL 결과셋  -> VO
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
                member.setMemberJoinDate(rs.getDate("member_joinDate"));

                // VO -> List (add) : 개별 회원정보 추가
                pagingMembers.add(member);
            }
		    // SQL 실행, 예외처리
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
		finally
        {
            // 자원 반납
            DbUtil.close(con, pstmt, rs);
        }
	
		// 리턴(반환)
        return pagingMembers;
    }

    @Override
    public boolean isEnableEmail(String memberEmail) 
    {
        // 리턴(반환값) 처리
        boolean isEnabled = false;
        // 실행 메서드명
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        // DB 연결
        Connection con = DbUtil.connect();
        // SQL 처리 객체
        PreparedStatement pstmt = null;
        // SQL 결과셋 객체 (DQL:select)
        ResultSet rs = null;
        // SQL 구문
        String sql = "SELECT DECODE(count(*), 0, 'true', 1, 'false') FROM member " + 
                "WHERE member_email = 'abcd1@abcd.com';";
        
        try 
        {
            // SQL 처리
            pstmt = con.prepareStatement(sql);
            // SQL 결과셋 객체 생성
            rs = pstmt.executeQuery();
            // SQL 실행, 예외처리
            if(rs.next())
            {
                if(rs.getBoolean(1))
                    isEnabled = true;
                else
                    isEnabled = false;
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
		finally
        {
            // 자원 반납
            DbUtil.close(con, pstmt, rs);
        }

        return isEnabled;
    }

    @Override
    public boolean isEnablePhone(String memberPhone) 
    {
        // 리턴(반환값) 처리
		boolean result = false;
		 
		// 트랜잭션/예외처리 객체 생성
		ExceptionMetadata emd
		   = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		
		// DB 연결
		Connection con = DbUtil.connect();
		
		// SQL 처리 객체
		PreparedStatement pstmt = null;	
		
		// SQL 결과셋 객체 (DQL:select)
		ResultSet rs = null;
				
		// SQL 구문
		// 1)
//				String sql = "SELECT DECODE(count(*), 0, 'true', 1, 'false') as phone_flag "
//						   + "FROM member " 
//						   + "WHERE member_phone = ?";
		
		// 2)
		String sql = "SELECT count(*) FROM member "
				   + "WHERE member_phone = ?";
			
		// SQL, 인자 (선)처리, 예외처리
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberPhone);
			// SQL 실행 
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 1)
				// result = Boolean.valueOf(rs.getString(1));
				// result = new Boolean(rs.getString(1));
				// result = new Boolean(rs.getString("phone_flag"));
				
				// 2)
				result = rs.getInt(1) == 0 ? true : false;
			}
			
		} catch (SQLException e) {
			emd.printErr(e, con, false);
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		}		
				
		// 리턴값
		return result;
    }

    @Override
    public boolean isEnablePhone(String memberId, String memberPhone) 
    {
        // 리턴(반환값) 처리
		boolean result = false;
		 
		// 트랜잭션/예외처리 객체 생성
		ExceptionMetadata emd
		   = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		
		// DB 연결
		Connection con = DbUtil.connect();
		
		// SQL 처리 객체
		PreparedStatement pstmt = null;	
		
		// SQL 결과셋 객체 (DQL:select)
		ResultSet rs = null;
				
		// SQL 구문
		// 1)
//		String sql = "SELECT DECODE(count(*), 0, 'true', 1, 'false') as phone_flag "
//				   + "FROM member " 
//				   + "WHERE member_id != ? "
//				   + "  AND member_phone = ?";
		
		// 2)
		String sql = "SELECT count(*) FROM member "
				   + "WHERE member_id != ? "
				   + "  AND member_phone = ?";
			
		// SQL, 인자 (선)처리, 예외처리
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPhone);
			// SQL 실행 
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 1)
				// result = Boolean.valueOf(rs.getString(1));
				// result = new Boolean(rs.getString(1));
				// result = new Boolean(rs.getString("phone_flag"));
				
				// 2)
				result = rs.getInt(1) == 0 ? true : false;
			}
			
		} catch (SQLException e) {
			emd.printErr(e, con, false);
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		}		
				
		// 리턴값
		return result;
    }

    @Override
    public List<MemberVo> getMembersBySearching(String searchKey, String searchValue, boolean isEquivalentSearch, String sortDirection, int page, int limit)
    {
        // 리턴(반환값) 처리
		List<MemberVo> result = null;
        MemberVo member = null;

		// 트랜잭션/예외처리 객체 생성
		ExceptionMetadata emd = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		
		// DB 연결
		Connection con = DbUtil.connect();
		
		// SQL 처리 객체
		PreparedStatement pstmt = null;	
		
		// SQL 결과셋 객체 (DQL:select)
		ResultSet rs = null;
				
		// SQL 구문
        //String sql = "SELECT * FROM (SELECT ROWNUM, m.*, FLOOR((ROWNUM - 1) / ? + 1)" + 
        //" page FROM ( SELECT * FROM member WHERE ? ? '?' ORDER BY member_id ? ) m ) WHERE page = ?";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM (SELECT ROWNUM, m.*, FLOOR((ROWNUM - 1) / ? + 1) page")
        .append(" FROM (SELECT * FROM member WHERE ").append(searchKey).append(" ");
        if(isEquivalentSearch)
            sb.append("like");
        else
            sb.append("=");
        sb.append(" '").append(searchValue).append("'ORDER BY member_id ").append(sortDirection);
        sb.append(") m) WHERE page = ?");

        String sql = sb.toString();
		// SQL, 인자 (선)처리, 예외처리
        try 
        {
            result = new ArrayList<>();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, limit); // 페이지당 출력 행 수
            pstmt.setInt(2, page); // 조회할 페이지 번호
            
            // SQL 실행 
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // 개별 회원정보 생성
                // 주의) VO 객체 이 구문에서 선언시 특정 개별 회원들만 여러행 출력됨
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
                member.setMemberJoinDate(rs.getDate("member_joinDate"));

                // VO -> List(add) : 개별 회원정보 추가
                result.add(member);
            }

        } 
        catch (SQLException e) 
        {
            emd.printErr(e, con, false);
        } 
        finally 
        {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		}		
				
		// 리턴값
		return result;
    }
}
