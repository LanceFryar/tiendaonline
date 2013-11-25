<%-- 
    Document   : album
    Created on : 07-oct-2013, 12:42:55
    Author     : josue
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tiendaonline.libraries.ISong"%>
<%@page import="com.tiendaonline.libraries.IAlbum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/estilo.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Online</title>
    </head>
    <body>
        <% IAlbum album = (IAlbum) request.getAttribute("album"); %>
        <% DecimalFormat formateador = new DecimalFormat("########.##"); %>
        <div class="header" style="text-align: center">
            <img src="/images/header.jpg" width="100%" height="300" alt="header"/>
            <h1> <%= album.getTitle() %> - <%= album.getAuthor() %></h1>
        </div>
        <div class="">
            <div class="albumimg">
                <img src="<%= album.getCover() %>" width="400" height="400">
                <p> Precio total: <%= formateador.format(album.getPrice()) %> </p>
                <a href="/TiendaOnline-war/FrontController?command=AddProduct&id=<%= album.getId() %>&from=<%= album.getId() %>">Comprar álbum</a>
            </div>
            <% int track = 1; %>
            <% ISong song = album.getSong(track); %>
            <% while (song != null){ %>
                <%= song.getPosition() %>. <%=song.getTitle() %> - 
                <%= song.getMinutes() %>:
                <% if (song.getSeconds()<10){ %> 0 <%}%>
                <%=song.getSeconds()%>
                <br />
                <%= formateador.format(song.getPrice()) %>€ <a href="/TiendaOnline-war/FrontController?command=AddProduct&id=<%= song.getId() %>&from=<%= album.getId() %>">Comprar</a>
                <br />
                <br />
            <%
                track++;
                song = album.getSong(track);
            }%>
        </div>
        
    </body>
</html>