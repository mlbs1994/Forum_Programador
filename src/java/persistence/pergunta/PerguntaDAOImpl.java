/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.pergunta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.LinguagemProgramacao;
import model.Pergunta;
import model.Usuario;

/**
 *
 * @author Matheus Levi
 */
public class PerguntaDAOImpl implements PerguntaDAO
{

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public PerguntaDAOImpl()
    {
         try
        {
            this.emf = Persistence.createEntityManagerFactory("Forum_ProgramadorPU2");
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
    public void cadastrarPergunta(Pergunta p)
    {
        this.em.persist(p);
    }

    @Override
    public Pergunta getPergunta(Long id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarPergunta(Pergunta p)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerPergunta(Pergunta p)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntas()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntasPorUsuario(Usuario usr)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntasPorLinguagemProgramacao(LinguagemProgramacao lp)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getPerguntasPorPalavraChave(String plvr)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getPerguntasAvancado(List<String> campos, String plvr)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntasRecentes()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntasAbertas()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pergunta> getListaPerguntasResolvidas()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitTransacao()
    {
        this.et.commit();
    }

    @Override
    public void finalizarTransacao()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abortarTransacao()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
