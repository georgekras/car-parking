<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp" %>

<title>User main page</title>
<body>
<br>
HELLO USER!
<br>
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
		<c:forEach items="${cars}" var="car">
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
				<br>
			</div>
			<br>
		</c:forEach>
	</div>
</body>
</html>
<%@ include file="/include/end-html.jsp" %>