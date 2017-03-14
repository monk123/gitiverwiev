<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shop</title>
    <link rel="stylesheet" href='<spring:url value="../../resources/bootstrap/css/bootstrap.min.css" />'/>
    <link href='<spring:url value="../../resources/bootstrap/css/bootstrap.css" />'/>
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
                <a class="navbar-brand" href="#">${labelShopList}</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">${labelAboutList}</a>
                    </li>
                    <li>
                        <a href="<c:url value='/contact'/>">${labelContactsList}</a>
                    </li>
                    <c:set var="locale" value="${request.LOCALE.language}"/>
                    <c:if test="${locale eq 'en'}">
                        <li class="active"><a href="#"><spring:message code="header.locale.ru"/></a></li>
                        <li><a href="?locale=en"><spring:message code="header.locale.en"/></a> </li>
                    </c:if>
                    <c:if test="${locale eq 'ru'}">
                         <li><a href="?locale=ru"><spring:message code="header.locale.ru"/></a></li>
                         <li class="active"><a href="#"><spring:message code="header.locale.en"/></a> </li>
                    </c:if>
                    <c:if test="${empty locale}">
                        <li><a href="?locale=ru"><spring:message code="header.locale.ru"/></a> </li>
                         <li class="active"><a href="?locale=en"><spring:message code="header.locale.en"/></a></li>
                    </c:if>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="<c:url value='/bucket/${product.id}'/>">
                            <span class="glyphicon glyphicon-shopping-cart"></span>${labelBucketList}</a>
                    </li>
                    <li>
                        <sec:authorize access="isAuthenticated()">
                            <p class="navbar-text">Hello, <sec:authentication property="principal.displayName"/></p>
                                <c:url var="logout" value="/logout"/>
                                    <li class="active">
                                        <a href="${logout}" id="logOutBottom"><span class="glyphiocon glyphicon-log-out" ><jsp:text/></span>Log Out</a>
                                    </li>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <c:url var="login" value="/login"/>
                                <a href="${login}"><span class="glyphicon-check"/>${labelSingInList}</a>
                        </sec:authorize>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <p class="lead">Categories</p>
                <div id="category-options" class="list-group">
                        <c:forEach var="product" items="${listProduct}">
                            <a charset="UTF-8" href="<c:url value='/product/${product.categoryNumber}' />" class="list-group-item category-select-option">${product.categoryName}</a>
                        </c:forEach>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <c:forEach var="product" items="${listProduct}">
                    <div class="col-xs-12">
                        <img src="${product.photo}"/>
                            <div class="caption">
                                <h4 class="pull-right">${product.price} $</h4>
                                <h4><a href="#">${product.name}</a></h4>
                                <p>${product.description}</p>
                                <div class="col-md-4">
                                    <a href="<c:url value="/data/${product.id}"/>">
                                    <button type="button" class="btn btn-primary">Просмотреть</button></a></div>
                            </div>
                    </div>
                    </c:forEach>
                </div>
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
