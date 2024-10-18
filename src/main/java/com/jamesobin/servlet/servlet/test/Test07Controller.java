package com.jamesobin.servlet.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test07")
public class Test07Controller extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		// 주소, 결제카드, 가격
		
		String address = request.getParameter("address");
		String card = request.getParameter("card");
		String priceString = request.getParameter("price");
		
		int price = Integer.parseInt(priceString);
		
		out.println(""
				+ "<html>\n"
				+ "	<head><title>주문하기</title></head>\n"
				+ "	<body>\n");
		
		// 서울시가 포함되어 있지 않으면
		if(!address.contains("서울시")) {
			out.println("		<h3>배달 불가 지역입니다.</h3>");
		} else if(card.equals("신한카드")) {
			out.println("		<h3>결제 불가 카드입니다.</h3>");
		} else {
			out.println("	<h3>" + address + " 배달 준비중</h3>\n"
					+ "		<hr>\n"
					+ "		<div>결제금액 : " + price + "원</div>\n");
		}
		
		out.println(""
				+ "	</body>\n"
				+ "</html>");
		
	}
	
}
