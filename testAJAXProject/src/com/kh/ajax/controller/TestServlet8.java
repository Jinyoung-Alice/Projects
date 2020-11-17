package com.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.Product;

/**
 * Servlet implementation class TestServlet8
 */
@WebServlet("/test8.do")
public class TestServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8"); 
		
        List<Product> list = new ArrayList<>();
		
		// 상품 10개 
		
		list.add(new Product(1, "왕눈이깜찍이", "국내산", "음료"));
		list.add(new Product(2, "신호등", "국내산", "사탕류"));
		list.add(new Product(3, "밭두렁", "국내산", "과자류"));
		list.add(new Product(4, "차카니", "인도네시아산", "과자류"));
		list.add(new Product(5, "짱구", "국내산", "과자류"));
		list.add(new Product(6, "아폴로", "중국산", "과자류"));
		list.add(new Product(7, "꾀돌이", "국내산", "과자류"));
		list.add(new Product(8, "쫀득이", "말레이시아산", "과자류"));
		list.add(new Product(9, "맥주사탕", "중국산", "사탕류"));
		list.add(new Product(10, "라면땅", "국내산", "음료"));
		
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
