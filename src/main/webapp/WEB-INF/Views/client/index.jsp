<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Trang Chủ</title>
    </head>
    <body>
        <div class="blog-area pt-150 pb-110">
            <div class="container">
                <div class="section-title text-center mb-60">
                    <h2 style="font-size:70px;">Được Xem Nhiều</h2>
                </div>
                <div class="row" id="top-view-product">
                </div>
            </div>
        </div>

        <div class="blog-area pt-150 pb-110">
            <div class="container">
                <div class="section-title text-center mb-60">
                    <h2 style="font-size:70px;">Sản phẩm mới nhất</h2>
                </div>
                <div class="row" id="newest-product">
                </div>
            </div>
        </div>

        <div class="overview-area pt-135">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="overview-content">
                            <h1>Corona Update</h1>
                            <br />
                            <table class="table table-bordered" id="covid-table">
                                <thead>
                                    <tr>
                                        <th scope="col">X?p h?ng</th>
                                        <th scope="col">Qu?c gia</th>
                                        <th scope="col">S? ca nhi?m</th>
                                        <!--                                        <th scope="col">T? vong</th>
                                                                                <th scope="col">H?i ph?c</th>-->
                                    </tr>
                                </thead>
                                <tbody id="covid-data">   
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <th scope="row">${item.getBrandID()}</th>
                                            <td>${item.getBrandName()}</td>
                                            <td>${item.getBrandUrl()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12">
                        <div class="overview-img">
                            <img class="tilter" src="<c:url value="assets/client/img/banner/banner.jpg" />" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

