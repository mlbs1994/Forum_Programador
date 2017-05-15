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
        <title>Alterar Cadastro- Fórum do Programador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="estilos/alterarCadastro.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        <script src="js/alterarCadastro.js"></script>
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
            <div id="formTitle" class="col-sm-5 centralizar"><h3>Alterar Cadastro</h3></div>
            <form id="formAlterarCadastro" class="text-left col-sm-5 centralizar" action="AlterarCadastroServlet" method="POST">
                <div class="form-group row col-sm-12">
                    <div class="formInput has-feedback kv-avatar center-block">
                        <label id="imgLabel" for="imgConta">Imagem da Conta: </label>
                        <div id="imgAvatar">
                            <img id="img" src="<%= usr.getImagem()%>" class="img-thumbnail" alt="Avatar" >
                            <div>
                            <div class="kv-avatar center-block" style="width:200px; margin-left: 280px;">
                                <input id="avatar-1" name="imgConta" type="file" class="file-loading" value="<%= usr.getImagem() %>"  onchange="srcImg()">
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group row col-sm-12">
                    <div class="formInput has-feedback">
			<label for="nome">Nome: </label>
			<input class="form-control" type="text" name="nome" maxlength="70" placeholder="Digite seu nome" value="<%= usr.getNomeUsuario() %>" required>
                        <i class="glyphicon glyphicon-user form-control-feedback"></i>
                    </div>
		</div>
                <div class="form-group row col-sm-12">
                    <div class="formInput has-feedback">
			<label for="login">Login: </label>
			<input id="loginHTML" class="form-control" type="text" name="login" maxlength="70" placeholder="Digite seu login" value="<%= usr.getLogin() %>" required>
                        <i class="glyphicon glyphicon-user form-control-feedback"></i>
                    </div>
		</div>
		<div class="form-group row col-sm-12">		
                    <div class="formInput has-feedback">	
                        <label for="email">Email: </label>
			<input class="form-control" type="email" name="email" size="40" maxlength="255" placeholder="Digite seu email" value="<%= usr.getEmail() %>" required>
			<i class="glyphicon glyphicon-envelope form-control-feedback"></i>
                    </div>
		</div>
		<div class="form-group row col-sm-12">
                    <div class="formInput has-feedback col-sm-ofsset-2 col-sm-12" style="padding: 0px;">	
			<label for="senha">Senha: </label>
			<input id="senhaHTML" class="form-control" type="password" name="senha" maxlength="20" value="<%= usr.getSenha() %>">
			<i class="glyphicon glyphicon-lock form-control-feedback"></i>
                    </div>
		</div>
		<div class="form-group row col-sm-12">
                    <div class="formInput has-feedback col-sm-ofsset-2 col-sm-12" style="padding: 0px;">	
			<label for="senha">Confirmar Senha: </label>
			<input id="confirmarSenhaHTML" class="form-control" type="password" name="senha" maxlength="20" value="<%= usr.getSenha() %>">
			<i class="glyphicon glyphicon-lock form-control-feedback"></i>
                    </div>
                </div>
		<div class="form-group row col-sm-12">	
                    <div class="text-center botao">
                        <button id="botaoCadastrar" type="button" class="btn btn-block" onclick="verificarSenha()">Alterar Dados</button>
                    </div>
		</div>
                <div class="text-center  row col-sm-12">
                    <p><b>Ou</b></p>
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
