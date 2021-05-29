
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


@WebServlet(name="ExcluirAtividadeServlet", urlPatterns={"/ExcluirAtividadeServlet"})
public class ExcluirAtividadeServlet extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        Usuario u = (Usuario) session.getAttribute("usuarioLogado");
        
        String idAtividade = request.getParameter("id");
        int id = Integer.parseInt(idAtividade);
        
        Atividades t = new Atividades();
        t.setId(id);
        t.setIdUsuario(u.getId());
        
       boolean removido = AtividadeDAO.removerAtividades(t);
       
       if (removido) {
           
           request.setAttribute ("msg", "Tarefa removida com sucesso!");
           RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
           rd.forward(request, response);
           
       } else{
           
           request.setAttribute("msg", "Erro ao remover atividade");
           RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
           rd.forward(request, response);
       }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
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
