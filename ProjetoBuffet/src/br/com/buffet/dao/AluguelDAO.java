/*
 */
package br.com.buffet.dao;

import br.com.buffet.model.Aluguel;
import br.com.buffet.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AluguelDAO {
    private Aluguel aluguel;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    // método construtor que chama a ConnectionFactory
    public AluguelDAO() throws Exception {
        try {
            conn = ConnectionFactory.getConnection(); 
        } catch(Exception e){
            throw new Exception("Erro: "+ e.getMessage());
        }    
    }
    
    public void salvar(Aluguel aluguel) throws Exception{
        try {
            String sql = "INSERT INTO ALUGUEL(NOME_CLIENTE, TEL_CLIENTE, END_FESTA, TEMA_FESTA, DTA_FESTA, HORA_INICIO, HORA_TERMINO) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, aluguel.getNomeCliente());
            ps.setString(2, aluguel.getTelCliente());
            ps.setString(3, aluguel.getEndFesta());
            ps.setString(4, aluguel.getTemaFesta());
            ps.setString(5, aluguel.getDtaFesta());
            ps.setString(6, aluguel.getHoraInicio());
            ps.setString(7, aluguel.getHoraTermino());
            ps.executeUpdate();
        } catch(Exception e) {
            throw new Exception("Erro ao salvar "+ e.getMessage());
        }    
    }
    
    public List consultarTodos() throws Exception{
        List<Aluguel> alugueis = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ALUGUEL";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){ // percorre cada registro
                Aluguel aluguel = new Aluguel();
                aluguel.setId(rs.getInt("ID"));
                aluguel.setNomeCliente(rs.getString("NOME_CLIENTE"));
                aluguel.setTelCliente(rs.getString("TEL_CLIENTE"));
                aluguel.setEndFesta(rs.getString("END_FESTA"));
                aluguel.setTemaFesta(rs.getString("TEMA_FESTA"));
                aluguel.setDtaFesta(rs.getString("DTA_FESTA"));
                aluguel.setHoraInicio(rs.getString("HORA_INICIO"));
                aluguel.setHoraTermino(rs.getString("HORA_TERMINO"));
                alugueis.add(aluguel);
            }
            return alugueis;
        } catch(Exception e){
            throw new Exception("Erro ao consultar todos "+ e.getMessage());
        }
    }
    
    public Aluguel consultar(int id) throws Exception {
        try {
            String sql = "SELECT * FROM ALUGUEL WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){ // Caso ache os dados no DB irá passa-los para o objeto
                aluguel = new Aluguel();
                aluguel.setId(id);
                aluguel.setNomeCliente(rs.getString("NOME_CLIENTE"));
                aluguel.setTelCliente(rs.getString("TEL_CLIENTE"));
                aluguel.setEndFesta(rs.getString("END_FESTA"));
                aluguel.setTemaFesta(rs.getString("TEMA_FESTA"));
                aluguel.setDtaFesta(rs.getString("DTA_FESTA"));
                aluguel.setHoraInicio(rs.getString("HORA_INICIO"));
                aluguel.setHoraTermino(rs.getString("HORA_TERMINO"));
            }
            return aluguel;
        } catch(Exception e){
            throw new Exception("Erro ao consultar "+ e.getMessage());
        }
    }   
    
    public List consultarPorData(String data) throws Exception {
        List<Aluguel> alugueis = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ALUGUEL WHERE DTA_FESTA = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();
            while(rs.next()){ // Caso ache os dados no DB irá passa-los para o objeto
                Aluguel aluguel = new Aluguel();
                aluguel.setId(rs.getInt("ID"));
                aluguel.setNomeCliente(rs.getString("NOME_CLIENTE"));
                aluguel.setTelCliente(rs.getString("TEL_CLIENTE"));
                aluguel.setEndFesta(rs.getString("END_FESTA"));
                aluguel.setTemaFesta(rs.getString("TEMA_FESTA"));
                aluguel.setDtaFesta(data);
                aluguel.setHoraInicio(rs.getString("HORA_INICIO"));
                aluguel.setHoraTermino(rs.getString("HORA_TERMINO"));
                alugueis.add(aluguel);
            }
            return alugueis;
        } catch(Exception e) {
            throw new Exception("Erro ao Consultar por Data "+ e.getMessage());
        }
    }    
    
    public void alterar(Aluguel aluguel) throws Exception{
        try {
            String sql = "UPDATE ALUGUEL SET NOME_CLIENTE = ?, TEL_CLIENTE = ?, END_FESTA = ?, TEMA_FESTA = ?, DTA_FESTA = ?, HORA_INICIO = ?, HORA_TERMINO = ? "
                    + "WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, aluguel.getNomeCliente());
            ps.setString(2, aluguel.getTelCliente());
            ps.setString(3, aluguel.getEndFesta());
            ps.setString(4, aluguel.getTemaFesta());
            ps.setString(5, aluguel.getDtaFesta());
            ps.setString(6, aluguel.getHoraInicio());
            ps.setString(7, aluguel.getHoraTermino());
            ps.setInt(8, aluguel.getId());
            ps.executeUpdate();
        } catch(Exception e){
            throw new Exception("Erro ao alterar "+ e.getMessage());
        }    
    }
    
    public void excluir(int id) throws Exception{
        try {
            String sql = "DELETE FROM ALUGUEL WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e){
            throw new Exception("Erro ao excluir "+ e.getMessage());
        }
    }
}
