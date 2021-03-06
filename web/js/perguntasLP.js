var xhrPergLP = new XMLHttpRequest();
var doc;

function carregarPerguntasLP(id)
{
    xhrPergLP.onreadystatechange = getInfoPergLP;
    
    try
    {
        xhrPergLP.open("GET","PerguntasLPServlet?id="+id,true);
        xhrPergLP.send();
    }
    catch(e)
    {
        alert(e);
    }
}

function getInfoPergLP()
{
    if(xhrPergLP.readyState==4)
    {

        
        doc = xhrPergLP.responseXML;
        
        var perguntas = doc.getElementsByTagName("pergunta");
        
        var i=0;
        var lp = perguntas[0].getAttribute("idLinguagemProgramacao");

        atualizarTitulo(lp);
        
        for(i=0;i<perguntas.length;i++)
        {
            //Criando os elementos
            
            var a = document.createElement("a");
            a.setAttribute("href","javascript:consultarPergunta("+i+")");
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
            
            document.getElementById("listaQuestoes").appendChild(a);
              
        }
        
    }
    
}

  function consultarPergunta(id)
  {
      var id = doc.getElementsByTagName("id")[id].childNodes[0].nodeValue
      window.location.href = "consultaPergunta.jsp?id="+id;
  }
  
  function atualizarTitulo(lp)
  {
      document.getElementById("lpTitulo").innerHTML = "Perguntas - "+lp;
  }