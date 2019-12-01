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
        System.out.println(estEnt.length);
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
        int linha = 2, posEstAtu = 0, posProxEst = 0;   
        while(true){
            if(linhas[linha].contains("{")) break;
            linha++;
        }
        linha++;
        while(true){
            if(linhas[linha].contains("}")) break;
            temp = linhas[linha].split(";");
            posEstAtu = pos_entrada(estEnt, temp[0]);
            posProxEst = pos_entrada(estEnt, temp[2]);
            if(matLei[posEstAtu][posProxEst] == "")     matLei[posEstAtu][posProxEst]  = temp[1] + ";";
            else                                        matLei[posEstAtu][posProxEst]  += temp[1] + ";";
            matEsc[posEstAtu][posProxEst] = temp[3];
            linha++;
        }
        impMatriz(matLei);
        impMatriz(matEsc);
        v.setMatEsc(matEsc);
        v.setMatLei(matLei);
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
    
    public void impMatriz(String m[][]){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
