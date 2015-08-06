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
        elementos.addElement("Pared");
        elementos.addElement("Goomba");
        elementos.addElement("Koopa");
        elementos.addElement("Ficha");
        elementos.addElement("Hongo");
        Nombres.setModel(elementos);
        jScrollPane1.setViewportView(Nombres);
        
           Nombres.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 1) {
            int index = list.locationToIndex(evt.getPoint());
            if(index==0){
                jTextField1.setText("Mario Bros");
                jTextField2.setText("/Imagenes/mario.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==1){
                jTextField1.setText("Castillo Final");
                jTextField2.setText("/Imagenes/castilllo.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==2){
                jTextField1.setText("Pared");
                jTextField2.setText("/Imagenes/pared.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==3){
                jTextField1.setText("Goomba");
                jTextField2.setText("/Imagenes/goomba.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==4){
                jTextField1.setText("Koopa");
                jTextField2.setText("/Imagenes/koopa.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==5){
                jTextField1.setText("Ficha");
                jTextField2.setText("/Imagenes/ficha.jpg");
                URL url = this.getClass().getResource(jTextField2.getText());  
                ImageIcon icon = new ImageIcon(url);  
                LabelImagen.setIcon(icon);  
            }
            if(index==6){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Direccion:");

        jButton1.setText("Agregar personaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addContainerGap(390, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        if(Nombres.getSelectedValue().toString().compareToIgnoreCase("Mario Bros")==0){
            elementos.remove(Nombres.getSelectedIndex());
        }
        if(Nombres.getSelectedValue().toString().compareToIgnoreCase("Castillo Final")==0){
            elementos.remove(Nombres.getSelectedIndex());
        }
        
       String nombre=jTextField1.getText();
       String path=jTextField2.getText();
    
       
       
       
       //        ListaDoble b = new ListaDoble();
//        Personajes a;
//        a=b.BorrarSacarPrimero().dato;

    }//GEN-LAST:event_jButton1ActionPerformed

  
    
    
   
    
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
