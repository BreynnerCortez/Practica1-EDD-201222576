/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Breynner
 */
public class EdicionTablero extends javax.swing.JFrame {

    public int posactualx=0;
    public int posactualy=0;
     Matriz mat=new Matriz();
    
    public String a;
    public int POSX=0;
    public int POSY=0;
    public static ListaDoble ListaLlenaDeNuevo=new  ListaDoble();
    
    
    public EdicionTablero() {
        initComponents();
        setTitle("Mario Bros Edicion");
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno= new ImageIcon(this.getClass().getResource("/Imagenes/NewSuperMarioBrosWallpaper1024tablero.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        mat=new Matriz();
        mat.IniciarMatriz4x2(4,2);
        jLabel1.setVisible(false);
        GraficarLabel();
        if(Principal.pilaocola==true){
            jLabel2.setText("IMPLEMENTACION COMO PILA:");
            ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.primero.dato.path));
         LabelImagen.setIcon(presentacion);
        }else{
            jLabel2.setText("IMPLEMENTACION COMO COLA:");
            ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.ultimo.dato.path));
         LabelImagen.setIcon(presentacion);
        }
         
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_refrescar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelTablero = new javax.swing.JPanel();
        LabelImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_refrescar.setText("Refrescar");
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar a Matriz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(PanelTablero);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void graficatodo(){
         ImageIcon im= new ImageIcon(this.getClass().getResource("/Imagenes/suelo.jpg"));
         int x=0;
         for(int i=0;i<30;i++){
            x=x+im.getIconWidth();
         JLabel nuevo= new JLabel(im);
         nuevo.setBounds(x,0, im.getIconWidth(), im.getIconHeight());
         PanelTablero.add(nuevo);
         }
         JScrollPane ScrollparaPanel = null;
         PanelTablero.setAutoscrolls(true);
         ScrollparaPanel.setViewportView(PanelTablero);
         ScrollparaPanel.setHorizontalScrollBarPolicy(ScrollparaPanel.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         ScrollparaPanel.setVerticalScrollBarPolicy(ScrollparaPanel.VERTICAL_SCROLLBAR_AS_NEEDED);
         ScrollparaPanel.setBounds(5,120, PanelTablero.getWidth(), PanelTablero.getHeight());
         this.getContentPane().add(ScrollparaPanel);
         ScrollparaPanel.setVisible(true);
        
        
    }
    public void GraficarLabel(){
        
        PanelTablero.removeAll();
        PanelTablero.revalidate();
        PanelTablero.updateUI();
         PanelTablero.setPreferredSize(new Dimension( 7000,2000));
        repaint();
         Dimension a=PanelTablero.getSize();
        int ancho=a.width;
        int alto=a.height;
        NodoMatriz pivofila=mat.primerafila;
        NodoMatriz pivo=mat.primerafila;
     for(int j=1;j<=mat.nofilas;j++){
            for(int i=1;i<=mat.nocolumnas;i++){
                
        ImageIcon im= new ImageIcon(this.getClass().getResource(pivo.dato.path));
        int col=pivo.col;
        int fila=pivo.fil;
        pivo=pivo.siguiente;
        JLabel nu=new JLabel(im); 
         nu.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
             POSX=col;
             POSY=fila;
             System.out.println("Ha echo click en:"+col+","+fila); }});
          if(i==1){
                posactualx=0;
                }else{
                    posactualx=posactualx+im.getIconWidth();
                }
          if(j==1){
            posactualy=alto-im.getIconHeight();
        }else{
            posactualy=alto-j*im.getIconHeight();
        }
         nu.setBounds(posactualx,posactualy, im.getIconWidth(), im.getIconHeight());
         nu.setVisible(true);
         PanelTablero.add(nu);
            }
            pivo=pivofila.arriba;
            pivofila=pivofila.arriba;
            
     }
             
}
    
   
    
    
    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
GraficarLabel();
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(Principal.pilaocola==true){
          
          Nodo nodouso=Principal.listadoble.PILAsacarPrimero();
          ListaLlenaDeNuevo.insertar(nodouso.dato);
          NodoMatriz a=mat.ModificarNodo(POSX, POSY);
            a.dato.nombre=nodouso.dato.nombre;
            a.dato.path=(nodouso.dato.path);
            a.dato.tipo=nodouso.dato.tipo;
            if(nodouso.siguiente!=null){
                LabelImagen.setVisible(true);
                ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.primero.dato.path));
         LabelImagen.setIcon(presentacion);
                 }
            else{
                LabelImagen.setVisible(false);
            }
            }
            
      if(Principal.pilaocola==false){
          Nodo nodouso=Principal.listadoble.COLAsacarUltimo();
          ListaLlenaDeNuevo.insertar(nodouso.dato);
           NodoMatriz a=mat.ModificarNodo(POSX, POSY);
            a.dato.nombre=nodouso.dato.nombre;
            a.dato.path=(nodouso.dato.path);
            a.dato.tipo=nodouso.dato.tipo;
            if(nodouso.anterior!=null){
                LabelImagen.setVisible(true);
            ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.ultimo.dato.path));
         LabelImagen.setIcon(presentacion);
            }else{
                LabelImagen.setVisible(false);
            }
      }
      GraficarLabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EdicionTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdicionTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdicionTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdicionTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdicionTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelImagen;
    public javax.swing.JPanel PanelTablero;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
