<%-- 
    Document   : productAution
    Created on : 11 thg 9, 2023, 20:33:50
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!--categoryId none-->
<h1 class="text-center">CHÀO MỪNG ĐẾN VỚI SẢN PHẨM ĐẤU GIÁ</h1>

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

        <tr>
            <td>
                <img src="${product.image}" alt="${product.name}" width="120"/>
            </td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.startingPrice} VND</td>
            <td>${product.quantity}</td>
            <td>${product.categoryId.name}</td>
            <td>${product.userId.firstName} ${product.userId.lastName}</td>
            <td>
            </td>
        </tr> 

    </tbody>
</table>



<div class="container mt-3" style="display: flex">
    <img src="<c:url value="${product.image}" />" class="img-thumbnail" alt="${product.image}" width="500px" height="300px">
    <div class="card">
        <div class="card-body" style="width: 800px" > 
            <table style="margin: 10px">
                <tr>
                    <td style="font-weight: bold; margin-right: 50px">Id: </td>
                    <td >${product.id}</td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">Tên sản phẩm: </td>
                    <td >${product.name}</td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">Số lượng: </td>
                    <td >${product.quantity}</td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">Danh mục: </td>
                    <td >${product.categoryId.name}</td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">Người đấu giá: </td>
                    <td >${product.userId.firstName} ${product.userId.lastName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">Giá hiện tại: </td>
                    <td >XXXX</td>
                </tr>
            </table>
            <br/>
            <div style="display:flex">
<!--                url value="/products/aution/{product.id}/aution" var="actionAution"/>-->
                <c:url value="/products/aution/${product.id}" var="actionAution"/>
                <form:form modelAttribute="aution" method="post" action="${actionAution}" enctype="multipart/form-data">
                    <form:hidden path="id"/>    

                    <form:select class="form-select" id="userId" name="userId" path="userId" style="display:none">
                        <option value="${currentUser.id}" selected></option>
                    </form:select>
                    <form:select class="form-select" id="productId" name="productId" path="productId" style="display:none">
                        <option value="${product.id}" selected></option>
                    </form:select>
                        
        
                    <form:input type="text" class="form-control" path="currentPrice" id="currentPrice" placeholder="Nhập giá..." name="currentPrice"/>
                    
                    <button class="btn btn-success" value="Post" type="submit" >Xác nhận đấu giá </button>

                </form:form>
            </div>

        </div>
    </div>
</div>

<!--                <h1>{currentUser.id}</h1>
                <h1>{product.userId.id}</h1>-->
<!--                 <:if test="{product.userId == currentUser.id}">-->
<c:if test="${currentUser.userRole == 'ROLE_ADMIN' || currentUser.id == product.userId.id}">
    <table class="table table-hover" >
        <thead>
            <tr style="background-color: #7952b3">
                <th>Id</th>
                <th>Tên sản phẩm</th>
                <th>Giá </th>
                <th>Người đấu giá</th>
           
                <th></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${currentAution}" var="a">
                <tr> 
                    <td>${a[0]}</td>
                    <td>${a[1]}</td>
                    <td>${a[2]} VND</td>
                    <td>${a[3]}</td>
                 

                    <td>
                        <c:url value="/products/aution/${product.id}/result" var="actionResult"/>
                        <form:form modelAttribute="result" method="post" action="${actionResult}">
                            <form:hidden path="id"/>    
                            
                            <!--  form:select class="form-select" id="productId" name="productId" path="productId" />
                                <option value="{product.id}" selected></option>s
                                /form:select>
                                form:input type="text" class="form-control" path="productId" id="productId" value="{a[5]}" /> -->
                            
                          
                            <form:input type="text" class="form-control" path="winnerId" id="winnerId" value="${a[4]}" style="display:none"/>
                            <form:input type="text" class="form-control" path="productId" id="productId" value="${a[5]}" style="display:none"/>
                            <form:input type="text" class="form-control" path="price" id="price" value="${a[2]}" style="display:none"/>
                             <form:input type="text" class="form-control" path="auctionProductId" id="auctionProductId" value="${a[0]}" style="display:none"/>
                           
<!--                            select class="form-select" id="auctionProductId" name="auctionProductId" path="auctionProductId" style="display:none">
                                ption value="{a[0]}" selected>abc</option>
                            form:select>
                            form:select class="form-select" id="winnerId" name="winnerId" path="winnerId" style="display:none">
                                ption value="{a[4]}" selected>abc</option>
                            form:select>
                            form:select class="form-select" id="productId" name="productId" path="productId" style="display:none">
                                option value="{a[5]}" selected>abc</option>
                            /form:select>
                            form:select class="form-select" id="price" name="price" path="price" style="display:none">
                                option value="{a[2]}" selected>abc</option>
                            /form:select>-->
                              <button class="btn btn-success" value="Post" type="submit" >Đấu giá thành công </button>

                        </form:form>
                    </td>               
                </tr> 
            </c:forEach>
         </tbody>
    </table>

</c:if>


