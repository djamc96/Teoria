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
        DivLinhas(v);                                                           // Chama a função para quebrar o texto de entrada em linhas
        
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
            v.setTxtSaida("");
            v.setTxtTransiçõoes(transições);
        }catch(Exception E){
       
        }
    }
    
    public void GerAlfabeto(Var v){
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
        int tamBin = log_base2(tam);
        alfEnt = new String[tam];
        alfEnt[0] = "%";
        alfSai.add("a" + conv_dec_bin(0,tamBin));
        alfEnt[1] = "$";
        alfSai.add("a" + conv_dec_bin(1,tamBin));
        for(int i = 2; i < tam; i++){
            alfSai.add("a" + conv_dec_bin(i,tamBin));
            alfEnt[i] = temp[i-2];
        }
        v.setAlfabetoEntrada(alfEnt);
        v.setAlfabetoSaida(alfSai);
        impAlfabeto(alfEnt, alfSai, v);
    }
    
    private void impAlfabeto(String alfEnt[],ArrayList alfSai, Var v){
        String temp = v.getTxtSaida();
        temp += "Alfabeto\n---------------------------------------\n";
        String ent[] = v.getAlfabetoEntrada();
        ArrayList sai = v.getAlfabetoSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "          -->        " + sai.get(i) + "\n";
        }
        temp += "\n";
        v.setTxtSaida(temp);
    }
    
    private void impEstados(String estEnt[],ArrayList estSai, Var v){
        String temp = v.getTxtSaida();
        temp += "Estados\n---------------------------------------\n";
        String ent[] = v.getEstadosEntrada();
        ArrayList sai = v.getEstadosSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "          -->        " + sai.get(i) + "\n";
        }
        temp += "\n";
        v.setTxtSaida(temp);
    }
    
    //Funções auxiliares
    
    //Função que recebe um numero e retorna seu logaritmo na base 2
    private int log_base2(int x){
        float r_float = (float) (Math.log(x) / Math.log(2));
        int r_int = (int) r_float;
        if((r_float - r_int) != 0) r_int++;
        return(r_int); 
    }
    
    //Conversor de decimal para binario
    private String conv_dec_bin(int num, int tam){
        String bin = "";
	while(num > 0){
	
		if(num % 2 == 0)    bin = "0" + bin;
		else                bin = "1" + bin;
			
		num /= 2;
	}
        while(bin.length() < tam){
            bin = "0" + bin;
        }
        return bin;
    }
}
