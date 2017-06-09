var xhr = new XMLHttpRequest();
var xhrCLP;

function submeterPergunta()
{
    var editorTextValue = $("#comentario").Editor("getText");
    
    document.getElementById("comentario").value = editorTextValue;
    
    document.getElementById("formSubmeterPergunta").submit();
}

function carregarLinguagemProgramacao()
{
    
    try
    {
        xhr.onreadystatechange=getInfo;
        
        xhr.open("GET","LinguagemProgramacaoServlet",true);
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
        var doc = xhr.responseXML;
        var lp = doc.getElementsByTagName("linguagem");
       
        var i=0;
        
        for(i=0;i<lp.length;i++)
        {
           var option = document.createElement("option");
           option.value = lp[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
           option.textContent = lp[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue
           
           document.getElementById("selectLP").appendChild(option);
        }
        
    }
}

function inserirCodigo()
{
    xhrCLP = new XMLHttpRequest();
    
    var lp = document.getElementById("selectLP").value;
    alert(lp);
    var url = "codeRSLPServlet?id="+lp;
    
    xhrCLP.onreadystatechange=selecionarLP;
    
    try
    {
        xhrCLP.open("GET", url, true);
        xhrCLP.send();
    }
    catch(e)
    {
        alert(e);
    }
    
}

function selecionarLP()
{
    if(xhrCLP.readyState==4)
    {
        var doc = xhrCLP.responseXML;
        var codigoLPNode = doc.getElementsByTagName("codigo");
        var codigoLP = codigoLPNode[0].childNodes[0].nodeValue;
        
        $("#comentario").Editor("setText", $("#comentario").Editor("getText")+"<pre><code class='"+codigoLP+"'>Digite seu código aqui</code></pre>");
        
        xhrCLP = null;
    }
}