package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.domian.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//11-1
/*
		@ResponseBody
		@RequestMapping(value="/test0301", method=RequestMethod.GET, produces = "application/json")
		public Member test0301() {
					
			Member member = new Member();
			member.setUserId("test");
			member.setPassword("123456");
			logger.info("test0301");
			logger.info("userId: " + member.getUserId() + " password: " + member.getPassword());
			
			return member;
		}
*/
	
		//11-2
		
	/*	
		@RequestMapping(value="/test0301", method=RequestMethod.GET, produces = "application/xml")
		@ResponseBody
		public Member test0302() {
			logger.info("test0302");
			
			Member member = new Member();
			member.setUserId("test");
			member.setPassword("123456");
			
			return member;
		}
			*/
		
	//12

	/*
	@RequestMapping(value="/test04", method=RequestMethod.GET)
	@ResponseBody
	public List<Member> test04() {
		logger.info("test04");
				
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("test1", "123456"));
		list.add(new Member("test2", "123456"));
		list.add(new Member("test3", "123456"));
		
		return list;
	}
	*/

	
	//13

	/*
	@RequestMapping(value="/test05", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Member> test05() {
		logger.info("test05");
		
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member1 = new Member("test1", "123456");
		map.put("key1", member1);
		
		Member member2 = new Member("test2", "123456");
		map.put("key2", member2);
		
		Member member3 = new Member("test3", "123456");
		map.put("key3", member3);
		
		
		
		return map;
	}
	*/
	

	//14
	/*
	@ResponseBody
	@RequestMapping(value="/test06", method = RequestMethod.GET)
	public ResponseEntity<Void> test06() {
		logger.info("test06");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	*/
	
	//15 
	/*
	@ResponseBody
	@RequestMapping(value="/test07", method = RequestMethod.GET)
	public ResponseEntity<String> test07() {
		logger.info("test07");
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
	}
	*/
	
	//16 
	/*
	@ResponseBody
	@RequestMapping(value="/test08", method = RequestMethod.GET)
	public ResponseEntity<Member> test08() {
		logger.info("test08");
		
		Member member = new Member();
		member.setUserId("test");
		member.setPassword("123456");
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
		
	}*/
	
	
	//17
	/*
	@ResponseBody
	@RequestMapping(value="/test09", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Member>> test09() {
		logger.info("test09");
			
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("test1", "123456"));
		list.add(new Member("test2", "123456"));
		list.add(new Member("test3", "123456"));
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		
	}
	*/
	
	//18
	@ResponseBody 
	@RequestMapping(value="/test10", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> test10() {
		logger.info("test10");
		
		Map<String, Member> map = new HashMap<String, Member>();
		map.put("key1", new Member("test1", "123456"));
		map.put("key2",new Member("test2", "123456"));
		map.put("key3", new Member("test3", "123456"));
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}		
		
}
