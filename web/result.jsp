<%-- 
    Document   : result
    Created on : 6 Νοε 2020, 4:32:22 μ.μ.
    Author     : makri
--%>

<%@page import ="java.io.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta lang="en">
	<meta name="description" content="The page of the product you registered">
	<meta name="author" content="Makris Charalampos">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Your Product's Page !</h1>
        
        <p>
            <% 
                String barcode = (String)(request.getAttribute("barcode"));
                out.print(barcode);
                
                %>    
        </p><br>
        <p>
            <%
                            String name = (String)request.getAttribute("name");
                            out.print(name);
                        %>
        </p><br>
        <p>
            <%
                            String color = (String)request.getAttribute("color");
                            out.print(color);
                        %>
        </p><br>
        <p>
            <%
                            String description = (String)request.getAttribute("description");
                            out.print(description);
                        %>
        </p><br>
        
    </body>
</html>
