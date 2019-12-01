/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import java.util.ArrayList;

/**
 *
 * @author maiara
 */
public class Passo5 {

    public Passo5(Var v) {
        gerSaida(v);
    }
    
    public void gerSaida(Var v){
        ArrayList <maqEstados> maqE = v.getMaqE();
        String txtSaida = "";
        maqEstados temp = null;
        for(int i = 0; i < maqE.size(); i++){
            temp = maqE.get(i);
            txtSaida += "(" + 
                        temp.getEstAtual() + ";" +
                        temp.getLeitura()  + ";" +
                        temp.getProxEst()  + ";" +
                        temp.getEscrita()  + ";" +
                        temp.getMovimento()+ ")\n";
        }
        v.setTxtSaida(txtSaida);
    }
    
}
