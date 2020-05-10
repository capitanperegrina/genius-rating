<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

<spring:message  code="passwordChange.old.pass.placeholder" var="oldPassPlaceholder"/>
<spring:message  code="passwordChange.new.pass.placeholder" var="newPassPlaceholder"/>

	<!-- Password change modal content -->
	<div id="changePass-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header modal-colored-header bg-primary">
	                <h4 class="modal-title" id="primary-header-modalLabel"><spring:message  code="passwordChange.title" /></h4>
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	            </div>
	            <div class="modal-body">
	                <form action="#" class="pl-3 pr-3">
	                    <div class="form-group">
	                        <label for="emailaddress1"><spring:message  code="passwordChange.old.pass" /></label>
	                        <input class="form-control" type="password" id="userForm_pass" required="" placeholder="su clave de acceso actual">
	                    </div>
	                    <div class="form-group">
	                        <label for="password1"><spring:message  code="passwordChange.new.pass" /></label>
	                        <input class="form-control" type="password" required="" id="userForm_recoverCode" placeholder="su nueva clave de acceso">
	                    </div>
	                </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-light" data-dismiss="modal"><spring:message  code="simpleUser.cancel" /></button>
	                <button type="button" class="btn btn-primary"><spring:message  code="passwordChange.button" /></button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<script src="assets/extra-libs/sparkline/sparkline.js"></script>