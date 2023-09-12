<%-- 
    Document   : header
    Created on : 27 thg 7, 2023, 16:56:05
    Author     : Kien
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action"/>
<c:url value="/list-product" var="actionListProduct"/>
<link href=" <c:url value="/css/header.css" /> " rel="stylesheet" />

<!--                       <img src="{pageContext.request.userPrincipal.avatar}" alt="logo" width="50"/>-->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Social NetWork Website</a>
        <div>


        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto"> 
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Home</a>
                </li>
                <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Danh mục sản phẩm
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <c:forEach items="${categories}" var="c">
                                    <c:url value="/list-product" var="cateAction">
                                        <c:param name="cateId" value="${c.id}" />
                                    </c:url>


                                    <li class="nav-item">
                                        <a class="nav-link" href="${cateAction}">${c.name}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </li>
                    </ul>
                </div>


                <li class="nav-item">
                    <a class="nav-link" href="${actionListProduct}">Sản phẩm đấu giá</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value="/register"  />">Đăng kí</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <c:if test="${currentUser.userRole == 'ROLE_ADMIN'}">
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/admin/stats" />">Admin</a>
                            </li>

                        </c:if>
                         
                        
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                        
                     
                            <li class="nav-item" style="margin-left: 100px">
                                <a class="nav-link text-success" href="<c:url value="/" />"> ${pageContext.request.userPrincipal.name} </a>
                            </li>

<!--                            <img src="<c:url value="/images/image.png" />" class="rounded-circle" alt="logo" width="50" />-->
                            <img src="${currentUser.avatar}" class="rounded-circle" alt="logo" width="50" />
                            <!--                    <img src="{pageContext.request.userPrincipal.avatar}" class="rounded-circle" alt="logo" width="50"/>-->
                             <li class="d-flex" >
                                <a  class="nav-link text-info"  href="<c:url value="/post/new-post"  />" >
                                    <i class="fas fa-plus-circle" style="font-size: 24px"></i>
                                </a>
                            </li>
                            <li class="d-flex "  >
                                <a class="nav-link text-info" href="<c:url value="/"  />">
                                    <i class="far fa-bell" style="font-size: 24px"></i>
                                </a>
                            </li>
                            
                    
                    </c:when>

                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/login"  />">Đăng nhập</a>
                        </li>
                    </c:otherwise>


                </c:choose>
                

            </ul>
            <form class="d-flex" action="${actionListProduct}">
                <input class="form-control me-2" type="text" name="kw" placeholder="Tìm kiếm sản phẩm...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>

        </div>
    </div>
</nav>
