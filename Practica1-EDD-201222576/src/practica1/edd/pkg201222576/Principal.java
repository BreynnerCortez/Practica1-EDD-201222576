/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javafx.scene.control.ScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Breynner
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    JList Nombres=new JList();
    DefaultListModel elementos = new DefaultListModel();
    public static  ListaDoble listadoble=new ListaDoble();
    public static boolean pilaocola;
    public Principal() {
        initComponents();
        setTitle("Mario Bros");
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno= new ImageIcon(this.getClass().getResource("/Imagenes/NewSuperMarioBrosWallpaper1024.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        
        //Lista de objetos
        elementos.addElement("Mario Bros");
        elementos.addElement("Castillo Final");
        elementos.addElement("Suelo");
        elementos.addElement("Pared");
        elementos.addElement("Goomba");
        elementos.addElement("Koopa");
        elementos.addElement("Ficha");
        elementos.addElement("Hongo");
        Nombres.setModel(elementos);
        jScrollPane1.setViewportView(Nombres);
        
        //accion con click
           Nombres.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 1) {
            int index = list.locationToIndex(evt.getPoint());
             String id=list.getSelectedValue().toString();
            if(id.compareToIgnoreCase("Mario Bros")==0){
                jTextField1.setText("Mario Bros");
                jTextField2.setText("/Imagenes/mario.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Castillo Final")==0){
                jTextField1.setText("Castillo Final");
                jTextField2.setText("/Imagenes/castillo.png");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Suelo")==0){
                jTextField1.setText("Suelo");
                jTextField2.setText("/Imagenes/suelo.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Pared")==0){
                jTextField1.setText("Pared");
                jTextField2.setText("/Imagenes/pared.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Goomba")==0){
                jTextField1.setText("Goomba");
                jTextField2.setText("/Imagenes/goomba.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Koopa")==0){
                jTextField1.setText("Koopa");
                jTextField2.setText("/Imagenes/koopa.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Ficha")==0){
                jTextField1.setText("Ficha");
                jTextField2.setText("/Imagenes/ficha.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(id.compareToIgnoreCase("Hongo")==0){
                jTextField1.setText("Hongo");
                jTextField2.setText("/Imagenes/hongo.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
        } 
    }
});
        
        
//        
//        jLabel1.addMouseListener(new MouseAdapter() {
//
//        public void mouseClicked(MouseEvent e) {
//            ((JLabel)e.getSource()).setText("aaa");
//            System.out.println("Ha echo click en"+((JLabel)e.getSource()).getText());
//			}
//        
//        });
//        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LabelImagen = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setPreferredSize(new java.awt.Dimension(737, 543));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Direccion:");

        jButton1.setText("Agregar personaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Implementar como PILA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Implementar como COLA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("EDICION Y ELIMINACION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      jButton2.setVisible(true);
      jButton3.setVisible(true);
      String id=Nombres.getSelectedValue().toString();
      String nombre=jTextField1.getText();
       String path=jTextField2.getText();
       Personajes a=new Personajes();
        if(id.compareToIgnoreCase("Mario Bros")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(1);
            listadoble.insertar(a);
            elementos.remove(Nombres.getSelectedIndex());
        }
        if(id.compareToIgnoreCase("Castillo Final")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(2);
            listadoble.insertar(a);
            elementos.remove(Nombres.getSelectedIndex());
        }
        if(id.compareToIgnoreCase("Suelo")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(3);
            listadoble.insertar(a);
        }
        if(id.compareToIgnoreCase("Pared")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(4);
            listadoble.insertar(a);
        }
        if(id.compareToIgnoreCase("Goomba")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(5);
            listadoble.insertar(a);
        }
        if(id.compareToIgnoreCase("Koopa")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(5);
            listadoble.insertar(a);
        }
        if(id.compareToIgnoreCase("Ficha")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(6);
            listadoble.insertar(a);
        }
        if(id.compareToIgnoreCase("Hongo")==0){
            a.SetNombre(nombre);
            a.SetPath(path);
            a.SetTipo(7);
            listadoble.insertar(a);
        }/*1 mario
      2 castillo
      3 suelo
      4 pared
      5 enemigos
      6 coin
      7 vida
    */
        
    
//        ListaDoble b = new ListaDoble();
//        Personajes a;
//        a=b.BorrarSacarPrimero().dato;

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FrameEditarEliminar frame = new FrameEditarEliminar(); 
        frame.setVisible (true); 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pilaocola=true;
        jButton3.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pilaocola=false;
        jButton2.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

  
    
    
   
    
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
