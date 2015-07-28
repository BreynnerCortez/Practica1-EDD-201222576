
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
 
    public boolean estavacia()
    {
        if(primero==null) return true;
        else return false;
    }
 
    public ListaDoble insertar(Personajes dat)
    {
        if(estavacia())
        {
            Nodo nuevo=new Nodo(dat);
            primero=nuevo;
            ultimo=nuevo;
        }
        else
        {
            Nodo nuevo=new Nodo(dat);
            ultimo.next=nuevo;
            nuevo.ant=ultimo;
            ultimo=nuevo;
        }
        return this;
    }
    public void imprimir()
    {
        Nodo actual;
        actual=primero;
        while(actual!=ultimo)
        {
            System.out.println(actual.dato);
            actual=actual.next;
        }
                System.out.println(actual.dato);
                 
    }
    
    
    
    
    
}
