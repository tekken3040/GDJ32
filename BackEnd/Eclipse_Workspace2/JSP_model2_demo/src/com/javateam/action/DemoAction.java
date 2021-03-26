package com.javateam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.control.CommandAction;

public class DemoAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, 
						     HttpServletResponse response) throws Throwable {

		String page = "content1.jsp";
		
		if (request.getParameter("page") != null) {

			page = request.getParameter("page") + ".jsp";
		} 
		
		request.setAttribute("page", page);
		
		return "template.jsp"; // jsp
	}

}