<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>BIENVENIDO ! - LOS SSL</title>

<link th:href="@{/css/bootstrap.css}" rel="stylesheet"  href="../css/bootstrap.css"/>
<link  rel="stylesheet"  href="../css/style.css">  
<link rel="shortcut icon" href="../img/tab.png"> 
<script th:src="@{/js/jquery.js}" src="../js/jquery.js"></script> 
<script th:src="@{/js/bootstrap.js}" src="../js/bootstrap.js"></script>
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
    
body {
  background-color: #B6FED2;
}

</style>
</head>


<body>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-secondary">
  <span class="navbar-brand"><img src="../img/logo.png"></span>
</nav>
<div class="container">
<div class="raw">
<div class="col-12">

<div class="mx-auto" style="width: 160px;">
<br/>
<h1>LOGIN</h1>
<br/>
</div>




<form method="post" action="login" >
  <div class="form-group">
    <label >NOMBRE DE USUARIO</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
   
  </div>
  <div class="form-group">
    <label >PASSWORD</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>
  <c:if test="${param.error != null}">
       <div class="alert alert-danger" role="alert">
  ERROR ! Nombre de usuario o contraseña incorrecta. Vuelva a intentarlo
	   </div>
</c:if>

<c:if test="${param.logout != null}">
<div class="alert alert-warning" role="alert">
  GRACIAS POR SU VISITA, HASTA PRONTO ! Recuerda visitar a <a href="https://github.com/equipossl" class="alert-link">LOS SSL</a>
</div>
</c:if>
  <button type="submit" class="btn btn-secondary">VALIDAR</button>
</form>



</div>
</div>
</div>

<br>
<br>
<br>


	<footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>About</h6>
            <p class="text-justify">Los SSL - <i>Prueba Módulo 5</i><p>Se solicita como parte de esta evaluación entregar el sistema el 100% como se ha pedido de
manera incremental hasta la clase anterior.
Consideraciones y requisitos.
1. Controlando el acceso al consumo de una API REST implementando seguridad
mediante JWT. 
2. Codifica una API REST utilizando Spring MVC para exponer recursos y
operaciones que dan solución a una problemática dada.
3. Los CRUD del sistema deben ser homologados a un API REST
GET (Leer y consultar los registros)
POST (Crear nuevos registros)
PUT (Editar y modificar los registros)
DELETE (Eliminar los registros).
4. Generar una pieza de software que consume un servicio REST utilizando Spring
MVC, la cual consuma la API REST creada y despliegue los distintos resultados
según solicitud del usuario; dicha pieza de software no es necesario que tenga
perfiles u otros, pero si debe poder realizar todas las acciones (Get, Post, Put,
Delete) bajo seguridad JWT.</p>
          </div>

               <div class="col-xs-6 col-md-3">
            <h6>Link al repositorio</h6>
            <ul class="footer-links">
              <li><a href="https://github.com/equipossl/Modulo5" target="_blank"><img src="../img/github2.png"></a></li><br>
              <li><b>DATOS DE ACCESO</b></li><hr>
              <li>usuario cliente: 123</li>
              <li>contraseña cliente: 123</li>
              <li>usuario administrador: 1234</li>
              <li>contraseña administrador: 1234</li>
              <li>usuario cliente: 12345</li>
              <li>contraseña cliente: 12345</li>
            </ul>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright 2020 · All Rights Reserved by 
         <a href="https://github.com/equipossl" target="_blank">Los SSL</a>.
            </p>
          </div>
      </div>
      </div>
</footer>

</body>
</html>