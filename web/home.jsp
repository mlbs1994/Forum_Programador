<%-- 
    Document   : home
    Created on : 01/05/2017, 23:06:20
    Author     : Matheus Levi
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% Usuario usr = (Usuario) session.getAttribute("usuario"); %>
<html>
	<head>
         <title>Página Inicial - Fórum do Programador</title>
         <meta charset="UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->
         <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
         <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
         <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
         <link rel="stylesheet" href="estilos/index.css"> 
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         <script src="js/loadNavbar.js"></script> 
         <script src="js/home.js"></script> 
	</head>
        <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50" onload="carregarLinguagemProgramacaoNav(); initGetPerguntasAbertas(); initGetPerguntasResolvidas(); ">
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
						<li><a href="#">Home</a></li>
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
			<div id="myCarousel" class="carousel slide col-sm-12" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
				  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				  <li data-target="#myCarousel" data-slide-to="1"></li>
				  <li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
				  <div class="item active">
					<img class="img-responsive" src="imagens/empTI.jpg" alt="New York" width="1200" height="400">
					<div class="carousel-caption">
					  <h3>Em ascensão</h3>
					  <p>Cresce o número de vagas na área de TI</p>
					</div>      
				  </div>
				  <div class="item">
					<img class="img-responsive" src="imagens/code-bg.jpg" alt="Chicago" width="1200" height="700">
					<div class="carousel-caption">
					  <h3>Padrões de Projeto</h3>
					  <p>Vejam os padrões de projetos mais usados em sistemas corporativos</p>
					</div>      
				  </div>
				  <div class="item">
					<img class="img-responsive" src="imagens/proj.jpg" alt="Los Angeles" width="1200" height="700">
					<div class="carousel-caption">
					  <h3>Caminhos para o sucesso</h3>
					  <p>7 dicas para ter sucesso em um projeto</p>
					</div>      
				  </div>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				  <span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				  <span class="sr-only">Next</span>
				</a>
			</div>
			<div id="questoesContainer" class="container-fluid col-sm-12">
				<div id="ultimasQuestoes" class="col-sm-6">
					<div id="ultimasQuestoesHeader" class="text-center">
						Questões Abertas
					</div>
					<div id="listaQuestoesAbertas" class="list-group col-sm-12">
					</div>
				</div>
				<div id="questoesRespondidas" class="col-sm-6">
					<div id="questoesRespondidasHeader" class="text-center">
						Questões Resolvidas
					</div>
					<div id="listaQuestoesResolvidas" class="list-group col-sm-12">
					</div>
				</div>
			</div>
			<div class="push"></div>
		</div>
		 <div class="footer text-center">
			<p>Site desenvolvido usando<a href="https://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
        </div>
	</body>
</html>
	
