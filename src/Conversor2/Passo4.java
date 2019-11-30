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
 * @author anderson
 */
public class Passo4 {

    public Passo4(Var v) {
        
    }
    
    public void simpEst(Var v){
        ArrayList <maqEstados> maqE = v.getMaqE();
        ArrayList <maqEstados> maqESimp = v.getMaqE();
        String   [] estEnt = v.getEstadosEntrada();
        int contEstAtual[] = v.getContEstAtual();
        int  contProxEst[] = v.getContProxEst();
        
        maqEstados trans, temp;
        for(int i = 0; i < maqE.size(); i++){
            trans = maqE.get(i);
            if(contEstAtual[pos_entrada(estEnt, trans.getProxEst())] == 1){
                temp = pesqMaqE(maqE, trans.getProxEst());
                if(temp.getLeitura() == " "){
                    trans.setProxEst(temp.getProxEst());
                    trans.setEscrita(temp.getEscrita());
                }
                maqESimp.add(trans);
            } else{
                maqESimp.add(trans);
            }
        }
        
        for(int i = 0; i < maqESimp.size(); i++){
            trans = maqESimp.remove(i);
            if(estFinal(maqE, estEnt, trans.getProxEst())){
                trans.setEscrita(trans.getLeitura());
                trans.setMovimento('f');
            } else{
                trans.setMovimento('d');
                if(trans.getEscrita() == " ")   trans.setEscrita(".");
            }
            maqESimp.add(trans);
        }
        
        for(int i = 0; i < maqESimp.size(); i++){
            trans = maqESimp.remove(i);
            if((trans.getLeitura() == "#") && (trans.getEscrita() == "#"))
        }
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
    
    private maqEstados pesqMaqE(ArrayList <maqEstados> maqE, String comp){
        
        maqEstados temp = null;
        for(int i = 0; i < maqE.size(); i++){
            temp = maqE.get(i);
            if(temp.getEstAtual().equals(comp))  break;
        }
        
        return temp;
    } 
    
    private boolean estFinal(ArrayList estF, String EstadosEntrada[], String comp){
        boolean test = false;
        for(int i = 0; i < estF.size(); i++){
            if(((int) estF.get(i)) == pos_entrada(EstadosEntrada, comp)){
                test = true;
                break;
            }
        }
        return test;
    }
}
