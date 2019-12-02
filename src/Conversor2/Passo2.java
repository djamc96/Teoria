/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import javax.swing.JOptionPane;

/**
 *
 * @author casa
 */
public class Passo2 {
    
    
    public Passo2(Var v) {
        System.out.println("passo 2\n");
        gerMatrizes(v);
        convMatrizEntrada(v);
        Passo3 p3 = new Passo3(v);
    }
    
    public void gerMatrizes(Var v){
        String   [] estEnt = v.getEstadosEntrada();
        String [][] matLei = new String [estEnt.length][estEnt.length];
        String [][] matEsc = new String [estEnt.length][estEnt.length];
        //System.out.println(estEnt.length);
        for(int i = 0; i < estEnt.length; i++){
            for(int j = 0; j < estEnt.length; j++){
                matLei[i][j] = "";
                matEsc[i][j] = "%";
            }
        }
        v.setMatLei(matLei);
        v.setMatEsc(matEsc);
    }
    
    public void convMatrizEntrada(Var v){
        String   [] linhas = v.getLinhas();
        String   [] estEnt = v.getEstadosEntrada();
        String   [] temp;
        String [][] matLei = v.getMatLei();
        String [][] matEsc = v.getMatEsc();
        int linha = 2, posEstAtu, posProxEst; 
        String txt = "";
        posEstAtu = posProxEst = 0;
        
        Funcoes f = new Funcoes();
        while(true){
            if(linhas[linha].contains("{"))     break;
            linha++;
        }
        linha++;
        while(true){
            if(linhas[linha].contains("}"))     break;
            temp = linhas[linha].split(";");
            posEstAtu   = f.pos_entrada(estEnt, temp[0]);
            posProxEst  = f.pos_entrada(estEnt, temp[2]);
            if(matLei[posEstAtu][posProxEst] == "")     matLei[posEstAtu][posProxEst]  = temp[1] + ";";
            else                                        matLei[posEstAtu][posProxEst]  += temp[1] + ";";
            if(!temp[3].equals(" "))  matEsc[posEstAtu][posProxEst] = temp[3];
            linha++;
        }
        
        txt += "Matriz de Leitura\n";
        v.setTxtTransiçõoes(txt);
        f.impMatriz(matLei, v);
        txt = v.getTxtTransiçõoes();
        txt += "Matriz de Escrita\n";
        v.setTxtTransiçõoes(txt);
        f.impMatriz(matEsc, v);
        
        v.setMatEsc(matEsc);
        v.setMatLei(matLei);
    }
}
