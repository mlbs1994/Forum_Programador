function verificarSenha(alterar)
{
    var senha = document.getElementById("senhaHTML").value;
    var confirmSenha = document.getElementById("confirmarSenhaHTML").value;
    
    if(senha != confirmSenha)
    {
        alert("Senha confirmada não corresponde!");
    }
    else
    {
        document.getElementById("formAlterarCadastro").submit();
    }
    
    
}

function excluirConta()
{
    window.location = "excluirConta.jsp";
}

function srcImg()
{
    var imgSrc = document.getElementById("img").src = document.getElementById("avatar-1").value;
    var imgs = imgSrc.split("\\");
    var img = "imagens/"+imgs[2];

    document.getElementById("img").src = img;
 
}