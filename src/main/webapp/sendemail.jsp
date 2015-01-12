<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
    <script type="text/javascript" src="/javascript/validate.min.js"></script>
</head>

<body>
<div>Use this form to send an email</div>
<div id="errors"></div>
<form name="emailForm" action="/sendemail" method="post">
    <div><input type="text" value="From Address" name="from"/>From Address
    <div><input type="text" value="mail1@test.com" name="to"/>To Address
    <div><input type="text" value="Subject" name="subject"/>Subject
    <div>Email Message</div>
    <div><textarea name="body" rows="3" cols="60"></textarea></div>
    <div><input type="submit" value="Send Email"/></div>
</form>

<script src="/javascript/verify.js"></script>
    
</body>
</html>