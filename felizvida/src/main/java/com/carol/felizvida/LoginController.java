package com.carol.felizvida;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String logincheck(String id,String pw) {	
		/*login check
		 * mybatis sqllog*/
		return "chart";
	}
}
