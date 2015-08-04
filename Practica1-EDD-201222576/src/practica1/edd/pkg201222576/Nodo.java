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
public class Nodo {
    
    Personajes dato;
    Nodo siguiente;
    Nodo anterior;
    Nodo(Personajes a)
    {
        dato=a;
        siguiente=null;
        anterior=null;
    }
    
}
