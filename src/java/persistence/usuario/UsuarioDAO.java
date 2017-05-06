/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.usuario;

import java.util.List;
import model.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface UsuarioDAO
{
    public void cadastrarUsuario(Usuario usr); //CREATE
    
    public Usuario getUsuario(Long id); // READ
    
    public void atualizarUsuario(Usuario usr); // UPDATE
    
    public void removerUsuario(Usuario usr); // DELETE
    
    public List<Usuario> getListaUsuarios();
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
    
    public Usuario autenticarUsuario(String login, String senha);
    
    
}
