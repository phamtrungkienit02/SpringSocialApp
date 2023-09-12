<%-- 
    Document   : listProduct
    Created on : 6 thg 9, 2023, 09:48:46
    Author     : Kien
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/list-product" var="actionListProduct"/>
<c:url value="/hello-post" var="action"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href=" <c:url value="/css/style.css" /> " rel="stylesheet" />

<section>

    <h1 class="text-center text-danger">DANH SÁCH SẢN PHẨM ĐẤU GIÁ</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div>
            <a href="<c:url value="/products" />" class="btn btn-info">Thêm sản phẩm</a>
        </div>    
           
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <h4 class="text-danger">Vui lòng đăng nhập để sử dụng hệ thống</h1>
    </c:if>
<!--    <h1>hello ${name}</h1>
    <h1>${fullName}</h1>
    <a href="<c:url value="/forward"/>">
        Redirect/forward
    </a>-->

    <!--   <form:form method="post" action="${action}" modelAttribute="user">
        <form:input path="firstName"/>
        <form:input path="lastName"/>
        <input type="submit" value="Send"/>
    </form:form>
    -->
   

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${actionListProduct}">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/list-product" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
            <!--???-->
            <li class="page-item" style="margin: 10dp">
                <form action="${actionListProduct}" id="pageSearch">
                    <input type="number" max="${counter}" min="1" name="page" onchange="document.getElementById('pageSearch').submit()" />
                </form>
            </li>
        </ul>
    </c:if>




    <table class="table table-hover" >
        <thead>
            <tr style="background-color: #7952b3">
                <th>Ảnh sản phẩm</th>
                <th>Id</th>
                <th>Tên sản phẩm</th>
                <th>Giá khởi điểm</th>
                <th>Số lượng</th>
                <th>Loại</th>
                <th>Người đấu giá</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${products}" var="p" >
                <tr>

                    <td>
                        <img src="${p.image}" alt="${p.name}" width="120"/>
                    </td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.startingPrice} VND</td>
                    <td>${p.quantity}</td>
                    <td>${p.categoryId.name}</td>
                    <td>${p.userId.firstName} ${p.userId.lastName}</td>
                    <td>

                        <c:url value="/products/${p.id}" var="api"/>
                        <c:url value="/api/products/${p.id}" var="del"/>
                        <%--                         endpoint cập nhật xóa gióng nhau --%>

                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="<c:url value="/products/aution/${p.id}"></c:url>" class="btn btn-info">Vào đấu giá</a>
                            <c:if test="${pageContext.request.userPrincipal.name == p.userId.username && currentUser.userRole != 'ROLE_ADMIN'}">             
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <!-- ''chuoi,deleteProduct ham js alert('hello') -->
                                <button class="btn btn-danger" onclick="deleteProduct('${del}')">Xóa</button>
                            </c:if>

                            <c:if test="${currentUser.userRole == 'ROLE_ADMIN'}">
                              <a href="${api}" class="btn btn-success">Cập nhật</a>
                              <button class="btn btn-danger" onclick="deleteProduct('${del}')">Xóa</button>
                              
                            </c:if>
                        </c:if>    


                    </td>
                </tr> 
            </c:forEach>
        </tbody>
    </table>
</section>

<!--js-->
<script defer src="<c:url value="/js/main.js"/> "></script>
