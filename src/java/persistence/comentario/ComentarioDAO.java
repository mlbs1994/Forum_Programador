/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.comentario;

import java.util.List;
import model.Artigo;
import model.Comentario;

/**
 *
 * @author Matheus Levi
 */
public interface ComentarioDAO 
{
    public void cadastrarComentario(Comentario c); //CREATE
    
    public Comentario getComentario(Long id);//READ
    
    public void atualizarComentario(Comentario c);//UPDATE
    
    public void removerComentario(Comentario c); //DELETE
    
    public List<Comentario> getListaComentarios();
    
    public List<Comentario> getListaComentariosArtigo(Artigo a);
    
}
