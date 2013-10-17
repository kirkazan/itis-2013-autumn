<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
   <c:if test="${1 eq 1}">
       true
   </c:if>
   <c:if test="${1 eq 2}">
       false
   </c:if>
</body>
</html>