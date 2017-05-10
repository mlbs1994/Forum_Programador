<%-- 
    Document   : consultaPergunta
    Created on : 02/05/2017, 08:28:10
    Author     : Matheus Levi
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% Usuario usr = (Usuario) session.getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
    	<head>
	 <title>Fórum do Programador - CSS com Problema</title>
         <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	 <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	 <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
     <link rel="stylesheet" href="estilos/consulta.css"> 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
			<div id="PerguntaContainer" class="container-fluid col-sm-12">
				<div class="col-sm-12 text-center PerguntaHeader" >
					Problema no CSS - 26/05/2016
				</div>
				<div class="col-sm-12 PerguntaContent">
					<div class="row col-sm-12">
						<div class="col-sm-12 comentarioHeader">Por: <span class="glyphicon glyphicon-user"></span> Matheus Levi
							<span class="glyphicon glyphicon-calendar"></span> 26/05/2016
							<span class="glyphicon glyphicon-time"></span> 08:59
						</div>
					</div>
					<div class=" col-sm-12 comentarioContent">
						<p>Bom dia Pessoal</p>
						<p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI
						, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum 
						sobreviveu n�o s� a cinco s�culos, como tamb�m ao salto para a editora��o eletr�nica, permanecendo essencialmente inalterado. 
						Se popularizou na d�cada de 60, quando a Letraset lan�ou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando 
						passou a ser integrado a softwares de editora��o eletr�nica como Aldus PageMaker.</p>
						<p>Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI
						, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum 
						sobreviveu n�o s� a cinco s�culos, como tamb�m ao salto para a editora��o eletr�nica, permanecendo essencialmente inalterado. 
						Se popularizou na d�cada de 60, quando a Letraset lan�ou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando 
						passou a ser integrado a softwares de editora��o eletr�nica como Aldus PageMaker.</p>
						<pre class="codeContent text-left">
// b is an index array, n is size of b,
// player is the array need to be delete elements,
// size is the size of player

void play_cards(int b[],int n,int player[],int *size){
int i;
for(i = 0; i < n; i++)
delete_cards(b[i],player,size);
}

void delete_cards(int n,int player[],int *size){
int i;
for(i = n; i < *size; i++)
	player[i] = player[i+1];   
	*size -= 1;
}

int main(void){
int player[10] = {1,2,3,3,4,4,5,5,6,7};
int index[6] = {2,3,4,5,6,7};
int size = 10;

play_cards(index,6,player,&size);

for(int i = 0; i < size; i++)
printf("%d|",player[i]);
puts("");

return 0;

}
						</pre>
					</div>
				</div>
				<div class="col-sm-12 PerguntaContent">
					<div class="row col-sm-12">
						<div class="col-sm-12 comentarioHeader">Por: <span class="glyphicon glyphicon-user"></span> Klebson
							<span class="glyphicon glyphicon-calendar"></span> 27/05/2016
							<span class="glyphicon glyphicon-time"></span> 09:51
						</div>
					</div>
					<div class=" col-sm-12 comentarioContent">
						<p>Olá Matheus</p>
						<p>Tente isso:</p>
						<pre class="codeContent text-left">
// b is an index array, n is size of b,
// player is the array need to be delete elements,
// size is the size of player

void play_cards(int b[],int n,int player[],int *size){
int i;
for(i = 0; i < n; i++)
delete_cards(b[i],player,size);
}

void delete_cards(int n,int player[],int *size){
int i;
for(i = n; i < *size; i++)
	player[i] = player[i+1];   
	*size -= 1;
}

int main(void){
int player[10] = {1,2,3,3,4,4,5,5,6,7};
int index[6] = {2,3,4,5,6,7};
int size = 10;

play_cards(index,6,player,&size);

for(int i = 0; i < size; i++)
printf("%d|",player[i]);
puts("");

return 0;

}
						</pre>
					</div>
				</div>
				<div class="col-sm-12 PerguntaContent">
					<div class="row col-sm-12">
						<div class="col-sm-12 comentarioHeader">Por: <span class="glyphicon glyphicon-user"></span> Matheus Levi
							<span class="glyphicon glyphicon-calendar"></span> 27/05/2016
							<span class="glyphicon glyphicon-time"></span> 10:15
						</div>
					</div>
					<div class=" col-sm-12 comentarioContent ultimoComentario">
						<p>Funcionou aqui, Muito Obrigado!</p>
					</div>
				</div>
			</div> 
			<div class="push"></div>
		</div>
		 <div class="footer text-center">
			<p>Site desenvolvido usando<a href="http://v4-alpha.getbootstrap.com" data-toggle="tooltip" title="Bootstrap CSS"> Bootstrap</a></p> 
        </div>
</html>
