

<%@page import="dao.AtividadeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Atividades"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio | Lista de Atividades</title>
    </head>
    <body>
        <a>
            <% 
                
                Usuario u = (Usuario) session.getAttribute("usuarioLogado");
                
                if(u != null){
                
                out.print(u.getEmail());
                }
            %>
        </a>
    <a href="LogoutServlet">Sair da sessão</a>
    
    <hr>
    <form method="POST" action="AdicionarTarefaServlet">
        <p>
            <label>Titulo: </label>
            <input type="text" name="titulo" />
        </p>
        <p>
            <input type= "submit" value = "Adicionar Atividade"/>
        </p>
        <p>
            <% 
            
            String msg = (String) request.getAttribute("msg");
            if (msg != null){
                out.println(msg);
            }
            
            %>
        </p>
    </form>
    <hr>
    
        <h1>Pagina Inicial | Suas Atividades</h1>
        
        <p>
        <% 
           ArrayList<Atividades> atividades = AtividadeDAO.buscarAtividadesDoUsuario(u);
           
           if (atividades.isEmpty()){
               out.println("Não há atividades!");
           }
           
           for ( Atividades t : atividades){
               out.println("<p>"
                       + t.getTitulo() + "-" + t.isFinalizada()
                       + " <a href=\"FinalizarAtividadeServlet?id=" + t.getId() + "\">Finalizar</a>"
                       +  "<a href=\"ExcluirAtividadeServlet?id=" + t.getId() +"\"> Excluir</a>"      
                       + "</p>");
           }
           
        %>
        
        </p>
    </body>
</html>
