<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Genius Rating - A free, do it yourself sailing rating system">
    <meta name="author" content="GeNius Rating v.<c:out value="${request_simpleUserManagementAppVersion}"/>">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="static/assets/images/favicon.png">
    <title><spring:message code="common.title"/></title>
    <!-- Custom CSS -->
    <link href="static/assets/extra-libs/c3/c3.min.css" rel="stylesheet">
    <link href="static/assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
    <link href="static/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
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
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
        data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
		<header class="topbar" data-navbarbg="skin6">		
<tiles:insertAttribute name="header" />
		</header>
		<aside class="left-sidebar" data-sidebarbg="skin6">
<tiles:insertAttribute name="aside" />
		</aside>
        <div class="page-wrapper">
            <div class="page-breadcrumb">
<tiles:insertAttribute name="breadcrumb" />
            </div>
            <div class="container-fluid">
<tiles:insertAttribute name="content" />            
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <footer class="footer text-center text-muted">            
<tiles:insertAttribute name="footer" />
			</footer>
        </div>
    </div>

    <script src="static/assets/libs/jquery/dist/jquery.min.js"></script>
    <script src="static/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="static/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- apps -->
    <script src="static/dist/js/app-style-switcher.js"></script>
    <script src="static/dist/js/feather.min.js"></script>
    <script src="static/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="static/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="static/dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <script src="static/assets/extra-libs/c3/d3.min.js"></script>
    <script src="static/assets/extra-libs/c3/c3.min.js"></script>
    <script src="static/assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="static/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="static/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="static/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>
    <script src="static/dist/js/pages/dashboards/dashboard1.min.js"></script>
    <script src="static/assets/capitanperegrina.js "></script>
<c:if test="${request_simpleUserManagementLogged != null}">
    <script src="static/assets/libs/simple-user/logout.js "></script>	
</c:if>
<tiles:insertAttribute name="modals" />
<tiles:insertAttribute name="javasctipt" />
</body>
</html>