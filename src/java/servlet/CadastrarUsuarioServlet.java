
package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;


@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      RequestDispatcher rd =  request.getRequestDispatcher("cadastrar_usuario.jsp");
      rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       //PROCESSAR O CADASTRO DO USUARIO
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
       
       Usuario u = new Usuario();
       u.setEmail(email);
       u.setSenha(senha);
       
      boolean inserido = UsuarioDAO.inserirUsuario(u);
      
      if(inserido){
         
        RequestDispatcher rd = request.getRequestDispatcher("cadastrar_sucesso.jsp");
        rd.forward(request, response);
      } else {
          
          RequestDispatcher rd = request.getRequestDispatcher("cadastrar_erro.jsp");
          rd.forward(request, response);
          
         
        }
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
