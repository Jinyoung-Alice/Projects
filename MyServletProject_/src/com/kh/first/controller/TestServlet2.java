package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 연결 시 자바 파일을 화면(HTML)에 연결하는 방법
 * 1) web.xml에 서블릿 클래스를 등록하는 방법 
 * 2) @webServlet("url 주소") 형태로 등록하는 방법 ( V )
 *  ** 둘은 같이 쓸 수 없다..!
 *  
 *  @author JinYoung
 */
@WebServlet("/test2.do")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 사용자가 정보를 GET 방식으로 보냈을 때 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 0. 전송 값에 한글이 있을 경우를 대비하여 문자형태(charset) 바꾸기 : 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 1. 웹 페이지에 전달할 결과를 담을 Output 객체 선언
		PrintWriter out = response.getWriter();
		
		// 2. html 내용 코드 작성
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>전달 결과</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h1>로그인 전달 내용 확인</h1>");
		
		// 3. HTML에서 전송한 내용을 자바 변수로 받기 
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		out.println(userId + "님, 로그인 환영합니다. <br>");
		out.println("비밀번호 :" + userPwd + "(만료까지 7일) <br>");
		
		out.println("</body>");
		out.println("</html>");
		
		// 4. 사용한 output  객체 반환(닫기 : close)하기 
		
		out.flush();
		out.close();
 
	}

	// 사용자가 정보를 POST 방식으로 보냈을 때 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * HTTP 통신 규약 
		 *        : 서버와 사용자 간 주고받는 데이터의 통신 규칙 
		 * 사용자 --> 서버 (request : 요청)
		 * 사용자 <-- 서버 (response : 응답)
		 * 
		 * 요청방식 (GET / POST / PUT / DELETE)
		 * 1. GET (like SELECT : 정보 조회)
		 *           : 특정 값에 대한 정보를 조회할 때 사용
		 * 2. POST (like INSERT / UPDATE)
		 *           : 전달하는 값을 활용한 데이터 추가, 수정 동의 
		 *             데이터 조작을 수행할 때 사용 
		 */
		 
		doGet(request, response);
	}

}
