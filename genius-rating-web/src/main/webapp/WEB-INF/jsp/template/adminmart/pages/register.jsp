<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>
<spring:message code="login.nick.placeholder" var="loginNickPlaceholder"/>
<spring:message code="login.mail.placeholder" var="loginMailPlaceholder"/>
<spring:message code="login.password.placeholder" var="loginPasswordPlaceholder"/>

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
            <div class="auth-box row text-center">
                <div class="col-lg-7 col-md-5 modal-bg-img" style="background-image: url(assets/images/big/3.jpg);">
                </div>
                <div class="col-lg-5 col-md-7 bg-white">
                    <div class="p-3">
                        <img src="assets/images/big/icon.png" alt="wrapkit">
                        <h2 class="mt-3 text-center"><spring:message code="login.signUp.free"/></h2>
                        <form:form action="registerRest.do" method="post" class="mt-4" modelAttribute="userForm" id="userForm">
                        	<form:hidden path="operation" id="userForm_operation"/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
										<small id="error_nick" class="badge badge-default badge-danger form-text text-white float-right"></small>
										<form:input class="form-control" type="text" path="nick"  id="userForm_nick" placeholder="${loginNickPlaceholder}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
										<small id="error_mail" class="badge badge-default badge-danger form-text text-white float-right"></small>
										<form:input class="form-control" type="email" path="mail"  id="userForm_mail" placeholder="${loginMailPlaceholder}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
										<small id="error_pass" class="badge badge-default badge-danger form-text text-white float-right"></small>
										<form:input class="form-control" type="password" path="pass" id="userForm_pass" placeholder="${loginPasswordPlaceholder}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-block btn-dark" id="userForm_submit"><spring:message code="login.signUp"/></button>
                                </div>
                                <div class="col-lg-12 text-center mt-5">
                                    <spring:message code="login.signUp.signedUp"/> <a href="login.do" class="text-danger"><spring:message code="login.signIn"/></a>
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
    <script src="assets/libs/simple-user/register.js "></script>
    <!-- ============================================================== -->
    <!-- This page plugin js -->
    <!-- ============================================================== -->
    <script>
        $(".preloader ").fadeOut();
    </script>
