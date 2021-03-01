<%-- 
    Document   : listaClientes
    Created on : 20/02/2021, 19:15:10
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
        <title>Clientes</title>
    </head>
    <body>
        <h1>Lista de clientes:</h1>
        <table border= "1" width= "50%">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Mail</th>
                    <th colspan='2'>Acción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var='clienteTemp' items='${clientes}'>
                    <c:url var="urlActualizar" value="/cliente/actualizaCliente">
                        <c:param name="idCliente" value="${clienteTemp.id}"/>
                    </c:url>
                    <c:url var="urlEliminar" value="/cliente/eliminaCliente">
                        <c:param name="idCliente" value="${clienteTemp.id}"/>
                    </c:url>
                    <tr>
                        <td>${clienteTemp.id}</td>
                        <td>${clienteTemp.nombre}</td>
                        <td>${clienteTemp.apellido}</td>
                        <td>${clienteTemp.email}</td>
                        <td>
                            <a href="${urlActualizar}">Actualizar</a>
                        </td>
                        <td>
                            <a href="${urlEliminar}" onclick="if (!(confirm('Seguro quiere eliminar el cliente?'))) return false;">Eliminar</a>
                        </td>
                    </tr>   
                </c:forEach>
            </tbody> 
        </table><br/>
        <button type="button" onclick="window.location.href='agregaCliente'; return false;">AGREGAR CLIENTE</button>
    </body>
</html>
