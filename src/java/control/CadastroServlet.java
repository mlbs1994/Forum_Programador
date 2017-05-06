/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.usuario.UsuarioDAO;
import persistence.usuario.UsuarioDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class CadastroServlet extends HttpServlet {


    UsuarioDAO usrDAO;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        
        try
        {  
            Usuario usr = new Usuario();
            usr.setNomeUsuario(request.getParameter("nome"));
            usr.setLogin(request.getParameter("login"));
            usr.setEmail(request.getParameter("email"));
            usr.setSenha(request.getParameter("senha"));
            if(request.getParameter("imgConta").equals(""))
            {
                usr.setImagem("imagens/user.png");
            }
            else
            {
                usr.setImagem("imagens/"+request.getParameter("imgConta"));
            }
            
            

            this.usrDAO = new UsuarioDAOImpl();
            this.usrDAO.cadastrarUsuario(usr);
            this.usrDAO.commitTransacao();
            //this.usrDAO.finalizarTransacao();
            
                response.sendRedirect("cadastroSucesso.html");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.println("<p>Erro no cadastro. Favor contate o administrador do sistema: matheuslevibarouh@gmail.com</p>");
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
