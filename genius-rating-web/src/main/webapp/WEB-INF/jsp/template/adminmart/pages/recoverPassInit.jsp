<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>
<spring:message  code="login.loginString.placeholder" var="loginStringPlaceholder"/>
    <div class="main-wrapper">
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center position-relative"
            style="background:url(assets/images/big/auth-bg.jpg) no-repeat center center;">
            <div class="auth-box row">
                <div class="col-lg-7 col-md-5 modal-bg-img" style="background-image: url(assets/images/big/3.jpg);">
                </div>
                <div class="col-lg-5 col-md-7 bg-white">
                    <div class="p-3">
                        <div class="text-center">
                            <img src="assets/images/big/icon.png" alt="wrapkit">
                        </div>
                        <h2 class="mt-3 text-center"><spring:message code="login.recover"/></h2>
                        <p class="text-center"><spring:message code="recoverPass.init.help"/></p>
                        <form:form action="recoverPassInitRest.do" method="post" class="mt-4" modelAttribute="userForm" id="userForm">
                        	<form:hidden path="operation" id="userForm_operation"/>                        
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label class="text-dark" for="uname"><spring:message code="login.loginString"/></label>
										<small id="error_mail" class="badge badge-default badge-danger form-text text-white float-right"></small>
                                        <form:input class="form-control" type="email" path="mail"  id="userForm_mail" placeholder="${loginStringPlaceholder}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 text-center">
                                	<button type="submit" class="btn btn-block btn-dark" id="userForm_submit"><spring:message code="login.recover"/></button>
                                </div>
                                <div class="col-lg-12 text-center mt-5">
                                    <spring:message code="login.noPassword"/> <a href="register.do" class="text-danger"><spring:message code="login.signUp"/></a>
                                </div>
                                <div class="col-lg-12 text-center mt-5">
                                    <a href="javascript:history.back();" class="text-danger"><spring:message code="simpleUser.back"/></a>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- All Required js -->
    <!-- ============================================================== -->
    <script src="assets/libs/jquery/dist/jquery.min.js "></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/libs/popper.js/dist/umd/popper.min.js "></script>
    <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js "></script>
    <script src="assets/capitanperegrina.js "></script>
    <script src="assets/libs/simple-user/recoverPass.js "></script>    
    <!-- ============================================================== -->
    <!-- This page plugin js -->
    <!-- ============================================================== -->
    <script>
        $(".preloader ").fadeOut();
    </script>
