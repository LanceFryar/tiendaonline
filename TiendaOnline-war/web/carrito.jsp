<%-- 
    Document   : carrito
    Created on : 09-oct-2013, 20:04:34
    Author     : Rayco
--%>

<%@page import="com.tiendaonline.model.User"%>
<%@page import="com.tiendaonline.interfacebeans.ICart"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tiendaonline.libraries.IProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
    <body>
        <div class="header">
            <img src="images/header.jpg" width="100%" height="300" alt="header">
            <h1>Carrito</h1>
        </div>
        <% User user = (User) request.getAttribute("user");%>
        <div class="sessionMenu">
            <p><%= user.getName() %> <a href="/TiendaOnline-war/FrontController?command=Logout">Logout</a></p>
        </div>
        <% ICart cart = (ICart) request.getAttribute("cart"); %>
        <% float bill = 0; %>
            <% DecimalFormat formateador = new DecimalFormat("########.##"); %>
            <% for (IProduct product : cart.getCart()) { %>
                <% bill += product.getPrice(); %>
                <a href="/TiendaOnline-war/FrontController?command=RemoveProduct&id=<%= product.getId() %>">Eliminar</a>
                <p> -> <%= product.getTitle() %>, <%= product.getAuthor() %>: <%= product.getPrice() %> €</p>
                <br />
                <br />
            <% } %>
            <p> Total:  <%= formateador.format(bill) %></p>
            <button type="button"
                    onclick= "location.href = '/TiendaOnline-war/FrontController?command=Buy'">
                Confirmar Pedido
            </button>
    </body>
</html>
