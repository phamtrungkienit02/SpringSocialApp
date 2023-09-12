<%-- 
    Document   : PostDetail
    Created on : 7 thg 9, 2023, 10:41:58
    Author     : Kien
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href=" <c:url value="/css/style.css" /> " rel="stylesheet" />
<script src="<c:url value="/js/main.js" />"></script>

<c:url value="/post/add-comment" var="action"/>
<c:url value="/post/add-like" var="actionLike"/>

<section>

    <div class="card" style="width: auto; margin:10px" >
        <div style="display: flex; align-items: center; margin: 10px">
            <img src="${post.userId.avatar}" class=" rounded-circle" alt="${post.userId.firstName}" width="50"/>
            <h6 style="margin-left: 15px; color: blue">${post.userId.lastName} ${post.userId.firstName}</h5>
                <c:if test="${post.updatedAt != null}">
                    <div style="margin-left: auto">
                        <p class="Date" >${post.updatedAt}</p>
                        <p>Đã chỉnh sửa </p>
                    </div>
                </c:if>
                <c:if test="${post.updatedAt == null}">
                    <p style="margin-left: auto" class="Date" > ${post.createdAt}</p>
                </c:if>
        </div>
          
        <div class="card-body">
            <h5 class="card-title">${post.title}</h5>
            <p class="card-text">${post.content} </p>   
        </div>
        <div style="display: flex; margin: 10px" >
            <p style="margin-left: auto; color: blue">${counterComment} lượt bình luận</p>
        </div>
    </div>
    <li class="nav-item" style="margin: 0px 0px 20px 20px">
          <form:form modelAttribute="like" method="post" action="${actionLike}">
                    <form:hidden path="id"/>         
                    <form:select class="form-select" id="user" name="user" path="userId" style="display:none">
                        <option value="${currentUser.id}" selected>${currentUser.firstName} ${currentUser.lastName}</option>
                    </form:select>
                    <form:select class="form-select" id="postId" name="postId" path="postId" style="display:none">
                        <option value="${post.id}" selected>${post.title}</option>
                    </form:select>
                        <c:if test="${checkData == true}">
                            <button value="Post" type="submit" style=" border: none; outline: none; background: white">
                                <i class="far fa-thumbs-up" id="like-button"  onclick="Like()" style="font-size: 24px"></i>
                            </button>
                        </c:if>
                        <c:if test="${checkData == false}">
                            <button value="Post" type="submit" style=" border: none; outline: none; background: white" disabled="true">
                                <i class="far fa-thumbs-up" " style="font-size: 24px; color: blue"></i>
                            </button>
                        </c:if>
                        
                </form:form>
        <p style="color: blue">${counterLike} lượt thích</p>
    </li>
    <br/>
    
    
    <div class="card" style="width: auto; margin:10px" >
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <div style="display: flex; align-items: center; margin: 10px">
                    <img src="${currentUser.avatar}" class=" rounded-circle" alt="${currentUser.firstName}" width="50"/>
                    <h6 style="margin-left: 15px; color: blue">${currentUser.lastName} ${currentUser.firstName}</h5>

                </div>
                <form:form modelAttribute="comment" method="post" action="${action}" enctype="multipart/form-data">
                   
                    <form:hidden path="id"/>
                    <form:textarea class="form-control" rows="5"  path="content" />
       
                    <form:errors path="content" element="div" cssClass="alert alert-danger" />
               
                    <form:select class="form-select" id="user" name="user" path="userId" style="display:none">
                        <option value="${currentUser.id}" selected>${currentUser.firstName} ${currentUser.lastName}</option>
                    </form:select>
                    <form:select class="form-select" id="postId" name="postId" path="postId" style="display:none">
                        <option value="${post.id}" selected>${post.title}</option>
                    </form:select>
                    <button class="btn btn-info mt-1" value="Bình luận" type="submit">Bình luận</button>
                </form:form>
            </c:when>
        </c:choose>



                    <c:if test="${countComment > 1}">
                        <ul class="pagination mt-1">
                            <li class="page-item"><a class="page-link" href="<c:url value="/post/${post.id}" />">Tất cả</a></li>
                                <c:forEach begin="1" end="${countComment}" var="i">
                                    <c:url value="/post/${post.id}" var="pageUrl">
                                        <c:param name="page" value="${i}" />
                                    </c:url>
                                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                                </c:forEach>
                            <!--???-->
                            <li class="page-item" style="margin: 10dp">
                                <form action="<c:url value="/post/${post.id}" />" id="pageSearch">
                                    <input type="number" max="${countComment}" min="1" name="page" onchange="document.getElementById('pageSearch').submit()" />
                                </form>
                            </li>
                        </ul>
                    </c:if>
        <c:forEach items="${comments}" var="c" >
            <div class="card" style="width: auto; margin:10px" >
                <div style="display: flex; align-items: center; margin: 10px">
                    <img src="${c.userId.avatar}" class=" rounded-circle" alt="${c.userId.firstName}" width="50"/>
                    <h6 style="margin-left: 15px; color: blue">${c.userId.lastName} ${c.userId.firstName}</h5>
                        <c:if test="${c.updatedAt != null}">
                            <div style="margin-left: auto">
                                <p class="Date" >${c.updatedAt}</p>
                                <p>Đã chỉnh sửa </p>
                            </div>
                        </c:if>
                        <c:if test="${c.updatedAt == null}">
                            <p style="margin-left: auto" class="Date" > ${c.createdAt}</p>
                        </c:if>

                </div>

                <div class="card-body">
                    <p class="card-text">${c.content} </p>   
                </div>
                <div style="display: flex; margin: 10px" >               
                    <!--                       <a href="/post-detail>" class="btn btn-info">Phản hồi</a>-->
                    <!--                       <p style="margin-left: auto; color: blue"> lượt phản hồi</p>-->
                </div>
                 <c:if test="${pageContext.request.userPrincipal.name != null}">
              <!-- 
                   c:if test="{pageContext.request.userPrincipal.name == c.userId.username}">    
                       <a href="c:url value="/post/comment/update/{c.id}" />" class="btn btn-info" style="margin: 10px">Sửa bình luận</a>
                   /c:if>
              -->
                </c:if>    
            </div>
            <li class="nav-item" style="margin:0px 0px 20px 20px">
                <a><i class="far fa-thumbs-up" id="like-button" onclick="Like()" style="font-size: 24px"></i></a>
            </li>
            <br/>
        </c:forEach>
    </div>

</section>

