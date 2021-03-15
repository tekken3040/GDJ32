package com.javabean.jdbc.member.dao;

import java.util.List;

import com.javabean.jdbc.member.domain.MemberVo;

/**
 * DAO(Data Access Object)
 *  : CRUD(DML(CUD) + DQL(select)) methods 들로 구성
 *  : 간혹 DDL에 대응되는 메서드로 구성될 수도 있음
 *  : CRUD(Create Read Update Delete)
 *  : CUD(Create Update Delete) => 협의의(좁은 의미의) DML
 * 
 * ex) DB = 영속(영구)저장소(Persistent Repository)
 * 영속(영구) 객체 : Persistent(/-ce) Object => VO, DAO, (D)TO
 * 
 * @author LimeParfait
 */

public interface MemberDao 
{
    /**
     * 개별 회원정보 삽입(생성)
     * 
     * @param member 회원정보 객체
     * @return 회원정보 생성 성공 여부
     */
    public boolean insertMember(MemberVo member);

    /**
     * 전체 회원정보들 조회(검색)
     * 
     * @return 전체 회원정보 리스트(목록)
     */
    public List<MemberVo> getAllMembers();

    /**
     * 개별 회원정보 조회(검색)
     * 
     * @param memberId 회원 아이디
     * @return 개별 회원정보(VO)
     */
    public MemberVo getMember(String memberId);

    /**
     * 개별 회원정보 수정(갱신)
     * 
     * @param member 회원정보 객체(VO)
     * @return 회원정보 갱신(수정) 성공 여부
     */
    public boolean updateMember(MemberVo member);

    /**
     * 개별 회원정보 삭제
     * 
     * @param memberId 회원 아이디
     * @return 회원정보 삭제 성공 여부
     */
    public boolean deleteMember(String memberId);

    /**
     * 회원 여부 점검<br><br>
     * 
     * ex) 회원가입시 회원 여부 점검시 활용<br><br>
     * 
     * @param memberID 회원 아이디
     * @return 회원(존재) 여부
     */
    public boolean isMember(String memberId);
}
