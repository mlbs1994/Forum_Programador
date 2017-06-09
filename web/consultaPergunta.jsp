<%-- 
    Document   : consultaPergunta
    Created on : 02/05/2017, 08:28:10
    Author     : Matheus Levi
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% Usuario usr = (Usuario) session.getAttribute("usuario"); %>
<% String id = request.getParameter("id"); %>
<!DOCTYPE html>
<html>
    	<head>
	 <title>Fórum do Programador - CSS com Problema</title>
         <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	 <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
         <link rel="stylesheet" href="estilos/consulta.css"> 
         <link rel="stylesheet" href="suyati-line-control-82a0f54/editor.css">
         <link rel="stylesheet" href="styles/default.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         <script src="suyati-line-control-82a0f54/editor.js"></script>  
         <script src="js/loadNavbar.js"></script> 
         <script src="js/consultaPergunta.js"></script>
         <script src="highlight.pack.js"></script>
	</head>
        <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50" onload="carregarPergunta('<%=id %>'); carregarLinguagemProgramacaoNav(); getRespostas();">
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
				  <ul class="nav navbar-nav navbar-right navbar-link">
						<li><a href="home.jsp">Home</a></li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">Linguagens de Programação
							<span class="caret"></span></a>
							<ul class="dropdown-menu" id="menuLP">
							</ul>
						</li>
						<li><a href="#">Artigos</a></li>
						<!--<li><a href="#">T�picos</a></li>-->
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">Perguntas
							<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="submeterPergunta.jsp">Fazer Perguntas</a></li>
								<li><a href="minhasPerguntas.jsp">Minhas Perguntas</a></li>
								<li><a href="perguntasAbertas.jsp">Em aberto</a></li>
								<li><a href="perguntasResolvidas.jsp">Resolvidas</a></li>
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
			<div id="PerguntaContainer" class="container-fluid col-sm-12">
				<div id="PerguntaHead" class="col-sm-12 text-center PerguntaHeader" >
				</div>
				<div class="col-sm-12 PerguntaContent">
					<div class="row col-sm-12">
                                            <div class="col-sm-12 comentarioHeader">Por: <span class="glyphicon glyphicon-user"></span><span id="nomeUsuario"></span>
                                                <span class="glyphicon glyphicon-calendar"></span><span id="dataPergunta"></span>
                                                <span class="glyphicon glyphicon-time"></span><span id="horaPergunta"></span>
						</div>
					</div>
					<div class=" col-sm-12 comentarioContent" id="conteudoPergunta">
					</div>   
				</div>
                                <div class="col-sm-12 PerguntaContent" id="respostasContent">
                                </div>
			</div>                          
		</div>
		  <div class="footer text-center">
			<p>Site desenvolvido usando<a href="https://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
        </div>                                        
        </body>                                            
</html>
