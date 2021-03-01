<%-- 
    Document   : agregaCliente
    Created on : 21/02/2021, 16:05:02
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
        <title>Agregar</title>
    </head>
    <body>
        <br/>
        <h2>Agrega o modifica un cliente:</h2>
        <br/>
        <form:form action="procesaCliente" modelAttribute="cliente">
            <form:hidden path="id"/>
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><form:input path="nombre" placeholder="Juan"/></td>  
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><form:input path="apellido" placeholder="Perez"/></td>  
                </tr>
                <tr>
                    <td>Email @:</td>
                    <td><form:input path="email" placeholder="juanperez@gmail.com"/></td>  
                </tr>
            </table>
            <br/>
            <button type="submit">GUARDAR</button>
        </form:form>
    </body>
</html>
