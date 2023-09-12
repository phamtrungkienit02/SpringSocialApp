<%-- 
    Document   : index
    Created on : 22 thg 7, 2023, 12:04:17
    Author     : Kien
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action"/>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href=" <c:url value="/css/style.css" /> " rel="stylesheet" />
<script src="<c:url value="/js/main.js" />"></script>

<section>
    <h1 class="text-center text-danger">BÀI VIẾT MỚI</h1>
    
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <h4 class="text-danger">Vui lòng đăng nhập để sử dụng hệ thống</h1>
    </c:if>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
            <!--???-->
            <li class="page-item" style="margin: 10dp">
                <form action="${action}" id="pageSearch">
                    <input type="number" max="${counter}" min="1" name="page" onchange="document.getElementById('pageSearch').submit()" />
                </form>
            </li>
        </ul>
    </c:if>




    <c:forEach items="${posts}" var="p" >
        <!--          <button onclick="loadPostId{post.id})"></button>-->

        <div class="card" style="width: auto; margin:10px" >
            <div style="display: flex; align-items: center; margin: 10px">
                <img src="${p.userId.avatar}" class=" rounded-circle" alt="${p.userId.firstName}" width="50"/>
                <h6 style="margin-left: 15px; color: blue">${p.userId.lastName} ${p.userId.firstName}</h5>

                    <c:if test="${p.updatedAt != null}">
                        <div style="margin-left: auto">
                            <p class="Date" >${p.updatedAt}</p>
                            <p>Đã chỉnh sửa </p>
                        </div>
                    </c:if>
                    <c:if test="${p.updatedAt == null}">
                        <p style="margin-left: auto" class="Date" > ${p.createdAt}</p>
                    </c:if>
            </div>

            <div class="card-body">
                <h5 class="card-title">${p.title}</h5>
                <p class="card-text">${p.content} </p>   
            </div>
            <div style="display: flex; margin: 10px;" >

                <c:url value="/post/${p.id}" var="actionPost"/>
                <c:url value="/api/post/${p.id}" var="apiDelPost"/>
                <c:if test="${pageContext.request.userPrincipal.name != null }">
                   <a href="${actionPost}" class="btn btn-success" style="margin: 10px">Xem chi tiết</a>
                   <c:if test="${pageContext.request.userPrincipal.name == p.userId.username && currentUser.userRole != 'ROLE_ADMIN'}">             
                        <a class="btn btn-danger" onclick="delPost('${apiDelPost}', ${p.id})" style="margin: 10px")">Xóa bài viết</a>
                       <a href="<c:url value="/post/update/${p.id}" />" class="btn btn-info" style="margin: 10px">Cập nhập bài viết</a>
                   </c:if>
                       
                     <c:if test="${currentUser.userRole == 'ROLE_ADMIN'}">
                              <a class="btn btn-danger" onclick="delPost('${apiDelPost}', ${p.id})" style="margin: 10px")">Xóa bài viết</a>
                              <a href="<c:url value="/post/update/${p.id}" />" class="btn btn-info" style="margin: 10px">Cập nhập bài viết</a>
                     </c:if>    
                </c:if>    
                   
                <!--                <a style="margin-left: auto;text-decoration: none" href="#" onclick=""> lượt bình luận</a>-->
            </div>
        </div>
        <br/>
    </c:forEach>


</section>
