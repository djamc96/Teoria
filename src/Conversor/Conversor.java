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
public class Conversor {
    
    
    public void DivLinhas(Variaveis var){
        String texto = var.getTxtArquivo();
        String[] linhas = texto.split("\n");
        var.setLinhas(linhas);
    }
    
    public void GerAlfabeto(Variaveis var){
        String[] linhas =var.getLinhas();
        String texto = linhas[0];
        int ini = texto.indexOf('{');
        int fin = texto.indexOf('}');
        System.out.println(texto);
        texto = texto.substring(ini, fin);
        String[] temp = texto.split(";");
        int tam = temp.length;
        String[] alfEnt, alfSai;
        alfEnt[0] = "%";
        alfSai[0] = 
        for(int i = 1; i < tam; i++){
            estSai[i] = "" 
        }
    }
    
    public void GerEstados(Variaveis var){
        
    }
    
}
