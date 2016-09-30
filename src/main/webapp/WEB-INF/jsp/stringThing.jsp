<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>String Thing</title>
</head>
<body>
<h1>String Thing</h1>
<br><br>
<form name="stringThingForm" method="POST" action="/combobulateString">
    Combobulate This: <input type="text" name="sentence" value="${sentence}" /><br>
    <input type="submit">
</form>

<c:if test="${sentence != null}">
    <br><br>
    <hr>
    <br><br>
    Original Sentence: <c:out value="${sentence}"/><br>
    Word Count: <c:out value="${wordCount}"/><br>
    Characters Count: <c:out value="${charCount}"/><br>
    Reverse Sentence: <c:out value="${reverseString}"/><br>
    Pig Latin: <c:out value="${pigLatin}"/><br>
    Google Links:<br>
    <c:forEach var="googleLink" items="${googleLinks}">
        <a href="<c:out value="${googleLink}"/>"><c:out value="${googleLink}"/></a><br>
    </c:forEach>
</c:if>

</body>
</html>