<%-- 
    Document   : register
    Created on : Feb 13, 2026, 3:12:00 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% if (request.getAttribute("errorMessage") != null) {%>
    <div class="alert alert-danger" style="color: red; border: 1px solid red; padding: 10px;">
        <%= request.getAttribute("errorMessage")%>
    </div>
    <% }%>
    <body>
        <div class="container vh-100 d-flex justify-content-center align-items-center">
            <div class="col-md-4 p-5 shadow rounded-3 p-3 bg-light">
                <form action="${pageContext.request.contextPath}/RegisterController"  method="POST">
                    <div class="form-group">
                        <label class="form-label" for="name">Name</label>
                        <input type="text" class="form-control" placeholder="Enter name" name="name"/>
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="surname">Surname</label>
                        <input type="text" class="form-control" placeholder="Enter surname" name="surname" />
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="azeID">ID</label>
                        <input type="text" class="form-control" placeholder="Enter Aze ID" name="azeID" />
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="age">Age</label>
                        <input type="text" class="form-control" placeholder="Enter age" name="age" />
                    </div>
                    <hr/>
                    <div class="form-group">
                        <label class="form-label" for="username">Username</label>
                        <input type="text" class="form-control" placeholder="Enter username" name="username" />
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="password">Password</label>
                        <input type="password" class="form-control" placeholder="Enter password" name="password" />
                    </div>
                    <div class="mt-2">
                        <button type="submit" class="d-grid btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
