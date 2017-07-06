<%-- 
    Document   : minhasPerguntas
    Created on : 09/05/2017, 11:04:05
    Author     : Matheus Levi
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% Usuario usr = (Usuario) session.getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
	<head>
	 <title>Fórum do Programador - Minhas Perguntas</title>
         <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->
         <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	 <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	 <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
         <link rel="stylesheet" href="estilos/minhasPerguntas.css"> 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         <script src="js/loadNavbar.js"></script> 
         <script src="js/minhasPerguntas.js"></script>
	</head>
        <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50" onload="carregarMinhasPerguntas(); carregarLinguagemProgramacaoNav();">
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
                                        <ul class="dropdown-menu" id="menuLP" >
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
						<li><a href="perguntasResolvidas.jsp">Resolvidas</a></li>
						<li><a href="perguntas.jsp">Todas</a></li>
                                                <li><a href="minhasRespostas.jsp">Minhas Respostas</a></li>                                            </ul>
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
				<div class="col-sm-12 text-center PerguntaHeader" >
					Minhas Perguntas
				</div>
                                <div id="filter-bar" class="col-sm-12 " style="padding-left: 0px; padding-right: 0px;">
                                    <div class="input-group">
                                        <div class="input-group-btn search-panel">
                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                                <span id="search_concept">Filter by</span> <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                              <li><a href="#contains">Contains</a></li>
                                              <li><a href="#its_equal">It's equal</a></li>
                                              <li><a href="#greather_than">Greather than ></a></li>
                                              <li><a href="#less_than">Less than < </a></li>
                                              <li class="divider"></li>
                                              <li><a href="#all">Anything</a></li>
                                            </ul>
                                        </div>
                                        <input type="hidden" name="search_param" value="all" id="search_param">         
                                        <input type="text" class="form-control" name="x" placeholder="Search term...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
                                        </span>
                                    </div>
				</div>
                                <div id="order-bar" class="col-sm-12" style="padding-left: 11px; padding-right: 0px; padding-top: 5px;">
                                    <label for="orderCampo">Ordenar por: </label>
                                    <select id="orderField" name="orderCampo">
                                        <option value="data">Data</option>
                                        <option value="respostas">Nº de Respostas</option>
                                    </select>
                                    <label for="orderOrdem">Ordem: </label>
                                    <select id="order" name="orderOrdem">
                                        <option value="asc">Ascedente</option>
                                        <option value="desc">Descrescente</option>
                                    </select>
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </div>    
                                <div id="Questoes" class="col-sm-12" style="padding-right: 0px;">
					<div id="listaQuestoes" class="list-group col-sm-12">
						<!--<a href="consultaPergunta.jsp"  class="list-group-item row text-left">
							<div class="col-sm-4 itemItemLista"><span class="glyphicon glyphicon-calendar"></span> 03/05/2016</div>
							<div class="col-sm-4 itemItemLista"><span class="glyphicon glyphicon-share-alt"></span> 2</div>
							<div class="col-sm-12 itemItemLista questao">Problema no CSS</div>
						</a>-->
					</div>
                                </div>
                              <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                              </nav>      
                            </div>  
           </div>
            <div class="footer text-center">
                <p>Site desenvolvido usando<a href="https://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
            </div> 
	</body>
</html>
	
