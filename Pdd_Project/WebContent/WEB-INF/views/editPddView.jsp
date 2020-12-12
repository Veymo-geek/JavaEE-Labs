<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Offense</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Offense</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty pdd}">
         <form method="POST" action="${pageContext.request.contextPath}/editPdd">
            <input type="hidden" name="offense_id" value="${pdd.offense_id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${pdd.offense_id}</td>
               </tr>
               <tr>
                  <td>Model</td>
                  <td><input type="text" name="model" value="${pdd.model}" /></td>
               </tr>
               <tr>
                  <td>Driver Name</td>
                  <td><input type="text" name="driver_name" value="${pdd.driver_name}" /></td>
               </tr>
               <tr>
                  <td>Offense Type</td>
                  <td><input type="text" name="offence_type" value="${pdd.offence_type}" /></td>
               </tr>
               <tr>
                  <td>Fine</td>
                  <td><input type="text" name="fine" value="${pdd.fine}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/pddList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>