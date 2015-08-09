
package practica1.edd.pkg201222576;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Breynner
 */
public class ListaDoble {
    Nodo primero;
    Nodo ultimo;
    int nodatos;
    ListaDoble()
    {
        primero=null;
        ultimo=null;
    }
 
     public boolean estavacio()
    {
        if(primero==null) {return true;}
        else {return false;}
    }
     
     
     
     public void insertar( Personajes datonuevo)
    {
        if(estavacio())
        {
            Nodo nuevo=new Nodo(datonuevo);
            primero=nuevo;
            ultimo=nuevo;
            nodatos++;
        }
        else
        {
            Nodo nuevo=new Nodo(datonuevo);
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
            nodatos++;
        }        
    }
    
     public Nodo PILAsacarPrimero(){
         if(primero.siguiente==null){
             Nodo aux=primero;
             primero=null;
             ultimo=null;
             return aux;
         }else{
         Nodo aux=primero;
         primero=primero.siguiente;
         primero.anterior=null;
         return aux;
         }
     }
     public Nodo COLAsacarUltimo(){
         if(ultimo.anterior==null){
             Nodo aux=ultimo;
             primero=null;
             ultimo=null;
             return aux;
         }
         else{
         Nodo aux=ultimo;
         ultimo=ultimo.anterior;
         ultimo.siguiente=null;
         return aux;
         }
         
     }
     
     public void EliminarUltimo(){
         if(ultimo.anterior==null){
             primero=null;
             ultimo=null;
             nodatos--;
         }
         else{
         Nodo aux=ultimo;
         ultimo=ultimo.anterior;
         ultimo.siguiente=null;
         nodatos--;
         }
         
     }
   
     
     
     
     
     
         public Nodo MostrarSiguiente()
        {
        Nodo aux=primero;
        return aux.siguiente;
        }
    
   public void Recorrer()
    {
        Nodo actual;
        actual=primero;
        while(actual!=ultimo)
        {
            System.out.println(actual.dato);
            actual=actual.siguiente;
        }
                System.out.println(actual.dato);
                 
    }
    
    
    
    
    
}
