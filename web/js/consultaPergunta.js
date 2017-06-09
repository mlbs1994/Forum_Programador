var xhrP = new XMLHttpRequest();
var xhrR = new XMLHttpRequest();
var xhrRP = new XMLHttpRequest();
var idPergunta;
var isEditorActive = 0;
var isEditorInit  = 0;
var editor;
var btnSubmeter = "<div id='butaoSubmeter' class='aResponder col-sm-4' style='width: 120px; text-align:left; padding-left: 5px;'>\n\
<a href='javascript:submeterResposta()'><span class='glyphicon glyphicon-share-alt'> Submeter</span></a></div>\n";
var btnInserirCodigo="<div id='butaoCodigo' class='aResponder col-sm-4' style='width: 140px; text-align:left; padding-left: 5px;'>\n\
<a href='javascript:inserirCodigo()'><span class='glyphicon glyphicon-copy'> Inserir Código</span></a></div>\n"
var lpCode;


function carregarPergunta(id)
{
    idPergunta = id;
    xhrP.onreadystatechange = getInfoPerg;
    
    try
    {
        xhrP.open("GET","PerguntaServlet?id="+id,true);
        xhrP.send();
    }
    catch(e)
    {
        alert(e);
    }
}

function getInfoPerg()
{
    if(xhrP.readyState==4)
    {
        var doc = xhrP.responseXML;
        var pergunta = doc.getElementsByTagName("pergunta");
 
        //idPergunta =  pergunta[0].getElementsByTagName("id")[0].childNodes[0].nodeValue;
        var usuario = pergunta[0].getElementsByTagName("login")[0].childNodes[0].nodeValue;
        var titulo = pergunta[0].getElementsByTagName("titulo")[0].childNodes[0].nodeValue;
        var data = pergunta[0].getElementsByTagName("data")[0].childNodes[0].nodeValue;
        var hora = pergunta[0].getElementsByTagName("hora")[0].childNodes[0].nodeValue;
        var lp = pergunta[0].getElementsByTagName("linguagem_programacao")[0].childNodes[0].nodeValue;
        lpCode = pergunta[0].getElementsByTagName("linguagem_programacaoCode")[0].childNodes[0].nodeValue;
        
        idLP = lp;
        
        document.getElementById("PerguntaHead").innerHTML = "[" +lp+ "]" + " " + titulo + " - " + data;
        document.getElementById("nomeUsuario").innerHTML = usuario;
        document.getElementById("dataPergunta").innerHTML = data;
        document.getElementById("horaPergunta").innerHTML = hora;
        
        var descricao = pergunta[0].getElementsByTagName("descricao")[0].childNodes[0].nodeValue;
        
        document.getElementById("conteudoPergunta").innerHTML = descricao+"<div id='pergunta' class='aResponder'>\n\
                <a href='javascript:fazerResposta()'><span class='glyphicon glyphicon-share-alt'>   \n\
                        Responder</span></a></div>\n\
                        <div id='respostaBox'>\n\
                            <div id='respostaText'></div>\n\
                        </div>\n\
                        <div id='btnSub' class='col-sm-12'>\n\
                        </div>";
        
        
        realcarSintaxeLP();
         
    }
    
    
}

function fazerResposta()
{
    
    var btnCssActive = "background-color: #f00;";
    var btnCssDesactive = "background-color: rgb(63, 101, 154);";
    
    
    if(isEditorActive==0)
    {
        document.getElementById("respostaBox").style.display = "";
        document.getElementById("pergunta").style = btnCssActive;
        if(isEditorInit==0)
        {
            editor = $("#respostaText").Editor();
            isEditorInit = 1;
        }
 
        document.getElementById("btnSub").innerHTML = btnSubmeter+btnInserirCodigo;
        isEditorActive = 1;
    }  
    else
    {  
        document.getElementById("pergunta").style = btnCssDesactive;
        document.getElementById("respostaBox").style.display = "none";
        document.getElementById("btnSub").innerHTML = "";
        isEditorActive = 0;
    } 
     
}

function submeterResposta()
{
    
    var resposta = $("#respostaText").Editor("getText");
    var respostaEncode = encodeURIComponent(resposta);
    var url = "SubmeterRespostaServlet";
    var parametros = "id="+idPergunta+"&resposta="+respostaEncode;
    xhrR.onreadystatechange = verificarResposta;
    
    try
    {
        xhrR.open("POST", url, true);
        alert(url);
        xhrR.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhrR.send(parametros); 
    }
    catch(e)
    {
        alert(e);
    }
}

function verificarResposta()
{
    if(xhrR.readyState==4)
    {
        var htmlTxt = xhrR.responseXML;
        alert(htmlTxt);
        var resposta = htmlTxt.getElementsByTagName("resposta");
        
        alert(resposta[0].childNodes[0].nodeValue);
        
        document.location.reload(true);
    }
    
}

function getRespostas()
{
    var url = "RespostasPerguntasServlet?id="+idPergunta;
    xhrRP.onreadystatechange = carregarRespostas;
    
    try
    {
        xhrRP.open("GET",url,true);
        xhrRP.send();
    }
    catch(e)
    {
        alert(e);
    }
    
}

function carregarRespostas()
{
    if(xhrRP.readyState==4)
    {
        var doc = xhrRP.responseXML;
        var respostas = doc.getElementsByTagName("resposta");
        var i=0;
        for(i=0;i<respostas.length;i++)
        {

            var usuario = respostas[i].getElementsByTagName("usuario")[0].childNodes[0].nodeValue
            var tituloPergunta = respostas[i].getElementsByTagName("usuario")[0].childNodes[0].nodeValue
            var data = respostas[i].getElementsByTagName("data")[0].childNodes[0].nodeValue
            var hora = respostas[i].getElementsByTagName("hora")[0].childNodes[0].nodeValue
            var descricao = respostas[i].getElementsByTagName("descricao")[0].childNodes[0].nodeValue

            var divR = document.createElement("div");
            var divComentario = document.createElement("div");
            var txtNomeUsuario = document.createTextNode("Por: ");
            var spanGlyphUsuario = document.createElement("span");
            var spanNomeUsuario = document.createElement("span");
            var spanGlyphData = document.createElement("span");
            var spanData = document.createElement("span");
            var spanGlyphHora = document.createElement("span");
            var spanHora = document.createElement("span");
            var divConteudoPergunta = document.createElement("div");

            //Atribuindo classes
            divR.className = "row col-sm-12";
            divComentario.className = "col-sm-12 comentarioHeader";
            divConteudoPergunta.className = "col-sm-12 comentarioContent";
            spanGlyphUsuario.className = "glyphicon glyphicon-user";
            spanGlyphData.className = "glyphicon glyphicon-calendar";
            spanGlyphHora.className = "glyphicon glyphicon-time";

            //Atribuindo ids
            spanNomeUsuario.id = "nomeUsuario";
            spanData.id = "dataPergunta";
            spanHora.id = "horaPergunta";
            divConteudoPergunta.id = "conteudoPergunta";

            //Atribuindo valores (textNode)
            spanNomeUsuario.textContent = usuario;
            spanData.textContent = data;
            spanHora.textContent = hora;
            divConteudoPergunta.innerHTML = descricao;

            //Construindo a árvore de elementos
            divR.appendChild(txtNomeUsuario);
            divR.appendChild(spanGlyphUsuario);
            divR.appendChild(spanNomeUsuario);
            divR.appendChild(spanGlyphData);
            divR.appendChild(spanData);
            divR.appendChild(spanGlyphHora);
            divR.appendChild(spanHora);

            document.getElementById("respostasContent").appendChild(divR);
            document.getElementById("respostasContent").appendChild(divConteudoPergunta);
            document.getElementById("respostasContent").style = "display: block;";

            realcarSintaxeLP();
            
        }
    }
    
    
    
}

function realcarSintaxeLP()
{
            $(document).ready(function() {
            $('pre code').each(function(i, block) {
              hljs.highlightBlock(block);
            });
          });
}

function inserirCodigo()
{
    $("#respostaText").Editor("setText", $("#respostaText").Editor("getText")+"<pre><code class='"+lpCode+"'>Digite seu código aqui</code></pre>");
}