/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.usuario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO
{
    
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    public UsuarioDAOImpl()
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
    public void cadastrarUsuario(Usuario usr)
    {
        this.em.persist(usr);
    }

    @Override
    public Usuario getUsuario(Long id)
    {
        return em.find(Usuario.class, id);
    }

    @Override
    public void atualizarUsuario(Usuario usr)
    {
        this.em.merge(usr);
    }

    @Override
    public void removerUsuario(Usuario usr)
    {
        usr = this.em.merge(usr);
        this.em.remove(usr);
    }

    @Override
    public List<Usuario> getListaUsuarios()
    {
        return this.em.createQuery("SELECT u from Usuario u", Usuario.class).getResultList();
    }
    
   

    @Override
    public void finalizarTransacao()
    {
        if (em != null)
        {
            em.close();
        }
        if (emf != null)
        {
            emf.close();
        }
    }

    @Override
    public void commitTransacao()
    {
        this.et.commit();
    }

    @Override
    public void abortarTransacao()
    {
        if (this.et != null)
        {
            this.et.rollback();
        }
        if (em != null)
        {
            em.close();
        }
        if (emf != null)
        {
            emf.close();
        }
    }

    @Override
    public Usuario autenticarUsuario(String login, String senha) 
    {
   
       Usuario usuario = null;
       Query q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
       q.setParameter("login", login);
       q.setParameter("senha", senha);
       List<Usuario> usr =  q.getResultList();
       
       if(!(usr.isEmpty()))
       {
           usuario = usr.get(0);
       }
       
       
       if(usuario==null)
       {
           System.out.print("FALSE");
       }
       else
       {
           System.out.print("TRUE");
       }
       
       return usuario;
    
    }
    
}
