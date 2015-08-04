/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;
import javax.swing.JLabel;
import java.awt.Font;

/**
 *
 * @author Breynner
 */
public class Personajes extends JLabel{
    
    public String nombre;
    public String path;
    public int tipo;
    
    public Personajes(){
       
        setText("hola");
    }
    public void SetNombre(String a){
        nombre=a;
    }
    public void SetPath(String a){
        path=a;
    }
    public void SethTipo(int a){
        tipo=a;
    }

  
    
    
    
}
