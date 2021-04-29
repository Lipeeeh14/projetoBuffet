/*
 */
package br.com.buffet.dao;

import br.com.buffet.model.Login;
import br.com.buffet.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    private Login login;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    // Conecta ao DB
    public LoginDAO() throws Exception {
        try {
            conn = ConnectionFactory.getConnection(); // chama o método de conexão com o DB
        } catch(Exception e){
            throw new Exception("Erro "+ e.getMessage());
        }    
    }
    
    // Método de verificação do login
    public boolean checkLogin(String login, String senha) throws Exception{
        boolean check = false;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            
            if(rs.next()){
                check = true;
            }
        } catch(Exception e){
            throw new Exception("Erro ao verificar o Login: "+ e.getMessage());
        }   
        
        return check;
    }
}
