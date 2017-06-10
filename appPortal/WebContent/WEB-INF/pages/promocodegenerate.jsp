<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<htaml>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>:: APP ::</title>
	
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/datatables.min.css" />" />
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/css/styles.css" />" />

	<script type="text/javascript"	src="<c:url value="/resources/js/jquery.js" />" /></script>
	<script type="text/javascript"	src="<c:url value="/resources/js/bootstrap.min.js" />" /></script>
	<script type="text/javascript"	src="<c:url value="/resources/js/datatables.min.js" />" /></script>
   <script type="text/javascript"	src="<c:url value="/resources/js/jquery.query-2.1.7.js" />" /></script>

    <script type="text/javascript" charset="utf-8">
        $(document).ready(function() {
            $('#productTable').DataTable();
			$('.dropdown-toggle').dropdown()
        } );
    </script>
    
    
</head>
	<%-- <%
	
	HttpSession sessionObj = request.getSession();
	 if (sessionObj == null || sessionObj.getAttribute("username") == null) {
	        // Forward the control to login.jsp if authentication fails or session expires
	        //request.getRequestDispatcher("/index.jsp").forward(request,           response);
	        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request,response);
	 }
	%>	 --%>

		<script type="text/javascript">
			$(document).ready(function() {
		
				$("#campId").focus();
				$("#campId").change(function(e) {
					$("#campError").hide();
					var username = $('#campId').val();
					var postData = $(this).serialize();
					//var formURL = $(this).attr("action");
					$.ajax({
						url : "getPromoDetails?count=" + username,
						type : "POST",
						contentType : 'application/json',
						//data : postData,
						dataType : 'json',
						success : function(data, textStatus, jqXHR) {
							if (data == "User not found") {
								//$("#welcometext").val(data);
							} else {
								$("#keyCode").val(data.keyCode);
								$("#shortCode").val(data.shortCode);
								//	alert(data.productRes);
								//	$("#productIdInfo").append(data.productRes);
		
							}
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log("Something really bad happened " + textStatus);
							alert("Error" + textStatus + " " + jqXHR.responseText);
		
						}
					});
					e.preventDefault(); //STOP default action
					e.unbind(); //unbind. to stop multiple form submit.
				});
			});
		</script>
		
<script type="text/javascript">
$(document).ready(function() {
	//$("#productIdInfo").focus();
	$("#productIdInfo").change(function(e) {
		var promoCodeId = $('#productIdInfo').val();
		var campId=$('#campId').val();
		var postData = $(this).serialize();
		$("#prodError").hide();
		//var formURL = $(this).attr("action");
		$.ajax({
			url : 'checkCamProductCheck?productId='+promoCodeId+'&campId='+campId,
			type : "POST",
			contentType: 'application/json',
			data : postData,
			dataType : 'html',
			success : function(data, textStatus, jqXHR) {
				
				if (data == "User not found") {
					//$("#welcometext").val(data);
				} else {
					$("#promoCodeExists").val(data);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("Something really bad happened " + textStatus);
				alert("Error" + textStatus + " " + jqXHR.responseText+"ERROR:>>>>>"+errorThrown);
				
			}
		});
		e.preventDefault(); //STOP default action
		e.unbind(); //unbind. to stop multiple form submit.
	});
});


</script>
  <!-- <style>
      .error{
      	color: red;
      	margin: 10px 0;
      }
      </style>
  -->

<script>
	$(document).ready(
			function() {
				/* $("#username").focus(); */
				$("#generateId").click(
						function() {
							var campSelectId=$('#campId').val();
							
							if(campSelectId=='default'){
								$("#campId").focus();
								$("#campError").html("Please choose Campaign Name");
							    //alert('Please choose Campaign Name');
							    return false;
							}
							var productIdInfo=$('#productIdInfo').val();
							if(productIdInfo=='default'){
								$("#productIdInfo").focus();
							    //alert('Please  choose Product');
							    $("#prodError").html("Please  choose Product");
							    return false;
							}
							
							var noOfPromocods=$('#inputNo').val();
							
							if(!noOfPromocods.match(/^\d+$/)) {
/* 								alert("Please Enter the Number of Promocodes");
 */								$("#errorMsg").html("Please Enter the Number of Promocodes");
								$("#inputNo").focus();
								//$("#prodError").html("Please Enter the Number of Promocodes");
								return false;
							}
							if(noOfPromocods==0){
								 //alert("Please Enter atleast one Promocode");
									$("#errorMsg").html("Please Enter atleast one Promocode");
								$("#inputNo").focus();
								return false;
							}
						/* 	if(noOfPromocods>1000000){
								$("#errorMsg").html("Please enter No:of Promocodes less than or equal to 1000000");
								 //alert("Please enter No:of Promocodes less than or equal to 1000000"); 
								//$("#errorMsg").val("Please enter No:of Promocodes less than or equal to 1000000");
								$("#inputNo").focus();
								return false;
							} */
							
							//$("#loader").show();
			});
			});
</script>

<SCRIPT language=Javascript>
    	     
    	       function isNumberKey(evt)
    	       {
    	          var charCode = (evt.which) ? evt.which : evt.keyCode;
    	          if (charCode != 46 && charCode > 31 
    	            && (charCode < 48 || charCode > 57))
    	             return false;

    	          return true;
    	       }
    	      
    	    </SCRIPT>
    	    
    <script type="text/javascript">
function resetAllInputStyles()
{
 
 $('#campId').prop('selectedIndex',0);
 $('#keyCode').prop('selectedIndex',0);
 $('#productIdInfo').prop('selectedIndex',0);
 $("#campError").html("");
 $("#prodError").html("");
 $("#errorMsg").html("");
 
}

</script>	    
    	    
</script>
    <style>
      	.mandatory{
      		color:red;
      		font-size: 14px;
      		position: relative;
      		top: -3px;
      	}
      </style>
      <style>
      .error{
        
      	color: red;
      	margin: 10px 0;
      	margin-left:300px;
      }
      </style>


<script type="text/javascript">
	$(document).ready(function() {
		$("#btn-cancel").click(function() {
			//$("#successMessage").css('display','none');
			$("#successMessage").hide();
			//$("#username").html("gfhgfg");
			$('#generateForm').get(0).reset();
			$("#campId").focus();
		});
	});
</script>
 <body>
  <%-- <div id="loader"><img src="<c:url value="/resources/images/ajax-loader.gif"/>"/></div> --%>

<section>
<!-- Header Start -->
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="header-container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            	<%-- <script type="text/javascript"	src="<c:url value="/resources/js/jquery.js" />" /></script> --%>
          <img src="<c:url value="/resources/images/APP.svg"/>" height='50' width='100'/>
        </div>
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
          <ul class="nav navbar-nav">
            <li><a href="partnerList">Partner List</a></li>
            <li><a href="productList">Products List</a></li>
            <li><a href="campaignList">Campaign List</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PROMO Generator <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <!-- <li><a href="importpromocode.html">Import Promo Code</a></li> -->
                <!-- <li><a href="importPromoCode">Import Promo Code</a></li> -->
                <li><a href="promoCodeGenerationList">Promo Code Generator</a></li>
                <li><a href="https://dscsm.APP.com.my/csm/">CSM-Promo Code Details</a></li>
                <li><a href="https://dscsm.APP.com.my/csm/">CSM-Subscriber Redemption</a></li>
              </ul>
            </li>
            
          
<!--                <li class="dropdown">
             <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PROMO Generator <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="importGameCode">GameCode Importer</a></li>
                </ul>
             </li>
 -->          
             <li class="dropdown">
             <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">GameCode Importer <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="importGameCode">GameCode Importer</a></li>
                </ul>
             </li>
          
          </ul> 
          <ul class="nav navbar-nav navbar-right">
            
            <%-- <li><a href="../navbar-static-top/">Logged In <%=session.getAttribute("loggedUser") %></a></li> --%>
            <li class="active"><a href="#">Logged In <%=session.getAttribute("username") %></a></li>
            <li class="active"><a href="logout">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<!-- Header End -->	
<div class="container body-container">
	<div class="row">
		<div class="col-md-12">
        	<h1>Promo Code Generator</h1>
    	</div>
    </div>
   
    <div class="row" style="margin-top: 15px;">
    	<div class="col-md-8">
        
        	<form class="form-horizontal" action="promoCodeGeneration" method="post" id="generateForm"  name="generateForm">

						<div id="successMessage"
							style="color: #6edc00; text-align: center;">
							<%
								if (request.getAttribute("successMessage") != null) {
							%>
							<%=request.getAttribute("successMessage")%>
							<%
								}
							%>
						</div>
						<div class="form-group">
            <label for="inputEmail" class="control-label col-xs-3">Campaign Name<span class="mandatory">*</span></label>
            <div class="col-xs-9">
								<select class="form-control" id="campId" 		name="Compaign">
									<option selected="" value="default">-----Select Campaign Name-----</option>
									<c:forEach items="${listOfCampaigns}" var="element">
										<option  value="${element.campaignId}">
											<c:out value="${element.campaignName}" /></option>
									</c:forEach>
								</select>
         <div class="error" id="campError"></div>

							</div>

        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-3">Campaign Key Code</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="keyCode" name="keyCodeName" readonly  placeholder="Campign Key Code">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-3">Campaign Short Code</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="shortCode" placeholder="Campign Short Code" readonly  name="shortCodeName">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-3">Product<span class="mandatory">*</span></label>
            <div class="col-xs-9">
              <!-- <div id="productIdInfo"></div>    -->
								<select class="form-control" id="productIdInfo"
									name="productId">
											<option selected="" value="default">-----Select Product-----</option>
									<c:forEach items="${fullList}" var="element">
										<option  value="${element.productId}">
											<c:out value="${element.productName}" /></option>
									</c:forEach>
								</select>
	     <div class="error" id="prodError"></div>
							</div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-3">Promo codes Exists(Count)</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="promoCodeExists" name="promoExists"   readonly  placeholder="Promo codes Exists(Count)">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-3">No:of PromoCodes<span class="mandatory">*</span></label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="inputNo" name="inputNo" placeholder="No:of PromoCodes" onkeypress="return isNumberKey(event)"> <div class="error" id="errorMsg"></div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <button type="submit" class="btn btn-primary" id="generateId">Generate</button>
                <input id="btn-cancel" type="button" class="btn btn-danger"  value="Reset" onclick="resetAllInputStyles()">
            </div>
        </div>

					</form>
        
        </div>
    </div>
    
</div>
</section>
<!-- Footer Start -->
<div class="footer">
  <div class="container">
		<h6>Copyright Â© 2017 APP . All rights reserved.</h6>
  </div>
</div>
<!-- Footer End -->
</body>
</html>
