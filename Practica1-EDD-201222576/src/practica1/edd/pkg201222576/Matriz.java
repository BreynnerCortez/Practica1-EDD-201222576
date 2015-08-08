
package practica1.edd.pkg201222576;

import java.awt.Dimension;
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
     
    public void AgregarUnaFila(Personajes a){
        int ulfi=ultimacol.fil;
        int ulcol=ultimacol.col;
        NodoMatriz pivo = ultimacol;
        NodoMatriz aux=pivo;
        NodoMatriz ultimafi=ultimacol;
        int x=ulcol;
        int contadorfil=1;
        while (x>=1) { 
                    NodoMatriz nuevocol = new NodoMatriz(a, x,ulfi+1); 
                   if(contadorfil==1){
                    pivo.arriba = nuevocol; 
                    pivo.arriba.abajo=pivo;
                    pivo = pivo.arriba; 
                    x--;
                    contadorfil++;
                   }else{
                    pivo.anterior=nuevocol;
                    pivo.anterior.siguiente=pivo;
                    pivo=pivo.anterior;
                    aux=aux.anterior;
                    pivo.abajo=aux;
                    pivo.abajo.arriba=pivo;
                    pivo.anterior=null;
                    x--; 
                        }
                    }
        nofilas++;
                     ultimacol=ultimafi.arriba;
                    
    }
     
    public void EliminarUnaColumna(){
        int ulfi=ultimacol.fil;
        int ulcol=ultimacol.col;
        NodoMatriz pivo = ultimacol;
        NodoMatriz ultimacolumna=ultimacol;
        int y=ulfi;
        int contadorcol=1;
        while (y>=1) { 
                   if(contadorcol==1){
                    pivo.anterior.siguiente = null; 
                    pivo = pivo.anterior; 
                    y--;
                    contadorcol++;
                   }else{
                    pivo.abajo.siguiente=null;
                    pivo=pivo.abajo;
                    y--; 
                        }
                    }
        nocolumnas--;
                     ultimacol=ultimacolumna.anterior;
                    
    }
    
    public void EliminarUnaFila(){
        int ulfi=ultimacol.fil;
        int ulcol=ultimacol.col;
        NodoMatriz pivo = ultimacol;
        NodoMatriz aux=pivo;
        NodoMatriz ultimafi=ultimacol;
        int x=ulcol;
        int contadorfil=1;
        while (x>=1) { 
                   if(contadorfil==1){
                    pivo.abajo.arriba = null; 
                    pivo = pivo.abajo; 
                    x--;
                    contadorfil++;
                   }else{
                    pivo.anterior.arriba=null;
                    pivo=pivo.anterior;
                    x--; 
                        }
                    }
        nofilas--;
                     ultimacol=ultimafi.arriba;
                    
    }
    
    public void RefrescarTablero(){
        EdicionTablero tablero= new EdicionTablero();
       int x=1;
       int y=1;
       int finalx=ultimacol.fil;
       int finaly=ultimacol.col;
       NodoMatriz pivo=primerafila;
       while(y<=finaly){
           while(x<=finalx){
               tablero.GraficarLabel(pivo, pivo.col, pivo.fil);
               pivo=pivo.siguiente;
               x++;
           }
           pivo=primerafila;
           pivo=pivo.arriba;          
           y++;
       }
        
        
        
    }
    
    
}
