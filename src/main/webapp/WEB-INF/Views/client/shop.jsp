<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/client/loading-spinner.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/client/css/jquery-ui.css'/>">

        <c:set value="${productlist}" var="productPageList" />
        <div class="breadcrumb-area pt-255 pb-170" style="background-image: url()">
            <div class="container-fluid">
                <div class="breadcrumb-content text-center">
                    <h2>cửa hàng</h2>
                    <ul>
                        <li>
                            <a href="<c:url value="/"/>">home</a>
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
                                    <c:forEach items="${productPageList.pageList}" var="item">
                                        <div class="product-width col-md-4 col-xl-3 col-lg-4">
                                            <div class="product-wrapper mb-35">
                                                <div class="product-img">
                                                    <a href="#">
                                                        <img src="${item.getProductImage()}" alt="${item.getProductName()}">
                                                    </a>
                                                    <div class="product-action">
                                                        <a class="action-plus-2 p-action-none" title="Thêm vào giỏ hàng"
                                                           href="#">
                                                            <i class="ti-shopping-cart"></i>
                                                        </a>
                                                    </div>
                                                    <div class="product-content-wrapper">
                                                        <div class="product-title-spreed">
                                                            <h4>
                                                                <a href="#">
                                                                    ${item.getProductName()}
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div class="product-price">
                                                            <c:choose>
                                                                <c:when test="${empty item.getPromotionPrice()}">
                                                                    <span>${item.getProductPrice()}₫</span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span>${item.getPromotionPrice()}₫</span>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="product-list-details">
                                                    <h2>
                                                        <a href="#">
                                                            ${item.getProductName()}
                                                        </a>
                                                    </h2>
                                                    <div class="quick-view-rating">
                                                        <i class="fa fa-star reting-color"></i>
                                                        <i class="fa fa-star reting-color"></i>
                                                        <i class="fa fa-star reting-color"></i>
                                                        <i class="fa fa-star reting-color"></i>
                                                        <i class="fa fa-star reting-color"></i>
                                                    </div>
                                                    <div class="product-price">
                                                        <c:choose>
                                                            <c:when test="${empty item.getPromotionPrice()}">
                                                                <span>${item.getProductPrice()}₫</span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span>${item.getPromotionPrice()}₫</span>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                    <p>${item.getProductDescription()}</p>
                                                    <div class="shop-list-cart">
                                                        <a href="#"><i class="ti-shopping-cart"></i> Add to cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <!--                            <div class="loader" id="loader">
                                                                <svg class="circular">
                                                                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="5" stroke-miterlimit="10"></circle>
                                                                </svg>
                                                            </div>-->
                            </div>
                        </div>
                        <!--Pagin Btn-->
                        <div class="paginations text-center mt-20">
                            <nav>
                                <ul class="pagination">
                                    <c:choose>
                                        <c:when test="${productPageList.firstPage}">
                                            <li>Prev</li>
                                            </c:when>
                                            <c:otherwise>
                                                <c:url value="/shop/prev" var="url" />                  
                                            <a href='<c:out value="${url}" />'>Prev</a>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach begin="1" end="${productPageList.pageCount}" step="1"  varStatus="tagStatus">
                                        <c:choose>
                                            <c:when test="${(productPageList.page + 1) == tagStatus.index}">
                                                <li>${tagStatus.index}</li>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:url value="/shop/${tagStatus.index}" var="url" />                  
                                                <a href='<c:out value="${url}" />'>${tagStatus.index}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${productPageList.lastPage}">
                                            <li>Next</li>
                                            </c:when>
                                            <c:otherwise>
                                                <c:url value="/shop/next" var="url" />                  
                                            <a href='<c:out value="${url}" />'>Next</a>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="<c:url value="/assets/client/js/jquery-ui.js"/>"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                let search = "@ViewBag.search";
                let sort = "@ViewBag.sort";
                let pageindex = 0;
                $.ajax({
                    url: "<c:url value="shop/productdata"/>",
                    type: "GET",
                    contentType: "application/json",
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        $("#loader").hide();
                        for (var i = 0; i < data.length; i++) {
                            //createProduct(data[i]);
                        }
                    }
                });
                function createProduct(data) {
                    console.log(data.ProductID);
                    $("#product-content").append(`
                <div class="product-width col-md-4 col-xl-3 col-lg-4">
                    <div class="product-wrapper mb-35">
                        <div class="product-img">
                            <a href="#">
                                <img src="` + data.ProductImage + `" />" alt="` + data.ProductName + `">
                            </a>
                            <div class="product-action">
                                <a class="action-plus-2 p-action-none" title="Thêm vào giỏ hàng"
                                   href="#">
                                    <i class="ti-shopping-cart"></i>
                                </a>
                            </div>
                            <div class="product-content-wrapper">
                                <div class="product-title-spreed">
                                    <h4>
                                        <a href="#">` + data.ProductName + `</a>
                                    </h4>
                                </div>
                                <div class="product-price">
                                                        `);
                    if (data.PromotionPrice !== null) {
                        $("#product-content").append(`<span>` + data.PromotionPrice + `</span>`);
                    } else {
                        $("#product-content").append(`<span>` + data.ProductPrice + `</span>`);
                    }
                    $("#product-content").append(`
                                </div>
                            </div>
                        </div>
                        <div class="product-list-details">
                            <h2>
                                <a href="#">` + data.ProductName + `</a>
                            </h2>
                            <div class="quick-view-rating">
                                <i class="fa fa-star reting-color"></i>
                                <i class="fa fa-star reting-color"></i>
                                <i class="fa fa-star reting-color"></i>
                                <i class="fa fa-star reting-color"></i>
                                <i class="fa fa-star reting-color"></i>
                            </div>
                            <div class="product-price">
                    `);
                    if (data.PromotionPrice !== null) {
                        $("#product-content").append(`<span>` + data.PromotionPrice + `</span>`);
                    } else {
                        $("#product-content").append(`<span>` + data.ProductPrice + `</span>`);
                    }
                    $("#product-content").append(`
                            </div>
                            <p>` + data.ProductDescription + `</p>
                            <div class="shop-list-cart">
                                <a href="#"></i> Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>`);
                }

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
