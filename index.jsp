<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <header>
			<div class="d-flex flex-column wrapper">
		        <nav class="navbar navbar-expand-lg navbar-dark bg-primary border-bottom shadow-sm mb-3">
		            <div class="container">
		                <a class="navbar-brand" href="index.jsp"><b>AlexSantos</b></a>
		                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		                    data-bs-target=".navbar-collapse">
		                    <span class="navbar-toggler-icon"></span>
		                </button>
		                <div class="collapse navbar-collapse">
		                    <ul class="navbar-nav flex-grow-1">
		                        <li class="nav-item">
		                            <a class="nav-link text-white" href="Cadastro.jsp">Cadastro</a>
		                        </li>
		                    </ul>
		                </div>
		            </div>
		        </nav>
		    </div>
		    
			<div class="container">
				<div class="row justify-content-center">
			      <h1 class= col-10 >Lista de veiculos cadastrados</h1>
			      <hr>
				</div>
			</div>
	    </header>
	
	    <div class="container">
	        <form action="ServletBase" method="post">
	            <button type="submit" class="btn btn-primary mb-3" name="option" value="insertForm" >Adicionar Veiculo</button>
	        </form>
	
	
	        <table class="table mt-5">
	            <thead class="thead-dark">
	                <tr>
	                    <th scope="col">Id</th>
	                    <th scope="col">Modelo</th>
	                    <th scope="col">Ano</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="user" items="${lista}">  
	                	<form action="ServletBase" method="post">           	
		                  	<tr>
		                      <input type="hidden" name="id" value="${user.id}"/>
		                      
	                           <td>${user.id} </td>
	                           <td>${user.modelo}</td>
	                           <td>${user.ano}</td>	                          
	                           <td>
	                           	<button type="submit" name="option" value="delete" class="btn-primary btn ">Remover</button>
	                           </td>
	                           
	                           <td>
	                           	<button type="submit" name="option" value="updateForm" class="btn-primary btn ">Alterar</button>
	                           </td>      
		                     </tr>
	                  	 </form> 
	               </c:forEach>        
	            </tbody>
	        </table>
	    </div>
	    
	     <div class="container">
	        <form action="ServletBase" method="post">
	            <button type="submit" class="btn btn-primary mb-3" name="option" value="insertForm1" >Ipva</button>
	        </form>
	
	
	        <table class="table mt-5">
	            <thead class="thead-dark">
	            
	                <tr>
	                    <th scope="col">Id</th>
	                    <th scope="col">Ano</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="user" items="${lista}">  
	                	<form action="ServletIpvaCarro" method="post">           	
		                  	<tr>
		                      <input type="hidden" name="id" value="${user.id}"/>
		                      
	                           <td>${user.id} </td>
	                           <td>${user.ano}</td>	                          
	                           <td>
	                          	
	                          	<button type="submit" name="option" value="updateForm1" class="btn-primary btn ">Alterar</button>
	                          
	                           </td>      
		                     </tr>
	                  	 </form> 
	               </c:forEach>        
	            </tbody>
	        </table>
	    </div>
</body>
</html>