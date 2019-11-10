/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor;

/**
 *
 * @author anderson
 */
public class Variaveis {
    
    private String txtArquivo;
    private String txtEntrada;
    private String txtSaida;
    private String Alfabeto[];
    private String Estados[];
    private String Linhas[];

    public String[] getAlfabeto() {
        return Alfabeto;
    }

    public void setAlfabeto(String[] Alfabeto) {
        this.Alfabeto = Alfabeto;
    }

    public String[] getEstados() {
        return Estados;
    }

    public void setEstados(String[] Estados) {
        this.Estados = Estados;
    }

    public String[] getLinhas() {
        return Linhas;
    }

    public void setLinhas(String[] Linhas) {
        this.Linhas = Linhas;
    }

    public String getTxtArquivo() {
        return txtArquivo;
    }

    public void setTxtArquivo(String txtArquivo) {
        this.txtArquivo = txtArquivo;
    }

    public String getTxtEntrada() {
        return txtEntrada;
    }

    public void setTxtEntrada(String txtEntrada) {
        this.txtEntrada = txtEntrada;
    }

    public String getTxtSaida() {
        return txtSaida;
    }

    public void setTxtSaida(String txtSaida) {
        this.txtSaida = txtSaida;
    }
    
    
}
