<%-- 
    Document   : productsenctype="multipart/form-data"
    Created on : 25 thg 8, 2023, 14:43:11
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/products" var="action"/>

<h1 class="text-center text-danger">QUẢN LÍ SẢN PHẨM</h1>


<!--enctype="multipart/form-data" de upload, có cái này mới đính kèm file được-->
<form:form modelAttribute="products" method="post" enctype="multipart/form-data" action="${action}">
    
<!--    cần trả về id đê update-->
    <form:hidden path="id"/>
    <form:hidden path="image"/>
    <!--path tro den column name cua prouct-->
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên sản phẩm" name="name"/>
        <label for="name">Tên sản phẩm</label>
        <form:errors path="name" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="description" id="desc" placeholder="Mô tả sản phẩm" name="desc"/>
        <label for="desc">Mô tả sản phẩm</label>
        <form:errors path="description" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="startingPrice" id="price" placeholder="Giá khởi điểm" name="price"/>
        <label for="price">Giá khởi điểm</label>
        <form:errors path="startingPrice" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="quantity" id="quantity" placeholder="Số lượng" name="quantity"/>
        <label for="quantity">Số lượng</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="cate" name="cate" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == products.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise><option value="${c.id}">${c.name}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="cate" class="form-label">Danh mục sản phẩm</label>
    </div>    
    <br>
    <form:select class="form-select" id="userId" name="userId" path="userId" style="display:none">
                        <option value="${currentUser.id}" selected>abc</option>
    </form:select>
<!--    <div class="form-floating">
        <form:select class="form-select" id="user" name="user" path="userId">
            <c:forEach items="${users}" var="u">
                <c:choose>
                    <c:when test="${u.id == products.userId.id}">
                        <option value="${u.id}" selected>${u.firstName} ${u.lastName}</option>
                    </c:when> 
                    <c:otherwise> <option value="${u.id}">${u.firstName} ${u.lastName}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="user" class="form-label">Danh mục user</label>
    </div>   -->

    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="image" placeholder="Tên sản phẩm" name="email"/>
        <label for="image">Ảnh sản phẩm</label>
        <form:errors path="file" element="div" cssClass="alert alert-danger" />
        <c:if test="${products.image != null}">
            <img src="${products.image}" alt="image product" width="120"/>
        </c:if>
    </div>

    <div class="form-floating mb-3 mt-3">
        <c:choose>
            <c:when test="${products.id != null}">
                <button class="btn btn-info mt-1" value="Thêm sản phẩm" type="submit">Cập nhật sản phẩm</button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-info mt-1" value="Thêm sản phẩm" type="submit">Thêm sản phẩm</button>
            </c:otherwise>
        </c:choose>
        
    </div>
</form:form>

