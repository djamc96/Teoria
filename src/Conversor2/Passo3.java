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
        Funcoes          f = new Funcoes();
        String   [] estEnt = v.getEstadosEntrada();
        String [][] matLei = v.getMatLei();
        String [][] matEsc = v.getMatEsc();
        String         txt = v.getTxtTransiçõoes();
        ArrayList <maqEstados> maqE = new ArrayList();
        
        for(int i = 0; i < matLei[0].length; i++){
            for(int j = 0; j < matLei[0].length; j++){
                if(matLei[i][j] != ""){
                    String[] temp = matLei[i][j].split(";");
                    for(int c = 0; c < temp.length; c++){
                        maqEstados mq = new maqEstados(estEnt[i], temp[c], estEnt[j], matEsc[i][j],' ');
                        maqE.add(mq);
                    }
                }
            }
        }
        txt += "\nTransições geradas apartir das matrizes\n";
        v.setTxtTransiçõoes(txt);
        f.impM(maqE, v);
        v.setMaqE(maqE);
    }
    
    public void contEst(Var v){
        ArrayList <maqEstados> maqE = v.getMaqE();
        String   [] estEnt = v.getEstadosEntrada();
        String [][] matLei = v.getMatLei();
        int      [] contEstAtual = new int[estEnt.length];
        int      [] contProxEst  = new int[estEnt.length];
        String txt = v.getTxtTransiçõoes();
        
        txt += "\nContagem de aparições nos estados\n\nEstado Atual            Proximo Estado\n";
        for(int i = 0; i < matLei[0].length; i++){
            contEstAtual[i] = contProxEst[i] = 0;
        }
        for(int i = 0; i < matLei[0].length; i++){
            for(int j = 0; j < matLei[0].length; j++){
                if(matLei[i][j] != ""){
                    contEstAtual[i]++;
                    contProxEst[j]++;
                }
            }
        }
        for(int i = 0; i < matLei[0].length; i++){
            txt +=  estEnt[i] + " = " + contEstAtual[i] + "      "+
                    estEnt[i] + " = " + contProxEst[i] + "\n";
        }
        v.setTxtTransiçõoes(txt);
        v.setContEstAtual(contEstAtual);
        v.setContProxEst(contProxEst);
    }
    
    public void defEst(Var v){
        int      [] contEstAtual = v.getContEstAtual();
        int      [] contProxEst  = v.getContProxEst();
        int           estInicial = -1;
        ArrayList estFinal = new ArrayList();
        String   [] estEnt = v.getEstadosEntrada();
        String txt = v.getTxtTransiçõoes();
        
        for(int i = 0; i < contEstAtual.length; i++){
            if(contEstAtual[i] == 1 && contProxEst[i] == 0) estInicial = i;
            if(contEstAtual[i] == 0)                        estFinal.add(i);
        }
        
        txt += "\nEstado Inicial\n" + estEnt[estInicial] + "\n";
        txt += "\nEstados Finais\n";
        for(int i = 0; i < estFinal.size(); i++){
            if(!estEnt[(int) estFinal.get(i)].equals("tmp"))  txt += estEnt[(int) estFinal.get(i)] + "\n";
        }
        txt += "\n";
        v.setTxtTransiçõoes(txt);
        v.setEstInicial(estInicial);
        v.setEstFinal(estFinal);
    }
}
