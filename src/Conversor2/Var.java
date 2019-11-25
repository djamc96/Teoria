/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import java.util.ArrayList;

/**
 *
 * @author casa
 */
public class Var {
    
    private String txtArquivo;                                                  //String com o texto lido do txt
    //private String txtEntrada;                                                  //
    private String txtTransiçõoes;                                              //String que contem o passo a passo das transições de conversão
    private String txtSaida;                                                    //String contendo o resultado final da conversão
    private String AlfabetoEntrada[];                                           //Alfabeto que contem no txt lido
    private ArrayList AlfabetoSaida = new ArrayList();
    //private String AlfabetoSaida[];                                             //Alfabeto gerado apartir da entrada    
    private String EstadosEntrada[];                                            //Estados que contem no txt lido
    private ArrayList EstadosSaida = new ArrayList();

    public ArrayList getAlfabetoSaida() {
        return AlfabetoSaida;
    }

    public void setAlfabetoSaida(ArrayList AlfabetoSaida) {
        this.AlfabetoSaida = AlfabetoSaida;
    }

    public ArrayList getEstadosSaida() {
        return EstadosSaida;
    }

    public void setEstadosSaida(ArrayList EstadosSaida) {
        this.EstadosSaida = EstadosSaida;
    }
    
    private String Linhas[];

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

    public String getTxtTransiçõoes() {
        return txtTransiçõoes;
    }

    public void setTxtTransiçõoes(String txtTransiçõoes) {
        this.txtTransiçõoes = txtTransiçõoes;
    }

    public String getTxtSaida() {
        return txtSaida;
    }

    public void setTxtSaida(String txtSaida) {
        this.txtSaida = txtSaida;
    }

    public String[] getAlfabetoEntrada() {
        return AlfabetoEntrada;
    }

    public void setAlfabetoEntrada(String[] AlfabetoEntrada) {
        this.AlfabetoEntrada = AlfabetoEntrada;
    }

    public String[] getEstadosEntrada() {
        return EstadosEntrada;
    }

    public void setEstadosEntrada(String[] EstadosEntrada) {
        this.EstadosEntrada = EstadosEntrada;
    }
    
    
}
