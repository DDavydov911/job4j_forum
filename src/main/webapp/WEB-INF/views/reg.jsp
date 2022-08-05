<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name='reg' action="<c:url value='/reg'/>" method='POST'>
    <input type='hidden' name='id' value="0">
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username'></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><input type='text' name='email'></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>