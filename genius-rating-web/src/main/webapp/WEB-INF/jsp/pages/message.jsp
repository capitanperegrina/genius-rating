<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp"%>

<script>
	$(document).ready(function() {
		showModal(LARGE,
				'<c:out value="${request_messageLevel}"/>',
				'<c:out value="${request_messageTitle}"/>',
				'<c:out value="${request_messageText}"/>',
				'<c:out value="${request_urlRedirect}"/>',
				null);
			});
</script>
