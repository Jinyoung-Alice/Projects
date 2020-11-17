<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage= "common/errorPage.jsp" %>
<%
      String menu = (String) request.getAttribute("menu");
      int price = (Integer) request.getAttribute("price");
      int money = 10000;
      
      // 강제로 에러 발생 시키기
      String str = null;
      str.length(); // ? 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결과</title>
</head>
<body>
       <h2>주문 내역을 확인 하세요</h2>
       <p>
                주문하신 음식 : <%= menu %><br>
                주문하신 음식 가격 : <%= price %>원<br>
                주신 돈 : <%= money %>원<br>
                <hr>
                거스름돈 : <%= money - price %>원<br>
       </p>
       <%
            if ((money - price) > 0) {
       %>
              <h2>이용해 주셔서 감사합니다! ♥</h2>
        <% } else { %>
              <h2>어이, 고객님, 돈을 더 주셔야죠...</h2>
         <% } %>
       
</body>
</html>