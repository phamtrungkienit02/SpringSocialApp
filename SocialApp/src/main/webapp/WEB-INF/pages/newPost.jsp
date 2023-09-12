<%-- 
    Document   : newPost
    Created on : 6 thg 9, 2023, 11:40:32
    Author     : Kien
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/post/new-post" var="action"/>

<section style="height: 600px">
<h1 class="text-center text-danger">ĐĂNG BÀI VIẾT</h1>
<form:form modelAttribute="post" method="post" action="${action}"  enctype="multipart/form-data">
    <form:hidden path="id"/>

    <div class="form-group">   
        <label for="text">Title</label>
        <form:input type="text" class="form-control" path="title" id="title" placeholder="" name="title"/>
        <form:errors path="title" element="div" cssClass="alert alert-danger" />
    </div>

    <div class="form-group">
        <label for="comment">Content</label>
        <form:textarea class="form-control" rows="5" id="content" path="content" />
        <form:errors path="content" element="div" cssClass="alert alert-danger" />
        <div class="form-group" style="display:none">   
            <form:select class="form-select" id="user" name="user" path="userId">
                <option value="${currentUser.id}" selected>${currentUser.firstName} ${currentUser.lastName}</option>
            </form:select>

        </div> 
    </div>
    <button class="btn btn-info mt-1" value="Post" type="submit">Post</button>

</form:form>
</section>