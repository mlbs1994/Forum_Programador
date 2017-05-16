var xhr = new XMLHttpRequest();

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
        
        xhr.open("GET","https://localhost:8443/Forum_Programador/LinguagemProgramacaoServlet",true);
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