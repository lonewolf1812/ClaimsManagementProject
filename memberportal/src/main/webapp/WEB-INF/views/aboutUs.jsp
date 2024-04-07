
<!DOCTYPE html>
<html>
<head>
<title>About Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}
.home-icon{
color:black;
padding-left:1150px;
}
.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		
</head>
<body>

<div class="about-section">
   <div class="home-icon"><a href="http://localhost:8086/home"><i class="material-icons" class="icon-size">home</i></a></div>
  <h1>About Us</h1>
  <p>MyClaims Insurance is a specialized health insurer offering products in the retail segment for Health Insurance, Top-up Coverage, Personal Accident, Maternity, International Travel Insurance and Critical Illness along with Group Health Insurance and Group Personal Accident Insurance for Corporates, Micro Insurance Products for the Rural Market and a Comprehensive Set of Wellness Services. With its operating philosophy being based on the principal tenet of consumer-centricity, the company has consistently invested in the effective application of technology to deliver excellence in customer servicing, product innovation and value-for-money services.</p>
  <p>MyClaims Insurance has been adjudged the as the Best Health Insurance Company once at the ABP News-BFSI Awards 2015 and again at the Emerging Asia Insurance Awards, 2019 & Best Claims Service Provider of the Year and Insurance India Summit & Awards 2018. MyClaims Insurance has also received the Editors Choice Award for Best Product Innovation at Finnoviti in 2013 and was conferred the Best Medical/Health Insurance Product Award at the FICCI Healthcare Excellence Awards in 2015, 2018 and 2019.</p>
</div>

<h2 style="text-align:center;color:purple;" >Our Team</h2>
<div class="row">
  
  <div class="column" style="left:417px; position:absolute; top:750px">
    <div class="card">
      <div class="container">
        <h2>Sudarshan Senthilkumar</h2>
        <p class="title">Team Member</p>
        <p style="color:magenta;"> "The roots below the earth claim no rewards for making the branches fruitful."</p>
        <p>Sudarshan Senthilkumar@gmail.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  
</div>

</body>
</html>
