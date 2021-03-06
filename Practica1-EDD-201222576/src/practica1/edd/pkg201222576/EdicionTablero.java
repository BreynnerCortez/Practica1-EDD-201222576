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
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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
    public static Matriz mat=new Matriz();
    public static Matriz Matrizpivote=new Matriz();
    public static String pathreportelista="";
    
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
        Matrizpivote=new Matriz();
        mat.IniciarMatriz4x2(4,2);
        Matrizpivote.IniciarMatriz4x2(4, 2);
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
        jButton2 = new javax.swing.JButton();
        LabelImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

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

        jButton2.setText("Objetos Disponibles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addGap(985, 985, 985)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableroLayout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jScrollPane1.setViewportView(PanelTablero);

        jLabel2.setText("jLabel2");

        jButton3.setText("Agregar Columna");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar Fila");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Quitar Fila");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 204, 255));
        jButton7.setText("EJECUTAR JUEGO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setText("Quitar Columna");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("Ver Disponibles");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jMenu1.setText("REPORTES");

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jMenuItem1.setText("Crear Reporte Lista Doble Enlazada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jMenuItem2.setText("Crear Reporte Matriz Ortogonal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jMenuItem3.setText("Ver Reporte Lista Doble Enlazada");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jMenuItem4.setText("Ver Reporte Matriz Ortogonal");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(164, 164, 164)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
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
        int tipo=pivo.dato.tipo;
        pivo=pivo.siguiente;
        JLabel nu=new JLabel(im); 
         nu.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
             POSX=col;
             POSY=fila;
             System.out.println("Ha echo click en:"+col+","+fila); 
             if(tipo!=0){
                 JOptionPane.showMessageDialog(null, "Posicion seleccionada contiene objeto\nSeleccione otra posicion");
             }
         }});
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
          NodoMatriz b=Matrizpivote.ModificarNodo(POSX, POSY);
            a.dato.nombre=nodouso.dato.nombre;
            a.dato.path=(nodouso.dato.path);
            a.dato.tipo=nodouso.dato.tipo;
            b.dato.nombre=nodouso.dato.nombre;
            b.dato.path=(nodouso.dato.path);
            b.dato.tipo=nodouso.dato.tipo;
            if(nodouso.siguiente!=null){
                LabelImagen.setVisible(true);
                ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.primero.dato.path));
         LabelImagen.setIcon(presentacion);
                 }
            else{
                LabelImagen.setVisible(false);
                JOptionPane.showMessageDialog(null,"Lista Vacia");
            }
            }
            
      if(Principal.pilaocola==false){
          Nodo nodouso=Principal.listadoble.COLAsacarUltimo();
          ListaLlenaDeNuevo.insertar(nodouso.dato);
           NodoMatriz a=mat.ModificarNodo(POSX, POSY);
            NodoMatriz b=Matrizpivote.ModificarNodo(POSX, POSY);
            a.dato.nombre=nodouso.dato.nombre;
            a.dato.path=(nodouso.dato.path);
            a.dato.tipo=nodouso.dato.tipo;
             b.dato.nombre=nodouso.dato.nombre;
            b.dato.path=(nodouso.dato.path);
            b.dato.tipo=nodouso.dato.tipo;
            if(nodouso.anterior!=null){
                LabelImagen.setVisible(true);
            ImageIcon presentacion=new ImageIcon(this.getClass().getResource(Principal.listadoble.ultimo.dato.path));
         LabelImagen.setIcon(presentacion);
            }else{
                LabelImagen.setVisible(false);
             JOptionPane.showMessageDialog(null,"Lista Vacia");
            }
      }
      GraficarLabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       mat.AgregarUnaFila();
       Matrizpivote.AgregarUnaFila();
       GraficarLabel();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      mat.AgregarUnaColumna();
      Matrizpivote.AgregarUnaColumna();
      GraficarLabel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        mat.EliminarUnaFila();
        Matrizpivote.EliminarUnaFila();
        GraficarLabel();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Juego nu= new Juego();
        nu.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        mat.EliminarUnaColumna();
        Matrizpivote.EliminarUnaColumna();
        GraficarLabel();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int heroes=0;
        int castillofinal=0;
        int suelo=0;
        int paredes=0;
        int enemigos=0;
        int fichas=0;
        int vidas=0;
        Nodo aux=Principal.listadoble.primero;
        if(aux==null){
            JOptionPane.showMessageDialog(null, "No hay elementos.");
        }else{
        while(aux.siguiente!=null){
            if(aux.dato.tipo==1){
                heroes++;
            }if(aux.dato.tipo==2){
                castillofinal++;
            }if(aux.dato.tipo==3){
                suelo++;
            }if(aux.dato.tipo==4){
                paredes++;
            }if(aux.dato.tipo==5 ){
                enemigos++;
            }if(aux.dato.tipo==6){
                enemigos++;
            }
            if(aux.dato.tipo==7){
                fichas++;
            }if(aux.dato.tipo==8){
                vidas++;
            }
           aux=aux.siguiente;
        }
        if(aux.dato.tipo==1){
                heroes++;
            }if(aux.dato.tipo==2){
                castillofinal++;
            }if(aux.dato.tipo==3){
                suelo++;
            }if(aux.dato.tipo==4){
                paredes++;
            }if(aux.dato.tipo==5 ){
                enemigos++;
            }if(aux.dato.tipo==6){
                enemigos++;
            }
            if(aux.dato.tipo==7){
                fichas++;
            }if(aux.dato.tipo==8){
                vidas++;
            }
        
        String informacion="Coteo de objetos restantes:\nHerores: "+heroes+"\n"
                + "Metas Finales: "+castillofinal+"\nSuelos: "+suelo+"\nParedes: "+paredes+"\n"
                + "Enemigos: "+enemigos+"\nFichas: "+fichas+"\nVidas: "+vidas+".";
        JOptionPane.showMessageDialog(null, informacion);
        
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          
     int contador=0;
        String paragrap="digraph ListaDoble{\n" +
"	rankdir=TB \n" +
"	label=\"Lista Doblemete Enlazada\"\n" +
"	rank=same\n" +
"	nodesep=0.5\n" +
"	node [shape=record];\n" +
"	edge [color=\"blue\", dir=fordware]\n" +
"	subgraph g{";
        String relacionesnodos="";
        
        Nodo auxiliar=Principal.listadoble.primero;
        for(int i=1;i<=Principal.listadoble.nodatos;i++){
            if(auxiliar!=null){
                if(i==1){
                    contador++;
                    int pivote=contador+1;
                    paragrap=paragrap+"lis"+contador+" [label=\"<d> "+auxiliar.dato.nombre+"|<a>\"]\n";
                    relacionesnodos=relacionesnodos+"lis"+contador+" -> lis"+pivote+";\n";
                    relacionesnodos=relacionesnodos+"lis"+pivote+" -> lis"+contador+";\n";
                }
                if(i>1&&auxiliar.siguiente!=null){
                     contador++;
                     int pivoted=contador+1;
                    paragrap=paragrap+"lis"+contador+" [label=\"<d> "+auxiliar.dato.nombre+"|<a>\"];\n";
                    relacionesnodos=relacionesnodos+"lis"+contador+" -> lis"+pivoted+";\n";
                    relacionesnodos=relacionesnodos+"lis"+pivoted+" -> lis"+contador+";\n";
                      }
                if(auxiliar.siguiente==null){
                    contador++;
                     int pivoted=contador+1;
                    paragrap=paragrap+"lis"+contador+" [label=\"<d> "+auxiliar.dato.nombre+"|<a>\"];\n";
                }
            auxiliar=auxiliar.siguiente;
            }
            
        }
        paragrap=paragrap+"null [label=\"null\", shape=none]";
        relacionesnodos=relacionesnodos+"lis"+contador+" -> null;\n}";
        paragrap=paragrap+"}\n"+relacionesnodos;
        
        //hace el archivo
         try
              { FileWriter fichero = new FileWriter("C:\\Users\\Breynner\\Desktop\\ReporteListaDoble.txt");;
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
      
      String fileInputPath = "C:\\Users\\Breynner\\Desktop\\ReporteListaDoble.txt";
      String fileOutputPath = "C:\\Users\\Breynner\\Desktop\\ReporteListaDoble.jpg";
      
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
        NodoMatriz pivofila=mat.primerafila;
        NodoMatriz pivo=mat.primerafila;
        while(pivo.arriba!=null){
            pivo=pivo.arriba;
            pivofila=pivo;
        }
       
        
        for(int j=1;j<=mat.nofilas;j++){
            relacol=relacol+"{\nrank = same;";
           for(int i=1;i<=mat.nocolumnas;i++){
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
    
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VisualizarReporte a=new VisualizarReporte();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        VisualizarReporte a=new VisualizarReporte();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    public static javax.swing.JPanel PanelTablero;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
