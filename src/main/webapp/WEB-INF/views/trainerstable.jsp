<%-- 
    Document   : trainerstable
    Created on : Feb 10, 2021, 1:40:40 PM
    Author     : tania
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="nav.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-12">
                <h2 class="text-center" >Trainers</h2>
                </div>
          </div>  
         <div class="row">
                <div class="col-12">       
                <h3 class="text-center" >${message}</h3>
            </div>
         </div>
            
            </br>


            <table class="table table-hover table-sm">
                <thead class="table-info">
                    <tr>
                        <th>Id</th>
                        <th>Vat Number</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                         <th>Date of Birth</th>
                        <th>Subject</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${trainers}" var="trainer">
                    <tr>
                        <td>${trainer.id}</td>
                         <td>${trainer.vatNumber}</td>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
                         <td>${trainer.dateofBirth}</td>
                        <td>${trainer.subject}</td>
                        <td><a href="${pageContext.request.contextPath}/trainer/update/${trainer.id}">Update</td>
                        <td><a href="${pageContext.request.contextPath}/trainer/delete/${trainer.id}">Delete</td>
                        </t>
                    </c:forEach>


            </table>

        </div>




        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
            integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
            integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
