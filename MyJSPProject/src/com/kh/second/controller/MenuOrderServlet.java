package com.kh.second.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 전달받은 데이터 확인
		String menu = request.getParameter("menuSelect");
		
		System.out.println("선택한 메뉴 확인 : " + menu );
		
		// 2. 비즈니스 로직 작성(업무 로직 : 기능 관련 소스코드 작성)
		int price = 0;
		
		switch(menu) {
		case "사과" : 
			price = 2500;
			break;
		case "시리얼" : 
			price = 3000;
			break;
		case "샐러드" : 
			price = 5000;
			break;
		case "계란후라이" : 
			price = 2000;
			break;
		case "맥모닝" : 
			price = 3500;
			break;
		}
		
		// 3. 비즈니스 로직 실행 결과 담기
		request.setAttribute("menu", menu);
		request.setAttribute("price", price);
		
		// 4. forward : 작성 내용을 jsp에게 전송 
		RequestDispatcher view = request.getRequestDispatcher("views/menuResult.jsp");
		view.forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
