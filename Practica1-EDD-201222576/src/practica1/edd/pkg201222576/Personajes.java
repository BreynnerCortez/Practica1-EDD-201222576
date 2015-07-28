/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

/**
 *
 * @author Breynner
 */
public class Personajes {
    
    public String nombre;
    public String path;
    public int tipo;
    
    public void SetNombre( String nombreaux){
        nombre=nombreaux;
    }
    public void SetPath( String pathaux){
        path=pathaux;
    }
    public void SetTipo( int tipoaux){
        tipo=tipoaux;
    }
    public int GetTipo(){
    return tipo;
    }
    
}
