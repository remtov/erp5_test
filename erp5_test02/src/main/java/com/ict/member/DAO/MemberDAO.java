package com.ict.member.DAO;

import java.util.List;

import com.ict.member.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMember() throws Exception;
}
