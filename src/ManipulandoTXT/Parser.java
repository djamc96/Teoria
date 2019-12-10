/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulandoTXT;
import java.io.*; 
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Parser {

    /**
     * @param args the command line arguments
     */
    public String carTxt(String Caminho) {
        String texto = "";
        File leitor = new File(Caminho);
        try{
            if(leitor.getName().endsWith(".txt")){
                if(!leitor.exists()){
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro na leitura", JOptionPane.ERROR_MESSAGE);
                }else{
                    BufferedReader br = new BufferedReader(new FileReader(Caminho));
                    while(br.ready()){
                        texto += br.readLine() + "\n";
                    }
                    br.close();
                }    
            }else{
                    JOptionPane.showMessageDialog(null, "Este formato está incorreto", "Erro na leitura do arquivo", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return texto;
   } 
}
   
