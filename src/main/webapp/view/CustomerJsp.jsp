<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(document).on("focusout", "#id1", function(){
		      $.ajax({
		         type:"GET",
		         url:"http://localhost:8080/CgetDetails/"+$("#id1").val(),
		         success: function(data) {
		             //Response from the controller comes here
		             var json = JSON.stringify(data);
		             //Bind it to fields like these
		             $("#name1").val(data.c_name);
		             $("#balance1").val(data.balance);
		             $("#od1").val(data.od);
		         },
		      error: function(data) {
		    	  $("#CwrongOne").show()
		    	  $("#name1").val("");
		          $("#balance1").val("");
		          $("#od1").val("");
		      }
		      })
		})
		$(document).on("focusin", "#id1", function(){
			$("#CwrongOne").hide()
		})
		
		$(document).on("focusout", "#bic1", function(){
		      $.ajax({
		         type:"GET",
		         url:"http://localhost:8080/BgetDetails/"+$("#bic1").val(),
		         success: function(data) {
		             //Response from the controller comes here
		             var json = JSON.stringify(data);
		             //Bind it to fields like these
		             $("#i_name1").val(data.name);
		         },
		      error: function(data) {
		    	  $("#BwrongOne").show()
		    	  $("#i_name1").val("");
		      }
		      })
		})
		$(document).on("focusin", "#bic1", function(){
			$("#BwrongOne").hide()
		})
	</script>
	<form>
		<table>
			<tr>
				<td>ID </td><td> <input type="text" name="id" id ="id1"></td>
				<td>Name </td><td> <input type="text"  name="name" id = "name1"> <br></td>
			</tr><tr>
				<td colspan=3> <div hidden=true id="CwrongOne" style="color:red">Customer ID is not present!</div></td>
				<td><div> &nbsp;</div></td>
			</tr><tr>
				<td>Balance </td><td> <input type="number" name="balance" id="balance1"><br></td>
				<td>OverDraft </td><td> <input type="text" name="od" id="od1"><br></td>	
			</tr>
		</table>
		
	</form>
	<hr>
	<form>
		<table>
			<tr>
				<td>BIC </td><td> <input type="text" name="bic" id ="bic1"></td>
				<td>Institution Name </td><td> <input type="text"  name="i_name" id = "i_name1"> <br></td>
			</tr><tr>
				<td colspan=3> <div hidden=true id="BwrongOne" style="color:red">Bank BIC is not present!</div></td>
				<td><div> &nbsp;</div></td>
			</tr><tr>
				<td>Account Holder Name </td><td> <input type="text" name="holderName" id="holderName1"><br></td>
				<td>Account Holder Number</td><td> <input type="text" name="holderNumber" id="holderNumber1"><br></td>	
			</tr>
		</table>
		
	</form>
</body>
</html>

