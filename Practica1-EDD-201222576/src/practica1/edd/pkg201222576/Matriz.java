
package practica1.edd.pkg201222576;

import javax.swing.JLabel;

/**
 *
 * @author Breynner
 */
public class Matriz {
    NodoMatriz primerofila;
    NodoMatriz ultimofila;
    NodoMatriz primeracol;
    NodoMatriz ultimocol;
    int nodatos;
    int nofilas;
    int nocolumnas;
    Matriz()
    {
        primerofila=null;
        ultimofila=null;
    }
 
     public boolean estavacio()
    {
        if(primerofila==null && primeracol==null) {return true;}
        else {return false;}
    }
     
     
     
     public void IniciarMatriz2x4(Personajes a, int fi, int co) { 
            a=null;
            int y = 1; 
            int x=1;
            NodoMatriz q = null; 
            //Filas
            while (y <= fi) { 
            NodoMatriz nuevo = new NodoMatriz(a, y, 0); 
            if(y==1){
                q=nuevo;
            primerofila=q;
            primeracol=q;
            x=1;
                    //Columnas
                    while (x <= co) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, 0, x); 
                    q.siguiente = nuevocol; 
                    q.siguiente.anterior=q;
                    q = q.siguiente; 
                    q.siguiente=null;
                    x++; 
                    nocolumnas++;
                    } 
            }else{
                x=1;
            q.arriba = nuevo;  
            q.arriba.abajo=q;
            q = q.arriba; 
            q.arriba=null;
            y++; 
            nofilas++;
                    //Columnas
                    while (x <= co) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, 0, x); 
                    q.siguiente = nuevocol; 
                    q.siguiente.anterior=q;
                    q = q.siguiente; 
                    q.siguiente=null;
                    x++; 
                    nocolumnas++;
                    } 
                }
            } 
            
   } 
    
     
     
     
    
}
