<%-- 
    Document   : adminStats
    Created on : 11 thg 9, 2023, 08:01:21
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<h1 class="text-center text-danger">ADMIN THỐNG KÊ</h1>
<hr/>
<br/>
<button id="export-pdf" Class="btn btn-info">XUẤT SANG PDF</button>
<br/>
<h3 class="text-danger">Tổng sản phẩm đấu giá theo danh mục</h1>
<div class="row" style="margin-bottom: 50px">
    <div class="col-md-5 col-xs-12">
        <table class="table">
            <tr>
                <th>Mã danh mục</th>
                <th>Tên danh mục</th>
                <th>Số lượng sản phẩm</th>
            </tr>
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td >${p[0]}</td>
                    <td >${p[1]}</td>
                    <td>${p[2]}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="col-md-5 col-xs-12">
        <input type="hidden" id="listProduct" value="${listProduct}">
        <div>
            <!--            data-bind="{JSON.stringify(listProduct)}-->
            <canvas id="myChart" ></canvas>
        </div>
    </div>
</div>

<hr/>
<br/>
<h3 class="text-danger">Top 5 sản phẩm đấu giá có giá khởi điểm cao nhất</h1>
    <div class="row" style="margin-bottom: 50px">
        <div class="col-md-5 col-xs-12">
            <table class="table">
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá khởi điểm</th>
                    <th>Tên danh mục</th>
                    <th>Người đấu giá</th>
                </tr>
                <c:forEach items="${listTop5Product}" var="top5">
                    <tr>
                        <td >${top5[0]}</td>
                        <td >${top5[1]}</td>
                        <td >${top5[2]} VND</td>
                        <td >${top5[3]}</td>
                        <td >${top5[4]}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-5 col-xs-12">
            <input type="hidden" id="listProduct" value="${listProduct}">
            <div>
                <!--            data-bind="{JSON.stringify(listProduct)}-->
                <canvas id="TopProduct" ></canvas>
            </div>
        </div>
    </div>

    <hr/>
    <br/>
    <h3 class="text-danger">Top 5 bài viết có lượt bình luận cao nhất</h1>
        <div class="row" style="margin-bottom: 50px">
            <div class="col-md-5 col-xs-12">
                <table class="table">
                    <tr>
                        <th>Mã Bài viết</th>
                        <th>Tiêu đề</th>
                        <th>Số lượt bình luận</th>
                        <th>Chủ bài viết</th>

                    </tr>
                    <c:forEach items="${listTop5PostByComment}" var="top5">
                        <tr>
                            <td >${top5[0]}</td>
                            <td >${top5[1]}</td>
                            <td >${top5[2]} lượt bình luận</td>
                            <td >${top5[3]}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-5 col-xs-12">
                <input type="hidden" id="listPostByComment" value="${listProduct}">
                <div>
                    <!--            data-bind="{JSON.stringify(listProduct)}-->
                    <canvas id="TopPostByComment" ></canvas>
                </div>
            </div>
        </div>



        <hr/>
        <br/>
        <h3 class="text-danger">Top 5 bài viết có nhiều lượt nhất</h1>
            <div class="row" style="margin-bottom: 50px">
                <div class="col-md-5 col-xs-12">
                    <table class="table">
                        <tr>
                            <th>Mã Bài viết</th>
                            <th>Tiêu đề</th>
                            <th>Số lượt like</th>
                            <th>Chủ bài viết</th>

                        </tr>
                        <c:forEach items="${listTop5PostByLike}" var="top5">
                            <tr>
                                <td >${top5[0]}</td>
                                <td >${top5[1]}</td>
                                <td >${top5[2]} lượt like</td>
                                <td >${top5[3]}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-5 col-xs-12">
                    <input type="hidden" id="listPostByComment" value="${listProduct}">
                    <div>
                        <!--            data-bind="{JSON.stringify(listProduct)}-->
                        <canvas id="TopPostByLike" ></canvas>
                    </div>
                </div>
            </div>







            <script>


                // Lấy dữ liệu JSON; tổng sản phẩm theo danh mục
                fetch('http://localhost:8080/SocialApp/api/admin/stats/')
                        .then(response => response.json())
                        .then(data => {

                            let listProduct = data;
                            console.log(listProduct);

                            //                window.onload = function () {
                            const ctx = document.getElementById('myChart');

                            //                    var labels = ['ddd','fdfd'], info = [1,2];
                            var labels = [], info = [];
                            listProduct.map(function (item) {
                                labels.push(item[1]);
                                info.push(item[2]);

                            });

                            //                     type: 'doughnut',
                            new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    //                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                                    labels: labels,
                                    datasets: [{
                                            label: 'THỐNG KÊ SẢN PHẦM THEO DANH MỤC',
                                            //                        data: [12, 19, 3, 5, 2, 3],
                                            data: info,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                            //                }

                        })
                        .catch(error => console.error(error));

                //top 5 sản phẩm có giá khởi điểm cao nhất
                fetch('http://localhost:8080/SocialApp/api/admin/stats/top-5-product/')
                        .then(response => response.json())
                        .then(data => {

                            let listProduct = data;
                            console.log(listProduct);

                            //                window.onload = function () {
                            const ctx = document.getElementById('TopProduct');

                            //                    var labels = ['ddd','fdfd'], info = [1,2];
                            var labels = [], info = [];
                            listProduct.map(function (item) {
                                labels.push(item[1]);
                                info.push(item[2]);

                            });

                            //                     type: 'doughnut',
                            new Chart(ctx, {
                                type: 'doughnut',
                                data: {
                                    //                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                                    labels: labels,
                                    datasets: [{
                                            label: 'TOP 5 SẢN PHẨM CÓ GIÁ CAO NHẤT',
                                            //                        data: [12, 19, 3, 5, 2, 3],
                                            data: info,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                            //                }

                        })
                        .catch(error => console.error(error));


                //top 5 bài viết có số lượt bình luận nhiều nhất
                fetch('http://localhost:8080/SocialApp/api/admin/stats/top-5-post-by-comment/')
                        .then(response => response.json())
                        .then(data => {

                            let listProduct = data;
                            console.log(listProduct);

                            //                window.onload = function () {
                            const ctx = document.getElementById('TopPostByComment');

                            //                    var labels = ['ddd','fdfd'], info = [1,2];
                            var labels = [], info = [];
                            listProduct.map(function (item) {
                                labels.push(item[1]);
                                info.push(item[2]);

                            });

                            //                     type: 'doughnut',
                            new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    //                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                                    labels: labels,
                                    datasets: [{
                                            label: 'TOP 5 BÀI VIẾT CÓ SỐ LƯỢT BÌNH LUẬN NHIỀU NHẤT',
                                            //                        data: [12, 19, 3, 5, 2, 3],
                                            data: info,
                                            backgroundColor: [
                                                'rgba(255, 99, 132, 0.2)',
                                                'rgba(255, 159, 64, 0.2)',
                                                'rgba(255, 205, 86, 0.2)',
                                                'rgba(75, 192, 192, 0.2)',
                                                'rgba(54, 162, 235, 0.2)',
                                                'rgba(153, 102, 255, 0.2)',
                                                'rgba(201, 203, 207, 0.2)'
                                            ],
                                            borderColor: [
                                                'rgb(255, 99, 132)',
                                                'rgb(255, 159, 64)',
                                                'rgb(255, 205, 86)',
                                                'rgb(75, 192, 192)',
                                                'rgb(54, 162, 235)',
                                                'rgb(153, 102, 255)',
                                                'rgb(201, 203, 207)'
                                            ],

                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                        })
                        .catch(error => console.error(error));



                //top 5 bài viết có số lượt LIKE nhiều nhất
                fetch('http://localhost:8080/SocialApp/api/admin/stats/top-5-post-by-like/')
                        .then(response => response.json())
                        .then(data => {

                            let listProduct = data;
                            console.log(listProduct);

                            //                window.onload = function () {
                            const ctx = document.getElementById('TopPostByLike');

                            //                    var labels = ['ddd','fdfd'], info = [1,2];
                            var labels = [], info = [];
                            listProduct.map(function (item) {
                                labels.push(item[1]);
                                info.push(item[2]);

                            });

                            //                     type: 'doughnut',
                            new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    //                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                                    labels: labels,
                                    datasets: [{
                                            label: 'TOP 5 BÀI VIẾT CÓ SỐ LƯỢT LIKE NHIỀU NHẤT',
                                            //                        data: [12, 19, 3, 5, 2, 3],
                                            data: info,
                                            backgroundColor: [
                                                'rgba(255, 99, 132, 0.2)',
                                                'rgba(255, 159, 64, 0.2)',
                                                'rgba(255, 205, 86, 0.2)',
                                                'rgba(75, 192, 192, 0.2)',
                                                'rgba(54, 162, 235, 0.2)',
                                                'rgba(153, 102, 255, 0.2)',
                                                'rgba(201, 203, 207, 0.2)'
                                            ],
                                            borderColor: [
                                                'rgb(255, 99, 132)',
                                                'rgb(255, 159, 64)',
                                                'rgb(255, 205, 86)',
                                                'rgb(75, 192, 192)',
                                                'rgb(54, 162, 235)',
                                                'rgb(153, 102, 255)',
                                                'rgb(201, 203, 207)'
                                            ],

                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                        })
                        .catch(error => console.error(error));



            </script>