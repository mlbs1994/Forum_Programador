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
    var c = confirm("Deseja realmente excluir a sua conta?");
    
    if(c==true)
    {
        window.location = "http://localhost:8080/Forum_Programador/ExcluirContaServlet";
    }  
}