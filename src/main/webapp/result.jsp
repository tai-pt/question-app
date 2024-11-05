<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kết Quả</title>
</head>
<body>
    <h1>Kết Quả Thi</h1>
    <p>Điểm số của bạn: <%= request.getAttribute("score") %></p>
    <a href="quiz.jsp">Thử lại</a>
</body>
</html>
