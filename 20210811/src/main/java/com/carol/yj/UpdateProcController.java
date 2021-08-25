package com.carol.yj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carol.yj.db.DBManager;

@Controller
public class UpdateProcController {
	
	@Autowired
	DBManager dbmc;
	
	@RequestMapping(value="/updateproc", method = RequestMethod.POST)
	public String updateproc(Model model, String para1, String para2) {
		dbmc.updatetest(para1, para2);		
		return "updateproc";
		
	}	

}
