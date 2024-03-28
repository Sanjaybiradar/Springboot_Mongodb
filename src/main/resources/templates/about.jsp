<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
</head>
<body>
    <h1>About Us</h1>
    <p>Welcome to our application! We are dedicated to providing...</p>

    <!-- Example of displaying dynamic content -->
    <p>Our team consists of:</p>
    <ul>
        <li th:each="member : ${teamMembers}" th:text="${member.name}"></li>
    </ul>

    <!-- Example of linking back to the home page -->
    <p><a th:href="@{/}">Back to Home</a></p>
</body>
</html>
