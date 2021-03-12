package com.javabean.jdbc.member.test;

import java.util.ArrayList;
import java.util.List;

import com.javabean.jdbc.member.dao.MemberDao;
import com.javabean.jdbc.member.dao.impl.MemberDaoImpl;
import com.javabean.jdbc.member.domain.MemberVo;

/**
 * getAllMembers 메서드 단위테스트 케이스(Unit Test)
 *  : 전체 회원정보 조회 테스트<br></br>
 * 
 * @author LimeParfait
 */
public class AllMembesTest 
{
    public static int getCountByWord(List<String> list, String id)
    {
        int count = 0;

        for(int i=0; i<list.size(); i++)
        {
            if (list.get(i).contentEquals(id)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) 
    {
        MemberDao dao = MemberDaoImpl.getInstance();

        // 인원수 확인
        System.out.println(dao.getAllMembers().size() == 4 ? true : false);

        // 테스트 케이스 점검사항
        // 중복행 출력 여부 점검
        // 각행에 대한 회원 아이디를 중복성 점검
        List<String> ids = new ArrayList<>();

        // 전체 현황
        for(int i=0; i<dao.getAllMembers().size(); i++)
        {
            //System.out.println(dao.getAllMembers().get(i));
            ids.add(dao.getAllMembers().get(i).getMemberId());
        }

        List<MemberVo> list = dao.getAllMembers();
        for(int i=0; i<list.size(); i++)
        {
            String id = list.get(i).getMemberId();
            System.out.println(id + " : " + getCountByWord(ids, id));
        }
    }
}
