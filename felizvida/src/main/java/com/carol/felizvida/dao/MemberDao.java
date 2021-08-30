package com.carol.felizvida.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carol.felizvida.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSession sqlsession;
	
	public MemberDto chklogin(MemberDto dto) { //id, pw 있는 dto
		dto = sqlsession.selectOne("member.logincheck",dto); //내용이 많은 dto
		return dto;

	}

}
