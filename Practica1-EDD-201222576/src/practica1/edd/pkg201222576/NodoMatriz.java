/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

import javax.swing.JLabel;

/**
 *
 * @author Breynner
 */
public class NodoMatriz extends JLabel{
    
    Personajes dato;
    int fil;
    int col;
    NodoMatriz siguiente;
    NodoMatriz anterior;
    NodoMatriz arriba;
    NodoMatriz abajo;
    NodoMatriz(Personajes a,int posx, int posy)
    {
        this.col = posx; 
        this.fil = posy; 
        dato=a;
        siguiente=null;
        anterior=null;
        arriba=null;
        abajo=null;
    }
    
}
