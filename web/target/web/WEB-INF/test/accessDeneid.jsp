<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>AccessDenied page</title>
</head>
<body>
Dear <strong>${product}</strong>, You are not authorized to access this page<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
