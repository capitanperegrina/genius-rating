<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp"%>

<c:if test="${empty boats}">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		    <div class="card text-center">
		        <div class="card-body">
		            <p class="card-text">No boats found</p>
		        </div>
		    </div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</c:if>
<c:if test="${not empty boats}">
	<div class="table-responsive">
		<table id="boatListTable" class="table table-hover table-info">
			<thead class="bg-info text-white">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Shipyard</th>
					<th scope="col">Model</th>
					<th scope="col">Built Year</th>
					<th scope="col">LOA</th>
					<th scope="col">#S</th>
					<th scope="col">Rating</th>
				</tr>
			</thead>
			<tbody>
<c:forEach items="${boats}" var="boat" varStatus="status">
				<tr>
					<td>${boat.boatName}</td>
					<td>${boat.shipyard}</td>
					<td>${boat.model}</td>
					<td>${boat.builtYear}</td>
					<td>${boat.loa}</td>
					<td>${boat.sNumber}</td>
					<td>${boat.rating}</td>
				</tr>
</c:forEach>			
			</tbody>
		</table>
	</div>
</c:if>

    <script src="assets/extra-libs/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="assets/libs/genius-rating/boatList.js "></script>

    <script>
    	boatTableSetup("<c:out value='${request_simpleUserManagementLang}'/>");
    </script>