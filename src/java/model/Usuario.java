
package model;

import java.util.ArrayList;

public class Usuario {
    
    private int id;
    private String email;
    private String senha;
    private ArrayList<Atividades> atividades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public ArrayList<Atividades> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividades> atividades) {
        this.atividades = atividades;
    }
    
}
