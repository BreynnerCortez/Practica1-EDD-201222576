/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.edd.pkg201222576;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Breynner
 */
public  class Juego extends javax.swing.JFrame {

    public static Matriz matrizpivote=EdicionTablero.mat;;
    public Timer t,td;
    public ActionListener ac,ac2;
    int contadormovene=0;
    int segundos=0;
    int minutos=0;
    int POSENX=0;
    int POSENY=0;
    int vidas=1;
    int bonus=0;
   
    public Juego() {
        initComponents();
        Graficar();
        labelmensaje.setVisible(false);
        labelvidas.setVisible(false);
        labelvidasdos.setVisible(false);
        labelbonus.setVisible(false);
        labelbonusdos.setVisible(false);
        ac2=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if(segundos>59){
                    minutos++;
                    segundos=0;
                }
                if(segundos<10){
                    LabelTiempo.setText("0"+minutos+":0"+segundos);
                    LabelTiempo.setVisible(true);
                }else{
                    LabelTiempo.setText("0"+minutos+":"+segundos);
                }
                
            }
        };
         td=new Timer(1000, ac2);
        ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MovimientosEnemigos();
                Graficar();
                }
        };
        t=new Timer(1100, ac);
                
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
        NodoMatriz pivofila=matrizpivote.primerafila;
        NodoMatriz pivo=matrizpivote.primerafila;
     for(int j=1;j<=matrizpivote.nofilas;j++){
            for(int i=1;i<=matrizpivote.nocolumnas;i++){
                
        ImageIcon im= new ImageIcon(this.getClass().getResource(pivo.dato.path));
        int col=pivo.col;
        int fila=pivo.fil;
        
        pivo=pivo.siguiente;
        JLabel nu=new JLabel(im); 
         nu.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
             POSENX=col;
             POSENY=fila;
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
        NodoMatriz pivofila=matrizpivote.primerafila;
        NodoMatriz pivo=matrizpivote.primerafila;   
        if(contadormovene<=3){
     for(int j=1;j<=matrizpivote.nofilas;j++){
            for(int i=1;i<=matrizpivote.nocolumnas;i++){
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
          for(int j=1;j<=matrizpivote.nofilas;j++){
            for(int i=1;i<=matrizpivote.nocolumnas;i++){
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

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelJuego = new javax.swing.JPanel();
        labelmensaje = new javax.swing.JLabel();
        LabelTiempo = new javax.swing.JLabel();
        labelvidasdos = new javax.swing.JLabel();
        labelbonus = new javax.swing.JLabel();
        labelvidas = new javax.swing.JLabel();
        labelbonusdos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuInicioPausa = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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

        labelmensaje.setFont(new java.awt.Font("TI-83p Mini Sans", 0, 24)); // NOI18N
        labelmensaje.setText("Buena Suerte! :)");

        LabelTiempo.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 24)); // NOI18N
        LabelTiempo.setText("Tiempo:");

        labelvidasdos.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 24)); // NOI18N
        labelvidasdos.setText("0");

        labelbonus.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 24)); // NOI18N
        labelbonus.setText("Bonus: ");

        labelvidas.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 24)); // NOI18N
        labelvidas.setText("Vidas: ");

        labelbonusdos.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 24)); // NOI18N
        labelbonusdos.setText("0");

        jMenu1.setText("JUEGO");

        jMenuItem3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jMenuItem3.setText("Refrescar Tablero");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        MenuInicioPausa.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        MenuInicioPausa.setText("Inicio");
        MenuInicioPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInicioPausaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuInicioPausa);

        jMenuItem6.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jMenuItem6.setText("Reiniciar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LabelTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelmensaje)
                        .addGap(107, 107, 107)
                        .addComponent(labelvidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelvidasdos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelbonus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelbonusdos)
                        .addGap(45, 45, 45)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTiempo)
                    .addComponent(labelmensaje)
                    .addComponent(labelvidasdos)
                    .addComponent(labelbonus)
                    .addComponent(labelvidas)
                    .addComponent(labelbonusdos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode()){

            case KeyEvent.VK_LEFT:
            System.out.println("Ha presionado izquierda y en la posicion: "+POSENX+","+POSENY);
            break;
            case KeyEvent.VK_RIGHT:
            System.out.println("Ha presionado derecha y en la posicion: "+POSENX+","+POSENY);
            break;
            case KeyEvent.VK_UP:
            System.out.println("Ha presionado arriba y en la posicion: "+POSENX+","+POSENY);
            break;
            case KeyEvent.VK_DOWN:
            System.out.println("Ha presionado abajo y en la posicion: "+POSENX+","+POSENY);
            break;

        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Graficar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MenuInicioPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInicioPausaActionPerformed
       if(!t.isRunning()&&!td.isRunning()){
           t.start();
           td.start();
           MenuInicioPausa.setText("Pausa");
           labelmensaje.setVisible(true);
           labelvidas.setVisible(true);
           labelvidasdos.setText(""+vidas);
        labelvidasdos.setVisible(true);
        labelbonus.setVisible(true);
        labelbonusdos.setText(""+bonus);
        labelbonusdos.setVisible(true);
       }else{
           t.stop();
           td.stop();
           MenuInicioPausa.setText("Inicio");
           labelmensaje.setText("Juego Pausado!");
       }
    }//GEN-LAST:event_MenuInicioPausaActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        matrizpivote=EdicionTablero.Matrizpivote;
           contadormovene=0;
           segundos=0;
           minutos=0;
           t.stop();
           td.stop();
           Graficar();
           vidas=1;
           bonus=0;
           labelmensaje.setVisible(false);
           labelvidas.setVisible(false);
        labelvidasdos.setVisible(false);
        labelbonus.setVisible(false);
        labelbonusdos.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
    private javax.swing.JLabel LabelTiempo;
    private javax.swing.JMenuItem MenuInicioPausa;
    public javax.swing.JPanel PanelJuego;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbonus;
    private javax.swing.JLabel labelbonusdos;
    private javax.swing.JLabel labelmensaje;
    private javax.swing.JLabel labelvidas;
    private javax.swing.JLabel labelvidasdos;
    // End of variables declaration//GEN-END:variables
}
