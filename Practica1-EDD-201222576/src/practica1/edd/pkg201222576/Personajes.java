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
    /*1 mario
      2 castillo
      3 suelo
      4 pared
      5 enemigos
      6 coin
      7 vida
    */
    public Personajes(){
       
        setText("hola");
    }
    public void SetNombre(String a){
        nombre=a;
    }
    public void SetPath(String a){
        path=a;
    }
    public void SetTipo(int a){
        tipo=a;
    }

  
    
    
    
}
