/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.linguagem_programacao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.LinguagemProgramacao;

/**
 *
 * @author Matheus Levi
 */
public class LinguagemProgramacaoDAOImpl implements LinguagemProgramacaoDAO
{
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public LinguagemProgramacaoDAOImpl()
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
    public void cadastrarLinguagemProgramacao(LinguagemProgramacao p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinguagemProgramacao getLinguagemProgramacao(Integer id) {
            return this.em.find(LinguagemProgramacao.class, id);
    }

    @Override
    public void atualizarLinguagemProgramacao(LinguagemProgramacao p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerLinguagemProgramacao(LinguagemProgramacao p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LinguagemProgramacao> getListaLinguagemProgramacao() 
    {
        return this.em.createQuery("SELECT lp from LinguagemProgramacao lp", LinguagemProgramacao.class).getResultList();
    }

    @Override
    public void commitTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finalizarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
