<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Offense List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Offense List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID</th>
          <th>Model</th>
          <th>Diver Name</th>
          <th>Offense Type</th>
          <th>Fine</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${pddList}" var="pdd" >
          <tr>
             <td>${pdd.offence_id}</td>
             <td>${pdd.model}</td>
             <td>${pdd.driver_name}</td>
             <td>${pdd.offence_type}</td>
             <td>${pdd.fine}</td>
             <td>
                <a href="editPdd?code=${pdd.offence_id}">Edit</a>
             </td>
             <td>
                <a href="deletePdd?code=${pdd.offence_id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createPdd" >+ add new offense</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>