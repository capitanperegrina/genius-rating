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
	
    <script src="assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- apps -->
    <!-- apps -->
    <script src="dist/js/app-style-switcher.js"></script>
    <script src="dist/js/feather.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <!-- themejs -->
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>	
