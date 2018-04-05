<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Edit Cars</title>
</head>
<body>
	<div class="container">
		<b>
			<div class="row">
				<div class=col-md-3>ID</div>
				<div class=col-md-3>Brand</div>
				<div class=col-md-3>Model</div>
			</div>
		</b>
	</div>
	<br>
	<div class="container">
		<c:forEach items="${car}" var="car">
			<div class="row">
				<div class=col-md-3>
					<input id="ID" class="form-control input-md" name="ID"
						value="${car.id}" />
				</div>
				<div class=col-md-3>
					<input id="brand" class="form-control input-md" name="Brand"
						value="${car.brand}" />
				</div>
				<div class=col-md-3>
					<input id="model" class="form-control input-md" name="Model"
						value="${car.model}" />
				</div>
				<div class=col-md-3>
					<a href="do?delete=${car.id}">Delete</a>
				</div>
				<br>
			</div>
			<br>
		</c:forEach>
	</div>
	
	<br>

	<form class="form-horizontal" action="./do?action=create" method=POST>
		<h2>Add car</h2>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Brand">Brand</label>
			<div class="col-md-4">
				<input id="Brand" name="Brand" type="text"
					class="form-control input-md">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Model">Model</label>
			<div class="col-md-4">
				<input id="Model" name="Model" type="text"
					class="form-control input-md">
			</div>
		</div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-danger">Add</button>
            </div>
        </div>
	</form>


	<form class="form-horizontal" action="./do?action=update" method=POST>
		<h2>Update car</h2>
		<div class="form-group">
			<label class="col-md-4 control-label" for="ID">ID</label>
			<div class="col-md-4">
				<input id="ID" name="ID" type="text"
					class="form-control input-md">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Brand">Brand</label>
			<div class="col-md-4">
				<input id="Brand" name="Brand" type="text"
					class="form-control input-md">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Model">Model</label>
			<div class="col-md-4">
				<input id="Model" name="Model" type="text"
					class="form-control input-md">
			</div>
		</div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-danger">Update</button>
            </div>
        </div>
	</form>
</body>
</html>