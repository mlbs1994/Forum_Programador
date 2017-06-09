/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LinguagemProgramacao;
import persistence.linguagem_programacao.LinguagemProgramacaoDAO;
import persistence.linguagem_programacao.LinguagemProgramacaoDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class LinguagemProgramacaoServlet extends HttpServlet {

    LinguagemProgramacaoDAO lpDAO;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        
        this.lpDAO = new LinguagemProgramacaoDAOImpl();
        
        List<LinguagemProgramacao> listaLinguagemProg = this.lpDAO.getListaLinguagemProgramacao();
        
        PrintWriter out = response.getWriter();
        
        out.println("<linguagens>");
        
        for(int i=0;i<listaLinguagemProg.size();i++)
        {
            out.println("<linguagem>");
            out.println("<id>"+listaLinguagemProg.get(i).getIdLinguagemProgramacao()+"</id>");
            out.println("<nome>"+listaLinguagemProg.get(i).getNome()+"</nome>");
            out.println("<codigoRS>"+listaLinguagemProg.get(i).getCodeRealceSintaxe()+"</codigoRS>");
            out.println("</linguagem>");
        }
        
        out.println("</linguagens>");
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
