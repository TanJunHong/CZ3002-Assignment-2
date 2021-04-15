<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="https://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Login Page</title>
    <s:head/>
</head>
<body style="position: relative; min-height: 100vh">
<div style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);">
    <s:form action="login">
        <s:textfield label="Username" name="username"/>
        <s:textfield label="Password" name="password" type="password"/>
        <s:submit/>
    </s:form>
    <s:actionerror style="color: red"/>
</div>
</body>
</html>
	