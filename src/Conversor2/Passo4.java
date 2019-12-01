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
        System.out.println("passo 4\n");
        simpEst(v);
        Passo5 p5 = new Passo5(v);
    }
    
    private void simpEst(Var v){
        ArrayList <maqEstados> maqE = v.getMaqE();
        ArrayList maqESimp = v.getMaqE();
        String   [] estEnt = v.getEstadosEntrada();
        String   [] alfEnt = v.getAlfabetoEntrada();
        int contEstAtual[] = v.getContEstAtual();
        int  contProxEst[] = v.getContProxEst();
        ArrayList estF = v.getEstFinal();
        
        maqEstados trans, temp = null;
        System.out.println(maqE.size());
        impM(maqE);
        for(int i = 0; i < maqE.size(); i++){
            trans = maqE.remove(i);
            if(contEstAtual[pos_entrada(estEnt, trans.getProxEst())] == 1){
                temp = pesqMaqE(maqE, trans.getProxEst());
                System.out.println(temp.getEscrita() + ';' + temp.getLeitura() + ";" + temp.getEstAtual() + ";" + temp.getProxEst());
                if(temp.getLeitura() == " "){
                    trans.setProxEst(temp.getProxEst());
                    trans.setEscrita(temp.getEscrita());
                }
            }
            System.out.println(trans.getEscrita() + ';' + trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getProxEst());
            maqE.add(trans);
        }
        
        for(int i = 0; i < maqE.size(); i++){
            System.out.println(maqE.size());
            trans = maqE.remove(i);
            System.out.println(trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
            if(estFinal(estF, estEnt, trans.getProxEst())){
                trans.setEscrita(trans.getLeitura());
                trans.setMovimento('f');
            } else if(trans.getEscrita().equals(" ")){
                trans.setMovimento('d');
                trans.setEscrita(".");
            }else{
                trans.setMovimento('d');
            }
            System.out.println(trans.getLeitura() + "\n" + trans.getEstAtual() + "\n" + trans.getEscrita() + '\n' + trans.getProxEst() + "\n" + trans.getMovimento());
            maqE.add(trans);
        }
        impM(maqE);
        maqESimp.clear();
        for(int i = 0; i < maqE.size(); i++){
            trans = maqE.get(i);
            System.out.println(trans.getLeitura() + "\n" + trans.getEstAtual() + "\n" + trans.getEscrita() + '\n' + trans.getProxEst() + "\n" + trans.getMovimento());
            if(trans.getLeitura().equals("#") && trans.getEscrita().equals("#") && estFinal(estF, estEnt, trans.getProxEst())){
                trans.setEscrita("%");
                trans.setLeitura("%");
                maqESimp.add(trans);
                System.out.println("1 " +trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
            } else if(trans.getLeitura().equals("#") && trans.getEscrita().equals("#") && (!estFinal(estF, estEnt, trans.getProxEst()))){
                temp.setEstAtual(trans.getEstAtual());
                temp.setProxEst("tmp");
                temp.setEscrita("%");
                temp.setLeitura("%");
                temp.setMovimento('e');
                maqESimp.add(temp);
                for(int j = 0; j < alfEnt.length; j++){
                    if(alfEnt[j] != "#"){
                        temp.setEstAtual("tmp");
                        temp.setProxEst("tmp");
                        temp.setEscrita(alfEnt[j]);
                        temp.setLeitura(alfEnt[j]);
                        temp.setMovimento('e');
                        maqE.add(temp);
                    }
                }
                temp.setEstAtual("tmp");
                temp.setProxEst(trans.getProxEst());
                temp.setEscrita("%");
                temp.setLeitura("%");
                temp.setMovimento('d');
                maqESimp.add(temp);
            }else{
                System.out.println(trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
                maqESimp.add(trans);
            }
        }
        impM(maqESimp);
        v.setMaqE(maqE);
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
            System.out.println(estF.get(i));
            if(estF.get(i).equals(pos_entrada(EstadosEntrada, comp))){
                test = true;
                break;
            }
        }
        return test;
    }
    
    public void impM(ArrayList <maqEstados> maqE){
        maqEstados temp;
        for(int i = 0; i < maqE.size(); i++){
            temp = maqE.get(i);
            System.out.println( temp.getEstAtual()  + ";" +
                                temp.getLeitura()   + ";" +
                                temp.getProxEst()   + ";" +
                                temp.getEscrita()   + ";" +
                                temp.getMovimento() + ";");
        }
    }
}
