/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.linguagem_programacao;

import java.util.List;
import model.LinguagemProgramacao;
import model.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface LinguagemProgramacaoDAO
{
    public void cadastrarLinguagemProgramacao(LinguagemProgramacao p); //CREATE
    
    public LinguagemProgramacao getLinguagemProgramacao(Integer id); //READ
    
    public void atualizarLinguagemProgramacao(LinguagemProgramacao p); //UPDATE
    
    public void removerLinguagemProgramacao(LinguagemProgramacao p); //DELETE
    
    public List<LinguagemProgramacao> getListaLinguagemProgramacao(); //Retornar todas as perguntas
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
