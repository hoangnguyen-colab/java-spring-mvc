<%-- 
    Document   : createproduct
    Created on : Nov 9, 2020, 4:31:41 PM
    Author     : FR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>

    <body>
        <link rel='stylesheet' href='/assets/materialize.min.css'>
        <link href="/assets/loading-spinner.css" rel="stylesheet" />
        <button class="btn btn-sm btn-primary" value="Back"
                onclick="window.location.href = '/admin/product/selectbrand'">
            <i class="mdi mdi-arrow-left-bold"></i>
            Back to Brand
        </button>
        <hr />

        <form action="#" method="post" id="create-product-form">
            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Brand</label>
                </div>
                <div class="input-field col s12">
                    <input type="text" readonly value="${Brand.getBrandName()}">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Name</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-name" name="product-name" type="text" class="validate">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>URL</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-url" type="text" class="validate" readonly value="(name)">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Price</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-price" name="product-price" type="number" class="validate">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Promotion Price</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-promotion" name="product-promotion" type="number" class="validate">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Stock</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-stock" name="product-stock" type="number" class="validate">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Product Image</label>
                </div>
                <div class="input-field col s12">
                    <input id="product-image" type="text" class="validate">
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Status</label>
                </div>
                <div class="input-field col s12">
                    <input id="status-checkbox" type="checkbox" checked="checked" />
                    <label for="status-checkbox" id="checkbox-label">Active</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col-lg-2 s12">
                    <label>Decription</label>
                </div>
                <div class="input-field col s12">
                    <textarea placeholder="Decription" id="text-area" name="area"></textarea>
                </div>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="create-configuation">
                <label class="form-check-label" for="create-configuation">Create Config</label>
            </div>
            <hr />

            <div id="config-partial"></div>

            <button class="btn waves-effect waves-light" type="submit" name="action">
                <span>Submit </span><i class="mdi mdi-send"></i>
            </button>

        </form>


        <script src='/assets/materialize.min.js'></script>
        <script src="/assets/admin/js/sweetalert.min.js"></script>
        <script src="/assets/jquery.validate.min.js"></script>
        <script>
                    function slugify(text) {
                        return text.toString().toLowerCase()
                                .replace(/\s+/g, '-')           // Replace spaces with -
                                .replace(/[^\w\-]+/g, '')       // Remove all non-word chars
                                .replace(/\-\-+/g, '-')         // Replace multiple - with single -
                                .replace(/^-+/, '')             // Trim - from start of text
                                .replace(/-+$/, ''); // Trim - from end of text
                    }
                    $(document).ready(function () {

//                    $('#create-configuation').click(function () {
//                    if ($(this).is(':checked')) {
//                    $.post("@Url.Action("CreateConfigurationPartial", "Configuration")", function (data) {
//                    $("#config-partial").empty();
//                    $("#config-partial").append(data);
//                    });
//                    } else if (!$(this).is(':checked')) {
//                    $("#config-partial").empty();
//                    }
//                    });
                        $('select').material_select();
                        $("#status-checkbox").click(function () {
                            if ($(this).is(":checked")) {
                                $("#checkbox-label").text("Active");
                            } else {
                                $("#checkbox-label").text("Inactive");
                            }
                            ;
                        });
                        $("#product-name").on('input', function (e) {
                            $("#product-url").val(slugify($("#product-name").val()));
                        });
                        $("#create-product-form").validate({
                            rules: {
                                'product-name': "required",
                                'product-price': {
                                    required: true
                                },
                                'product-stock': {
                                    digits: true
                                }
                            },
                            messages: {
                                'product-name': "Please enter product name",
                                'product-price': {
                                    required: "Please enter product price"
                                },
                                'product-stock': "Not a correct format"
                            },
                            submitHandler: function () {
                                let data = {
                                    "ProductName": $("#product-name").val(),
                                    "ProductPrice": $("#product-price").val(),
                                    "PromotionPrice": $("#product-promotion").val(),
                                    "ProductStock": $("#product-stock").val(),
                                    "BrandID": "${Brand.getBrandID()}",
                                    "ProductImage": $("#product-image").val(),
                                    "ProductDescription": $("#text-area").val(),
                                    "ProductStatus": $("#status-checkbox").is(":checked")
                                };

                                console.log(data);


                                $.ajax({
                                    url: "/admin/product/submitcreate",
                                    type: "get",
                                    data: data,
                                    dataType: "json",
                                    contentType: "application/json",
                                    success: function (response) {

//                                    if (response.Success && $('#create-configuation').is(':checked')) {
//                                    let config = {
//                                    "OSName": $("#OSName").val(),
//                                            "OSVersion": $("#OSversion").val(),
//                                            "SizeDisplay": $("#Display").val(),
//                                            "FrontCamera": $("#FrontCamera").val(),
//                                            "RearCamera": $("#RearCamera").val(),
//                                            "Cpu": $("#CPU").val(),
//                                            "Ram": $("#Ram").val(),
//                                            "Rom": $("#Rom").val(),
//                                            "SimStatus": $("#Sim").val(),
//                                            "Battery": $("#Battery").val(),
//                                            "ProductID": `${response.id}`
//                                    };
//                                    $.ajax({
//                                    url: "@Url.Action("CreateConfiguration", "Configuration")",
//                                            type: "POST",
//                                            data: JSON.stringify(config),
//                                            dataType: "json",
//                                            contentType: "application/json",
//                                            success: function (response) {
//                                            if (response.Success) {
//                                            swal("Created product!", "", "success");
//                                            } else if (!response.Success) {
//                                            swal("Error creating config!", "", "error");
//                                            }
//                                            },
//                                            error: function (error) {
//                                            swal("Error creating config !", "", "error");
//                                            }
//                                    });
                                        if (response.Status) {
                                            swal("Created product!", "", "success")
                                                    .then((value) => {
                                                        location.href = '/admin/productlist';
                                                    });
                                        } else {
                                            swal("Created product Fail!", "", "error");
                                        }
                                    },
                                    error: function (error) {
                                        swal("Error creating product !", "", "error");
                                    }

                                });
                            }
                        });
                    });
        </script>
    </body>
</html>
