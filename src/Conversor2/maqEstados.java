/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

/**
 *
 * @author anderson
 */
public class maqEstados {
    
    private String  estAtual;
    private String  proxEst;
    private String  leitura;
    private String  escrita;
    private char    movimento;

    public maqEstados(String estAtual, String leitura, String proxEst, String escrita, char movimento) {
        this.estAtual = estAtual;
        this.proxEst = proxEst;
        this.leitura = leitura;
        this.escrita = escrita;
        this.movimento = movimento;
    }

    public String getEstAtual() {
        return estAtual;
    }

    public void setEstAtual(String estAtual) {
        this.estAtual = estAtual;
    }

    public String getProxEst() {
        return proxEst;
    }

    public void setProxEst(String proxEst) {
        this.proxEst = proxEst;
    }

    public String getLeitura() {
        return leitura;
    }

    public void setLeitura(String leitura) {
        this.leitura = leitura;
    }

    public String getEscrita() {
        return escrita;
    }

    public void setEscrita(String escrita) {
        this.escrita = escrita;
    }

    public char getMovimento() {
        return movimento;
    }

    public void setMovimento(char movimento) {
        this.movimento = movimento;
    }
    
}
