<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Monitoring</title>
<script>  
var request;  
function sendInfo()  
{    
var url="test";  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try  
{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}  
catch(e)  
{  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('note').innerHTML=val;  
}  
}  
  
</script>  
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $("button[name='dir']").click(function(){
		  alert("clicked");
		  
	    $.ajax({
	    	url: "test",
	    	type: "GET",
	    	success: function(result){
	      $("#note").val(result);
	    }});
	  });
	});
</script>

            <button name="dir">Directory</button>
            <button name="ping">Ping www.google.com</button>
<textarea id='note' name='workItemVO.note'> </textarea>        



</html>






