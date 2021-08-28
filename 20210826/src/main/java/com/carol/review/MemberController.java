package com.carol.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	SqlSession sqlsession;

	@RequestMapping(value = "memberlist")
	public String memberlist(Model model) {
		List<MemberDto> list = sqlsession.selectList("member.select");
		for (MemberDto dto : list) {
			System.out.println("dto= " + dto);
		}
		
		model.addAttribute("aa", "bb");
		model.addAttribute("alist",list);
		return "member/list";
	}
	/* 
	 * request getParameter("id");
	 * String id, String pw 변수명 name 이랑 같으면 자동으로 들어옴
	 * */
//	@RequestMapping(value="memberinsert")
//	public String memberinsert(String id, 
//							String pw, 
//							String age, 
//							String gender, MemberDto dto) {
//		System.out.println("id = "+id);
//		System.out.println("pw = "+pw);
//		System.out.println("age = "+age);
//		System.out.println("gender = "+gender);
//		System.out.println("dto = "+ dto);
//		sqlsession.insert("member.insert");
//		return "member/insert";	
//}
	
	@RequestMapping(value="memberinsert")
	public String memberinsert(MemberDto dto) {
		sqlsession.insert("member.insert",dto);
		return "member/insert";	
}	
	
	@RequestMapping(value="memberinsertform")
	public String memberinsertform() {
		return "member/insertform";	
	}
	
	@RequestMapping(value="memberupdateform")
	public String memberupdateform(int idx,Model model) {
		System.out.println(idx);
		MemberDto dto = sqlsession.selectOne("member.selectone",idx);
		System.out.println(dto);
		model.addAttribute("member",dto);
		return "member/updateform";	
	}
	
	@RequestMapping(value="memberupdate")
	public String memberupdate(MemberDto dto,Model model) {
		System.out.println("update ========\n"+dto);
		sqlsession.update("member.update",dto);
		return "redirect:memberlist";	
	}
	
	@RequestMapping(value="memberdelete")
	public String memberdelete(int idx) {
		System.out.println("delete =======\n"+idx);
		sqlsession.delete("member.delete",idx);
		return "redirect:memberlist";
	}
	
}
