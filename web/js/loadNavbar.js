var xhrNav = new XMLHttpRequest();

function carregarLinguagemProgramacaoNav()
{
    
    try
    {
        xhrNav.onreadystatechange=getInfoNav;
        
        xhrNav.open("GET","http://localhost:8080/Forum_Programador/LinguagemProgramacaoServlet",true);
        xhrNav.send();
        
    }
    catch(e)
    {
        alert(e);
    }
}

function getInfoNav()
{
    if(xhrNav.readyState==4)
    {
        var doc = xhrNav.responseXML;
        var lp = doc.getElementsByTagName("linguagem");
       
        var i=0;
        
        for(i=0;i<lp.length;i++)
        {
           var li = document.createElement("li");
           var a = document.createElement("a");
           a.setAttribute("href","perguntaLP.jsp?id="+lp[i].getElementsByTagName("id")[0].childNodes[0].nodeValue);
           a.textContent = lp[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue
           
           //adicionando estilo
           
           li.style = "color: #fff !important; background-color: #90ACD2;";
           a.style = " color: #fff !important;"
           li.appendChild(a);
           
           
           document.getElementById("menuLP").appendChild(li);
        }
        
    }
}