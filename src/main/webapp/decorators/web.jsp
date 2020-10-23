<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Trang Chu</title>
        <!-- all css here -->
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/bootstrap.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/animate.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/owl.carousel.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/chosen.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/icofont.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/themify-icons.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/font-awesome.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/meanmenu.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/bundle.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/responsive.css'/>">
        <script src="<c:url value='/assets/js/vendor/modernizr-2.8.3.min.js'/>"></script>
        <script src="<c:url value='/assets/js/vendor/jquery-1.12.0.min.js'/>"></script>
    </head>
    <body>
        <div class="wrapper">
            <%@ include file="/common/header.jsp" %>

            <dec:body />

            <%@ include file="/common/footer.jsp" %>
        </div>

        <!-- all js here -->
        <script src="<c:url value='/assets/js/popper.js'/>"></script>
        <script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/assets/js/isotope.pkgd.min.js'/>"></script>
        <script src="<c:url value='/assets/js/imagesloaded.pkgd.min.js'/>"></script>
        <script src="<c:url value='/assets/js/jquery.counterup.min.js'/>"></script>
        <script src="<c:url value='/assets/js/waypoints.min.js'/>"></script>

        <script src="<c:url value='/assets/js/owl.carousel.min.js'/>"></script>
        <script src="<c:url value='/assets/js/plugins.js'/>"></script>
        <script src="<c:url value='/assets/js/main.js'/>"></script>
        <script>
            $(document).ready(function () {
                $.get("https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true", function (data) {
                    var html = $("#covid-data");
//                    for (i = 0; i < data.length; i++) {
//                        html.append(`<tr>
//                                        <th scope="row">${i + 1}</th>
//                                        <td>${data[i].country}</td>
//                                        <td>${data[i].infected}</td>
//                                        <td>${data[i].deceased}</td>
//                                        <td>${data[i].recovered}</td>
//                                    </tr>`);
//                    }

                    $('#covid-table').DataTable()
                });
            });
        </script>
        <script type="text/javascript">
            var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
            (function () {
                var s1 = document.createElement("script"), s0 = document.getElementsByTagName("script")[0];
                s1.async = true;
                s1.src = 'https://embed.tawk.to/5e5926ab298c395d1cea4ed0/default';
                s1.charset = 'UTF-8';
                s1.setAttribute('crossorigin', '*');
                s0.parentNode.insertBefore(s1, s0);
            })();
        </script>
    </body>
</html>
