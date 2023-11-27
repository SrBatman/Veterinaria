/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import misclases.*;

/**
 *
 * @author Asus
 */
public class Menu extends javax.swing.JFrame {
    int yMouse, xMouse;
    final private ArrayList<Servicio[]> listaServicios = new ArrayList<>();
    final private ArrayList<Mascota> listaMascota = new ArrayList<>();
    private Empleado me = null;
    private DefaultTableModel modelo;
    private Connection conexion = null;
    /**
     * Creates new form Menu
     * @param user
     * @param db
     */
    public Menu(Empleado user, Connection db) {
        me = user;
        conexion = db;
        initComponents();
        setLocationRelativeTo(null);
        fillBox();
        setDatos();

    }
    
    public void addServices(Servicio[] services){
        listaServicios.add(services);
    }
    
    public boolean petExists(String n){
        for (Mascota mascota : listaMascota) {
            if (mascota.getNombre().equals(n))  return true;
        }
        return false;
        
    }
    
    public void addMascota(Mascota pet){
        listaMascota.add(pet);
    }
    
    public void updateTable(){
            Object[] info = new Object[5];
            modelo = (DefaultTableModel) Tabla.getModel();
            double suma = 0;
           for (Mascota owo : listaMascota){
               info [0] = owo.getNombre();
           }
           
            

                for (Servicio[] arrayS : listaServicios){
                    StringBuilder nombresServicios = new StringBuilder();
                    for (Servicio s : arrayS){
                        if (nombresServicios.length() > 0) {
                            nombresServicios.append(", ");
                            }
                         nombresServicios.append(s.getTipo());
                        }
                     info[1] = nombresServicios.toString();
                   }
                
                
                for (Servicio[] arrayS : listaServicios){
                    double total = 0;
                    for (Servicio s : arrayS){
                        total += s.getPrecio();
                        }
                     suma+=total;
                     info[2] = "$ " + total;
                   }
                   
               
                 modelo.addRow(info);
            txtTotal.setText("$"+ suma);
            Tabla.setModel(modelo);
    }
    
    private void fillBox(){
         ClientsBox.addItem("Ninguno");
        String sql = "select nombre, apellidoP, apellidoM from cliente";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ClientsBox.addItem(rs.getString("nombre") + " " + rs.getString("apellidoP")+ " " + rs.getString("apellidoM"));
            }
        }catch (SQLException e){
            System.out.println("Hubo un error para consultar los datos: " + e);
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

        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        addpatient = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clicHere = new javax.swing.JLabel();
        ClientsBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        generateInvoice = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Salir");
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jButton2.setText("Empleados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(666, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 810));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setText("Registro de consulta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 37));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acerca de la consulta"));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Paciente", "Servicio(s)", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        Tabla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        addpatient.setText("Agregar paciente");
        addpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addpatient))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addpatient)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 724, 320));

        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, -1));

        jLabel5.setText("¿No encuentras al cliente?");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 170, 20));

        clicHere.setForeground(new java.awt.Color(0, 66, 255));
        clicHere.setText("Agregalo aqui.");
        clicHere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicHereMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clicHereMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clicHereMouseExited(evt);
            }
        });
        getContentPane().add(clicHere, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 100, 20));

        ClientsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ClientsBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 199, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la factura"));

        generateInvoice.setText("Generar Factura");
        generateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateInvoiceActionPerformed(evt);
            }
        });

        jLabel3.setText("Total: ");

        txtTotal.setText("$0.00");

        jLabel4.setText("Descuento aplicado:");

        txtDescuento.setText("No");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Empleado que lo genero: ");

        txtEmpleado.setText("Desconocido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                        .addComponent(generateInvoice))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescuento)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateInvoice)
                    .addComponent(jLabel6)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 720, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y- yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ServicesManagement em = new ServicesManagement();
        em.setVisible(true);
        em.pack();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_TablaMouseClicked

    private void TablaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_TablaPropertyChange

    private void addpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpatientActionPerformed
        // TODO add your handling code here:
        AddPatient Lwindow = new  AddPatient(this);
        Lwindow.setVisible(true);
        
    }//GEN-LAST:event_addpatientActionPerformed

    private void clicHereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicHereMouseClicked
        // TODO add your handling code here:
        System.out.println("Si");
    }//GEN-LAST:event_clicHereMouseClicked

    private void clicHereMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicHereMouseEntered
        // TODO add your handling code here:
        clicHere.setForeground(new Color(   0, 143, 255  ));
        clicHere.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_clicHereMouseEntered

    private void clicHereMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicHereMouseExited
        // TODO add your handling code here:
        clicHere.setForeground(new Color(0, 66, 255));
    }//GEN-LAST:event_clicHereMouseExited

    private void ClientsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientsBoxActionPerformed

    private void generateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateInvoiceActionPerformed
        // TODO add your handling code here:
        System.out.println("Tamaño de servicios: "+ listaServicios.size());
        System.out.println("Tamaño de : " + listaMascota.size());
    }//GEN-LAST:event_generateInvoiceActionPerformed

    private void setDatos(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date fechaActual = new Date();
        String fechaComoCadena = formatoFecha.format(fechaActual);
        txtFecha.setText(fechaComoCadena);
        txtEmpleado.setText(me.getName() + " " + me.getLastNameP() + " " + me.getLastNameM());
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClientsBox;
    private javax.swing.JTable Tabla;
    private javax.swing.JToggleButton addpatient;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel clicHere;
    private javax.swing.JToggleButton generateInvoice;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JLabel txtEmpleado;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}