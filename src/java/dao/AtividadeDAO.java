
package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Atividades;
import model.Usuario;


public class AtividadeDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    private static final String SELECT_BY_USER_ID_SQL = "SELECT * FROM lista_atividades.atividades WHERE id_usuario = ? ";
    private static final String INSERT_SQL 
            = "INSERT INTO lista_atividades.atividades(titulo, finalizada, id_usuario) VALUES(?, ?, ?)";
    
    private static final String UPDATE_SQL = "UPDATE lista_atividades.atividades SET finalizada = ? WHERE id = ? and id_usuario = ?";
    
    private static final String DELETE_SQL = "DELETE FROM lista_atividades.atividades WHERE id = ? and id_usuario = ?";
    
    public static ArrayList<Atividades> buscarAtividadesDoUsuario(Usuario u){
        
        ArrayList <Atividades> atividades = new ArrayList();
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
            
            PreparedStatement stnt = c.prepareStatement(SELECT_BY_USER_ID_SQL);
            stnt.setInt(1, u.getId());
            
            ResultSet rs = stnt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");
                
                Atividades t = new Atividades ();
                t.setId(id);
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setIdUsuario(u.getId());
                
                atividades.add(t);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividades;
    }
    
    public static boolean inserirAtividades(Atividades t){
        
        boolean sucesso = false;
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            PreparedStatement stnt = c.prepareStatement(INSERT_SQL);
            
            stnt.setString(1, t.getTitulo());
            stnt.setBoolean(2, t.isFinalizada());
            stnt.setInt(3,t.getIdUsuario());
            
            int rowsAffected = stnt.executeUpdate();
            
            sucesso = rowsAffected > 0 ;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    
    public static boolean finalizarAtividade (Atividades t){
        boolean sucesso = false;
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stnt = c.prepareStatement(UPDATE_SQL);
            
            stnt.setBoolean(1, true);
            stnt.setInt(2, t.getId());
            stnt.setInt(3, t.getIdUsuario());
            
            int rowsAffected = stnt.executeUpdate();
            
            sucesso = rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }
    
    public static boolean removerAtividades(Atividades t){
      boolean sucesso = false;
      
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            PreparedStatement stnt = c.prepareStatement(DELETE_SQL);
            
            stnt.setInt(1, t.getId());
            stnt.setInt(2, t.getIdUsuario());
            
            int rowsAffected = stnt.executeUpdate();
            
            sucesso = rowsAffected > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      return sucesso;
    }
}
