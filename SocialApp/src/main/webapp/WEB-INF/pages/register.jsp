<%-- 
    Document   : register
    Created on : 30 thg 8, 2023, 15:47:52
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/register" var="action"/>
<link href=" <c:url value="/css/style.css" /> " rel="stylesheet" />

<h1 class="text-center text-danger">ĐĂNG KÍ NGƯỜI DÙNG</h1>


<!--enctype="multipart/form-data" de upload, có cái này mới đính kèm file được-->
<form:form modelAttribute="user" method="post"  action="${action}" enctype="multipart/form-data">
     <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <!--    cần trả về id đê update-->
    <form:hidden path="id"/>
    <form:hidden path="avatar"/>
    <!--path tro den column name cua prouct-->
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="firstName" id="firstName" placeholder="firstName" name="firstName"/>
        <label for="firstName">First Name</label>
        <form:errors path="firstName" element="div" cssClass="alert alert-danger" />

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="lastName" id="lastName" placeholder="Last Name" name="lastName"/>
        <label for="lastName">Last Name</label>
        <form:errors path="lastName" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" placeholder="username" name="username"/>
        <label for="username">Username</label>
          <form:errors path="username" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" path="password" id="password" placeholder="password" name="password"/>
        <label for="password">Password</label>
         <form:errors path="password" element="div" cssClass="alert alert-danger" />
    </div>
<!--    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="password" id="confirmPass" placeholder="confirmPass" name="confirmPass"/>
        <label for="password">Confirm password</label>
    </div>-->
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="email" placeholder="email" name="email"/>
        <label for="email">Email</label>
         <form:errors path="email" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phone" id="phone" placeholder="phone" name="phone"/>
        <label for="phone">Phone</label>
         <form:errors path="phone" element="div" cssClass="alert alert-danger" />
    </div>


    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="fileAvatar" id="avatar" placeholder="avatar" name="avatar"/>
        <label for="fileAvatar">Avatar</label>
         <form:errors path="fileAvatar" element="div" cssClass="alert alert-danger" />
    </div>

    <div class="form-floating mb-3 mt-3">

        <button class="btn btn-info mt-1" value="Thêm sản phẩm" type="submit">Register</button>

    </div>
</form:form>
