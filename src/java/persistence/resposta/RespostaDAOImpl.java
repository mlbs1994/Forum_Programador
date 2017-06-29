/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.resposta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Matheus Levi
 */
public class RespostaDAOImpl implements RespostaDAO
{

     EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public RespostaDAOImpl()
    {
         try
        {
            this.emf = Persistence.createEntityManagerFactory("Forum_ProgramadorPU3");
            this.em = emf.createEntityManager();
            this.et = em.getTransaction();
            this.et.begin();
        }
        catch(Exception e)
        {
            
            finalizarTransacao();
            System.err.print("Transação abortada - ROLLBACK");
            e.printStackTrace();
        }
    }
    
    @Override
    public void cadastrarResposta(Resposta r)
    {
        this.em.persist(r);
    }

    @Override
    public Resposta getResposta(Integer id)
    {
         return this.em.find(Resposta.class, id);
    }

    @Override
    public void atualizarResposta(Resposta r)
    {
        this.em.merge(r);
    }

    @Override
    public void deletarResposta(Resposta r) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resposta> getListaRespostas() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resposta> getListaRespostasPorPergunta(Pergunta p) 
    {
        Query q = this.em.createQuery("SELECT r FROM Resposta r WHERE r.idPergunta = :idPergunta");
        q.setParameter("idPergunta", p);
        q.setMaxResults(20);
           
        return q.getResultList();
    }

    @Override
    public List<Resposta> getListaRespostasPorUsuario(Usuario usr) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commitTransacao() {
        this.et.commit();
    }

    @Override
    public void finalizarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void marcarMelhorResposta(Resposta r)
    {
        r.setMelhorResposta(true);
        this.commitTransacao();
    }
    
}
