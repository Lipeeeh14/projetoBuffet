/*
    Classe do Aluguel encapsulada
 */
package br.com.buffet.model;

public class Aluguel {
    private int id;
    private String nomeCliente;
    private String telCliente;
    private String endFesta;
    private String temaFesta;
    private String dtaFesta;
    private String horaInicio;
    private String horaTermino;
    
    // Construtores
    public Aluguel(){}

    public Aluguel(String nomeCliente, String telCliente, String endFesta, String temaFesta, String dtaFesta, String horaInicio, String horaTermino) {
        this.nomeCliente = nomeCliente;
        this.telCliente = telCliente;
        this.endFesta = endFesta;
        this.temaFesta = temaFesta;
        this.dtaFesta = dtaFesta;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }
    
    // Getters e Setters
    public int getId(){ 
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getEndFesta() {
        return endFesta;
    }

    public void setEndFesta(String endFesta) {
        this.endFesta = endFesta;
    }

    public String getTemaFesta() {
        return temaFesta;
    }
    
    public void setTemaFesta(String temaFesta) {
        this.temaFesta = temaFesta;
    }
    
    public String getDtaFesta() {
        return dtaFesta;
    }

    public void setDtaFesta(String dtaFesta) {
        this.dtaFesta = dtaFesta;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }
    
}
