<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Bill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.background {
  position: fixed;
  z-index: -1;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  object-fit: cover;
  height: 100%;
  width: 100%;
}


.form-card {
  border-radius: 12px;
  background: #fff;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.56s cubic-bezier(0.25, 0.8, 0.25, 1);
  max-width: 500px;
  padding: 20px;
  margin: 50px auto;
}

.form-card:hover,
.form-card:focus {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}

.form-card:focus-within {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}

.form-actions {
  position: relative;
  display: -ms-flexbox;
  display: flex;
  margin-top: 2.25rem;
}

.form-actions .form-btn-cancel {
  -ms-flex-order: -1;
  order: -1;
}

.form-actions::before {
  content: "";
  position: absolute;
  width: 100%;
  height: 1px;
  background: #999;
  opacity: 0.3;
}

.form-actions > * {
  -ms-flex: 1;
  flex: 1;
  margin-top: 0;
}

.form-fieldset {
  padding: 30px;
  border: 0;
}

.form-fieldset + .form-fieldset {
  margin-top: 15px;
}

.form-legend {
  padding: 1em 0 0;
  margin: 0 0 -0.5em;
  font-size: 1.5rem;
  text-align: center;
}

.form-legend {
  position: absolute;
  top: 95px;
  left: 490px;
}
.home-icon{
  top:10px;
  color:red;
  padding-left:900px;
  position:absolute;
    
  }
  
  .brand-wrapper {
  margin-bottom: 25px; 
  position: absolute;
  left: 525px;
  top: 20px;
  }
  p{
  text-align: center;
  
  }
  
  table{
  	border: 1.5px solid black;
  	border-collapse: collapse;
  	margin-left: auto;
  	margin-right: auto;	
  }
  
  th,td{
  padding:6px;
  	text-align: left;
  	padding-top:10px;
  	border: 1.5px solid black;
  	border-collapse: collapse;
  }

body {
  margin: 40px auto;
  background-image: linear-gradient(to top, #a3bded 0%, #6991c7 100%);
}
</style>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<!-- Taken from https://codepen.io/jonnitto/project/editor/XRPjxx -->
<video width="1280" height="720" class="background" autoplay muted loop>
  <source src="https://codepen.jonnitto.ch/BackgroundVideo.mp4" type="video/mp4">
</video>
<div class="home-icon"><a href="http://localhost:8086/home"><i class="material-icons" class="icon-size">home</i></a></div>
<form class="form-card">
    	<div class="brand-wrapper">
                <h1 style="text-align: center;"><a class="navbar-brand" style="font-style: inherit; font-size: 2rem; color:#0099cc;"><b style="font-family:arial;font-weight: bold;">  <img src="data:image/jpeg;base64,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" width="60" height="60" style="position:absolute; padding-top:15px;" ><i style="position:absolute; padding-left:60px; padding-top:30px;">My</i><b style="color: #ffcc00;position:absolute; padding-left:105px; padding-top:30px;">Claims</b></b></a></h1>
        </div>
    <fieldset class="form-fieldset">
        <legend class="form-legend"><b>Your Premium Bill Summary</b></legend><br><br><br>
      
        <table>
        <tr><p id="date">Date&Time :<script>
const d = new Date();
document.getElementById("date").innerHTML = d;
</script> </p></tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Member Id :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">${ premium.memberId }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Policy Id :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">${ premium.policyId }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Policy Name :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">${ premium.policyName }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Premium Due Amount :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">Rs. ${ premium.premiumDueAmount }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Charges :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">Rs. ${ premium.charges }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Due Date :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">${ premium.dueDate }<br><br></td>
        </tr>
        <tr>
        	<td style="color:#007399; font-size:18px; font-weight:bold;">Last Premium Paid Date :<br><br></td>
        	<td style="color:#ff0080; font-size:18px; font-weight:bold;">${ premium.premiumPaidDate }<br><br></td>
        </tr>
        
        </table>
    </fieldset>    
   
</form>
  
</body>
</html>