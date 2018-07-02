package com.sss.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/LoginServlet")
public class LoginController {
	@Autowired
	ServletContext context;
	@RequestMapping(method = RequestMethod.POST)
	public void login(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println("User:"+user);
        System.out.println("Password:"+pwd);
		
        RequestDispatcher rd = context.getRequestDispatcher("/login.html");
        PrintWriter out= response.getWriter();
        out.println("<font color=red>Either user name or password is wrong.</font>");
        rd.include(request, response);
    }
}
