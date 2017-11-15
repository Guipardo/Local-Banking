<%-- 
    Document   : homepage
    Created on : 13/11/2017, 17:13:07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../design.css">
        <title> Local Banking </title>
    </head>
    <body class='fundo'>
        <h1 id='logotitulo' class='titulo'> Local Banking </h1>
        <article>
            <br>
            <hr>
            <br>
            <form name='cadastro' action='/api/v1/conta/criar'>
                <a class='texto'>Número da Conta </a><br>
                <input type="text" name="numero">
                <br><br>
                <a class='texto'>Agência </a><br>
                <input type="text" name="agencia">
                <br><br>
                <a class='texto'>Titular </a><br>
                <input type="text" name="titular">
                <br><br>
                <a class='texto'>Senha </a><br>
                <input type="password" name="senha">
                <br><br>
                <input type="submit" value="Enviar">
            </form>
            <hr>
        </article>
        <a href="../homepage.jsp" class='texto'> Voltar</a>
        <footer class='footer'> Local Banking - Desenvolvido por Guilherme Rodrigues </footer> 
    </body>
</html>