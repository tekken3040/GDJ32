package com.javateam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.control.CommandAction;

public class Demo2Action implements CommandAction
{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
		System.out.println("demo.do");
		request.setAttribute("java", "1.8");
		return "demo.jsp";
	}	
}
