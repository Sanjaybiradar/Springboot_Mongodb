<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Home Page</title>
</head>
<body>
<h1>Welcome to Our Application!</h1>
<p>This is the home page of our application.</p>

<!-- Example of displaying a dynamic message -->
<p th:if="${empName != null}">Hello, <span th:text="${empName}"></span>!</p>
<p th:unless="${empName != null}">Welcome, Guest!</p>

<!-- Example of linking to another page -->
<p><a th:href="@{/about}">About Us</a></p>
</body>
</html>