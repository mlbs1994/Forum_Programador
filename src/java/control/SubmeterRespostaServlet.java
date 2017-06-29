/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pergunta;
import model.Resposta;
import model.Usuario;
import persistence.pergunta.PerguntaDAO;
import persistence.pergunta.PerguntaDAOImpl;
import persistence.resposta.RespostaDAO;
import persistence.resposta.RespostaDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class SubmeterRespostaServlet extends HttpServlet {

   
    RespostaDAO rDAO;
    PerguntaDAO pDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando");
        response.setContentType("text/xml;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
       
        try
        {
            HttpSession s = request.getSession(false);
            System.out.println("Criado sessão");
            this.rDAO = new RespostaDAOImpl();
            this.pDAO = new PerguntaDAOImpl();
            System.out.println("Criado DAOs");
            Usuario usr = (Usuario) s.getAttribute("usuario");
            System.out.println("id = "+request.getParameter("id"));
            System.out.println("resposta = "+request.getParameter("resposta"));
            Pergunta p = this.pDAO.getPergunta(Integer.parseInt(request.getParameter("id")));
            Date dataSubmissao = new Date();
            String descricao = request.getParameter("resposta");
            System.out.println("descricao: "+descricao);
                
            Resposta r = new Resposta();

            r.setIdUsuario(usr);
            r.setIdPergunta(p);
            r.setDataSubmissao(dataSubmissao);
            r.setDescricao(descricao);


            this.rDAO.cadastrarResposta(r);
            this.rDAO.commitTransacao();

            out.print("<respostaServidor>");
            out.print("<resposta>OK</resposta>");
            out.print("</respostaServidor>");
        }
        catch(Exception e)
        {
            out.print("<respostaServidor>");
            out.print("<resposta>Error</resposta>");
            out.print("</respostaServidor>");
            e.printStackTrace();
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
