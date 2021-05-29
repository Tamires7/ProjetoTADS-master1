package dao;

import com.mysql.cj.jdbc.Driver;
import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class UsuarioDAO {

    private static final String SELECT_SQL = "SELECT * FROM lista_atividades.usuario";
    private static final String INSERT_SQL = "INSERT INTO lista_atividades.usuario (email,senha) VALUES (?,?)";
    private static final String UPDATE_SQL = "UPDATE lista_atividades.usuario SET email = ?, senha = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM lista_atividades.usuario WHERE id = ?";
    private static final String SELECT_EMAIL = "SELECT * FROM lista_atividades.usuario WHERE email = ?";
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = scanner.nextLine();

        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);

        inserirUsuario(u);

    }

    public static ArrayList<Usuario> buscarUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList();

        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stnt = c.prepareStatement(SELECT_SQL);

            ResultSet rs = stnt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Usuario u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);

                usuarios.add(u);

            }
            stnt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public static Usuario buscarUsuarioPorEmail (String email){
        
        Usuario u = null;
        
        try {
           Driver driver = new Driver(); 
           DriverManager.registerDriver(driver);
           
           Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             
           PreparedStatement stnt = c.prepareStatement(SELECT_EMAIL);
           
           stnt.setString(1, email);
           
           ResultSet rs = stnt.executeQuery();
           
           if (rs.next()){
               
               int id = rs.getInt("id");
               String senha = rs.getString("senha");
               
               u = new Usuario();
               u.setId(id);
               u.setEmail(email);
               u.setSenha(senha);
           }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    } 

    public static boolean inserirUsuario(Usuario u) {

        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stnt = c.prepareStatement(INSERT_SQL);

            stnt.setString(1, u.getEmail());
            stnt.setString(2, u.getSenha());

            int rowsAffected = stnt.executeUpdate();

            if (rowsAffected > 0) {
                sucesso = true;
            } else {
                sucesso = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public static boolean atualizarUsuario(Usuario u) {

        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stnt = c.prepareStatement(UPDATE_SQL);

            stnt.setString(1, u.getEmail());
            stnt.setString(2, u.getSenha());
            stnt.setInt(3, u.getId());

            int rowsAffected = stnt.executeUpdate();

            if (rowsAffected > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
        }
        return sucesso;
    }

    public static boolean deletarUsuario(Usuario u) {

        boolean sucesso = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stnt = c.prepareStatement(DELETE_SQL);

            stnt.setInt(1, u.getId());

            int rowsAffected = stnt.executeUpdate();

            if (rowsAffected > 0) {

                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;

    }
}
