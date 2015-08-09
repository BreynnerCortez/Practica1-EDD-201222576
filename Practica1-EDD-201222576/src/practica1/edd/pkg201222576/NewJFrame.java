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
import static practica1.edd.pkg201222576.Juego.matrizpivote;

/**
 *
 * @author Breynner
 */
public class NewJFrame extends javax.swing.JFrame {
    public static Matriz matrizpivote=EdicionTablero.mat;;
    public Timer t,td;
    public ActionListener ac,ac2;
    int contadormovene=0;
    int segundos=0;
    int minutos=0;
    int POSENX=0;
    int POSENY=0;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        
         // Graficar();
      //  labelmensaje.setVisible(false);

//        ac2=new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                segundos++;
//                if(segundos>59){
//                    minutos++;
//                    segundos=0;
//                }
//                if(segundos<10){
//                    TextFieldTiempo.setText("0"+minutos+":0"+segundos);
//                    TextFieldTiempo.setVisible(true);
//                }else{
//                    TextFieldTiempo.setText("0"+minutos+":"+segundos);
//                }
//                
//            }
//        };
//         td=new Timer(1000, ac2);
//        ac=new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               MovimientosEnemigos();
//                Graficar();
//                }
//        };
//        t=new Timer(1100, ac);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        PanelJuego = new javax.swing.JPanel();
        labelmensaje = new javax.swing.JLabel();
        TextFieldTiempo = new javax.swing.JLabel();

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
            .addGap(0, 875, Short.MAX_VALUE)
        );
        PanelJuegoLayout.setVerticalGroup(
            PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelJuego);

        labelmensaje.setFont(new java.awt.Font("TI-83p Mini Sans", 0, 24)); // NOI18N
        labelmensaje.setText("Buena Suerte! :)");

        TextFieldTiempo.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        TextFieldTiempo.setText("Tiempo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TextFieldTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(labelmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(440, 440, 440))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(TextFieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

             switch(evt.getKeyCode()){
            
            case KeyEvent.VK_LEFT:
                JOptionPane.showMessageDialog(null, "presion");
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelJuego;
    private javax.swing.JLabel TextFieldTiempo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelmensaje;
    // End of variables declaration//GEN-END:variables
}
