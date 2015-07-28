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
public class Nodo {
    
    Object dato;
    Nodo next;
    Nodo ant;
    Nodo(Object a)
    {
        dato=a;
        next=null;
        ant=null;
    }
}
