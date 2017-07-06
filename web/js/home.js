var xhrPA = new XMLHttpRequest(); // Perguntas Abertas
var xhrPR = new XMLHttpRequest(); // Perguntas Resolvidas
var docAbertas;
var docResolvidas;

function initGetPerguntasAbertas()
{
    try
    {
         var url = "PerguntasAbertasServlet";
         
         xhrPA.onreadystatechange=getPerguntasAbertas;
         xhrPA.open("GET","PerguntasAbertasServlet",true);
         xhrPA.send();
        
         
    }
    catch(e)
    {
        alert(e);
    }
}

function getPerguntasAbertas()
{
    if(xhrPA.readyState==4)
    {
        docAbertas = xhrPA.responseXML;
        var perguntas = docAbertas.getElementsByTagName("pergunta");
        var i=0;
        
        for(i=0;i<perguntas.length;i++)
        {
            
            if(i==11)
            {
                break;
            }
            //Criando os elementos
            
            var a = document.createElement("a");
            a.setAttribute("href","javascript:consultarPerguntaAberta("+i+")");
           // a.setAttribute("href","javascript:alert("+i+")");
            a.className = "list-group-item row text-left";
            var divData = document.createElement("div");
            var divResposta = document.createElement("div");
            var divTitulo = document.createElement("div");
            divData.className = "col-sm-4 itemItemLista";
            divResposta.className = "col-sm-4 itemItemLista";
            divTitulo.className = "col-sm-12 itemItemLista questao";
            var spanData = document.createElement("span");
            var spanResposta = document.createElement("span");
            spanData.className = "glyphicon glyphicon-calendar";
            spanResposta.className = "glyphicon glyphicon-share-alt";
            
            //Definindo os estilos
            divTitulo.style = "font-weight:bold; color:#3F659A";
            
            //Definindo os valores
            divData.textContent = perguntas[i].getElementsByTagName("data")[0].childNodes[0].nodeValue+" ";
            divResposta.textContent = perguntas[i].getElementsByTagName("respostas")[0].childNodes[0].nodeValue+" ";
            divTitulo.textContent = "["+perguntas[i].getElementsByTagName("linguagem_programacao")[0].childNodes[0].nodeValue+"] "
                    +perguntas[i].getElementsByTagName("titulo")[0].childNodes[0].nodeValue+" ";
            
            divData.appendChild(spanData);
            divResposta.appendChild(spanResposta);
            
            
            a.appendChild(divData);
            a.appendChild(divResposta);
            a.appendChild(divTitulo);
            
            document.getElementById("listaQuestoesAbertas").appendChild(a);
              
        }
    }
}

function initGetPerguntasResolvidas()
{
    try
    {
      
         xhrPR.onreadystatechange=getPerguntasResolvidas;
         xhrPR.open("GET","PerguntasResolvidasServlet",true);
         xhrPR.send();
        
        
    }
    catch(e)
    {
        alert(e);
    }
}

function getPerguntasResolvidas()
{
    if(xhrPR.readyState==4)
    {
        docResolvidas = xhrPR.responseXML;
        
        var perguntas = docResolvidas.getElementsByTagName("pergunta");
        
        var i=0;
        
        for(i=0;i<perguntas.length;i++)
        {
            //Criando os elementos
            
            if(i==11)
            {
                break;
            }
            
            var a = document.createElement("a");
            a.setAttribute("href","javascript:consultarPerguntaResolvida("+i+")");
           // a.setAttribute("href","javascript:alert("+i+")");
            a.className = "list-group-item row text-left";
            var divData = document.createElement("div");
            var divResposta = document.createElement("div");
            var divTitulo = document.createElement("div");
            divData.className = "col-sm-4 itemItemLista";
            divResposta.className = "col-sm-4 itemItemLista";
            divTitulo.className = "col-sm-12 itemItemLista questao";
            var spanData = document.createElement("span");
            var spanResposta = document.createElement("span");
            spanData.className = "glyphicon glyphicon-calendar";
            spanResposta.className = "glyphicon glyphicon-share-alt";
            
            //Definindo os estilos
            divTitulo.style = "font-weight:bold; color:#3F659A";
            
            //Definindo os valores
            divData.textContent = perguntas[i].getElementsByTagName("data")[0].childNodes[0].nodeValue+" ";
            divResposta.textContent = perguntas[i].getElementsByTagName("respostas")[0].childNodes[0].nodeValue+" ";
            divTitulo.textContent = "["+perguntas[i].getElementsByTagName("linguagem_programacao")[0].childNodes[0].nodeValue+"] "
                    +perguntas[i].getElementsByTagName("titulo")[0].childNodes[0].nodeValue+" ";
            
            divData.appendChild(spanData);
            divResposta.appendChild(spanResposta);
            
            
            a.appendChild(divData);
            a.appendChild(divResposta);
            a.appendChild(divTitulo);
            
            document.getElementById("listaQuestoesResolvidas").appendChild(a);
              
        }
    }
       
}

  function consultarPerguntaAberta(id)
  {
      var id = docAbertas.getElementsByTagName("id")[id].childNodes[0].nodeValue
      window.location.href = "consultaPergunta.jsp?id="+id;
  }
  
  function consultarPerguntaResolvida(id)
  {
      var id = docResolvidas.getElementsByTagName("id")[id].childNodes[0].nodeValue
      window.location.href = "consultaPergunta.jsp?id="+id;
  }