/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.pergunta;

import java.util.List;
import model.LinguagemProgramacao;
import model.Pergunta;
import model.Usuario;


public interface PerguntaDAO
{
    public void cadastrarPergunta(Pergunta p); //CREATE
    
    public Pergunta getPergunta(Long id); //READ
    
    public void atualizarPergunta(Pergunta p); //UPDATE
    
    public void removerPergunta(Pergunta p); //DELETE
    
    public List<Pergunta> getListaPerguntas(); //Retornar todas as perguntas
    
    public List<Pergunta> getListaPerguntasPorUsuario(Usuario usr); //Retorna as perguntas de um usuário
    
    public List<Pergunta> getListaPerguntasPorLinguagemProgramacao(LinguagemProgramacao lp); //Retorna as perguntas associadas a uma linguagem de programação específica
    
    public List<Pergunta> getPerguntasPorPalavraChave(String plvr); //Retorna lista de perguntas por palavra chave
    
    public List<Pergunta> getPerguntasAvancado(List<String> campos, String plvr); //Retorna lista de perguntas por busca avançada (campos selecionados + palavra chave)
    
    public List<Pergunta> getListaPerguntasRecentes(); //Retorna lista de perguntas recentes
     
    public List<Pergunta> getListaPerguntasAbertas(); //Retorna lista de perguntas abertas
    
    public List<Pergunta> getListaPerguntasResolvidas(); //Retorna lista de perguntas resolvidas
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
    
    
}
