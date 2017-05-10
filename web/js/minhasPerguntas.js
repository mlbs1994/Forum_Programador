var xhr = new XMLHttpRequest();
var doc;

function carregarPerguntas()
{
    xhr.onreadystatechange = getInfo;
    
    try
    {
        xhr.open("GET","http://localhost:8080/Forum_Programador/MinhasPerguntasServlet",true);
        xhr.send();
    }
    catch(e)
    {
        alert(e);
    }
}

function getInfo()
{
    if(xhr.readyState==4)
    {
        doc = xhr.responseXML;
        
        var perguntas = doc.getElementsByTagName("pergunta");
        
        var i=0;
        
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
            divTitulo.textContent = perguntas[i].getElementsByTagName("titulo")[0].childNodes[0].nodeValue+" ";
            
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