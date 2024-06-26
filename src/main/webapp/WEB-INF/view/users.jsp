<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row">
            <h1>List of User Details</h1>
        </div>

        <div class="row">
            <div class="col-lg-3">
                <a href="/hrMgmtSystem/user/new" method="get" class="btn btn-primary bt-sm mb-3">Add User</a>
            </div>
        </div>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>User Email</th>
                    <th>User password</th>
                    <th> Actions </th>
                </tr>
            </thead>
                <tr th:each = "user: ${users}">
                    <td th:text = "${user.userId}"></td>
                    <td th:text = "${user.username}"></td>
                    <td th:text = "${user.email}"></td>
                    <td th:text = "${user.password}"></td>
                    <td>
                        <a th:href = "@{/users/edit/{id}(id=${user.userId})}"
                           class="btn btn-primary">Update</a>
                        <a th:href = "@{/users/delete/{id}(id=${user.userId})}"
                           class="btn btn-primary">delete</a>
                    </td>
                </tr>

        </table>

    </div>
</body>
</html>