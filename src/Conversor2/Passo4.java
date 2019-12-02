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
        this.simpEst(v);
        this.gerEstados(v);
        Passo5 p5 = new Passo5(v);
    }
    
    private void simpEst(Var v){
        Funcoes f = new Funcoes();
        ArrayList <maqEstados> maqE = v.getMaqE();
        ArrayList <maqEstados> maqETemp = new <maqEstados> ArrayList();
        ArrayList estFinal = v.getEstFinal();
        String   [] estEnt = v.getEstadosEntrada();
        String   [] alfEnt = v.getAlfabetoEntrada();
        int contEstAtual[] = v.getContEstAtual();
        int  contProxEst[] = v.getContProxEst();
        ArrayList EstadosSaida = v.getEstadosSaida();
        String txt = v.getTxtTransiçõoes();
        int tam;
        maqEstados trans, temp = null;
        
        txt += "\n1 simplicação\n";
        v.setTxtTransiçõoes(txt);
        tam = maqE.size();
        for(int i = 0; i < tam; i++){
            trans = maqE.get(i);
            if(contEstAtual[f.pos_entrada(estEnt, trans.getProxEst())] == 1){
                temp = f.pesqMaqE(maqE, trans.getProxEst());
                //System.out.println(temp.getEscrita() + ';' + temp.getLeitura() + ";" + temp.getEstAtual() + ";" + temp.getProxEst());
                if(temp.getLeitura().equals("%")){
                    trans.setProxEst(temp.getProxEst());
                    trans.setEscrita(temp.getEscrita());
                }
            }
            //System.out.println(trans.getEscrita() + ';' + trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getProxEst());
            maqETemp.add(trans);
        }
        
        maqE.clear();
        maqE.addAll(maqETemp);
        
        f.impM(maqETemp,v);
        txt += "\n2 simplicação\n";
        v.setTxtTransiçõoes(txt);
        maqETemp.clear();
        tam = maqE.size();
        for(int i = 0; i < tam; i++){
            //System.out.println(i +" "+ maqE.size());
            trans = maqE.get(i);
            //System.out.println(trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
            if(f.estFinal(estFinal, estEnt, trans.getProxEst())){
                trans.setEscrita(trans.getLeitura());
                trans.setMovimento('f');
            } else if(trans.getEscrita().equals("%")){
                trans.setMovimento('d');
                trans.setEscrita(".");
            }else{
                trans.setMovimento('d');
            }
           // System.out.println(trans.getLeitura() + "  " + trans.getEstAtual() + "  " + trans.getEscrita() + "  " + trans.getProxEst() + "  " + trans.getMovimento());
            maqETemp.add(trans);
        }
        f.impM(maqETemp,v);
        maqE.clear();
        maqE.addAll(maqETemp);
        
        txt += "\n3 simplicação\n";
        v.setTxtTransiçõoes(txt);
        maqETemp.clear();
        tam = maqE.size();
        //System.out.println(tam);
        for(int i = 0; i < tam; i++){
            //System.out.println(i + "\n");
            trans = maqE.get(i);
            //System.out.println(trans.getLeitura() + "  " + trans.getEstAtual() + "  " + trans.getEscrita() + "  " + trans.getProxEst() + "  " + trans.getMovimento());
            if(trans.getLeitura().equals("#") && trans.getEscrita().equals("#")){
                //System.out.println("leitura eescrita = #");
                if(f.estFinal(estFinal, estEnt, trans.getProxEst())){
                    trans.setEscrita("%");
                    trans.setLeitura("%");
                    maqETemp.add(trans);
                    //System.out.println("1 " +trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
                }else{
                    gerRetorno(maqETemp, trans.getEstAtual(), trans.getProxEst(), alfEnt, estEnt, v);
                }
            } else  {
                //System.out.println(trans.getLeitura() + ";" + trans.getEstAtual() + ";" + trans.getEscrita() + ';' + trans.getProxEst() + ";" + trans.getMovimento());
                maqETemp.add(trans);
  
            }
        }
        maqE.clear();
        maqE.addAll(maqETemp);
        maqETemp.clear();
        tam = maqE.size();
        for(int i = 0; i < tam; i++){
            trans = maqE.get(i);
            if(trans.getLeitura().equals(" ") || trans.getLeitura().equals("#"))    trans.setLeitura("%");
            if(trans.getEscrita().equals(" ") || trans.getEscrita().equals("#"))    trans.setEscrita("%");
            maqETemp.add(trans);
        }
        maqE.clear();
        maqE.addAll(maqETemp);
        f.impM(maqE,v);
        v.setMaqE(maqE);
    } 
           
    private void gerEstados(Var v){
        Funcoes f = new Funcoes();
        ArrayList <String> estSai = new ArrayList();
        estSai.clear();
        int tamBin = f.log_base2(v.getEstadosEntrada().length);
        for(int i = 0; i < v.getEstadosEntrada().length; i++){
            estSai.add("q" + f.conv_dec_bin(i,tamBin));
        }
        v.setEstadosSaida(estSai);
    }
    
    private void gerRetorno(ArrayList <maqEstados> maqE, String estAtual, String proEst, String alfEnt[], String estEnt[], Var v){
            //Adicionando transições
            maqEstados temp = new maqEstados(estAtual, "%", "tmp", "%",'e');
            maqE.add(temp);
            for (String alfEnt1 : alfEnt) {
                if (!alfEnt1.equals("#")) {
                    temp = new maqEstados("tmp", alfEnt1, "tmp", alfEnt1,'e');
                    maqE.add(temp);
                }
            }
            temp = new maqEstados("tmp", "%", proEst, "%",'d');
            maqE.add(temp);
            
            //Adicionando novo estado;
            String[] estE = new String[estEnt.length + 1];
            for(int i = 0; i < estEnt.length; i++){
                estE[i] = estEnt[i];
            }
            estE[estEnt.length] = "tmp";
            //EstadosSaida.add("q" + v.conv_dec_bin(tam, v.log_base2(tam)));
            v.setEstadosEntrada(estE);
            //v.setEstadosSaida(EstadosSaida);
    }
    
}
