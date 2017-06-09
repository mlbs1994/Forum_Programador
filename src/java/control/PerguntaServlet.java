/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pergunta;
import persistence.pergunta.PerguntaDAO;
import persistence.pergunta.PerguntaDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class PerguntaServlet extends HttpServlet {

   
    PerguntaDAO pDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out = response.getWriter();
           
        String id = request.getParameter("id");
        
        this.pDAO = new PerguntaDAOImpl();
        Pergunta p = this.pDAO.getPergunta(Integer.parseInt(id));
        
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat dataf = new SimpleDateFormat(DATE_FORMAT);
        
        String HOUR_FORMAT = "HH:mm";
        SimpleDateFormat hourf = new SimpleDateFormat(HOUR_FORMAT);
        
        out.println("<pergunta>");
            out.println("<id>"+p.getIdPergunta()+"</id>");
            out.println("<login>"+p.getIdUsuario().getLogin()+"</login>");
            out.println("<linguagem_programacao>"+p.getIdLinguagemProgramacao().getNome()+"</linguagem_programacao>");
            out.println("<data>"+dataf.format(p.getDataSubmissao())+"</data>");
            out.println("<hora>"+hourf.format(p.getDataSubmissao())+"</hora>");
            out.println("<titulo>"+p.getTitulo()+"</titulo>");
            out.println("<descricao><![CDATA["+p.getDescricao()+"]]></descricao>");
        out.println("</pergunta>");
        
        
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
