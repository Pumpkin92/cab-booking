<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Calculate Fare</h2>

    <%-- Show calculated fare --%>
    <c:if test="${not empty fare}">
        <p>${fare}</p>
    </c:if>

    <form action="/calculate-fare" method="post">
        Distance (km): <input type="number" name="distance" required /><br/>
        <button type="submit">Calculate</button>
    </form>

    <br>
    <a href="/">Back to Home</a>
</body>
</html>