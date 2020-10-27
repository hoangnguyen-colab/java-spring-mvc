<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/loading-spinner.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/jquery-ui.css'/>">
        
        <div class="breadcrumb-area pt-255 pb-170" style="background-image: url()">
            <div class="container-fluid">
                <div class="breadcrumb-content text-center">
                    <h2>cửa hàng</h2>
                    <ul>
                        <li>
                            <a href="@Url.Action("Index", "Home")">home</a>
                        </li>
                        <li>cửa hàng</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="shop-wrapper fluid-padding-2 pt-120 pb-150">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="product-sidebar-area pr-60">
                            <div class="sidebar-widget pb-55">
                                <h3 class="sidebar-widget">Tìm kiếm</h3>
                                <div class="sidebar-search">
                                    <form action="" method="get">
                                        <input class="search-box" type="text" placeholder="Tìm kiếm..." name="search" id="search-product">
                                        <button type="submit"><i class="ti-search"></i></button>
                                    </form>
                                </div>
                            </div>
                            <div class="sidebar-widget pb-50">
                                <h3 class="sidebar-widget">Lọc theo hãng</h3>
                                <div class="widget-categories">
                                    <ul id="category-content">
                                        <li><a href="#">Tất cả</a></li>
                                        <%@ include file="/common/client/partialview/navbrand.jsp" %>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop-topbar-wrapper">
                            <div class="grid-list-options">
                                <ul class="view-mode">
                                    <li class="active"><a href="#product-grid" data-view="product-grid"><i class="ti-layout-grid2"></i></a></li>
                                    <li><a href="#product-list" data-view="product-list"><i class="ti-view-list"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-sorting">
                                <div class="sorting sorting-bg-1">
                                    <form>
                                        <select class="select" id="sort-filter">
                                            <option value="default">Mặc định </option>
                                            <option value="name_asc">Tên A -> Z</option>
                                            <option value="name_desc">Tên Z -> A</option>
                                            <option value="price_asc">Giá thấp nhất</option>
                                            <option value="price_desc">Giá cao nhất</option>
                                        </select>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="grid-list-product-wrapper tab-content">
                            <div class="product-grid product-view tab-pane active">
                                <div class="row" id="product-content">
                                </div>
                                <div class="loader" id="loader">
                                    <svg class="circular">
                                    <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="5" stroke-miterlimit="10"></circle>
                                    </svg>
                                </div>
                            </div>
                        </div>
                        <!--Load Btn-->
                        <div class="paginations text-center mt-20">
                            <div class="btn">
                                <button id="load-more">Tải thêm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="<c:url value="/assets/js/jquery-ui.js"/>"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                let search = "@ViewBag.search";
                let sort = "@ViewBag.sort";
                let pageindex = 0;
                $.get("123123", function (data) {
                    console.log("Run")
                    //$("#category-content").append(data);
                }
                );
        
                $.post("123123",
                        {
                            "search": search,
                            "sort": sort,
                            "pageindex": pageindex
                        },
                        function (data) {
                            $("#product-content").append(data);
                            $("#loader").hide();
                        }
                );
        
                $("#sort-filter").on('change', function (event) {
                    let url =
                            '@Html.Raw(Url.Action("Shop", "Shop", new { search = "search-value", sort = "sort-value" }))';
                    url = url.replace("search-value", search);
                    url = url.replace("sort-value", this.value);
                    window.location.href = url;
                });
                
                $("#search-product").autocomplete({
                    source: function (request, response) {
                        $.ajax({
                            url: "123123",
                            type: "POST",
                            dataType: "json",
                            data: {prefix: request.term},
                            success: function (data) {
                                response($.map(data.name, function (item) {
                                    return {label: item.ProductName, value: item.ProductName};
                                }));
                            }
                        });
                    },
                    minLength: 2
                });
                $("#load-more").click(function () {
                    $("#loader").show();
                    pageindex += 1;
                    $.post("123123",
                            {
                                "search": search,
                                "sort": sort,
                                "pageindex": pageindex
                            },
                            function (data) {
                                $("#product-content").append(data);
                                $("#loader").hide();
                            });
                });
            });
        </script>

    </body>
</html>
