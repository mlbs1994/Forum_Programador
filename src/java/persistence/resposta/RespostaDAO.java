/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.resposta;

import java.util.List;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface RespostaDAO
{
    public void cadastrarResposta(Resposta r); //CREATE
    
    public Resposta getResposta(Integer id); //READ
    
    public void atualizarResposta(Resposta r); //UPDATE
    
    public void deletarResposta(Resposta r); //DELETE
    
    public void marcarMelhorResposta(Resposta r);
    
    public List<Resposta> getListaRespostas();
    
    public List<Resposta> getListaRespostasPorPergunta(Pergunta p);
    
    public List<Resposta> getListaRespostasPorUsuario(Usuario usr);
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
    
}
