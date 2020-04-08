

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
fieldset {
	border: 2px solid gray;
	margin: 5px;
	padding: 15px;
}

legend {
	width: auto;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<form action="add" method="get" >
			
			<fieldset>
				<legend>ADD NEW TODO ITEM</legend>
				<div class="form-group">
					<input type="text" class="form-control" name="todo"
						placeholder="ENTER IT" required="required">
				</div>
				
				<input type="submit" value="ADD"
					class="btn btn-primary form-control">
			</fieldset>
		</form>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th>TODO</th>
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="entry" items="${item}">
                    <tr><input type="hidden" name="id" value=${entry.key}  >
                        <td>${entry.value}</td>
                        <td><a href="./delete?id=${entry.key}" <span class='far fa-trash-alt' style='font-size:24px'></span></a></td>
                   </tr>
                
                </c:forEach>
                </tbody>
            </table>
		<br>
	</div>
</body>
</html>
