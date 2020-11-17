package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SilsubServlet
 */
@WebServlet("/silsub.do")
public class SilsubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SilsubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	    PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>신청곡</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>신청곡 안내</h1>");
		
		out.println("<h3>신청자 : 홍길동</h3>"); 
		out.println("<br>");
		out.println("<h3>메일 : redload@example.com</h3>");
		out.println("<br>");
		
		out.println("<p>");
		out.println("사연 : 요즘 비가 오며 날이 덥다 춥다 그러네요.<br>");
		out.println("이런 찝찝한 날씨에 버스를 타려니<br>");
		out.println("마음이 싱숭생숭합니다.<br>");
		out.println("심지어 옆자리에 앉은 사람은<br>");
		out.println("비에 쫄딱 맞았는지 정말 비에 엄청 젖어 있어요...<br>");
		out.println("이런 날 듣기 좋은 음악 어디 없을까요..?<br>");
		out.println("신청곡은 '자자'의 '버스안에서' 부탁드려요!<br>");
		out.println("</p>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
