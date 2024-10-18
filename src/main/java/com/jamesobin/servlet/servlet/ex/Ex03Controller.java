package com.jamesobin.servlet.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ex03")
public class Ex03Controller extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
//		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		// 이름과 생년월일 전달 받고,
		// 이름과 나이를 정한 html을 구성한다.
		
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday"); // 20240812
		
		String yearString = birthday.substring(0, 4);
		int year = Integer.parseInt(yearString);
		
		int age = 2024 - year + 1;
//		{"name":"김인규", "age":22}
		
		out.println("{\"name\":\"" + name + "\",\"age\":" + age +"}");
		
//		out.println(""
//				+ "<html>\n"
//				+ "	<head><title>정보</title></head>\n"
//				+ "	<body>\n"
//				+ "		<h3>이름 : " + name + "</h3>\n"
//				+ "		<h3>나이 : " + age + "</h3>\n"
//				+ "	</body>\n"
//				+ "</html>");
		
	}
	
}
