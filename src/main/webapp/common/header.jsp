<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <div class="header-area transparent-bar ptb-55">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-4">
                    <div class="logo-small-device">
                        <a href="#"><img alt="" src="<c:url value='/assets/img/logo/logo-1.png'/>"></a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-8">
                    <div class="header-contact-menu-wrapper pl-45">
                        <div class="header-contact">
                            <p style="font-size:20px;"> <b>Liên hệ với chúng tôi 0978 793 083</b></p>
                        </div>
                        <div class="menu-wrapper text-center">
                            <button class="menu-toggle">
                                <img class="s-open" alt="" src="<c:url value='assets/img/icon-img/menu.png'/>">
                                <img class="s-close" alt="" src="<c:url value='assets/img/icon-img/menu-close.png'/>">
                            </button>
                            <div class="main-menu">
                                <nav>
                                    <ul>
                                        <li><a href="@Url.Action("Index", "Home")">home</a></li>
                                        <li>
                                            <a href="@Url.Action("Shop", "Shop")">sản phẩm</a>
                                            <ul class="dropdown partial-content" data-url="@Url.Action("NavbarCategory", "Home")">
                                                <li><a>Loading</a></li>
                                            </ul>
                                        </li>
                                        <li class="active">
                                            <a href="@Url.Action("About", "Home")">về tôi</a>
                                        </li>
                                        <li><a href="@Url.Action("Contact", "Home")">liên hệ</a></li>
                                        <li>
                                            <a href="@Url.Action("Login", "Customer")">đăng nhập</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="header-cart cart-small-device cart-partial">
                    </div>
                </div>
                <!--Mobile-->
                <div class="mobile-menu-area col-12">
                    <div class="mobile-menu">
                        <nav id="mobile-menu-active">
                            <ul class="menu-overflow">
                                <li><a href="@Url.Action("Index", "Home")">home</a></li>
                                <li>
                                    <a href="@Url.Action("Shop", "Shop")">sản phẩm</a>
                                    <ul class="dropdown partial-content" data-url="@Url.Action("NavbarCategory", "Home")">
                                        <li><a>Loading</a></li>
                                    </ul>
                                </li>
                                <li class="active">
                                    <a href="@Url.Action("About", "Home")">về tôi</a>
                                </li>
                                <li><a href="@Url.Action("Contact", "Home")">liên hệ</a></li>
                                <li>
                                    <a href="@Url.Action("Cart", "Cart")">giỏ hàng</a>
                                </li>
                                <li>
                                    <a href="@Url.Action("Login", "Customer")">đăng nhập</a>
                                </li>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-cart-wrapper">
            <div class="header-cart cart-partial">
            </div>
        </div>
    </div>
</header>