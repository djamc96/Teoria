/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulandoTXT;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author casa
 */
public class GerarTXT {
    
    public void salvar(String txt, String nome) throws IOException{
        FileWriter arq = new FileWriter(nome);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.print(txt);
        arq.close();
    }
    
}
