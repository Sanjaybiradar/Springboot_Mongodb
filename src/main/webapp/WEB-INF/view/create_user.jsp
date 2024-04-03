<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<br>
<br>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center caard">
                <h1 class="text-center">Create New User</h1>
                <div class="card-body">
                    <form th:action="@{/hrMgmtSystem/user/new/add}" th:object = "${?user}" method="POST">
                        <div class="form-group">
                            <label>UserId</label>
                            <input
                                    type="text"
                                    name="userId"
                                    th:field="*{userId}"
                                    class="form-control"
                                    placeholder="Enter User ID"
                            />
                        </div>

                        <div class="form-group">
                            <label>UserName</label>
                            <input
                                    type="text"
                                    name="username"
                                    th:field="*{username}"
                                    class="form-control"
                                    placeholder="Enter User Name"
                            />
                        </div>

                        <div class="form-group">
                            <label>Email</label>
                            <input
                                    type="text"
                                    name="email"
                                    th:field="*{email}"
                                    class="form-control"
                                    placeholder="Enter Email-Id"
                            />
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input
                                    type="text"
                                    name="password"
                                    th:field="*{password}"
                                    class="form-control"
                                    placeholder="Enter Password"
                            />
                        </div>

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">
                                Submit
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>