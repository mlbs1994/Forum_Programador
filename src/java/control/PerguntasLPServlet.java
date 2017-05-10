package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LinguagemProgramacao;
import model.Pergunta;
import model.Usuario;
import persistence.linguagem_programacao.LinguagemProgramacaoDAO;
import persistence.linguagem_programacao.LinguagemProgramacaoDAOImpl;
import persistence.pergunta.PerguntaDAO;
import persistence.pergunta.PerguntaDAOImpl;

/**
 *
 * @author Matheus Levi
 */
public class PerguntasLPServlet extends HttpServlet {

    PerguntaDAO pDAO;
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
        
        HttpSession s = request.getSession(false);
        PrintWriter out = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        this.pDAO = new PerguntaDAOImpl();
        this.lpDAO = new LinguagemProgramacaoDAOImpl();
        
        Usuario usr = (Usuario) s.getAttribute("usuario");
        LinguagemProgramacao lp = this.lpDAO.getLinguagemProgramacao(id);
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        
        List<Pergunta> listaMinhasPerguntas = this.pDAO.getListaPerguntasPorLinguagemProgramacao(lp);
        
        out.println("<perguntas_usuario>");
        
        for(int i=0;i<listaMinhasPerguntas.size();i++)
        {
            out.println("<pergunta idLinguagemProgramacao='"+lp.getNome()+"'>");
            out.println("<id>"+listaMinhasPerguntas.get(i).getIdPergunta()+"</id>");
            out.println("<titulo>"+listaMinhasPerguntas.get(i).getTitulo()+"</titulo>");
            out.println("<data>"+sdf.format(listaMinhasPerguntas.get(i).getDataSubmissao())+"</data>");
            out.println("<respostas>"+listaMinhasPerguntas.get(i).getRespostaList().size()+"</respostas>");
            out.println("</pergunta>");
        }
        
        out.println("</perguntas_usuario>");
        
        
        
          
        
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