/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Breynner
 */
public  class Juego extends javax.swing.JFrame {

    public static Matriz mat=EdicionTablero.mat;
    public Timer t;
    public ActionListener ac;
    int contadormovene=0;
   
    public Juego() {
        initComponents();
        Graficar();
        ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MovimientosEnemigos();
                Graficar();
                }
        };
        t=new Timer(1000, ac);
                
    }
    public void Graficar(){
         int posactualx=0;
         int posactualy=0;
        PanelJuego.removeAll();
        PanelJuego.revalidate();
        PanelJuego.updateUI();
         PanelJuego.setPreferredSize(new Dimension(8000,1000));
        repaint();
         Dimension a=PanelJuego.getSize();
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
         PanelJuego.add(nu);
            }
            pivo=pivofila.arriba;
            pivofila=pivofila.arriba;
            
     }
        
    }

    
    
    public void MovimientosEnemigos(){
        if ( contadormovene>=6){
            contadormovene=0;
        }
        contadormovene++;
        NodoMatriz pivofila=mat.primerafila;
        NodoMatriz pivo=mat.primerafila;   
        if(contadormovene<=3){
     for(int j=1;j<=mat.nofilas;j++){
            for(int i=1;i<=mat.nocolumnas;i++){
                if(pivo.anterior!=null){
                if(pivo.dato.tipo==5||pivo.dato.tipo==6){
                 String nombrepiv=pivo.anterior.dato.nombre;
                 String pathpiv=pivo.anterior.dato.path;
                 int tipopiv=pivo.anterior.dato.tipo;
                 if(tipopiv!=4){
                 pivo.anterior.dato.nombre=pivo.dato.nombre;
                 pivo.anterior.dato.path=pivo.dato.path;
                 pivo.anterior.dato.tipo=pivo.dato.tipo;
                 pivo.dato.nombre=nombrepiv;
                 pivo.dato.path=pathpiv;
                 pivo.dato.tipo=tipopiv;}else{
                     contadormovene++;
                 }
                 
                        }               
                }    
                pivo=pivo.siguiente;
            }
            if(pivofila!=null){
            pivo=pivofila.arriba;
            pivofila=pivofila.arriba;
            }
                }
                }
     
      if (contadormovene>3){
          Boolean entro=false;
          for(int j=1;j<=mat.nofilas;j++){
            for(int i=1;i<=mat.nocolumnas;i++){
                if(pivo!=null&&pivo.siguiente!=null){
                if(pivo.dato.tipo==5||pivo.dato.tipo==6){
                 String nombrepiv=pivo.siguiente.dato.nombre;
                 String pathpiv=pivo.siguiente.dato.path;
                 int tipopiv=pivo.siguiente.dato.tipo;
                 pivo.siguiente.dato.nombre=pivo.dato.nombre;
                 pivo.siguiente.dato.path=pivo.dato.path;
                 pivo.siguiente.dato.tipo=pivo.dato.tipo;
                 pivo.dato.nombre=nombrepiv;
                 pivo.dato.path=pathpiv;
                 pivo.dato.tipo=tipopiv;
                 entro=true;
                       }
                if(entro==false){
                pivo=pivo.siguiente; 
                }if(entro==true){
                    if(pivo.siguiente!=null){
                    pivo=pivo.siguiente.siguiente;
                            }
                    entro=false;
                }    
                
               }
                
            }
            if(pivofila!=null){
            pivo=pivofila.arriba;
            pivofila=pivofila.arriba;
            }
                }
                
                    }
      
      
      
        }
            
     
        
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PanelJuego = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_iniciopausa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelJuegoLayout = new javax.swing.GroupLayout(PanelJuego);
        PanelJuego.setLayout(PanelJuegoLayout);
        PanelJuegoLayout.setHorizontalGroup(
            PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1102, Short.MAX_VALUE)
        );
        PanelJuegoLayout.setVerticalGroup(
            PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(PanelJuego);

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setText("Refrescar Tablero");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_iniciopausa.setBackground(new java.awt.Color(102, 153, 255));
        btn_iniciopausa.setText("INICIO");
        btn_iniciopausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciopausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_iniciopausa)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_iniciopausa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Graficar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_iniciopausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciopausaActionPerformed
 if(!t.isRunning()){
            t.start();
            btn_iniciopausa.setText("PAUSA");
        }else{
     t.stop();
     btn_iniciopausa.setText("INICIO");
 }
    }//GEN-LAST:event_btn_iniciopausaActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelJuego;
    private javax.swing.JButton btn_iniciopausa;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
