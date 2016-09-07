<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head lang="en">
	<title>Spring Boot Demo - FreeMarker</title>
	
	<link href="/static/css/index.css" rel="stylesheet" />
	
</head>
<body>
	<img src="/static/images/logo.png" alt="logo"/>
	<h1 id="title">${title}</h1>
	
	<c:url value="http://www.roncoo.com" var="url"/>
	<spring:url value="http://www.roncoo.com" htmlEscape="true" var="springUrl" />
	
	Spring URL: ${springUrl}
	<br>
	JSTL URL: ${url}
	
	<!-- <script type="text/javascript" src="/static/webjars/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$(function(){
			$('#title').click(function(){
				alert('点击了');
			});
		})
	</script> -->
</body>
</html>
