<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
</head>
<body>
    <h1>Trắc Nghiệm</h1>
    <form action="quiz" method="post">
        <%
        ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");

            if (questions != null ) {
                for (Question q : questions) {
        %>
                <div class="question">
                    <p><%= q.getQuestion() %></p>
                    <label><input type="radio" name="anw<%= q.getId() %>" value="1"> <%= q.getOption1() %></label><br>
                    <label><input type="radio" name="anw<%= q.getId() %>" value="2"> <%= q.getOption2() %></label><br>
                    <label><input type="radio" name="anw<%= q.getId() %>" value="3"> <%= q.getOption3() %></label><br>
                    <label><input type="radio" name="anw<%= q.getId() %>" value="4"> <%= q.getOption4() %></label><br><br>
                </div>
        <%
                }
            } else {
        %>
                <p>No questions available.</p>
        <%
            }
        %>
        <button type="submit">Nộp Bài</button>
    </form>
</body>
</html>
