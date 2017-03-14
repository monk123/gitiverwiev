<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
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
<div class="container">
    <c:if test="${! empty listProduct}">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Product name</th>
            <th>Article</th>
            <th>Count</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category</th>
            <th>Category Number</th>
            <th>Photo</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.article}</td>
            <td>${product.productCount}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.categoryName}</td>
            <td>${product.categoryNumber}</td>
            <td><img src="${product.photo}"/></td>
            <td><a href="<c:url value="/edit/${product.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/remove/${product.id}"/>">Delete</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>


    <h1>Add Product</h1>
    <c:url var="addProduct" value="/table/add"/>
        <s:form action="${addProduct}" commandName="product" enctype="" acceptCharset="UTF-8">
            <table class="table">
                <thead>
                   <c:if test="${!empty product.name}">
                       <tr>
                           <td>
                               <s:label path="id">
                                   <spring:message text="ID"/>
                               </s:label>
                           </td>
                           <td>
                               <s:input path="id" readonly="true" disabled="true"/>
                               <s:hidden path="id"/>
                           </td>
                       </tr>
                   </c:if>
                <tr>
                    <td>
                        <s:label path="name"><spring:message text="Name"/></s:label>
                    </td>
                    <td>
                        <s:input path="name" />
                    </td>
                </tr>
                   <tr>
                       <td>
                           <s:label path="article"><spring:message text="Article"/></s:label>
                       </td>
                       <td>
                           <s:input path="article"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:label path="description"><spring:message text="Description"/></s:label>
                       </td>
                       <td>
                           <s:input path="description"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:label path="productCount"><spring:message text="Count"/></s:label>
                       </td>
                       <td>
                           <s:input path="productCount"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:label path="categoryName"><spring:message text="Category Name"/></s:label>
                       </td>
                       <td>
                           <s:input path="categoryName"/>
                       </td>
                       <td>
                           <s:label path="categoryNumber"><spring:message text="Category Number"/></s:label>
                       </td>
                       <td>
                           <s:input path="categoryNumber"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:label path="price"><spring:message text="Price"/></s:label>
                       </td>
                       <td>
                           <s:input path="price"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:label path="photo"><spring:message text="Photo"/></s:label>
                       </td>
                       <td>
                           <s:input type="text" path="photo"/>
                       </td>
                   </tr>

                   <!-- ADD PRODUCT -->
                <tr>
                    <td>
                        <c:if test="${!empty product.name}">
                            <input type="submit" value="<spring:message text="Edit"/>"/>
                        </c:if>

                        <c:if test="${empty product.name}">
                            <input type="submit" value="<spring:message text="Add"/>"/>
                        </c:if>
                    </td>
                </tr>
                </thead>
            </table>
        </s:form>
</div>

<script src='<c:url value="../../resources/bootstrap/js/jquery-3.1.1.min.js" />'></script>
<script src='<c:url value="../../resources/bootstrap/js/bootstrap.min.js" />'></script>

</body>
</html>
