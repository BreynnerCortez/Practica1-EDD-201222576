
package practica1.edd.pkg201222576;

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
    
    
     
     
     
     
     
    public void imprimir()
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
