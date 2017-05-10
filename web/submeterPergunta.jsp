<%-- 
    Document   : submeterPergunta
    Created on : 06/05/2017, 18:17:13
    Author     : Matheus Levi
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Usuario"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usr = (Usuario) session.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submeter Pergunta - Fórum do Programador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="estilos/submeterPergunta.css">
        <link rel="stylesheet" href="suyati-line-control-82a0f54/editor.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        <script src="suyati-line-control-82a0f54/editor.js"></script>  
        <script src="js/submeterPergunta.js"></script>
        <script src="js/loadNavbar.js"></script>
    </head>
    <body onload="carregarLinguagemProgramacao(); carregarLinguagemProgramacaoNav();">
        <div class="wrapper">
            <nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid col-sm-12">
                    <div class="navbar-header">
			<a class="navbar-brand navbar-left" href="#myPage"><img class="img-responsive" src="imagens/logo.png" id="logo"></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myFpBar">
                            <span class="icon-bar icon-bar-estilo"></span>
                            <span class="icon-bar icon-bar-estilo"></span>
                            <span class="icon-bar icon-bar-estilo"></span>                        
			</button>
                    </div>
                    <div class="collapse navbar-collapse" id="myFpBar">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="home.jsp">Home</a></li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Linguagens de Programação
                                <span class="caret"></span></a>
                                <ul class="dropdown-menu" id="menuLP">
                                </ul>
                            </li>
                            <li><a href="#">Artigos</a></li>
				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Perguntas
                                    <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
					<li><a href="submeterPergunta.jsp">Fazer Perguntas</a></li>
                                        <li><a href="minhasPerguntas.jsp">Minhas Perguntas</a></li>
					<li><a href="perguntasAbertas.jsp">Em aberto</a></li>
					<li><a href="perguntasRespondidas.jsp">Respondidas</a></li>
					<li><a href="perguntas.jsp">Todas</a></li>
                                        <li><a href="minhasRespostas.jsp">Minhas Respostas</a></li>
                                    </ul>
				</li>
				<li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Bem Vindo <b> <% out.print(usr.getLogin());  %></b>
                                    <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
					<li><a href="alterarCadastro.jsp">Alterar dados da conta</a></li>
					<li><a href="LogoutServlet">Sair</a></li>
                                    </ul>
                                </li>
                        </ul>
                </div>
            </div>
	</nav>
        <!-- Formulario de submissão de pergunta -->     
        <div id="formContainer" class="container text-center col-sm-12">
            <div id="formTitle" class="col-sm-5 centralizar"><h3>FAÇA SUA PERGUNTA</h3></div>
            <form id="formSubmeterPergunta" class="text-left col-sm-5 centralizar" action="SubmeterPerguntaServlet" method="POST">
                <div class="form-group row col-sm-12">
                    <div class="formInput has-feedback">
			<label for="titulo">Titulo </label>
			<input class="form-control" type="text" name="titulo" maxlength="70" placeholder="Digite o titulo" value="<%= usr.getNomeUsuario() %>" required>
                    </div>
		</div>
                <div class="form-group row col-sm-12">
                    <div class="formInput has-feedback">
			<label for="lgp">Linguagem de Programação </label><br>
                        <select id="selectLP" name="lgp">
                        </select>
                    </div>
		</div>
		<div class="form-group row col-sm-12">		
                    <div class="formInput has-feedback">	
                        <label for="comentario">Pergunta </label>
			<input id="comentario" name="comentario"  />
                    </div>
		</div>
		<div class="form-group row col-sm-12">	
                    <div class="text-center botao">
                        <button id="botaoCadastrar" type="button" class="btn btn-block" onclick="submeterPergunta()">Submeter</button>
                    </div>
		</div>
            </form>
	</div>
	</div>
	<div class="footer text-center">
            <p>Site desenvolvido usando<a href="http://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
	</div>                              
      </div>      
      <script>
            var editor = $("#comentario").Editor();
        </script>
    </body>
</html>
