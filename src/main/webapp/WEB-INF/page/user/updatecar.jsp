<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>

<br>
<b>
<div class="container">
	<div class="row">
		<div class=col-md-1>ID</div>
		<div class=col-md-3>Brand</div>
		<div class=col-md-2>Model</div>
	</div>
</div>
</b>

<br>
<div class="container">
	<c:forEach items="${cars}" var="car">
		<form class="form-horizontal${car.id}"
			action="FrontController?action=update_car" method=POST>
			<div class="row">
				<div class=col-md-2>
					<input id="ID" class="form-control input-md" name="ID"
						value="${car.id}" />
				</div>
				<div class=col-md-3>
					<input id="Brand" class="form-control input-md" name="Brand"
						value="${car.brand}" />
				</div>
				<div class=col-md-2>
					<input id="Model" class="form-control input-md" name="Model"
						value="${car.model}" />
				</div>

				<button id="Update" value="Update" name="Update"
					class="btn btn-success">Update</button>
			</div>
		</form>
		<br>
	</c:forEach>
</div>

<%@ include file="/include/end-html.jsp"%>