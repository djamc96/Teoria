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
public class Passo1 {

    public Passo1(Var v) {
        System.out.println("passo 1\n");
        DivLinhas(v);                                                           // Chama a função para quebrar o texto de entrada em linhas
        GerAlfabeto(v);
        GetEstados(v);
        Passo2 p2 = new Passo2(v);
    } 
      
    public void DivLinhas(Var v){
        try{
            String transições = "Transição 1 - Linhas lidas\n";
            String texto = v.getTxtArquivo();
            String[] linhas = texto.split("\n");
            v.setLinhas(linhas);
            //v.setTxtEntrada(v.getTxtArquivo());
            for(String l : linhas){
                transições += l + "\n";
            }
            transições += "----------------------------------------\n";
            v.setTxtSaida("");
            v.setTxtTransiçõoes(transições);
        }catch(Exception E){
       
        }
    }
    
    public void GerAlfabeto(Var v){
        Funcoes f = new Funcoes();
        String[] alfEnt;
        ArrayList alfSai = new ArrayList();
        String[] linhas =v.getLinhas();
        String texto = linhas[0];
        int ini = texto.indexOf('{');
        int fin = texto.indexOf('}');
        System.out.println(texto);
        texto = texto.substring(ini + 1, fin);
        String[] temp = texto.split(";");
        int tam = temp.length;
        tam = tam + 2;
        int tamBin = f.log_base2(tam);
        alfEnt = new String[tam];
        alfEnt[0] = "%";
        alfSai.add("a" + f.conv_dec_bin(0,tamBin));
        alfEnt[1] = ".";
        alfSai.add("a" + f.conv_dec_bin(1,tamBin));
        for(int i = 2; i < tam; i++){
            if(!temp[i-2].equals("#")){
                alfSai.add("a" + f.conv_dec_bin(i,tamBin));
                alfEnt[i] = temp[i-2];
            }
        }
        alfEnt[tam - 1] = "#";
        v.setAlfabetoEntrada(alfEnt);
        v.setAlfabetoSaida(alfSai);
        impAlfabeto(alfEnt, alfSai, v);
    }
    
    private void impAlfabeto(String alfEnt[],ArrayList alfSai, Var v){
        String temp = v.getTxtTransiçõoes();
        temp += "Alfabeto\n---------------------------------------\n";
        String ent[] = v.getAlfabetoEntrada();
        ArrayList sai = v.getAlfabetoSaida();
        for(int i = 0; i < ent.length; i++){
            if(!ent[i].equals("#"))      temp += ent[i] + "          -->        " + sai.get(i) + "\n";
        }
        temp += "#          -->         \n";
        temp += "\n";
        v.setTxtTransiçõoes(temp);
    }
    
    public void GetEstados(Var v){
        String[] estEnt = null;
        //ArrayList estSai = new ArrayList();
        String[] linhas =v.getLinhas();
        String texto = linhas[1];
        int ini = texto.indexOf('{');
        int fin = texto.indexOf('}');
        //System.out.println(texto);
        texto = texto.substring(ini+1, fin);
        String[] temp = texto.split(";");
        int tam = temp.length;
        //int tamBin = log_base2(tam);
        estEnt = new String[tam];
        for(int i = 0; i < tam; i++){
            //estSai.add("q" + conv_dec_bin(i,tamBin));
            estEnt[i] = temp[i];
        }
        v.setEstadosEntrada(estEnt);
        //v.setEstadosSaida(estSai);
        //impEstados(estEnt, estSai, v);
    }
    
    private void impEstados(String estEnt[],ArrayList estSai, Var v){
        String temp = v.getTxtTransiçõoes();
        temp += "Estados\n---------------------------------------\n";
        String ent[] = v.getEstadosEntrada();
        ArrayList sai = v.getEstadosSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "          -->        " + sai.get(i) + "\n";
        }
        temp += "\n";
        v.setTxtTransiçõoes(temp);
    }

}
