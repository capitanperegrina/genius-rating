<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

	<!-- Success Alert Modal -->
	<div id="common-alert-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog" id="common-alert-modal-size">
	    <!-- 
	    	modal-sm
	    	modal-lg 
	    -->
	        <div id="common-alert-modal-background"> 
	        <!-- 
	        	modal-content modal-filled bg-success
	        	modal-content modal-filled bg-info
	        	modal-content modal-filled bg-warning
	        	modal-content modal-filled bg-danger 
	        -->
	            <div class="modal-body p-4">
	                <div class="text-center">
	                    <i id="common-alert-modal-icon"></i>
	                    <!-- 
	                    	dripicons-checkmark h1
	                    	dripicons-information h1 text-info
	                    	dripicons-warning h1 text-warning
	                    	dripicons-wrong h1
	                     -->
	                    <h4 class="mt-2" id="modal-title"></h4>
	                    <p class="mt-3" id="modal-message"></p>
	                    <button type="button" data-dismiss="modal" id="common-alert-modal-button">Continue</button>
						<!-- 
							btn btn-light my-2
							btn btn-info my-2
							btn btn-warning my-2
							btn btn-light my-2
						-->
	                </div>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->