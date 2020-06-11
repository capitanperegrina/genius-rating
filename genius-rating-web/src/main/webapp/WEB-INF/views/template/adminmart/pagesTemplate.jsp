<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>

<html dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="GeNius Rating v. ${request_simpleUserManagementAppVersion}">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="static/assets/images/favicon.png">
    <title><spring:message code="common.title"/></title>
    <!-- Custom CSS -->
    <link href="static/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
<tiles:insertAttribute name="content" />
<tiles:insertAttribute name="modals" />
</body>

</html>
