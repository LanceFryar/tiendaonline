<%-- 
    Document   : main
    Created on : 30-sep-2013, 13:37:36
    Author     : josue
--%>

<%@page import="com.tiendaonline.model.User"%>
<%@page import="com.tiendaonline.interfacebeans.ICatalog"%>
<%@page import="com.tiendaonline.libraries.IAlbum"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Online. Catálogo</title>
    </head>
    <body>
        <% User user = (User) request.getAttribute("user");%>
        <% ICatalog catalog = (ICatalog) request.getAttribute("catalog");%>
        <div class="sessionMenu">
            <% if (user==null) { %>
            <form action="/TiendaOnline-war/FrontController?command=Login&from=0&page=<%= catalog.getPosition() %>">
                <p>Nombre: <input type="text" name="user"></p><p>Contraseña: <input type="password" name="password"></p>
                <input type="submit" name="Login">
            </form>
            <% }else { %>
            <p><%= user.getName() %> <a href="/TiendaOnline-war/FrontController?command=Logout">Logout</a></p>
            <% } %>
        </div>
        <div class="header">
            <img src="images/header.jpg" height="300" width="100%" />
            <h1> Catálogo </h1>
        </div>
        <div class="carrito">
            <a href="/TiendaOnline-war/FrontController?command=Cart"><img src="images/carrito.png" height="100" width="100"></a>
            <br />
        </div>
        <div class="content">
            <% int id=catalog.getPosition(); %>
            <% int numberOfAlbums=catalog.getNumberOfProducts(); %>
            <% IAlbum album = (IAlbum)catalog.getProduct(String.valueOf(id)); %>
            <% while ((catalog.getNumberOfProducts() > 0)||(album!=null)){ %>
            <% if (id%2==0) { %>
                <div class="albumi">
            <% }else { %>
                <div class="albumd">
            <% } %>
                <div class="img">
                    <img src="<%= album.getCover() %>" height="200" width="200">
                </div>
                <b>Álbum: </b><a href="/TiendaOnline-war/FrontController?command=Album&id=<%= id %>"><%= album.getTitle() %></a><br />
                <b>Artista: </b><%= album.getAuthor() %> <br />
                <% DecimalFormat formateador = new DecimalFormat("########.##"); %>
                <b>Precio: </b><%= formateador.format(album.getPrice()) %>€<br />
                <a href="/TiendaOnline-war/FrontController?command=AddProduct&id=<%= id+1 %>&from=0">Comprar</a><br />
                <br />
            </div>
            <% id++;
            numberOfAlbums--;
            album = (IAlbum)catalog.getProduct(String.valueOf(id));
            }%>
        </div>
        <div class="pages">
            <% if ((catalog.getPosition()-catalog.getNumberOfProducts()) > 0) { %>
            <a href="/TiendaOnline-war/FrontController?command=Main&page=<%= catalog.getPosition()-catalog.getNumberOfProducts() %>">Prev</a>
            <% }%>
            <p><%= catalog.getPosition()/catalog.getNumberOfProducts() %></p>
            <% if (catalog.getPosition()+catalog.getNumberOfProducts() < catalog.getProductCount()) { %>
            <a href="/TiendaOnline-war/FrontController?command=Main&page=<%= catalog.getPosition()+1 %>">Next</a>
            <% }%>
            <form action="/TiendaOnline-war/FrontController?command=Main">
                <select name="page">
                    <option value="0" selected>Ir a la página deseada</option>
                    <% int pageNumber = 1; %>
                    <% while (((pageNumber-1)*catalog.getNumberOfProducts())+1 < catalog.getProductCount()) { %>
                    <option value="<%= page %>"><%= page %></option>
                    <% pageNumber++;
                        } %>
                </select>
                <input type="submit" value="Ir">
            </form>
        </div>
    </body>
</html>