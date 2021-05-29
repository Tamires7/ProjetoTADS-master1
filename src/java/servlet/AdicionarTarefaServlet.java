
package servlet;

import dao.AtividadeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Atividades;
import model.Usuario;


@WebServlet(name="AdicionarTarefaServlet", urlPatterns={"/AdicionarTarefaServlet"})
public class AdicionarTarefaServlet extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        Usuario u = (Usuario)session.getAttribute("usuarioLogado");
        
        String titulo = request.getParameter("titulo");
        
        Atividades t = new Atividades();
        t.setTitulo(titulo);
        t.setFinalizada(false);
        t.setIdUsuario(u.getId());
        
        boolean inserida = AtividadeDAO.inserirAtividades(t);
        
        if(inserida){
            
            request.setAttribute("msg", "Atividade inserida com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
            
        } else{
            
            request.setAttribute("msg", "Erro ao adicionar a Atividade");
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
