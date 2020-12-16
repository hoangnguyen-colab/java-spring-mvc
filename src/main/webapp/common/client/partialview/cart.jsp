<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${empty sessionScope.cartlist}">
        <div style="overflow-y: scroll;">
            <button class="icon-cart">
                <i class="ti-shopping-cart"></i>
                <span class="count-style">0</span>
                <span class="count-price-add">Giỏ hàng</span>
            </button>
            <div class="shopping-cart-content">

                <h2 class="text-center">Giỏ Hàng Trống</h2>
                <div class="shopping-cart-btn">
                    <a class="btn-style cr-btn" href="<c:url value="/shop"/>">bắt đầu mua hàng</a>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="total" value="${0}"/>
        <c:forEach var="item" items="${sessionScope.cartlist}">
            <c:set var="total" value="${total + item.quantity}" />
        </c:forEach>
        <div style="overflow-y: scroll;">
            <button class="icon-cart">
                <i class="ti-shopping-cart"></i>
                <span class="count-style">${total}</span>
                <span class="count-price-add">Giỏ hàng</span>
            </button>
            <div class="shopping-cart-content">
                <ul>
                    <c:forEach var="item" items="${sessionScope.cartlist}">
                        <li class="single-shopping-cart">
                            <div class="shopping-cart-img">
                                <a href="<c:url value="/product/${item.product.getProductURL()}/${item.product.getProductID()}"/>">
                                    <img alt="${item.product.getProductName()}" src="${item.product.getProductImage()}" style="width: 45px;">
                                </a>
                            </div>
                            <div class="shopping-cart-title">
                                <h3>
                                    <a href="<c:url value="/product/${item.product.getProductURL()}/${item.product.getProductID()}"/>">
                                        ${item.product.getProductName()}
                                    </a>
                                </h3>

                                <span>
                                    Giá: subtotal ₫
                                </span>
                                <span class="qty">SL: ${item.quantity}</span>
                            </div>
                            <div class="shopping-cart-delete">
                                <a href="#delete" id="cart-del-btn">
                                    <i class="icofont icofont-ui-delete"></i>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="shopping-cart-total">
                    <h4><span>total ₫</span></h4>
                </div>
                <div class="shopping-cart-btn">
                    <a class="btn-style cr-btn" href="<c:url value="/cart"/>">chi tiết</a>
                </div>
                <div class="shopping-cart-btn">
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
