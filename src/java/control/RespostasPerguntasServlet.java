/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Resposta;
import persistence.pergunta.PerguntaDAO;
import persistence.pergunta.PerguntaDAOImpl;
import persistence.resposta.RespostaDAO;
import persistence.resposta.RespostaDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class RespostasPerguntasServlet extends HttpServlet {


    RespostaDAO rDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/xml;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        
        int idPergunta = Integer.parseInt(request.getParameter("id"));
        
        this.rDAO = new RespostaDAOImpl();
        
        List<Resposta> listaRespostas = new ArrayList<Resposta>();
        
        listaRespostas = rDAO.getListaRespostasPorPergunta(
                    new PerguntaDAOImpl().getPergunta(idPergunta));
        
        out.println("<respostas idPergunta='"+idPergunta+"'>");
        
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat dataf = new SimpleDateFormat(DATE_FORMAT);
        
        String HOUR_FORMAT = "HH:mm";
        SimpleDateFormat hourf = new SimpleDateFormat(HOUR_FORMAT);
        
        for(int i=0;i<listaRespostas.size();i++)
        {
            out.println("<resposta>");
            out.println("<id>"+listaRespostas.get(i).getIdResposta()+"</id>");
            out.println("<usuario id='"+listaRespostas.get(i).getIdUsuario().getIdUsuario()+"'>"+
                    listaRespostas.get(i).getIdUsuario().getNomeUsuario()+"</usuario>");
            out.println("<tituloPergunta idUsuario='"+listaRespostas.get(i).getIdPergunta().
                    getIdUsuario().getIdUsuario()+"'>"+listaRespostas.get(i).getIdPergunta().
                            getTitulo()+
                    "</tituloPergunta>");
            out.println("<data>"+dataf.format(listaRespostas.get(i).getDataSubmissao())+"</data>");
            out.println("<hora>"+hourf.format(listaRespostas.get(i).getDataSubmissao())+"</hora>");
            out.println("<descricao><![CDATA["+listaRespostas.get(i).getDescricao()+"]]></descricao>");
            out.println("<melhorResposta>"+listaRespostas.get(i).getMelhorResposta()+"</melhorResposta>");
            out.println("<numLikes>"+listaRespostas.get(i).getNumLikes()+"</numLikes>");
            out.println("</resposta>");
        }
        
        out.println("</respostas>");
        
        
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
