<html>
  <head>
  <title>Submit Page</title>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
  </head>
    <style>
      body {
        text-align: center;
        padding: 40px 0;
        background: #EBF0F5;
        background-image:url("https://i.gifer.com/origin/1a/1af8d3b487b77085d5288814f151e1de.gif");
        background-repeat:repeat;
      }
        h1 {
          color: #88B04B;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-weight: 900;
          font-size: 40px;
          margin-bottom: 10px;
        }
        p {
          color: #404F5E;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-size:20px;
          margin: 0;
        }
      i {
        color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
      }
      .card {
        background: white;
        padding: 60px;
        border-radius: 16px;
        box-shadow: 0 10px 30px 0 rgba(172, 168, 168, 0.43);
        display: inline-block;
        margin: 0 auto;
      }
      
      .display-4{
      	color: #ff0080;
      	font-weight: bold;
      }
      
      .login-btn {
    padding: 13px 20px 12px;
    background-color: #000;
    border-radius: 4px;
    font-size: 17px;
    font-weight: bold;
    line-height: 20px;
    color: #fff;
    margin-bottom: 24px; }
    
     .login-btn:hover {
      border: 1px solid #000;
      background-color: transparent;
      color: #000; }
      
      #submit{
      	background-color:#88B04B;
      }
      
    </style>
    <body>
		<form action="/home/newClaim/sumbit/updateClaim">
      <div class="card">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
        <span style='font-size:100px; position:absolute; left:560; top:140px;'>&#128106;</span>
      </div>
        <h1>Your Claim Submitted Successfully!!!</h1> 
        <p>We received your claim request;<br/> we'll be in touch shortly!</p>
        <p align="center" class="display-4">${Message}</p>
					<p align="center" class="text-muted mb-4"></p>
        
        <br><br>
            <input type="submit" class="btn btn-block login-btn mb-4" id="submit" value="Update Claim">
      </div>
      </form>
      
    </body>
</html>