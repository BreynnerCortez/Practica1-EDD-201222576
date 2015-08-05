
package practica1.edd.pkg201222576;

import javax.swing.JLabel;

/**
 *
 * @author Breynner
 */
public class ListaDoble {
    Nodo primero;
    Nodo ultimo;
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
        }
        else
        {
            Nodo nuevo=new Nodo(datonuevo);
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }        
    }
    
     public Nodo PILAsacarPrimero(){
         Nodo aux=primero;
         primero=primero.siguiente;
         primero.anterior=null;
         return aux;
     }
     public Nodo COLAsacarUltimo(){
         if(ultimo.anterior==null){
             primero=null;
             ultimo=null;
             return ultimo;
         }
         else{
         Nodo aux=ultimo;
         ultimo=ultimo.anterior;
         ultimo.siguiente=null;
         return aux;
         }
     }
     
     
     
     
     
     
         public Nodo MostrarSiguiente()
        {
        Nodo aux=primero;
        return aux.siguiente;
        }
    
//    public void Recorrer()
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
