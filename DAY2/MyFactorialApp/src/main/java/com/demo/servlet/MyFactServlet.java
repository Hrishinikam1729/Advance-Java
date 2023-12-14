package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFactServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int sum = 0;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int num1 = Integer.parseInt(request.getParameter("num1"));
			String op = request.getParameter("btn");
			if(op!=null) {
			if(op.equals("add")) {
				int num2 = Integer.parseInt(request.getParameter("num2"));
				sum = num1 + num2;
				out.println("<h3>Sum is</h3>");
				out.println("sum :" + sum);
			}else if(op.equals("fact")) {
				int factorial = fact(num1);
				out.println("<h3>Factorial is</h3>");
				out.println("Factorial :" + factorial);
			}
			}
			
	}

	private int fact(int num1) {
		if(num1==1) {
			return num1;
		}else {
			return num1 * fact(num1-1);
		}
	}
}
