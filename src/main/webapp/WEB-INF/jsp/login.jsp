<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UNIDAD 5 EQUIPO SSL</title>

<link  rel="stylesheet"  href="./css/bootstrap.css"> 

<script  src="./js/jquery.js"></script> 
<script  src="./js/bootstrap.js"></script> 
<style>
    /* error div */
    div#action-error
    {
        text-align: center;
        border: 1px solid white;
        display: none;
        background-color: #a80077;
        border-radius: 15px;
    }

    /* success div */
    div#action-logout
    {
        text-align: center;
        border: 1px solid white;
        display: none;
        background-color: #5a8e4a;
        border-radius: 15px;
    }

</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <span class="navbar-brand" >LOS SSL</span>
    
</nav>

<div class="container">
<div class="raw">
<div class="col-12">

<div class="mx-auto" style="width: 200px;">
<br/>
<h1>LOGIN</h1>
<br/>
</div>
<c:if test="${param.error != null}">
       <h4 style="color:#ff0000">ERROR: nombre de usuario o password incorrecto</h4>
      </c:if>
      <c:if test="${param.logout != null}">
       <h4 style="font-weight:800; color:#0063C7">Hasta pronto</h4>
      </c:if>


<form method="post" action="login" >
  <div class="form-group">
    <label >NOMBRE DE USUARIO</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
   
  </div>
  <div class="form-group">
    <label >PASSWORD</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>
  
  <button type="submit" class="btn btn-primary">VALIDAR</button>
</form>



</div>
</div>


          </div>
<div class="mx-auto" style="width: 300px;">
<br/>
<h2>EQUIPO LOS SSL</h2>
<br/>
</div>


</body>
</html>