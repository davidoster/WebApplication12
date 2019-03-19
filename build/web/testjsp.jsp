<%-- 
    Document   : testjsp
    Created on : Mar 19, 2019, 1:27:19 PM
    Author     : George.Pasparakis
--%>

<%@page import="java.util.logging.Level"%>
<%@page import="controllers.HelloWorld"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="database.Database"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello from testjsp.jsp</h1>
        <% out.print("Hello again"); %>
        <p><%= 5 + 5 %></p>
        <p><%= "5 + 5" %></p>
        <%= "Hello again again" %>
        <% 
           String a = "hello";
           int i = 20;
           List<String> aListofStrings = new ArrayList<>();
           aListofStrings.add(a);
           aListofStrings.add("sdfsdf");
           aListofStrings.add(new String("adfdsfsdfsdr3r"));
           out.print(a + " " + i + "<br />");
           for (String elem : aListofStrings) {
                   out.print(elem);
                   out.print("<br />");
           }
           String server = "ra1.anystream.eu:1011";
           String username = "mydb";
           String password = "mydb";
           String database = "mydb";
           String query = "SELECT * FROM `mydb`.`Employee`;";
           Database db = new Database();
           ResultSet rs = db.Database(server, database, username, password, query);
            try {
                while(rs.next()) {
                    out.println(rs.getString(1) + "&nbsp;" + rs.getString(2) + "&nbsp;" + rs.getString(3) + 
                                                  "&nbsp;" + rs.getString(4) + "<br />");
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
            }
        %>
    </body>
</html>
