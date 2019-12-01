/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import java.util.ArrayList;

/**
 *
 * @author anderson
 */
public class Passo3 {
    
    public Passo3(Var v) {
        System.out.println("passo 3\n");
        this.matrizTransEnt(v);
        this.contEst(v);
        this.defEst(v);
        Passo4 p4 = new Passo4(v);
    }
    
    public void matrizTransEnt(Var v){
        String   [] estEnt = v.getEstadosEntrada();
        String [][] matLei = v.getMatLei();
        String [][] matEsc = v.getMatEsc();
        ArrayList <maqEstados> maqE = new ArrayList();
        for(int i = 0; i < matLei[0].length; i++){
            for(int j = 0; j < matLei[0].length; j++){
                if(matLei[i][j] != ""){
                    String[] temp = matLei[i][j].split(";");
                    for(int c = 0; c < temp.length; c++){
                        if(matEsc[i][j] != " ") maqEstados mq = new maqEstados(estEnt[i], temp[c], estEnt[j], matEsc[i][j],' ');
                        maqE.add(mq);
                    }
                }
            }
        }
        v.impMatriz(matEsc);
        v.impMatriz(matLei);
        v.setMaqE(maqE);
    }
    
    public void contEst(Var v){
        ArrayList <maqEstados> maqE = v.getMaqE();
        String   [] estEnt = v.getEstadosEntrada();
        String [][] matLei = v.getMatLei();
        int      [] contEstAtual = new int[estEnt.length];
        int      [] contProxEst  = new int[estEnt.length];
        for(int i = 0; i < matLei[0].length; i++){
            contEstAtual[i] = contProxEst[i] = 0;
        }
        for(int i = 0; i < matLei[0].length; i++){
            for(int j = 0; j < matLei[0].length; j++){
                if(matLei[i][j] != ""){
                    contEstAtual[i]++;
                }
            }
        }
        v.setContEstAtual(contEstAtual);
        v.setContProxEst(contProxEst);
    }
    
    public void defEst(Var v){
        int      [] contEstAtual = v.getContEstAtual();
        int      [] contProxEst  = v.getContProxEst();
        int           estInicial = -1;
        ArrayList estFinal = new ArrayList();
        for(int i = 0; i < contEstAtual.length; i++){
            if(contEstAtual[i] == 1 && contProxEst[i] == 0) estInicial = i;
            if(contEstAtual[i] == 0)                        estFinal.add(i);
        }
        v.setEstInicial(estInicial);
        v.setEstFinal(estFinal);
    }
}
