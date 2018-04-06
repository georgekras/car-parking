<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>

<br>
<div class="container">
	<div class="row">
		<div class=col-md-3>Brand</div>
		<div class=col-md-2>Model</div>
	</div>
</div>
<br>
<form class="form-horizontal" action="FrontController?action=create_car" method=POST>
	<div class="row">
		<div class=col-md-1 hidden=true>
			<input id="ID" class="form-control input-md" name="ID" value="0" />
		</div>
		<div class=col-md-3>
			<input id="Brand" class="form-control input-md" name="Brand" />
		</div>
		<div class=col-md-2>
			<input id="Model" class="form-control input-md" name="Model" />
		</div>
		<button id="Create" value="Create" name="Create"
			class="btn btn-success">Create</button>
	</div>
</form>

<%@ include file="/include/end-html.jsp"%>