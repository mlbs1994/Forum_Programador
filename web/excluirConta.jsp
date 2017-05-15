<%-- 
    Document   : alterarCadastro
    Created on : 02/05/2017, 08:33:10
    Author     : Matheus Levi
--%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<% Usuario usr = (Usuario) session.getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Excluir Conta - Fórum do Programador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="estilos/excluirConta.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        <script src="js/excluirConta.js"></script>
        <script src="js/loadNavbar.js"></script> 
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50" onload="carregarLinguagemProgramacaoNav()">
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
        <div id="formContainer" class="container text-center col-sm-12">
            <div id="formTitle" class="col-sm-5 centralizar"><h3>Excluir Conta</h3></div>
            <form id="formAlterarCadastro" class="text-left col-sm-5 centralizar" action="AlterarCadastroServlet" method="POST">
                <div class="form-group row col-sm-12 text-center textoForm">
                        <p>Lamentamos a sua partida. As portas sempre estarão abertas para você</p>
		</div>
                <div class="form-group row col-sm-12 text-center textoForm">
                        <p>Informe email e sua senha para confirmar a exclusão da sua conta</p>
		</div>
		<div class="form-group row col-sm-12">		
                    <div class="formInput has-feedback">	
                        <label for="email">Email: </label>
			<input class="form-control" type="email" name="email" size="40" maxlength="255" placeholder="Digite seu email"  required>
			<i class="glyphicon glyphicon-envelope form-control-feedback"></i>
                    </div>
		</div>
		<div class="form-group row col-sm-12">
                    <div class="formInput has-feedback col-sm-ofsset-2 col-sm-12" style="padding: 0px;">	
			<label for="senha">Senha: </label>
			<input id="senhaHTML" class="form-control" type="password" name="senha" maxlength="20" >
			<i class="glyphicon glyphicon-lock form-control-feedback"></i>
                    </div>
		</div>
		<div class="form-group row col-sm-12">
                    <div class="formInput has-feedback col-sm-ofsset-2 col-sm-12" style="padding: 0px;">	
			<label for="senha">Confirmar Senha: </label>
			<input id="confirmarSenhaHTML" class="form-control" type="password" name="senha" maxlength="20" >
			<i class="glyphicon glyphicon-lock form-control-feedback"></i>
                    </div>
                </div>
                <div class="form-group row col-sm-12">	
                    <div class="text-center botao">
                        <button id="botaoExcluirConta" type="button" class="btn btn-block" onclick="excluirConta()">Excluir Conta</button>
                    </div>
		</div>
            </form>
            <div class="push"></div>
	</div>
	<div class="footer text-center">
            <p>Site desenvolvido usando<a href="http://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
	</div>  
        </div>                              
    </body>
</html>
