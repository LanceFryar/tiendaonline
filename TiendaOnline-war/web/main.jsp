<%-- 
    Document   : main
    Created on : 30-sep-2013, 13:37:36
    Author     : josue
--%>

<%@page import="com.tiendaonline.interfacebeans.ICatalog"%>
<%@page import="com.tiendaonline.libraries.IAlbum"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/estilo.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Online. Catálogo</title>
    </head>
    <body>
        <div class="header">
            <img src="C:/Users/Josué/Documents/NetBeansProjects/tiendaonline/TiendaOnline-war/web/images/header.jpg" height="300" width="100%" />
            <h1> Catálogo </h1>
        </div>
        <div class="carrito">
            <a href="/TiendaOnline-war/FrontController?command=Cart"><img src="C:/Users/Josué/Documents/NetBeansProjects/tiendaonline/TiendaOnline-war/web/images/carrito.png" height="100" width="100"></a>
            <br />
        </div>
        <div class="content">
            <% ICatalog catalog = (ICatalog) request.getAttribute("catalog");%>
            <% int id=1; %>
            <% IAlbum album = (IAlbum)catalog.getProduct(String.valueOf(id)); %>
            <% while (album!=null){ %>
            <% if (id%2==0) { %>
                <div class="albumi">
            <% }else { %>
                <div class="albumd">
            <% } %>
                <div class="img">
                    <img src="C:/Users/Josué/Documents/NetBeansProjects/tiendaonline/TiendaOnline-war/web<%= album.getCover() %>" height="200" width="200">
                </div>
                <b>Álbum: </b><a href="/TiendaOnline-war/FrontController?command=Album&id=<%= id %>"><%= album.getTitle() %></a><br />
                <b>Artista: </b><%= album.getAuthor() %> <br />
                <% DecimalFormat formateador = new DecimalFormat("########.##"); %>
                <b>Precio: </b><%= formateador.format(album.getPrice()) %>€<br />
                <a href="/TiendaOnline-war/FrontController?command=AddProduct&id=<%= id+1 %>&from=0">Comprar</a><br />
                <br />
            </div>
            <% id++;
            album = (IAlbum)catalog.getProduct(String.valueOf(id));
            }%>
        </div>
    </body>
</html>