package persistence.artigo;

import java.util.List;
import model.Artigo;

/**
 *
 * @author Matheus Levi
 */
public interface ArtigoDAO
{
    public void cadastrarArtigo(Artigo a); //CREATE
    
    public Artigo getArtigo(Long id); //READ
    
    public void atualizarArtigo(Artigo a); //UPDATE
    
    public void removerArtigo(Artigo a); //DELETE
    
    public List<Artigo> getListaArtigos();
    
    public List<Artigo> getListaArtigosUsuario();
    
    
}
