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
        convSaida(v);
        gerSaida(v);
    }
    
    public void convSaida(Var v){
        ArrayList <maqEstados>  maqE        = v.getMaqE();
        ArrayList <maqEstados>  maqETemp    = new <maqEstados> ArrayList();
        ArrayList               alfSaida    = v.getAlfabetoSaida();
        ArrayList               estSaida    = v.getEstadosSaida();
        String                  alfEnt[]    = v.getAlfabetoEntrada();
        String                  estEnt[]    = v.getEstadosEntrada();
        maqEstados              tmp;
        int tam = maqE.size();
        Funcoes f = new Funcoes();
        
        maqETemp.clear();
        for(int i = 0; i < tam; i++){
            tmp = maqE.get(i);
            //System.out.println(tmp.getLeitura() + ";" + tmp.getEstAtual() + ";" + tmp.getEscrita() + ';' + tmp.getProxEst() + ";" + tmp.getMovimento());
            tmp.setEstAtual((String) estSaida.get(f.pos_entrada(estEnt, tmp.getEstAtual())));
            tmp.setLeitura((String) alfSaida.get(f.pos_entrada(alfEnt, tmp.getLeitura())));
            tmp.setProxEst((String) estSaida.get(f.pos_entrada(estEnt, tmp.getProxEst())));
            tmp.setEscrita((String) alfSaida.get(f.pos_entrada(alfEnt, tmp.getEscrita())));
            //System.out.println(tmp.getLeitura() + ";" + tmp.getEstAtual() + ";" + tmp.getEscrita() + ';' + tmp.getProxEst() + ";" + tmp.getMovimento());
            maqETemp.add(tmp);
        }
        maqE.clear();
        maqE.addAll(maqETemp);
    }
    
    public void gerSaida(Var v){
        ArrayList <maqEstados>    maqE = v.getMaqE();
        String               [] estEnt = v.getEstadosEntrada();
        ArrayList             estSaida = v.getEstadosSaida();
        String               [] alfEnt = v.getAlfabetoEntrada();
        ArrayList             alfSaida = v.getAlfabetoSaida();
        String txtSaida = "";
        maqEstados temp = null;
        
        txtSaida += "Alfabeto\n\n";
        for(int i = 0; i < alfSaida.size();i++){
            txtSaida += alfEnt[i] + "  =>  " + (String) alfSaida.get(i) + "\n";
        }
        txtSaida += alfEnt[alfSaida.size()] + "  =>  \n";
        
        txtSaida += "\nEstados\n\n";
        for(int i = 0; i < estSaida.size();i++){
            txtSaida += estEnt[i] + "  =>  " + (String) estSaida.get(i) + "\n";
        }
        
        txtSaida += "\nTransições\n\n";
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
