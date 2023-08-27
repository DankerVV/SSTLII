package com.mycompany.proyectoalternosstlii;

//import java.awt.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.*;


public class main extends javax.swing.JFrame{ //implements KeyListener {
    private int tiempo1=0;
    private int tiempo2=3;
    private int puntos=0;
    private int num_preguntas=1;
    private Timer mTimer;
    private Timer mTimer2;
    
    public main() {
        initComponents();
        conexionBD objetoConexion = new conexionBD();
        objetoConexion.establecerConexion();
         mTimer = new Timer(1000, (ActionEvent e) -> {
                iniciarCronometro();  
            });
         mTimer2 = new Timer(1000, (ActionEvent e) -> {
                iniciarCronometro2();  
            });
        this.setVisible(true);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), true);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
        
        //----------ESCUCHAR TECLADO----------
        KeyListener escucharTeclado= new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                ;
            }
            @Override
            public void keyPressed(KeyEvent e) {//ESTO ES PARA PODER INGRESAR CON ESPACIO, SIN NECESIDAD DE PRESIONAR EL BOTON
                //System.out.println("Tecla: "+ e.getKeyCode()+"\n");
                int tecla_code = e.getKeyCode();//getCode te da el codigo de cada tecla presionada
                if(tecla_code==10){
                    if((txtIntroducirNombre.getText().equals("")==false)&&(txtIntroducirNombre.getText().equals(" ")==false)){//10 es el codigo del espacio
                        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
                        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), true);
                        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
                        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
                        lblTituloInicio2.setText("Bienvenido(a) "+txtIntroducirNombre.getText());
                        jTabbedPane1.setSelectedIndex(1);
                        usuarios objetoUsuarios = new usuarios();
                        objetoUsuarios.login(txtIntroducirNombre.getText());
                        cuestionario objetoCuestionario = new cuestionario();
                        objetoCuestionario.mostrarTabla(tblCuestionario);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ADVERTENCIA: no puedes dejar este campo vacío");
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent arg0) {
                ;
            }
        };
        txtIntroducirNombre.addKeyListener(escucharTeclado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblTituloInicio = new javax.swing.JLabel();
        txtIntroducirNombre = new javax.swing.JTextField();
        lblIntroduceNombre = new javax.swing.JLabel();
        btnInicioAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTituloInicio2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuestionario = new javax.swing.JTable();
        lblIntroduceNombre1 = new javax.swing.JLabel();
        lblIntroduceNombre2 = new javax.swing.JLabel();
        spinIDjuego = new javax.swing.JSpinner();
        btnJugar = new javax.swing.JButton();
        lblIntroduceNombre3 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblTituloInicio3 = new javax.swing.JLabel();
        lblIntroduceNombre7 = new javax.swing.JLabel();
        lblIntroduceNombre8 = new javax.swing.JLabel();
        spinPreguntas = new javax.swing.JSpinner();
        lblIntroduceNombre9 = new javax.swing.JLabel();
        txtTituloPreg = new javax.swing.JTextField();
        btnListoCrear = new javax.swing.JButton();
        lblPreguntaNum = new javax.swing.JLabel();
        lblTituloPreguntas = new javax.swing.JLabel();
        txtPregunta = new javax.swing.JTextField();
        lblIntroduceNombre11 = new javax.swing.JLabel();
        txtRespCorr = new javax.swing.JTextField();
        lblIntroduceNombre12 = new javax.swing.JLabel();
        txtRespIncorr1 = new javax.swing.JTextField();
        txtRespIncorr2 = new javax.swing.JTextField();
        txtRespIncorr3 = new javax.swing.JTextField();
        btnSigPreg = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblNumPregunta = new javax.swing.JLabel();
        lblPreguntas = new javax.swing.JLabel();
        lblSegundos = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        btnOpcionUno = new javax.swing.JButton();
        btnOpcionTres = new javax.swing.JButton();
        btnOpcionCuatro = new javax.swing.JButton();
        btnOpcionDos = new javax.swing.JButton();
        lblFrases = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTituloInicio.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        lblTituloInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloInicio.setText("Emulador de Kahoot");

        txtIntroducirNombre.setFont(new java.awt.Font("Oriya MN", 0, 24)); // NOI18N
        txtIntroducirNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntroducirNombreActionPerformed(evt);
            }
        });

        lblIntroduceNombre.setFont(new java.awt.Font("Lao Sangam MN", 0, 24)); // NOI18N
        lblIntroduceNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre.setText("Introduce tu nombre para comenzar");

        btnInicioAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnInicioAceptar.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnInicioAceptar.setText("Aceptar");
        btnInicioAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(lblTituloInicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(lblIntroduceNombre)
                .addGap(18, 18, 18)
                .addComponent(txtIntroducirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicioAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblTituloInicio)
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIntroducirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntroduceNombre)
                    .addComponent(btnInicioAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        lblTituloInicio2.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        lblTituloInicio2.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloInicio2.setText("Bienvenido(a) ");

        tblCuestionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCuestionario);

        lblIntroduceNombre1.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        lblIntroduceNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre1.setText("Selecciona el ID del cuestionario que te interesa");

        lblIntroduceNombre2.setFont(new java.awt.Font("Lao Sangam MN", 1, 24)); // NOI18N
        lblIntroduceNombre2.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre2.setText("Para participar en un cuestionario:");

        btnJugar.setBackground(new java.awt.Color(255, 255, 255));
        btnJugar.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnJugar.setText("a jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        lblIntroduceNombre3.setFont(new java.awt.Font("Lao Sangam MN", 0, 24)); // NOI18N
        lblIntroduceNombre3.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre3.setText("Para crear un cuestionario:");

        btnCrear.setBackground(new java.awt.Color(255, 255, 255));
        btnCrear.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnCrear.setText("haz click aquí");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnVolver.setText("volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(lblTituloInicio2)
                .addContainerGap(400, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIntroduceNombre2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblIntroduceNombre1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinIDjuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblIntroduceNombre3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTituloInicio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(lblIntroduceNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinIDjuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntroduceNombre1))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntroduceNombre3)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane1.addTab("Menú", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        lblTituloInicio3.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        lblTituloInicio3.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloInicio3.setText("Crear un Cuestionario");

        lblIntroduceNombre7.setFont(new java.awt.Font("Lao Sangam MN", 1, 24)); // NOI18N
        lblIntroduceNombre7.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre7.setText("Primero decide un título:");

        lblIntroduceNombre8.setFont(new java.awt.Font("Lao Sangam MN", 1, 24)); // NOI18N
        lblIntroduceNombre8.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre8.setText("¿Cuántas preguntas serán?");

        lblIntroduceNombre9.setFont(new java.awt.Font("Lao Sangam MN", 2, 14)); // NOI18N
        lblIntroduceNombre9.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre9.setText("Mínimo 3. Máximo 10");

        txtTituloPreg.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        btnListoCrear.setBackground(new java.awt.Color(255, 255, 255));
        btnListoCrear.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnListoCrear.setText("listo");
        btnListoCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoCrearActionPerformed(evt);
            }
        });

        lblPreguntaNum.setFont(new java.awt.Font("Lao Sangam MN", 1, 24)); // NOI18N
        lblPreguntaNum.setForeground(new java.awt.Color(255, 255, 255));
        lblPreguntaNum.setText("Pregunta 1");

        lblTituloPreguntas.setFont(new java.awt.Font("Marker Felt", 1, 24)); // NOI18N
        lblTituloPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPreguntas.setText("Aún no puedes hacer las preguntas");

        txtPregunta.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtPregunta.setEnabled(false);

        lblIntroduceNombre11.setFont(new java.awt.Font("Lao Sangam MN", 1, 18)); // NOI18N
        lblIntroduceNombre11.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre11.setText("Respuesta correcta:");

        txtRespCorr.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRespCorr.setEnabled(false);

        lblIntroduceNombre12.setFont(new java.awt.Font("Lao Sangam MN", 1, 18)); // NOI18N
        lblIntroduceNombre12.setForeground(new java.awt.Color(255, 255, 255));
        lblIntroduceNombre12.setText("Respuestas incorrectas:");

        txtRespIncorr1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txtRespIncorr2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRespIncorr2.setEnabled(false);

        txtRespIncorr3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRespIncorr3.setEnabled(false);

        btnSigPreg.setBackground(new java.awt.Color(255, 255, 255));
        btnSigPreg.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        btnSigPreg.setText("siguiente pregunta");
        btnSigPreg.setEnabled(false);
        btnSigPreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigPregActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTituloInicio3)
                        .addGap(377, 377, 377))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTituloPreguntas)
                        .addGap(357, 357, 357))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblPreguntaNum)
                        .addGap(18, 18, 18)
                        .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnSigPreg))
                    .addComponent(lblIntroduceNombre9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIntroduceNombre12)
                                .addComponent(lblIntroduceNombre11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRespCorr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRespIncorr2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRespIncorr1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRespIncorr3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIntroduceNombre8)
                                .addComponent(lblIntroduceNombre7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spinPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTituloPreg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addComponent(btnListoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloInicio3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntroduceNombre7)
                    .addComponent(txtTituloPreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntroduceNombre8)
                    .addComponent(spinPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIntroduceNombre9)
                .addGap(22, 22, 22)
                .addComponent(lblTituloPreguntas)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreguntaNum)
                    .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSigPreg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntroduceNombre11)
                    .addComponent(txtRespCorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIntroduceNombre12)
                    .addComponent(txtRespIncorr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespIncorr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespIncorr3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Crear", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        lblNumPregunta.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        lblNumPregunta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPregunta.setText("Pregunta 1");

        lblPreguntas.setFont(new java.awt.Font("Marker Felt", 1, 48)); // NOI18N
        lblPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        lblPreguntas.setText(".");

        lblSegundos.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        lblSegundos.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundos.setText("10");

        lblPuntos.setFont(new java.awt.Font("Marker Felt", 1, 18)); // NOI18N
        lblPuntos.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos.setText("puntos: 0");

        btnOpcionUno.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        btnOpcionUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionUnoActionPerformed(evt);
            }
        });

        btnOpcionTres.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        btnOpcionTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionTresActionPerformed(evt);
            }
        });

        btnOpcionCuatro.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        btnOpcionCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionCuatroActionPerformed(evt);
            }
        });

        btnOpcionDos.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        btnOpcionDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionDosActionPerformed(evt);
            }
        });

        lblFrases.setFont(new java.awt.Font("Marker Felt", 1, 18)); // NOI18N
        lblFrases.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpcionUno, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcionTres, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpcionDos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcionCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 265, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumPregunta)
                .addGap(294, 294, 294)
                .addComponent(lblSegundos)
                .addGap(130, 130, 130))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(lblFrases, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lblPuntos)
                    .addContainerGap(957, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundos)
                    .addComponent(lblNumPregunta))
                .addGap(59, 59, 59)
                .addComponent(lblPreguntas)
                .addGap(18, 18, 18)
                .addComponent(lblFrases, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcionUno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcionDos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcionCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcionTres, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(lblPuntos)
                    .addContainerGap(481, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Jugar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioAceptarActionPerformed
        if((txtIntroducirNombre.getText().equals("")==false)&&(txtIntroducirNombre.getText().equals(" ")==false)){//10 es el codigo del espacio
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), true);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
            lblTituloInicio2.setText("Bienvenido "+txtIntroducirNombre.getText());
            jTabbedPane1.setSelectedIndex(1);
            usuarios objetoUsuarios = new usuarios();
            objetoUsuarios.login(txtIntroducirNombre.getText());
        }
        else{
            JOptionPane.showMessageDialog(null, "ADVERTENCIA: no puedes dejar este campo vacío");
        }
    }//GEN-LAST:event_btnInicioAceptarActionPerformed

    private void txtIntroducirNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntroducirNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntroducirNombreActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        int aux, band=0;
        aux = Integer.valueOf(spinIDjuego.getValue().toString());
        
        for(int i=0; i< tblCuestionario.getRowCount();i++){
            //System.out.println("Aux:"+aux+"TablaID:"+tblCuestionario.getValueAt(i, 0));
            if(Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())==aux){
                band=1;
                break;
            }
        }
        
        if(band!=0){
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), false);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
            jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), true);
            jTabbedPane1.setSelectedIndex(3);
            mTimer2.start();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR: no se encontró ese ID");
        }
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), true);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
        btnListoCrear.setEnabled(true);
        txtTituloPreg.setText("");
        txtTituloPreg.setEnabled(true);
        spinPreguntas.setEnabled(true);
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        txtIntroducirNombre.setText("");
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), true);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnListoCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoCrearActionPerformed
        int spin_value= Integer.valueOf(spinPreguntas.getValue().toString());
        
        if((txtTituloPreg.getText().equals("")==false)&&(txtTituloPreg.getText().equals(" ")==false)){//VALIDAR QUE NO SE DEJE EL ESPACIO EN BLANCO
           if(spin_value>=3 && spin_value<=10){//VALIDAR EL SPIN ETNRE 3 Y 10
               cuestionario objetoCuestionario = new cuestionario();
               objetoCuestionario.insertarCuestionario(txtTituloPreg.getText(), "", 0,  spin_value, txtIntroducirNombre.getText());
               btnSigPreg.setEnabled(true);
               txtPregunta.setEnabled(true);
               txtRespCorr.setEnabled(true);
               txtRespIncorr1.setEnabled(true);
               txtRespIncorr2.setEnabled(true);
               txtRespIncorr3.setEnabled(true);
               lblTituloPreguntas.setText("Preguntas");
               num_preguntas = 1;
               btnListoCrear.setEnabled(false);
               spinPreguntas.setEnabled(false);
               txtTituloPreg.setEnabled(false);
           }
           else{
                JOptionPane.showMessageDialog(null, "ADVERTENCIA: debes elegir entre 3 y10 preguntas");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ADVERTENCIA: no puedes dejar este campo vacío");
        }
    }//GEN-LAST:event_btnListoCrearActionPerformed

    private void btnSigPregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigPregActionPerformed
        if((txtPregunta.getText().equals("")==false)&&(txtPregunta.getText().equals(" ")==false)){
            if((txtRespCorr.getText().equals("")==false)&&(txtRespCorr.getText().equals(" ")==false)){
                if((txtRespIncorr1.getText().equals("")==false)&&(txtRespIncorr1.getText().equals(" ")==false)){
                    if((txtRespIncorr2.getText().equals("")==false)&&(txtRespIncorr2.getText().equals(" ")==false)){
                        if((txtRespIncorr3.getText().equals("")==false)&&(txtRespIncorr3.getText().equals(" ")==false)){//PARA QUE NINGUN ESPACIO QUEDE VACÍO
                            preguntas objetoPreguntas = new preguntas();
                            cuestionario objetoCuestionario = new cuestionario();
                            int auxId = objetoCuestionario.ultimoID();
                            
                            objetoPreguntas.insertarPreguntas(auxId, num_preguntas, txtPregunta.getText(), txtRespCorr.getText(), 
                                    txtRespIncorr1.getText(), txtRespIncorr2.getText(), txtRespIncorr3.getText());
                            
                            num_preguntas++;
                            System.out.println("NumPreguntas: "+num_preguntas);
                            lblPreguntaNum.setText("Pregunta "+num_preguntas);
                            int spin_value= Integer.valueOf(spinPreguntas.getValue().toString());
                            txtPregunta.setText("");
                            txtRespCorr.setText("");
                            txtRespIncorr1.setText("");
                            txtRespIncorr2.setText("");
                            txtRespIncorr3.setText("");
                            if(spin_value==num_preguntas-1){//AQUI SE DETECTA QUE YA SE INGRESARON TODAS LAS PREGUNTAS
                                txtPregunta.setText("");
                                btnSigPreg.setEnabled(false);
                                num_preguntas=1;
                                System.out.println("NumPreguntas: "+num_preguntas);
                                objetoCuestionario.mostrarTabla(tblCuestionario);
                                JOptionPane.showMessageDialog(null, "Se han guardado todas las preguntas");
                                jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
                                jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), true);
                                jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
                                jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
                                jTabbedPane1.setSelectedIndex(1);
                                lblPreguntaNum.setText("Pregunta "+num_preguntas);
                            }
                        }
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ADVERTENCIA: no puedes dejar ningún campo vacío");
        }
    }//GEN-LAST:event_btnSigPregActionPerformed
    //--------------------TEMPORIZADOR--------------------
    private void iniciarCronometro(){
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        lblSegundos.setText(String.valueOf(tiempo1));
        tiempo1++;
        if(tiempo1<=1){//SOLO SE HACE EN EL PRIMER SEGUNDO, DESPUES YA NO
            lblFrases.setText("");
            int aux_numPregunta=num_preguntas;
            lblNumPregunta.setText("Pregunta "+aux_numPregunta);
            
            //----------PREGUNTAS----------
            Random random = new Random();
            List<Integer> numeros = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                numeros.add(i);
            }
            Collections.shuffle(numeros);            
            int aux1=numeros.get(0), aux2=numeros.get(1), aux3=numeros.get(2), aux4=numeros.get(3);
            int i=0;
            System.out.println("Números sin repetirse: " + aux1 + aux2 + aux3 + aux4);
            String correcta="", incorrecta1="", incorrecta2="", incorrecta3="";
            preguntas objetoPreguntas = new preguntas();
            correcta = objetoPreguntas.retornarRespustaC(spin, num_preguntas);
            incorrecta1 = objetoPreguntas.retornarRespustaI1(spin, num_preguntas);
            incorrecta2 = objetoPreguntas.retornarRespustaI2(spin, num_preguntas);
            incorrecta3 = objetoPreguntas.retornarRespustaI3(spin, num_preguntas);
            
            switch(aux1){
                case 1:btnOpcionUno.setText(correcta);
                    break;
                case 2:btnOpcionUno.setText(incorrecta1);
                    break;
                case 3:btnOpcionUno.setText(incorrecta2);
                    break;
                case 4:btnOpcionUno.setText(incorrecta3);
                    break;
            }
            switch(aux2){
                case 1:btnOpcionDos.setText(correcta);
                    break;
                case 2:btnOpcionDos.setText(incorrecta1);
                    break;
                case 3:btnOpcionDos.setText(incorrecta2);
                    break;
                case 4:btnOpcionDos.setText(incorrecta3);
                    break;
            }switch(aux3){
                case 1:btnOpcionTres.setText(correcta);
                    break;
                case 2:btnOpcionTres.setText(incorrecta1);
                    break;
                case 3:btnOpcionTres.setText(incorrecta2);
                    break;
                case 4:btnOpcionTres.setText(incorrecta3);
                    break;
            }
            switch(aux4){
                case 1:btnOpcionCuatro.setText(correcta);
                    break;
                case 2:btnOpcionCuatro.setText(incorrecta1);
                    break;
                case 3:btnOpcionCuatro.setText(incorrecta2);
                    break;
                case 4:btnOpcionCuatro.setText(incorrecta3);
                    break;
            }
            
        }
        
        
        if(tiempo1==11){//CONDICION DE SALIDA POR PREGUNTA
            num_preguntas++;
            tiempo1=0;
            mTimer2.start();
            mTimer.stop();
        }

        for(int i=0 ; i<tblCuestionario.getRowCount(); i++){//CONDICION DE SALIDA PERMANENTE
            if(num_preguntas-1==Integer.valueOf(tblCuestionario.getValueAt(i, 3).toString()) && spin==Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())){
            revisarPuntos();
            salidaPermanente();
            }
        }
        
    }
    
    //--------------------TEMPORIZADOR AUXILIAR--------------------
    private void iniciarCronometro2(){
        //System.out.println(tblCuestionario.getValueAt(0, 3).toString());
        if(tiempo2>2){
            String pregunta="";
            preguntas objetoPreguntas = new preguntas();
            int spin = Integer.valueOf(spinIDjuego.getValue().toString());
            //System.out.println("AYUDAAA "+ spin + " : " + num_preguntas);
            pregunta = objetoPreguntas.retornarPregunta(spin, num_preguntas);
            lblPreguntas.setText(pregunta);
            lblPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        lblNumPregunta.setText(String.valueOf(tiempo2));
        tiempo2--;
        btnOpcionUno.setText("");
        btnOpcionUno.setEnabled(false);
        btnOpcionDos.setText("");
        btnOpcionDos.setEnabled(false);
        btnOpcionTres.setText("");
        btnOpcionTres.setEnabled(false);
        btnOpcionCuatro.setText("");    
        btnOpcionCuatro.setEnabled(false);       
        
        
        if(tiempo2==-1){//CONDICION DE SALIDA
            tiempo2=3;
            btnOpcionUno.setEnabled(true);
            btnOpcionDos.setEnabled(true);
            btnOpcionTres.setEnabled(true);
            btnOpcionCuatro.setEnabled(true);
            mTimer.start();
            mTimer2.stop();
        }
    }
    
    
    private void btnOpcionCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionCuatroActionPerformed
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        String correcta="";
        preguntas objetoPreguntas = new preguntas();
        correcta = objetoPreguntas.retornarRespustaC(spin, num_preguntas);
        if(btnOpcionCuatro.getText().equals(correcta)){
            System.out.println("Correcto");
            agregarPuntos();
            lblPuntos.setText("Puntos: " + puntos);
        }
        else{
            lblFrases.setText("Mal :(");}
        //SALIR TRAS HABER ELEGIDO ESTA OPCION
        for(int i=0 ; i<tblCuestionario.getRowCount(); i++){//CONDICION DE SALIDA PERMANENTE
            if(num_preguntas-1==Integer.valueOf(tblCuestionario.getValueAt(i, 3).toString()) && spin==Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())){
            revisarPuntos();
            salidaPermanente();
            }
        }
        num_preguntas++;
        tiempo1=0;
        mTimer2.start();
        mTimer.stop();
    }//GEN-LAST:event_btnOpcionCuatroActionPerformed

    private void btnOpcionUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionUnoActionPerformed
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        String correcta="";
        preguntas objetoPreguntas = new preguntas();
        correcta = objetoPreguntas.retornarRespustaC(spin, num_preguntas);
        if(btnOpcionUno.getText().equals(correcta)){
            System.out.println("Correcto");
            agregarPuntos();
            lblPuntos.setText("Puntos: " + puntos);
        }
        else{
            lblFrases.setText("Mal :(");}
        //SALIR TRAS HABER ELEGIDO ESTA OPCION
        for(int i=0 ; i<tblCuestionario.getRowCount(); i++){//CONDICION DE SALIDA PERMANENTE
            if(num_preguntas-1==Integer.valueOf(tblCuestionario.getValueAt(i, 3).toString()) && spin==Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())){
            revisarPuntos();
            salidaPermanente();
            }
        }
        num_preguntas++;
        tiempo1=0;
        mTimer2.start();
        mTimer.stop();       
    }//GEN-LAST:event_btnOpcionUnoActionPerformed

    private void btnOpcionDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionDosActionPerformed
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        String correcta="";
        preguntas objetoPreguntas = new preguntas();
        correcta = objetoPreguntas.retornarRespustaC(spin, num_preguntas);
        if(btnOpcionDos.getText().equals(correcta)){
            System.out.println("Correcto");
            agregarPuntos();
            lblPuntos.setText("Puntos: " + puntos);
        }
        else{
            lblFrases.setText("Mal :(");}
        //SALIR TRAS HABER ELEGIDO ESTA OPCION
        for(int i=0 ; i<tblCuestionario.getRowCount(); i++){//CONDICION DE SALIDA PERMANENTE
            if(num_preguntas-1==Integer.valueOf(tblCuestionario.getValueAt(i, 3).toString()) && spin==Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())){
            revisarPuntos();
            salidaPermanente();
            }
        }
        num_preguntas++;
        tiempo1=0;
        mTimer2.start();
        mTimer.stop();
    }//GEN-LAST:event_btnOpcionDosActionPerformed

    private void btnOpcionTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionTresActionPerformed
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        String correcta="";
        preguntas objetoPreguntas = new preguntas();
        correcta = objetoPreguntas.retornarRespustaC(spin, num_preguntas);
        if(btnOpcionTres.getText().equals(correcta)){
            System.out.println("Correcto");
            agregarPuntos();
            lblPuntos.setText("Puntos: " + puntos);
        }
        else{
            lblFrases.setText("Mal :(");}
        //SALIR TRAS HABER ELEGIDO ESTA OPCION
        for(int i=0 ; i<tblCuestionario.getRowCount(); i++){//CONDICION DE SALIDA PERMANENTE
            if(num_preguntas-1==Integer.valueOf(tblCuestionario.getValueAt(i, 3).toString()) && spin==Integer.valueOf(tblCuestionario.getValueAt(i, 0).toString())){
            revisarPuntos();
            salidaPermanente();
            }
        }
        num_preguntas++;
        tiempo1=0;
        mTimer2.start();
        mTimer.stop();
    }//GEN-LAST:event_btnOpcionTresActionPerformed

    private void salidaPermanente(){
        num_preguntas=1;
        tiempo2=3;
        tiempo1=0;
        puntos=0;
        mTimer2.stop();
        mTimer.stop();
        btnOpcionUno.setText("");
        btnOpcionUno.setEnabled(false);
        btnOpcionDos.setText("");
        btnOpcionDos.setEnabled(false);
        btnOpcionTres.setText("");
        btnOpcionTres.setEnabled(false);
        btnOpcionCuatro.setText("");    
        btnOpcionCuatro.setEnabled(false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel1), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel2), true);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel3), false);
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(jPanel4), false);
        jTabbedPane1.setSelectedIndex(1);
    }
    
    private void revisarPuntos(){
        int spin = Integer.valueOf(spinIDjuego.getValue().toString());
        cuestionario objetoCuestionario = new cuestionario();
        int record = objetoCuestionario.retornarPuntaje(spin);
        if(puntos > record){
            JOptionPane.showMessageDialog(null, "¡FELICIDADES! Has logrado un nuevo record en este cuestionario");
            objetoCuestionario.modificarCampeon(txtIntroducirNombre.getText(), puntos, spin);
            objetoCuestionario.mostrarTabla(tblCuestionario);
        }
    }
    
    private void agregarPuntos(){
        if(tiempo1<=2){
            puntos = puntos + 10;
            lblFrases.setText("¡Excelente!");
        }
        else if(tiempo1>=3 && tiempo1<=5){
            puntos = puntos + 7;
            lblFrases.setText("¡Muy bien!");
        }
        else if(tiempo1>=6 && tiempo1<=8){
            puntos = puntos + 5;
            lblFrases.setText("¡Bien!");
        }
        else if(tiempo1>=9){
            puntos = puntos + 3;
            lblFrases.setText("¡Nada mal!");
        }
    }
    
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnInicioAceptar;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnListoCrear;
    private javax.swing.JButton btnOpcionCuatro;
    private javax.swing.JButton btnOpcionDos;
    private javax.swing.JButton btnOpcionTres;
    private javax.swing.JButton btnOpcionUno;
    private javax.swing.JButton btnSigPreg;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFrases;
    private javax.swing.JLabel lblIntroduceNombre;
    private javax.swing.JLabel lblIntroduceNombre1;
    private javax.swing.JLabel lblIntroduceNombre11;
    private javax.swing.JLabel lblIntroduceNombre12;
    private javax.swing.JLabel lblIntroduceNombre2;
    private javax.swing.JLabel lblIntroduceNombre3;
    private javax.swing.JLabel lblIntroduceNombre7;
    private javax.swing.JLabel lblIntroduceNombre8;
    private javax.swing.JLabel lblIntroduceNombre9;
    private javax.swing.JLabel lblNumPregunta;
    private javax.swing.JLabel lblPreguntaNum;
    private javax.swing.JLabel lblPreguntas;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblSegundos;
    private javax.swing.JLabel lblTituloInicio;
    private javax.swing.JLabel lblTituloInicio2;
    private javax.swing.JLabel lblTituloInicio3;
    private javax.swing.JLabel lblTituloPreguntas;
    private javax.swing.JSpinner spinIDjuego;
    private javax.swing.JSpinner spinPreguntas;
    private javax.swing.JTable tblCuestionario;
    private javax.swing.JTextField txtIntroducirNombre;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespCorr;
    private javax.swing.JTextField txtRespIncorr1;
    private javax.swing.JTextField txtRespIncorr2;
    private javax.swing.JTextField txtRespIncorr3;
    private javax.swing.JTextField txtTituloPreg;
    // End of variables declaration//GEN-END:variables
}
