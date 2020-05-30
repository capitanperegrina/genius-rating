<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp"%>

<c:if test="${empty boats}">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		    <div class="card text-center">
		        <div class="card-body">
		            <p class="card-text"><spring:message code="boat.list.empty"/></p>
		        </div>
		    </div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</c:if>
<c:if test="${not empty boats}">
	<div class="table-responsive">
		<table id="boatListTable" class="table table-hover table-striped table-bordered table-sm mb-0">
			<thead class="bg-info text-white">
				<tr>
					<th scope="col" class="text-center">#</th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.boatName"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.shipyard"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.model"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.buildYear"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.loa"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.sNumber"/></th>
					<th scope="col" class="text-center"><spring:message code="boat.list.header.rating"/></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
<c:forEach items="${boats}" var="boat" varStatus="status">
				<tr>
					<th class="text-right" scope="row">${boat.boatId}</th>
					<td class="col-md-2">${boat.boatName}</td>
					<td class="col-md-2">${boat.shipyard}</td>
					<td class="col-md-2">${boat.model}</td>
					<td class="text-center">${boat.builtYear}</td>
					<td class="text-right">${boat.loa}</td>
					<td class="text-right">${boat.sNumber}</td>
					<td class="text-right">${boat.rating}</td>
<c:if test="${allBoats}">
					<td class="col-md-1 text-center">
</c:if>					
<c:if test="${not allBoats}">
					<td class="col-md-2 text-center">
						<button type="button" class="btn btn-outline-primary btn-rounded" title="<spring:message code="boat.list.button.edit.alt"/>"><i class="fas fa-edit"></i></button>
						<button type="button" class="btn btn-outline-primary btn-rounded" title="<spring:message code="boat.list.button.del.alt"/>"><i class="fas fa-trash-alt"></i></button>
</c:if>
						<button type="button" class="btn btn-outline-primary btn-rounded" title="<spring:message code="boat.list.button.see.alt"/>"><i class="fas fa-binoculars"></i></button>
						<button type="button" class="btn btn-outline-primary btn-rounded" title="<spring:message code="boat.list.button.pdf.alt"/>"><i class="fas fa-file-pdf"></i></button>
					</td>
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