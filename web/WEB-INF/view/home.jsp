<%@ page import="com.wind.util.Constants" %>
<%@ page import="com.wind.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/5/1
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/home.css" type="text/css">
    <title>Welcome</title>
</head>
<body>
<div class="forward center">
    <h6>
        Welcome to the wind studio
    </h6>
</div>
<div class="info">
    <h3> User：<%=user.getUsername()%></h3>
    <a href="${pageContext.request.contextPath}/view/upload.do?method=enter">
        <button class="mybtn">上传视频</button>
    </a>
</div>

<div class="container">
    <div class="alura-log">
        <a href="${pageContext.request.contextPath}/view/logout.do">
            <img src="${pageContext.request.contextPath}/static/images/logo.png" class="page-logo">
        </a>
    </div>
    <h1 class="page-title">风之影城</h1>
    <div class="container-opcoes">
        <label for="ordenarFilmes">sort:</label>
        <select id="ordenarFilmes" onchange="ordenar()">
            <option value="nome" class="ordemNome">Type</option>
            <option value="anoLancamento" class="ordemLancamento">years</option>
            <option value="anoCronologico" class="ordemCronologica">name</option>
        </select>
        <button class="mostra-container-cadastro" onclick="habilitaContainerCadastro()">search</button>
    </div>

    <div class="container-cadastro center">
        <fieldset>
            <legend>Cadastro</legend>
            <div class="container-cadastro-campo">
                <label for="nomeFilme">Nome do filme</label>
                <input id="nomeFilme" type="text">
            </div>
            <div class="container-cadastro-campo">
                <label for="anoLancamentoFilme">Ano de lançamento</label>
                <input id="anoLancamentoFilme" type="number" step="1">
            </div>
            <div class="container-cadastro-campo">
                <label for="anoCronologiaFilme">Ano cronológico dos eventos</label>
                <input id="anoCronologiaFilme" type="number">
            </div>
            <div class="container-cadastro-campo">
                <label for="linkTrailerFilme">Endereço do trailer</label>
                <input id="linkTrailerFilme" type="text">
            </div>
            <div class="container-cadastro-campo">
                <label for="linkImagemFilme">Endereço da imagem</label>
                <input id="linkImagemFilme" type="text">
            </div>
            <div class="container-cadastro-campo">
                <label for="linkImdbFilme">Endereço resumo do filme</label>
                <input id="linkImdbFilme" type="text">
            </div>
            <button onclick="salvarFilme()">Salvar</button>
            <button onclick="desabilitaContainerCadastro()">Cancelar</button>
        </fieldset>
    </div>
    <div class="container-total">
        <c:forEach var="movie" items="${movies}">
            <a href="${pageContext.request.contextPath}/view/movie.do?id=${movie.getId()}">
                <div class="container-movies">
                    <h2 class="center">
                        ${movie.getName()}
                        <br>
                        上映时间: ${movie.getYears()}
                    </h2>
                    <img src="${pageContext.request.contextPath}/static/images/${movie.getImage()}" alt="${movie.getName()}">
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
<a href="https://github.com/2w1nd?tab=repositories" target="_blank">
    <footer>Copyright © 2013-2021 风之影城  runoob.com All Rights Reserved. 备案号：闽ICP备15012807号-1</footer>
</a>
</body>
</html>
