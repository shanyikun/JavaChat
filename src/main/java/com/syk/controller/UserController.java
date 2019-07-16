package com.syk.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.syk.service.UserService;
import com.syk.user.UserInfo;

@Controller
public class UserController {
	@RequestMapping(value="/")
	public String indexPage() {
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	/*@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerRequest(@RequestParam("name") String name, @RequestParam("password") String password, Model model) throws ClassNotFoundException, SQLException {
		UserService userService=new UserService();
		String result=userService.executeRegister(name, password);
		model.addAttribute("result", result);
		return "userPage";
	}*/
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerRequest(UserInfo userInfo, Model model) throws ClassNotFoundException, SQLException {
		UserService userService=new UserService();
		String result=userService.executeRegister(userInfo.getName(), userInfo.getPassword());
		model.addAttribute("result", result);
		return "redirect:/userInfo";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginRequest(@RequestParam(name= "name") String name, @RequestParam(name = "password") String password, Model model) throws ClassNotFoundException, SQLException {
		UserService userService = new UserService();
		String result = userService.executeLogin(name, password);
		model.addAttribute("result", result);   // 重定向时模型中的原始类型属性会自动以查询参数的形式附加到重定向URL上，不必显式拼接字符串
		return "redirect:/userInfo";
	}
	
	@RequestMapping(value="/userInfo", method=RequestMethod.GET)
	public String userInfo(@RequestParam("result") String result, Model model) {
		model.addAttribute("result", result);
		return "userPage";
	}
}
