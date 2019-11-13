/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor;

import javax.swing.JOptionPane;

/**
 *
 * @author anderson
 */
public class Conversor {
    
    
    public void DivLinhas(Variaveis var){
        try{
            String texto = var.getTxtArquivo();
            String[] linhas = texto.split("\n");
            var.setLinhas(linhas);
            var.setTxtEntrada(var.getTxtArquivo());
            var.setTxtSaida("");
        }catch(Exception E){
       
        }
    }
    
    public void GerAlfabeto(Variaveis var){
        String[] alfEnt, alfSai;
        String[] linhas =var.getLinhas();
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
        alfSai = new String[tam];
        alfEnt[0] = "%";
        alfSai[0] = "a" + conv_dec_bin(0,tamBin);
        alfEnt[1] = "$";
        alfSai[1] = "a" + conv_dec_bin(1,tamBin);
        for(int i = 2; i < tam; i++){
            alfSai[i] = "a" + conv_dec_bin(i,tamBin);
            alfEnt[i] = temp[i-2];
        }
        var.setAlfabetoEntrada(alfEnt);
        var.setAlfabetoSaida(alfSai);
        impAlfabeto(alfEnt, alfSai, var);
    }
    
    private void impAlfabeto(String alfEnt[],String alfSai[], Variaveis var){
        String temp = var.getTxtSaida();
        temp += "Alfabeto\n---------------------------------------\n";
        String ent[] = var.getAlfabetoEntrada();
        String sai[] = var.getAlfabetoSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "          -->        " + sai[i] + "\n";
        }
        temp += "\n";
        var.setTxtSaida(temp);
    }
    
    public void GerEstados(Variaveis var){
        String[] estEnt = null, estSai = null;
        String[] linhas =var.getLinhas();
        String texto = linhas[1];
        int ini = texto.indexOf('{');
        int fin = texto.indexOf('}');
        System.out.println(texto);
        texto = texto.substring(ini+1, fin);
        String[] temp = texto.split(";");
        int tam = temp.length;
        int tamBin = log_base2(tam);
        estEnt = new String[tam];
        estSai = new String[tam];
        for(int i = 0; i < tam; i++){
            estSai[i] = "q" + conv_dec_bin(i,tamBin);
            estEnt[i] = temp[i];
        }
        var.setEstadosEntrada(estEnt);
        var.setEstadosSaida(estSai);
        impEstados(estEnt, estSai, var);
    }
    
    private void impEstados(String estEnt[],String estSai[], Variaveis var){
        String temp = var.getTxtSaida();
        temp += "Estados\n---------------------------------------\n";
        String ent[] = var.getEstadosEntrada();
        String sai[] = var.getEstadosSaida();
        for(int i = 0; i < ent.length; i++){
            temp += ent[i] + "          -->        " + sai[i] + "\n";
        }
        temp += "\n";
        var.setTxtSaida(temp);
    }
    
    public void transicoes(Variaveis var){
        String saida = var.getTxtSaida();
        String transMT = "Transições\n---------------------------------------\n";
        String[] linhas = var.getLinhas();
        String[] estEnt = var.getEstadosEntrada();
        String[] estSai = var.getEstadosSaida();
        String[] alfEnt = var.getAlfabetoEntrada();
        String[] alfSai = var.getAlfabetoSaida();
        String escrita, leitura;
        int linha = 2;        
        while(true){
            if(linhas[linha].contains("{")) break;
            linha++;
        }
        linha++;
        while(true){
            if(linhas[linha].contains("}")) break;
            String[] temp = linhas[linha].split(";");
            String est_atual = temp[0];
            if(" ".equals(temp[1]))      leitura = "$";
            else                        leitura = temp[1];
            String prox_est = temp[2];
            if(" ".equals(temp[3]))      escrita = "%";
            else                        escrita = temp[3];
            /****************************************************************/
            transMT += "(";
            transMT += estSai[pos_entrada(estEnt, est_atual)] + " , ";
            transMT += alfSai[pos_entrada(alfEnt, leitura)] + " , ";
            transMT += estSai[pos_entrada(estEnt, prox_est)] + " , ";
            transMT += alfSai[pos_entrada(alfEnt, escrita)] + ") \n";
            linha++;
        }
        saida += transMT + "\n";
        var.setTxtSaida(saida);
    }
    
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
    
    private int pos_entrada(String txt[], String comp){
        int pos = -1;
        int tam = txt.length;
        int i;
        for(i = 0; i < tam; i++){
            if(comp.equals(txt[i]))  {pos = i;   break;}
        } 
        
        if(pos < 0)     {JOptionPane.showMessageDialog(null, "Arquivo de entrada com erro de sintaxe"); System.exit(0);}
        return pos;
    }
    
}
