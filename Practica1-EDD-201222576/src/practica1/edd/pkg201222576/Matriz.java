
package practica1.edd.pkg201222576;

import javax.swing.JLabel;

/**
 *
 * @author Breynner
 */
public class Matriz {
    NodoMatriz primerafila;
    NodoMatriz ultimafila;
    NodoMatriz primeracol;
    NodoMatriz ultimacol;
    int nodatos;
    int nocolumnas=1;
    int nofilas=1;
  
    Matriz()
    {
        primerafila=null;
        ultimafila=null;
    }
 
     public boolean estavacio()
    {
        if(primerafila==null && primeracol==null) {return true;}
        else {return false;}
    }
     
     
     
     public void IniciarMatriz2x4(Personajes a, int fi, int co) { 
          
            int y = 1; 
            int x=1;
            NodoMatriz q = null; 
            NodoMatriz aux=q;
            //Filas
            while (y <= fi) { 
            NodoMatriz nuevo = new NodoMatriz(a,1,y); 
            if(y==1){
                q=nuevo;
            primerafila=q;
            primeracol=q;
            
            x=2;
                    //Columnas
                    while (x <= co) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, x,y); 
                    q.siguiente = nuevocol; 
                    q.siguiente.anterior=q;
                    q = q.siguiente; 
                    q.siguiente=null;
                    x++; 
                    } 
                    y++;
                    ultimacol=q;
                    q=primerafila;
                    
            }else{
                x=2;
            q.arriba = nuevo;  
            q.arriba.abajo=q;
            aux=q;
            q = q.arriba; 
            q.arriba=null;
            ultimafila=q;
            
            nofilas++;
                    //Columnas
                    while (x <= co) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, x,y); 
                    q.siguiente = nuevocol; 
                    q.siguiente.anterior=q;
                    q = q.siguiente; 
                    aux=aux.siguiente;
                    q.abajo=aux;
                    q.abajo.arriba=q;
                    q.siguiente=null;
                    x++;  
                    nocolumnas++;
                    }
                   
                    y++; 
                     ultimacol=q;
                    q=primerafila;
                }
            
            } 
            
            
   } 
    
     
  public NodoMatriz insertar(Personajes a,int posx, int posy) { 
        NodoMatriz aux = primeracol;//Se crea el nodo auxiliar (aux) y se le da el valor de la siguiente columna del nomo m 
        while (aux.col != posx) {//Mientras que la columna del nodo aux sea diferente a la columna donde vamos a insertar el nuevo valor, recorre el nodo aux hasta dar con la columna desea para insertar el valor 
        aux = aux.siguiente; 
        } 
        NodoMatriz aux1 = aux; 
        while (aux1.fil != posy) {
        aux1 = aux1.arriba; 
        aux = aux1; 
        } 
        aux.dato.SetNombre("Apareci");
        return aux;
   }
     
    public void AgregarUnaColumna(Personajes a){
        int ulfi=ultimacol.fil;
        int ulcol=ultimacol.col;
        NodoMatriz pivo = ultimacol;
        NodoMatriz aux=pivo;
        NodoMatriz ultimacolumna=ultimacol;
        int y=ulfi;
        int contadorcol=1;
        while (y>=1) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, ulcol+1,y); 
                   if(contadorcol==1){
                    pivo.siguiente = nuevocol; 
                    pivo.siguiente.anterior=pivo;
                    pivo = pivo.siguiente; 
                    y--;
                    contadorcol++;
                   }else{
                    pivo.abajo=nuevocol;
                    pivo.abajo.arriba=pivo;
                    pivo=pivo.abajo;
                    aux=aux.abajo;
                    pivo.anterior=aux;
                    pivo.anterior.siguiente=pivo;
                    pivo.siguiente=null;
                    y--; 
                        }
                    }
        nocolumnas++;
                     ultimacol=ultimacolumna.siguiente;
                    
    }
     
    
}
