<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP와 서블릿 통신하기</title>
</head>
<body>
       <h1>JSP와 서블릿 통신하기</h1>

       <h3>
                현재 시간 : <%@ include file= "common/time.jsp" %>
       </h3>
       
       <form action="/jsp/menuOrder.do" method="get">
              메뉴선택 :
                   <select name="menuSelect" >
                           <option value="사과">사과</option>
                           <option value="시리얼">시리얼</option>
                           <option value="샐러드">샐러드</option>
                           <option value="계란후라이">계란후라이</option>
                           <option value="맥모닝">맥모닝</option>
                   </select>
                     
                   <button type= "submit">주문 완료!</button>
       </form>
       
       
       
       
       
       
       
       
       
       
       
       
</body>
</html>