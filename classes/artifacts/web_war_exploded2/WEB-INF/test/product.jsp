<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href='<c:url value="../../resources/bootstrap/css/bootstrap.min.css"/>'/>
    <link href='<c:url value="../../resources/bootstrap/css/bootstrap.css"/>'/>
    <link rel="stylesheet" href='<c:url value="../../resources/bootstrap/js/jquery-3.1.1.min.js"/>'/>
    <link rel="stylesheet" href='<c:url value="../../resources/bootstrap/js/bootstrap.min.js"/>'/>
    <link rel="stylesheet" href='<c:url value="../../resources/ie10/ie10-viewport-bug-workaround.js"/>'/>
    <link rel="stylesheet" href='<c:url value="../../resources/ie10/ie10-viewport-bug-workaround.css"/>'/>
    <link rel="stylesheet" href='<c:url value="../../resources/css/index.css"/>'/>
    <link href='<c:url value="../../resources/css/shop-homepage.css"/>' rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>test</title>
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
                    <c:if test="${locale eq 'ru'}">
                <li><a href="?locale=ru"><spring:message code="header.locale.ru"/></a> </li>
                <li class="active"><a href="#"><spring:message code="header.locale.en"/></a></li>
                </c:if>
                </li>
                <li>
                    <c:if test="${locale eq 'en'}">
                <li class="active"><a href="#"><spring:message code="header.locale.ru"/></a> </li>
                <li><a href="?locale=en"><spring:message code="header.locale.en"/></a></li>
                </c:if>
                </li>
                <li>
                    <c:if test="${empty locale}">
                <li><a href="?locale=en"><spring:message code="header.locale.en"/></a> </li>
                <li class="active"><a href="?locale=ru"><spring:message code="header.locale.ru"/></a></li>
                </c:if>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" ><span class="glyphicon glyphicon-shopping-cart"></span>${labelBucketList}</a></li>
                <li>
                    <c:url var="login" value="/login"/>
                    <a href=${login} >
                        <span class="glyphicon glyphicon-user"></span>${labelSingInList}</a></li>
                <li>
                    <a href="#" data-toggle="modal" data-target="#login-modal">
                        <span class="glyphicon glyphicon-log-in"></span> ${labelLoginList}</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-md-9">
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-xs-12">
                <img  src="${product.photo}" />
                <div class="caption">
                    <h4 class="pull-right"></h4>
                    <h4><a href="#">${product.name}</a></h4>
                    <p>${product.description}><a target="_blank" href="">  </a></p>
                    <div class="col-md-4">
                        <a href="<c:url value="/data/${product.id}"/>">
                            <button type="button" class="btn btn-primary">Просмотреть</button></a></div>
                    <div class="ratings">
                        <p class="pull-right"></p>
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
