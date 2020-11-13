<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usu�rios do Sistema</title>
</head>
<body>
    <jsp:useBean id="dao" class="br.com.java.dao.UsuarioDAO"/>
     <h1> Lista de Usu�rios do Sistema</h1>
  <table border="1">
  
        <tr>
            
            <th> Nome </th>
            <th> Endere�o</th>
 
        </tr>
    <c:forEach var="usuario" items="${dao.lista}">
    
      
      <tr>
        <td>${usuario.nome}</td>
        <td>${usuario.endereco}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>