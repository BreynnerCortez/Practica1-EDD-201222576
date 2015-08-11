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
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javazoom.jl.player.Player;

/**
 *
 * @author Breynner
 */
public  class Juego extends javax.swing.JFrame {
    
    public static String pathreportelista="";
    public static Matriz matrizpivote=EdicionTablero.mat;;
    public Timer t,td,tt,tc;
    public ActionListener ac,ac2,ac3,ac4;
    int contadormovene=0;
    int segundos=0;
    int minutos=0;
    int POSENX=0;
    int POSENY=0;
    int vidas=1;
    int bonus=0;
    int caida=1;
    Boolean haysuelo=false;
   
    public Juego() {
        initComponents();
        Graficar();
        labelmensaje.setVisible(false);
        labelvidas.setVisible(false);
        labelvidasdos.setVisible(false);
        labelbonus.setVisible(false);
        labelbonusdos.setVisible(false);
        ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MovimientosEnemigos();
                Graficar();
                }
        };
        t=new Timer(1100, ac);
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
        ac3=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             GravedadSalto();
                }
        };
        tt=new Timer(1100, ac3);
        ac4=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             Gravedad();
                }
        };
        tc=new Timer(900, ac4);

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
    
    public void GravedadSalto(){
        if(caida<=2){
        NodoMatriz aux= BuscarMario();
        if(aux.abajo==null){tc.stop(); t.stop(); td.stop();
         try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
        JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                + "para la proxima");
                                                
        System.exit(0);
        }
                 String nombrepiv=aux.abajo.dato.nombre;
                 String pathpiv=aux.abajo.dato.path;
                 int tipopiv=aux.abajo.dato.tipo;
                 if(tipopiv!=4){
                 aux.abajo.dato.nombre=aux.dato.nombre;
                 aux.abajo.dato.path=aux.dato.path;
                 aux.abajo.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre=nombrepiv;
                 aux.dato.path=pathpiv;
                 aux.dato.tipo=tipopiv;
                 Graficar();
                 }
        }else{
            tt.stop();
        }
                 caida++;
        
    }
    
    public void Gravedad(){
        if(haysuelo==false){
        NodoMatriz aux= BuscarMario();
        if(aux.abajo==null){tc.stop(); t.stop(); td.stop();
         try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
        JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                + "para la proxima");
                                                
        System.exit(0);
        }
                 String nombrepiv=aux.abajo.dato.nombre;
                 String pathpiv=aux.abajo.dato.path;
                 int tipopiv=aux.abajo.dato.tipo;
                 if(tipopiv==2){ 
                      try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                     JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\n"
                         + "FELICITACIONES HA GANADO!\nSu puntaje fue: "+labelbonusdos.getText());
                                                
                System.exit(0);
                 }
                 if(tipopiv==7){
                     aux.abajo.dato.nombre=aux.dato.nombre;
                 aux.abajo.dato.path=aux.dato.path;
                 aux.abajo.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre="nulo";
                 aux.dato.path="/Imagenes/null.png";
                 aux.dato.tipo=0;
                 Graficar();
                 bonus++;
                 labelbonusdos.setText(""+bonus);
                 }
                 if(tipopiv==8){
                     aux.abajo.dato.nombre=aux.dato.nombre;
                 aux.abajo.dato.path=aux.dato.path;
                 aux.abajo.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre="nulo";
                 aux.dato.path="/Imagenes/null.png";
                 aux.dato.tipo=0;
                 Graficar();
                 vidas++;
                 labelvidasdos.setText(""+vidas);
                 
                      try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\vida.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                     JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\n"
                         + "FELICITACIONES HA GANADO!\nSu puntaje fue: "+labelbonusdos.getText());
                                                
                System.exit(0);
                 }
                 if(tipopiv==3 || tipopiv==4){
                     haysuelo=true;
                 }else{
                 if(tipopiv==5||tipopiv==6){
                     if(tipopiv==5){
                 aux.abajo.dato.nombre=aux.dato.nombre;
                 aux.abajo.dato.path=aux.dato.path;
                 aux.abajo.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre="nulo";
                 aux.dato.path="/Imagenes/null.png";
                 aux.dato.tipo=0;
                 Graficar();
                     }else{
                        vidas--;
                        labelvidasdos.setText(""+vidas);
                 Graficar();
                 if(vidas==0){
                     try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                     JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                + "para la proxima");
                                
                    System.exit(0);
                 }
                     }
                 
                 }if(tipopiv==0){
                     aux.abajo.dato.nombre=aux.dato.nombre;
                 aux.abajo.dato.path=aux.dato.path;
                 aux.abajo.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre=nombrepiv;
                 aux.dato.path=pathpiv;
                 aux.dato.tipo=tipopiv;
                 Graficar();
                 }
                 }
                }else{
            tc.stop();
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
                     if(tipopiv==1){
                         vidas--;
                         labelvidasdos.setText(""+vidas);
                         if (vidas==0){
                              try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                       JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                        + "para la proxima");
                                               
                            System.exit(0);
                         }
                     }else{
                         pivo.anterior.dato.nombre=pivo.dato.nombre;
                 pivo.anterior.dato.path=pivo.dato.path;
                 pivo.anterior.dato.tipo=pivo.dato.tipo;
                 pivo.dato.nombre=nombrepiv;
                 pivo.dato.path=pathpiv;
                 pivo.dato.tipo=tipopiv;
                     }
                 }else{
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
                 if(tipopiv==1){
                         vidas--;
                         labelvidasdos.setText(""+vidas);
                         if (vidas==0){
                             try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                       JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                        + "para la proxima");
                                                                
                            System.exit(0);
                         }
                     }else{
                 pivo.siguiente.dato.nombre=pivo.dato.nombre;
                 pivo.siguiente.dato.path=pivo.dato.path;
                 pivo.siguiente.dato.tipo=pivo.dato.tipo;
                 pivo.dato.nombre=nombrepiv;
                 pivo.dato.path=pathpiv;
                 pivo.dato.tipo=tipopiv;
                 entro=true;
                 }
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
            
      public NodoMatriz BuscarMario(){

        NodoMatriz pivofila=matrizpivote.primerafila;
        NodoMatriz pivo=matrizpivote.primerafila;
        for(int j=1;j<=matrizpivote.nofilas;j++){
           for(int i=1;i<=matrizpivote.nocolumnas;i++){

                int col=pivo.col;
                int fila=pivo.fil;
                if(pivo.dato.tipo==1)
                {
                    return pivo;
                }
                pivo=pivo.siguiente;
        
               }
            pivo=pivofila.arriba;
            pivofila=pivofila.arriba;
            
        }
      return null;
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
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

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

        jMenuItem7.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jMenuItem7.setText("Crear Reporte Matriz");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jMenuItem8.setText("Ver Reporte Matriz");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

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
        NodoMatriz aux=BuscarMario();
        String nombrepiv="";
        String pathpiv="";
        int tipopiv=0;
        switch(evt.getKeyCode()){

           
            case KeyEvent.VK_RIGHT:
                if(aux.siguiente.abajo.dato.tipo==3 || aux.siguiente.abajo.dato.tipo==4){haysuelo=true;}
                 nombrepiv=aux.siguiente.dato.nombre;
                 pathpiv=aux.siguiente.dato.path;
                 tipopiv=aux.siguiente.dato.tipo;
                 if(tipopiv!=4){
                      if(tipopiv==2){ 
                        try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\fin.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }
                     JOptionPane.showMessageDialog(null, "JUEGO TERMINADO:\n"
                         + "FELICITACIONES HA GANADO!\nSu puntaje fue: "+labelbonusdos.getText()+"\nSuerte "
                + "para la proxima");
                                              
                System.exit(0);
                 }
                     if(tipopiv==7 || tipopiv==8){
                          aux.siguiente.dato.nombre=aux.dato.nombre;
                 aux.siguiente.dato.path=aux.dato.path;
                 aux.siguiente.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre="nulo";
                 aux.dato.path="/Imagenes/null.png";
                 aux.dato.tipo=0;
                 if(aux.abajo.dato.tipo==0){haysuelo=false;}
                
                 if(tipopiv==7){bonus++; labelbonusdos.setText(""+bonus);
                 }
                 if(tipopiv==8){vidas++; labelvidasdos.setText(""+vidas);
                                                          try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\vida.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }}
                 Graficar();
                 if(haysuelo==false){
                     tc.start();
                 }
                 
                     }else{
                 aux.siguiente.dato.nombre=aux.dato.nombre;
                 aux.siguiente.dato.path=aux.dato.path;
                 aux.siguiente.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre=nombrepiv;
                 aux.dato.path=pathpiv;
                 aux.dato.tipo=tipopiv;
                 Graficar();
                 NodoMatriz auxdos=BuscarMario();
                 if(auxdos.abajo.dato.tipo==0){
                     haysuelo=false;}
                 
                 if(haysuelo==false){
                     tc.start();
                 }
                     }
                 }
                  
            System.out.println("Ha presionado derecha y en la posicion: "+POSENX+","+POSENY);
            break;
             case KeyEvent.VK_LEFT:
                 if(aux.anterior.abajo.dato.tipo==3 || aux.anterior.abajo.dato.tipo==4){haysuelo=true;}
                 nombrepiv=aux.anterior.dato.nombre;
                 pathpiv=aux.anterior.dato.path;
                 tipopiv=aux.anterior.dato.tipo;
            if(tipopiv!=4){
                 if(tipopiv==7 || tipopiv==8){
                          aux.anterior.dato.nombre=aux.dato.nombre;
                 aux.anterior.dato.path=aux.dato.path;
                 aux.anterior.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre="nulo";
                 aux.dato.path="/Imagenes/null.png";
                 aux.dato.tipo=0;
                 if(aux.abajo.dato.tipo==0){haysuelo=false;}
                 if(tipopiv==7){bonus++; labelbonusdos.setText(""+bonus);}
                 if(tipopiv==8){vidas++; labelvidasdos.setText(""+vidas);
                                                          try {
                                    FileInputStream fis;
                                     Player player;
                                     fis = new FileInputStream("C:\\Users\\Breynner\\Documents\\SegundoSemestre 2015\\EDD\\sonidos practica 1\\vida.mp3");
                                     BufferedInputStream bis = new BufferedInputStream(fis);

                                     player = new Player(bis);
                                     player.play();         
                                 } catch (Exception e) {
                                 }}
                 Graficar();
                 if(haysuelo==false){
                     tc.start();
                 }
                 
                     }else{
                 aux.anterior.dato.nombre=aux.dato.nombre;
                 aux.anterior.dato.path=aux.dato.path;
                 aux.anterior.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre=nombrepiv;
                 aux.dato.path=pathpiv;
                 aux.dato.tipo=tipopiv;
                 Graficar();
                 NodoMatriz auxdos=BuscarMario();
                 if(auxdos.abajo.dato.tipo==0){
                     haysuelo=false;}
                 
                 if(haysuelo==false){
                     tc.start();
                 }
                 
                }
        }
                 
            System.out.println("Ha presionado izquierda y en la posicion: "+POSENX+","+POSENY);
            break;
            case KeyEvent.VK_UP:
                nombrepiv=aux.arriba.arriba.dato.nombre;
                 pathpiv=aux.arriba.arriba.dato.path;
                 tipopiv=aux.arriba.arriba.dato.tipo;
                 if(tipopiv!=4){
                 aux.arriba.arriba.dato.nombre=aux.dato.nombre;
                 aux.arriba.arriba.dato.path=aux.dato.path;
                 aux.arriba.arriba.dato.tipo=aux.dato.tipo;
                 aux.dato.nombre=nombrepiv;
                 aux.dato.path=pathpiv;
                 aux.dato.tipo=tipopiv;
                 caida=1;
                 haysuelo=false;
                 tc.start();
                 }
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
        labelmensaje.setText("Buena Suerte! :) ");
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
           LabelTiempo.setText("Tiempo:");
           labelmensaje.setVisible(false);
           labelvidas.setVisible(false);
        labelvidasdos.setVisible(false);
        MenuInicioPausa.setText("Inicio");
        labelbonus.setVisible(false);
        labelbonusdos.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
  int contadornulls=0;
        String nulls="";
        String paragrap="digraph g{\n" +
        "edge [color=\"blue\", dir=fordware]\n" +
        "\n" +
        "node[shape=record]\n";
       String relacol="";
       String relafil="ranksep = .5; splines=ortho;\n" +
                        "{\n" +
                        "node [shape = record ];";
        NodoMatriz pivofila=matrizpivote.primerafila;
        NodoMatriz pivo=matrizpivote.primerafila;
        while(pivo.arriba!=null){
            pivo=pivo.arriba;
            pivofila=pivo;
        }
       
        
        for(int j=1;j<=matrizpivote.nofilas;j++){
            relacol=relacol+"{\nrank = same;";
           for(int i=1;i<=matrizpivote.nocolumnas;i++){
                if(pivo.siguiente!=null){
                paragrap=paragrap+"mat"+pivo.col+pivo.fil+"[label=\"<f0>|<f1>"+pivo.dato.nombre+"|<f2>\"];";
                relacol=relacol+"mat"+pivo.col+pivo.fil+":f2 -> mat"+pivo.siguiente.col+pivo.siguiente.fil+":"
                        + "f0;\nmat"+pivo.siguiente.col+pivo.siguiente.fil+":f0 -> mat"+pivo.col+pivo.fil+":f2;";
                }else{
                    contadornulls++;
                    paragrap=paragrap+"mat"+pivo.col+pivo.fil+"[label=\"<f0>|<f1>"+pivo.dato.nombre+"|<f2>\"];";
                relacol=relacol+"mat"+pivo.col+pivo.fil+":f2 -> nulo"+contadornulls;
                }
                
                 if(pivo.abajo!=null){
                relafil=relafil+"mat"+pivo.col+pivo.fil+"->mat"+pivo.abajo.col+pivo.abajo.fil+";";
                relafil=relafil+"mat"+pivo.abajo.col+pivo.abajo.fil+"->mat"+pivo.col+pivo.fil+";";
                }
                pivo=pivo.siguiente;
               }
           relacol=relacol+"}\n";
            
            pivo=pivofila.abajo;
            pivofila=pivofila.abajo;
        }
        
        for(int c=1;c<=contadornulls;c++){
        nulls="nulo"+c+";";
                }
        
        relafil=relafil+"}";
        paragrap=paragrap+nulls+relafil+relacol+"}";

        
        
        
        
        //hace el archivo
         try
              { FileWriter fichero = new FileWriter("C:\\Users\\Breynner\\Desktop\\ReporteMatrizOrtogonal.txt");;
                PrintWriter pw = new PrintWriter(fichero);
          pw.write(paragrap);
                fichero.close();
              }

              //Si existe un problema al escribir cae aqui
              catch(Exception e)
              {
              System.out.println("Error al escribir");
              }
        
        
        
        try {
      
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
      String fileInputPath = "C:\\Users\\Breynner\\Desktop\\ReporteMatrizOrtogonal.txt";
      String fileOutputPath = "C:\\Users\\Breynner\\Desktop\\ReporteMatrizOrtogonal.jpg";
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      pathreportelista=fileOutputPath;
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }       
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       VisualizarReporteEnEjecucion a=new VisualizarReporteEnEjecucion();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbonus;
    private javax.swing.JLabel labelbonusdos;
    private javax.swing.JLabel labelmensaje;
    private javax.swing.JLabel labelvidas;
    private javax.swing.JLabel labelvidasdos;
    // End of variables declaration//GEN-END:variables
}
