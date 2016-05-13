package com.fengjing.framework.spring.security;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringSecurityController {
	
	@RequestMapping(value="/welcome.do", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {
 
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "hello";
 
	}
 
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
 
	@RequestMapping(value="/loginfailed.do", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
	
	/**
	 * ����basic��ʽ�ǳ� ����һЩ������Ҫ��ͻ��˷���HttpServletResponse.SC_UNAUTHORIZED���߹ر���������������˳�
	 * �����ô˷�ʽ���ɹ�,�����
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/basiclogout.do", method = RequestMethod.GET)
	public void basiclogout(HttpServletRequest request,HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public String welcomeAdmin(ModelMap model) {
 
		model.addAttribute("message", "Spring Security - ROLE_ADMIN");
		return "hello";
 
	}
	
	
}
