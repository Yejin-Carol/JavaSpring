package com.carol.yj1;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	SqlSession sqlsession;
	
	
	@RequestMapping(value="memberlist")
	public String memberlist() {
		List<MemberDto> list = sqlsession.selectList("member.select");
		for(MemberDto dto : list) {
			System.out.println("dto = " + dto);
		}
		
		//sqlsession.selectList("member.select");
		return "member/list";
	}
	
	@RequestMapping(value="memberinsert")
	public String memberinsert() {
		sqlsession.insert("member.insert");
		return "member/insert";
	}
}
