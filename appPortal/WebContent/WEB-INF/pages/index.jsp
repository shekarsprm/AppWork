<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>:: APP ::</title>
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/datatables.min.css" />" />
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/styles.css" />" />

	<script type="text/javascript"	src="<c:url value="/resources/js/jquery.js" />" /></script>
	<script type="text/javascript"	src="<c:url value="/resources/js/bootstrap.min.js" />" /></script>
	<script type="text/javascript"	src="<c:url value="/resources/js/datatables.min.js" />" /></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#btn-cancel").click(function() {
			$('#loginform').get(0).reset();
			$("#Username").focus();
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#btn-login").click(function() {
			$("#usernameError").html("");
			$("#passwordError").html("");
			$("#resetError").html("");
			 
			var userName = $.trim($('#Username').val());
			var password = $.trim($('#login-password').val());
			if(userName=='' || userName=='null'|| userName=='NULL'){
				//$("#Username").focus();
				
				$("#usernameError").html("Enter User Name");
				$("#usernameError").css("display","block");
			    return false;
			}
			if(password=='' || password=='null'|| password=='NULL'){
				
				//$("#login-password").focus();
				
				$("#passwordError").html("Enter Password");
				$("#passwordError").css("display","block");
			    return false;
			}
		});
	});
</script>

 
<script type="text/javascript">
function resetAllInputStyles()
{
 
	
 $("#Username").html("");
 $("#Password").html("");
 $("#errorMsg").html("");
 $("#usernameError").html("");
 $("#passwordError").html("");
 $("#resetError").html("");
}
</script>	
      
      
      
      <style>
      .error{
      	color: red;
      	margin: 10px 0;
      }
      </style>
 


<body>

<!-- Login div starts here -->
<div class="container"	>
	<div class="row">
		<div class="col-md-12">
        	<div class="card card-container">
            	<div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Login</div>
                    </div> 
                    <div style="padding-top:30px" class="panel-body">
                        <form id="loginform" class="form-horizontal" role="form" action="login"   method="post" name="loginform">
                            <div style="margin-bottom: 5px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input  class="form-control" name="Username" id="Username" value="" placeholder="User Name" type="text" />                                        
                            </div>
                            <div class="error" id="usernameError"></div>
                            <div style="margin-bottom: 5px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" class="form-control" name="Password"  placeholder="Password" type="password">
                            </div>
                            <div class="error" id="passwordError"></div><%
						if (request.getAttribute("message") != null) {
							 out.println("<div id='resetError'><font color='red'>"+request.getAttribute("message")+"</font></div>"); 
							/* $("#usernameError").html("<font color='red'>"+request.getAttribute("message")+"</font>");
							 $("#usernameError").css("display","block"); */
						}
					%> 
                            <div style="margin-top:10px" class="form-group">
                                <div class="col-sm-12 controls text-center">
                                  
                                  <input type="submit" id="btn-login" class="btn btn-primary btn-font" name="action" value="Login"/>
                                  
                                  <input id="btn-cancel" type="button" class="btn btn-danger btn-font"  value="Reset" onclick="resetAllInputStyles()">
                                  
                                </div>
                            </div><%-- <div id="notice">${message}</div> --%>
                                   
                        </form>     
			          
				 
				
                    </div>                     
                </div>
       		</div>
    	</div>
    </div>
  
	<br>
</div>
<!-- Login div ends here -->


</body>
</html>