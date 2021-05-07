<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/30
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>welcome</title>'
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" type="text/css">
</head>
<body>

<div class="center">
    <h1>Movie city of wind</h1>
</div>

<div class="container">
    <!-- Sign In -->
    <div class="container__form container--signin">
        <form action="${pageContext.request.contextPath}/view/user.do" class="form" method="post" id="form1">
            <input type="hidden" name="method" value="login">
            <h2 class="form__title">Sign In</h2>
            <div class="error">${error}</div>
            <input type="text" placeholder="Email" class="input" name="email" required/>
            <input type="password" placeholder="Password" class="input" name="pwd" required/>
            <a href="#" class="link">Forgot your password?</a>
            <button class="btn" type="submit">Sign In</button>
        </form>
    </div>

    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form class="form" action="${pageContext.request.contextPath}/view/user.do" method="post" id="form2">
            <input type="hidden" name="method" value="register">
            <h2 class="form__title">Sign Up</h2>
            <div>${info}</div>
            <input type="text" placeholder="User" class="input" id="username" name="username" onfocus="shoeTips('hint','用户名长度不能小于四')" onblur="hint_hide()" onkeyup="hint()" required/><span id="hint"></span>
            <input type="email" placeholder="Email" class="input" id="email" name="email" required/>
            <input type="password" placeholder="Password" class="input" id="pwd" name="pwd"  onfocus="shoeTips('pass_hint','密码长度不能小于六')" onblur="pass_hide()" onkeyup="checkPass()" required/><span id="pass_hint"></span>
            <button class="btn" type="submit">Sign Up</button>
        </form>
    </div>

    <!-- Overlay -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <button class="btn" id="signIn">Sign In</button>
            </div>
            <div class="overlay__panel overlay--right">
                <button class="btn" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js"></script>
</html>