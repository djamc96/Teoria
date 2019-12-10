/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author casa
 */
public class Funcoes {
    
    //Função que recebe um numero e retorna seu logaritmo na base 2
    public int log_base2(int x){
        float r_float = (float) (Math.log(x) / Math.log(2));
        int r_int = (int) r_float;
        if((r_float - r_int) != 0) r_int++;
        return(r_int); 
    }
    
    //Conversor de decimal para binario
    public String conv_dec_bin(int num, int tam){
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
    
    public boolean estFinal(ArrayList estF, String EstadosEntrada[], String comp){
        boolean test = false;
        for(int i = 0; i < estF.size(); i++){
            //System.out.println(estF.get(i) + " " + estF.size());
            if(estF.get(i).equals(pos_entrada(EstadosEntrada, comp))){
                test = true;
                break;
            }
        }
        return test;
    }
    
    
    public maqEstados pesqMaqE(ArrayList <maqEstados> maqE, String comp){
        maqEstados temp = null;
        for(int i = 0; i < maqE.size(); i++){
            temp = maqE.get(i);
            if(temp.getEstAtual().equals(comp))  break;
        }
        
        return temp;
    }
    
    public int pos_entrada(String txt[], String comp){
        int pos = -1;
        int tam = txt.length;
        int i;
        for(i = 0; i < tam; i++){
            if(comp.equals(txt[i]))  {pos = i;   break;}
        } 
        
        if(pos < 0)     {JOptionPane.showMessageDialog(null, "Arquivo de entrada com erro de sintaxe"); System.exit(0);}
        return pos;
    }
    
    public void impMatriz(String m[][], Var v){
        String txt = v.getTxtTransiçõoes();
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                txt += m[i][j] + " | ";
            }
            txt += "\n";
        }
        v.setTxtTransiçõoes(txt);
    }
    
    public void impM(ArrayList <maqEstados> maqE, Var v){
        String txt = v.getTxtTransiçõoes();
        maqEstados temp;
        for(int i = 0; i < maqE.size(); i++){
            temp = maqE.get(i);
            txt +=  temp.getEstAtual()  + " | " +
                    temp.getLeitura()   + " | " +
                    temp.getProxEst()   + " | " +
                    temp.getEscrita()   + " | " +
                    temp.getMovimento() + "\n";
        }
        txt += "\n";
        v.setTxtTransiçõoes(txt);
    }
}
