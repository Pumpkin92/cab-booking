<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Book a Cab</h2>

   
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <form action="/book" method="post">
        Name: <input type="text" name="customerName" required /><br/>
        Pickup: <input type="text" name="pickupLocation" required /><br/>
        Destination: <input type="text" name="destination" required /><br/>
        Distance (km): <input type="number" name="distance" required /><br/>
        <button type="submit">Book Cab</button>
    </form>

    <br>
    <a href="/">Back to Home</a>
</body>
</html>