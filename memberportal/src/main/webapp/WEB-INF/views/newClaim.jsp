
<html>
    <head>
    
    <title>newClaim</title>
    
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>    
</head>
    <style>
        body {
  margin: auto;
  background: #eaeaea;  
  font-family: 'Open Sans', sans-serif;
}

.info p {
  text-align:center;
  color: #999;
  text-transform:none;
  font-weight:600;
  font-size:15px;
  margin-top:2px
}

.info i {
  color:#F6AA93;
}
form h1 {
  font-size: 18px;
  background: #F6AA93 none repeat scroll 0% 0%;
  color: rgb(255, 255, 255);
  padding: 22px 25px;
  border-radius: 5px 5px 0px 0px;
  margin: auto;
  text-shadow: none; 
  text-align:left
}

form {
  max-width: 700px;
  width:700%;
  margin: 5% auto;
  background-color: #FFFFFF;
  height: 103%;
  overflow: hidden;
  border: 0;
  border-radius: 27.5px;
  box-shadow: 0 10px 30px 0 rgba(172, 168, 168, 0.43);
}

p span {
  color: #F00;
}

p {
  margin: 0px;
  font-weight: 500;
  /* text-align: center; */
  line-height: 2;
  color:#333;
}

h1 {
  text-align:center; 
  color: #666;
  text-shadow: 1px 1px 0px #FFF;
  margin:50px 0px 0px 0px
}

input {
  border-radius: 0px 5px 5px 0px;
  border: 1px solid rgb(193, 250, 160);
  margin-bottom: 15px;
  width: 75%;
  height: 40px;
  float: left;
  padding: 0px 15px;
}

a {
  text-decoration:inherit
}

textarea {
  border-radius: 0px 5px 5px 0px;
  border: 1px solid #EEE;
  margin: 0;
  width: 75%;
  height: 130px; 
  float: left;
  padding: 0px 15px;
}

.form-group {
  overflow: hidden;
  clear: both;
}

.icon-case {
  width: 35px;
  float: left;
  border-radius: 15px 0px 0px 5px;
  background:#eeeeee;
  height:41px;
  position: relative;
  text-align: center;
  line-height:40px;
}

i {
  color:#555;
  margin-top: 12px;
}

.contentform {
  padding: 40px 30px;
}

.bouton-contact{
  background-color: #81BDA4;
  color: #FFF;
  text-align: center;
  width: 100%;
  border:0;
  padding: 17px 25px;
  border-radius: 0px 0px 5px 5px;
  cursor: pointer;
  margin-top: 22px;
  font-size: 18px;
}

.leftcontact {
  width:49.5%; 
  float:left;
  border-right: 1px dotted #CCC;
  box-sizing: border-box;
  padding: 0px 15px 0px 0px;
}

.rightcontact {
  width:49.5%;
  float:right;
  box-sizing: border-box;
  padding: 0px 30px 20px 15px;
}

.validation {
  display:none;
  margin: 0 0 10px;
  font-weight:400;
  font-size:13px;
  color: #DE5959;
}

#sendmessage {
  border:1px solid #fff;
  display:none;
  text-align:center;
  margin:10px 0;
  font-weight:600;
  margin-bottom:30px;
  background-color: #EBF6E0;
  color: #5F9025;
  border: 1px solid #B3DC82;
  padding: 13px 40px 13px 18px;
  border-radius: 3px;
  box-shadow: 0px 1px 1px 0px rgba(0, 0, 0, 0.03);
}

#sendmessage.show,.show  {
  display:block;
}

#hospital{
  padding-right: 10px;
  position: absolute;
  left: 530px;
}

#home{
  position: absolute;
  left: 950px;
  top: 85px;
}

</style>
<body>
<h3 align="center" class="display-4">${Message}</h3>
					<p align="center" class="text-muted mb-4"></p>
            
  <form action="/home/newClaim/submit"  method="POST">
    <h1><center>Claim Submission</center><a href="http://localhost:8086/home"><i class="fa fa-home" id="home"></i></a></span></h1>
      
    <div class="contentform">

      <div class="leftcontact">
            <div class="form-group">
              <p>Policy ID</p>
              <span class="icon-case"><i class="fa fa-key"></i></span>
                <input type="text" name="policyId" id="policyId" data-rule="required" />
                <div class="validation"></div>
       </div> 

            <div class="form-group">
            <p>Member ID  </p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
            <input type="text" name="memberId" id="memberId" data-rule="required" />
                <div class="validation"></div>
      </div>
      
      <div class="form-group">
      <p>Claim Status </p>
      <span class="icon-case"><i class="fa fa-stream"></i></span>
        <input type="text" name="claimstatus" id="claimstatus" data-rule="required" />
                <div class="validation"></div>
      </div>
      
      <div class="form-group">
      <p>Claim Date </p>
      <span class="icon-case"><i class="fa fa-calendar-day"></i></span>
        <input type="text" name="claimeddate" id="claimeddate" data-rule="required" />
                <div class="validation"></div>
      </div>
        
  </div>

  <div class="rightcontact">  

      <div class="form-group">
      <p>Claim Amount </p>
      <span class="icon-case"><i class="fa fa-money"></i></span>
        <input type="text" name="claimedamount" id="claimedamount" data-rule="required" />
                <div class="validation"></div>
      </div>  

      <div class="form-group">
      <p>Hospital Name</p>  
      <span class="icon-case"><i class="fa fa-plus-square"></i></span>
        <input type="text" name="hospitalName" id="hospitalName" data-rule="maxlen:10"data-rule="required" />
                <div class="validation"></div>
      </div>
      
      <div class="form-group">
      <p>Claimed Benefit</p>  
      <span class="icon-case"><i class="fa fa-gifts"></i></span>
        <input type="text" name="claimedbenefit" id="claimedbenefit" data-rule="maxlen:10"data-rule="required" />
                <div class="validation"></div>
      </div>

	 <div class="form-group">
      <p>Remarks</p>  
      <span class="icon-case"><i class="fa fa-pen-square"></i></span>
        <input type="text" name="remarks" id="remarks" data-rule="maxlen:10"data-rule="required" />
                <div class="validation"></div>
      </div>
	 
 
  </div>
  <button type="submit" class="bouton-contact">Submit Claim</button>

  </div>

  
</form> 

  
</body>
</html>