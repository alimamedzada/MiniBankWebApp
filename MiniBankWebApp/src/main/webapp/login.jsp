<%-- 
    Document   : login
    Created on : Feb 13, 2026, 1:47:54 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container vh-100 d-flex justify-content-center align-items-center">
            <div class="text-center p-5 shadow rounded bg-light">
                <form action="${pageContext.request.contextPath}/LoginController"  method="POST">
                    <div class="form-group">
                        <label class="form-label" for="username">Username</label>
                        <input type="text" class="form-control" placeholder="Enter username" name="username" />
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="password">Password</label>
                        <input type="password" class="form-control" placeholder="Enter password" name="password" />
                    </div>
                    <div class="mt-2">
                        <button type="submit" class="d-grid btn btn-primary">Login</button>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
