<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<spring:message code="label_contact_shop_us" var="labelShopList"/>
<spring:message code="label_contact_bucket_us" var="labelBucketList"/>
<spring:message code="label_contact_login_us" var="labelLoginList"/>
<spring:message code="label_contact_signin_us" var="labelSingInList"/>
<spring:message code="label_contact_about_us" var="labelAboutList"/>
<spring:message code="label_contact_service_us" var="labelServiceList"/>
<spring:message code="label_contact_contacts_us" var="labelContactsList"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop Homepage - Start Bootstrap Template</title>
    <link rel="stylesheet" href='<c:url value="../../resources/bootstrap/css/bootstrap.min.css" />'/>
    <link href='<c:url value="../../resources/bootstrap/css/bootstrap.css" />'/>
    <link rel="stylesheet" href='<c:url value="../../resources/ie10/ie10-viewport-bug-workaround.js" />'/>
    <link rel="stylesheet" href='<c:url value="../../resources/ie10/ie10-viewport-bug-workaround.css" />'/>
    <link rel="stylesheet" href='<c:url value="../../resources/css/index.css" />'/>
    <link href='<c:url value="../../resources/css/shop-homepage.css" />' rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/index"/>">${labelShopList}</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">${labelAboutList}</a>
                </li>
                <li>
                    <a href="<c:url value='/contact'/>">${labelContactsList}</a>
                </li>
                <li>
                    <c:if test="${locale eq 'en'}">
                <li><a href="?locale=en"><spring:message code="header.locale.en"/></a> </li>
                <li class="active"><a href="#"><spring:message code="header.locale.ru"/></a></li>
                </c:if>
                </li>
                <li>
                    <c:if test="${locale eq 'ru'}">
                <li class="active"><a href="#"><spring:message code="header.locale.ru"/></a> </li>
                <li><a href="?locale=en"><spring:message code="header.locale.en"/></a></li>
                </c:if>
                </li>
                <li>
                    <c:if test="${empty locale}">
                <li><a href="?locale=ru"><spring:message code="header.locale.ru"/></a> </li>
                <li class="active"><a href="?locale=en"><spring:message code="header.locale.en"/></a></li>
                </c:if>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="<c:url value='/bucket'/>">
                        <span class="glyphicon glyphicon-shopping-cart"></span>${labelBucketList}</a>
                </li>
                <li>
                    <a href="<c:url value='/login'/>">
                            <span class="glyphicon glyphicon-user"></span>${labelSingInList}</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Shopping Cart
                <small>Item List</small>
            </h1>
        </div>
    </div>
    <!-- /.row -->

    <!-- page content  -->
    <div>

        <div class="row">
            <!-- left category  -->
            <c:if test="${not empty product}">
                    <div class="row">
                        <div class="col-lg-3 col-md-3">
                            <img class="img-responsive" src="${product.photo}" alt="">
                        </div>
                        <div class="col-lg-3 col-md-3">
                            <p>${product.name}, ${product.price} $</p>
                        </div>
                        <div class="col-lg-3 col-md-3">
                            <p>Quantity: ${product.productCount}</p>
                        </div>
                        <div class="col-lg-3 col-md-3">
                           <!-- <p>Total: {product.getProductTotalPrice()}</p> сделать метод тотал price-->
                        </div>
                    </div>
                    <hr>

            </c:if>
        </div>
        <div class="row">
            <!--<span class="pull-right">Total: { totalPrice }</span> сделать метод тотал price -->
        </div>
        <div class="row">
            <button id="checkout-btn" type="button" class="btn btn-primary btn-md pull-right">Checkout</button>
        </div>
    </div>
</div>
<footer>
    <div class="row">
        <div class="col-lg-12">
            <p>Copyright © Your Website 2017</p>
        </div>
    </div>
</footer>

<script src='<c:url value="../../resources/bootstrap/js/jquery-3.1.1.min.js" />'></script>
<script src='<c:url value="../../resources/bootstrap/js/bootstrap.min.js" />'></script>

</body>
</html>