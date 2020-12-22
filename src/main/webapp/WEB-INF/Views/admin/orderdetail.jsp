<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/client/loading-spinner.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/client/css/order-list.css'/>">

        <div class="container bootstrap snippet ptb-80" style="margin-bottom: 50px;">
            <div class="row">
                <div class="col-12">
                    <br />

                    <div class="row">
                        <div class="col-md-3">
                            <ul class="list-group">
                                <li class="list-group-item">Order ID</li>
                                <li class="list-group-item">Customer Name</li>
                                <li class="list-group-item">Customer Address</li>
                                <li class="list-group-item">Customer Phone</li>
                                <li class="list-group-item">Created Date</li>
                                <li class="list-group-item">Total</li>
                                <li class="list-group-item">Status</li>
                            </ul>
                        </div>
                        <div class="col-sm">
                            <ul class="list-group">
                                <li class="list-group-item">${orderdetail.getOrderID()}</li>
                                <li class="list-group-item">${orderdetail.getCustomerName()}</li>
                                <li class="list-group-item">${orderdetail.getCustomerAddress()}</li>
                                <li class="list-group-item">${orderdetail.getCustomerPhone()}</li>
                                <li class="list-group-item">${orderdetail.getOrderDate()}</li>
                                <li class="list-group-item">
                                    <fmt:formatNumber type = "number" 
                                                      maxFractionDigits = "3" 
                                                      value = "${orderdetail.getTotal()}" />₫
                                </li>
                                <li class="list-group-item">
                                    <c:choose>
                                        <c:when test="${orderdetail.getOrderStatusID() == 1 || orderdetail.getOrderStatusID() == 5}">
                                            <div class="row">
                                                <div class="col-sm">
                                                    <div class="alert" role="alert" id="alert-status">
                                                        ${orderdetail.getStatusName()}
                                                    </div>
                                                </div>
                                                <div class="col-sm">
                                                    <button class="btn btn-sm btn-info" onclick="">
                                                        <i class="mdi mdi-format-list-bulleted"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="alert" role="alert" id="alert-status">
                                                ${orderdetail.getStatusName()}
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </li>
                            </ul>
                        </div>
                    </div>

                    <br />

                    <table class="table table-bordered" id="order-table">
                        <thead>
                            <tr>
                                <th>
                                    #
                                </th>
                                <th>
                                    Ten Sp
                                </th>
                                <th>
                                    Gia
                                </th>
                                <th>
                                    So luong
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${productlist}" var="item">
                                <tr>
                                    <td>
                                        <img src="${item.getProductImage()}" style="max-height: 50px;" />
                                    </td>
                                    <td>${item.getProductName()}</td>
                                    <td>
                                        <fmt:formatNumber type = "number" 
                                                          maxFractionDigits = "3" 
                                                          value = "${item.getProductPrice()}" />₫
                                    </td>
                                    <td>${item.getProductStock()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                var alert = $("#alert-status");
                var statusid = ${orderdetail.getOrderStatusID()};
                if (statusid === 1) {
                    alert.addClass('alert-secondary');
                } else if (statusid === 2) {
                    alert.addClass('alert-primary');
                } else if (statusid === 3) {
                    alert.addClass('alert-success');
                } else if (statusid === 4 || statusid === 5) {
                    alert.addClass('alert-danger');
                }
            })
        </script>
    </body>
</html>
