<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <!-- Add CSS links for styling -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add custom CSS styles here */
    </style>
</head>
<body>
    <!-- Header -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">My App</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/hrMgmtSystem" method="get">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/hrMgmtSystem/api/v1/employee/getAllEmployee" method="get">Employee Details</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" th:action="@{/signup}" href="/hrMgmtSystem/signup" method="get">SignUp</a>
                    </li>
                    <!-- Add more menu items as needed -->
                </ul>
            </div>
        </nav>
    </header>

    <!-- Main content -->
    <div class="container">
        <h1>User Management System</h1>
        <p>This is the home page.</p>
        <!-- Add more content as needed -->
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <span class="text-muted">© 2024 My App. All rights reserved.</span>
        </div>
    </footer>

    <!-- Add JavaScript links for Bootstrap (optional) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
