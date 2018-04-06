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
		<form class="form-horizontal"
			action="FrontController?id=${car.id}&action=delete_car" method=POST>
			<div class="row">
				<div class=col-md-1>${car.id}</div>
				<div class=col-md-3>${car.brand}</div>
				<div class=col-md-2>${car.model}</div>
				<button id="Delete" value="Delete" name="Delete"
					class="btn btn-danger">Delete</button>
			</div>
		</form>
		<br>
	</c:forEach>
</div>

<%@ include file="/include/end-html.jsp"%>