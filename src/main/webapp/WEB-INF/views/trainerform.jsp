<%-- 
    Document   : trainerform
    Created on : Feb 10, 2021, 1:40:52 PM
    Author     : tania
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <title>Trainer Form</title>
    </head>
    <body>
        <jsp:include page="nav.jsp" />
        <div class="container my-container">
            <div class="row">
                <div class="col align-self-center">
                    <h1 >Create New Trainer</h1> 
                    <c:if test="${trainer.id==null}">
                        <c:url value="/trainer/create" var="link"/>
                        <c:set var="btntext" value="Create Trainer"/>
                        <c:set var="subjecttext" value="${trainer.subject}"/>
                    </c:if>
                    <c:if test="${trainer.id!=null}">
                        <c:url  value="/trainer/update" var="link"/>
                           <c:set var="btntext" value="Update Trainer"/>
                            <c:set var="subjecttext" value="Please Select Subject"/>
                    </c:if>
                    <form:form action="${link}" method="POST" modelAttribute="trainer" cssErrorClass="form-control height30px error">
                             <form:hidden path="id"/>
                             
                                <div class="form-group">
                            <label for="vatNumber">Vat Number</label>
                            <form:input type="number" id="vatNumber" path="vatNumber" class="form-control" />
                            <form:errors path="vatNumber" cssClass="error"></form:errors>
                        </div> </br>
                        
                        <div class="form-group">
                            <label for="firstname">First Name</label>
                            <form:input type="text" id="firstname" path="firstName" class="form-control" />
                            <form:errors path="firstName" cssClass="error"></form:errors>
                        </div> </br>

                        <div class="form-group">
                            <label for="lastname">Last Name</label>
                            <form:input type="text" id="lastname" path="lastName" class="form-control" />
                              <form:errors path="lastName" cssClass="error" element="div"></form:errors>
                        </div> </br>
                        
                           <div class="form-group">
                            <label for="dateofBirth">Date of Birth</label>
                            <form:input type="date" id="dateofBirth" path="dateofBirth" class="form-control" />
                            <form:errors path="dateofBirth" cssClass="error"></form:errors>
                        </div> </br>

                        <div class="form-group">
                            <label  for="subject">Choose Subject</label>
                            <form:select path="subject" id="subject" class="form-control">
                                <form:option value="${subjecttext}">${subjecttext}</form:option>
                                <c:forEach items="${subjects}" var="subject">
                                <form:option value="${subject}">${subject}</form:option>
                               </c:forEach>
                            </form:select>
                        </div> </br>

                        <button type="submit" class="btn  btn-danger btn-lg">${btntext}</button>
                    </form:form>
                </div>     
            </div>  
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
