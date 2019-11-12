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
        var.setTxtEntrada(var.getTxtArquivo());
        var.setTxtSaida("");
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
        int tamBin = log_base2(tam);
        String[] alfEnt = null, alfSai = null;
        alfEnt[0] = "%";
        alfSai[0] = "a" + conv_dec_bin(0,tamBin);
        for(int i = 1; i < tam; i++){
            alfSai[i] = "a" + conv_dec_bin(i,tamBin);
            alfEnt[i] = temp[i];
        }
        var.setAlfabetoEntrada(alfEnt);
        var.setAlfabetoSaida(alfSai);
        impAlfabeto(alfEnt, alfSai, var);
    }
    
    private void impAlfabeto(String alfEnt[],String alfSai[], Variaveis var){
        String temp = var.getTxtSaida();
        temp += "Alfabeto\n";
        String ent[] = var.getAlfabetoEntrada();
        String sai[] = var.getAlfabetoSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "      -->        " + sai[i] + "\n";
        }
        temp += "\n";
        var.setTxtSaida(temp);
    }
    
    public void GerEstados(Variaveis var){
        String[] linhas =var.getLinhas();
        String texto = linhas[1];
        int ini = texto.indexOf('{');
        int fin = texto.indexOf('}');
        System.out.println(texto);
        texto = texto.substring(ini, fin);
        String[] temp = texto.split(";");
        int tam = temp.length;
        int tamBin = log_base2(tam);
        String[] estEnt = null, estSai = null;
        estEnt[0] = "%";
        estSai[0] = "q" + conv_dec_bin(0,tamBin);
        for(int i = 1; i < tam; i++){
            estSai[i] = "q" + conv_dec_bin(i,tamBin);
            estEnt[i] = temp[i];
        }
        var.setEstadosEntrada(estEnt);
        var.setEstadosSaida(estSai);
        impAlfabeto(estEnt, estSai, var);
    }
    
    private void impEstados(String estEnt[],String estSai[], Variaveis var){
        String temp = var.getTxtSaida();
        temp += "Estados\n";
        String ent[] = var.getEstadosEntrada();
        String sai[] = var.getEstadosSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "      -->        " + sai[i] + "\n";
        }
        temp += "\n";
        var.setTxtSaida(temp);
    }
    
    public void transicoes(Variaveis var){
        String[] linhas =var.getLinhas();
        int linha = 2;        
        while(true){
            if(linhas[linha].contains("{")) break;
            linha++;
        }
        while(true){
            if(linhas[linha].contains("}")) break;
            String[] temp = linhas[linha].split(";");
            String estatual  
            
        }
    }
    
    //Função que recebe um numero e retorna seu logaritmo na base 2
    private int log_base2(int x){
        return(int) (Math.log(x) / Math.log(2));
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
    
    private int pos_entrada(String txt[], String comp){
        int pos = -1;
        int tam = txt.length;
        for(int i = 0; i < tam; i++){
            if(txt[i] == comp)  {pos = i;   break;}
        } 
        if
    }
    
}
