/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.CtrlCliente;
import Control.CtrlFactura;
import Control.CtrlUsuario;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JEFERSSON
 */
public class ReporFacturaGui extends javax.swing.JInternalFrame {

    CtrlFactura objCtrlF=new CtrlFactura();
    CtrlCliente objCtrlCli=new CtrlCliente();
    CtrlUsuario objCtrlUsu=new CtrlUsuario();
    
    DefaultTableModel modelo;//modelo de datos
    TableRowSorter<TableModel> elqueOrdena;
    
    public static int numeroDocumentoPK;
    
    
    public ReporFacturaGui() {
        initComponents();
        txtBuscarFactura.setEnabled(false);
        jDCFechaIni.setDateFormatString("yyyy-MM-dd");//dar formato a la fecha, por defecto viene dd/MM/yyyy
        ((JTextField) this.jDCFechaIni.getDateEditor()).setEditable(false);//para no editar en el jDateShooser
        jDCFechaFin.setDateFormatString("yyyy-MM-dd");//dar formato a la fecha, por defecto viene dd/MM/yyyy
        ((JTextField) this.jDCFechaFin.getDateEditor()).setEditable(false);//para no editar en el jDateShooser
        btnVerDetalle.setEnabled(false);
        llenarJTable();
        System.out.println("Entre a Reporte factura <---");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarFactura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporFactura = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<String>();
        jDCFechaIni = new com.toedter.calendar.JDateChooser();
        jDCFechaFin = new com.toedter.calendar.JDateChooser();
        btnBuscarRango = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Reporte Facturas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Factura:");

        txtBuscarFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscarFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarFacturaKeyReleased(evt);
            }
        });

        tblReporFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblReporFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Factura", "Documento", "Fecha", "Hora", "Caja", "Empleado", "Cliente", "Nro Documento", "Resolucion Factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReporFactura.setRowHeight(22);
        tblReporFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporFactura);

        btnVerDetalle.setBackground(new java.awt.Color(224, 139, 16));
        btnVerDetalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetalle.setText("Ver Detalle");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        lblTotalRegistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalRegistros.setText("Total Registros:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tipo de Busqueda:");

        cbxTipoBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rango de Fechas", "Busqueda general" }));
        cbxTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoBusquedaActionPerformed(evt);
            }
        });

        btnBuscarRango.setBackground(new java.awt.Color(21, 128, 178));
        btnBuscarRango.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarRango.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarRango.setText("Buscar");
        btnBuscarRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRangoActionPerformed(evt);
            }
        });

        btnVerTodo.setBackground(new java.awt.Color(15, 112, 28));
        btnVerTodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnVerTodo.setText("Ver Todo");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha Inicio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha Fin:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDCFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jDCFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarRango)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDCFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDCFechaIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarRango, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(btnVerTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(cbxTipoBusqueda))
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalRegistros)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarFacturaKeyReleased
        String buscarF;
        buscarF=txtBuscarFactura.getText();
        buscarEnTiempoReal(buscarF);
    }//GEN-LAST:event_txtBuscarFacturaKeyReleased

    private void tblReporFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporFacturaMouseClicked
         btnVerDetalle.setEnabled(true);         
    }//GEN-LAST:event_tblReporFacturaMouseClicked

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
       int filasele=tblReporFactura.getSelectedRow();
        System.out.println("fila sele:"+filasele);
        numeroDocumentoPK=Integer.valueOf(tblReporFactura.getValueAt(filasele, 0).toString());
       DetalleVentaGui objDetVenGui=new DetalleVentaGui(null, true);
       objDetVenGui.setVisible(true);
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnBuscarRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRangoActionPerformed
        if(jDCFechaIni.getDate()==null){
            JOptionPane.showMessageDialog(null,"Digite Fecha Inicial primero","Error",JOptionPane.ERROR_MESSAGE);
        }else if(jDCFechaFin.getDate()==null){
            JOptionPane.showMessageDialog(null,"Digite Fecha Final primero","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            String fechaIni=getMiFechaIni();
            String fechaFin=getMiFechaFin();
            buscarFactPorRango(fechaIni,fechaFin);
        }
    }//GEN-LAST:event_btnBuscarRangoActionPerformed

    private void cbxTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoBusquedaActionPerformed
        if(cbxTipoBusqueda.getSelectedItem().toString().equalsIgnoreCase("Rango de Fechas")){
            
            txtBuscarFactura.setEnabled(false);
            txtBuscarFactura.setText("");
            jDCFechaIni.setEnabled(true);
            jDCFechaFin.setEnabled(true);
            btnBuscarRango.setEnabled(true);
            
        }else if(cbxTipoBusqueda.getSelectedItem().toString().equalsIgnoreCase("Busqueda general")){
            txtBuscarFactura.setEnabled(true);
            jDCFechaIni.setDate(null);
            jDCFechaFin.setDate(null);
            jDCFechaIni.setEnabled(false);
            jDCFechaFin.setEnabled(false);
            btnBuscarRango.setEnabled(false);
            
        }  
        
    }//GEN-LAST:event_cbxTipoBusquedaActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
       borrarJtable();
       llenarJTable();
       jDCFechaIni.setDate(null);
       jDCFechaFin.setDate(null);
    }//GEN-LAST:event_btnVerTodoActionPerformed
    
    public String getMiFechaIni(){
        String   fecha="" ;
        int anio=jDCFechaIni.getCalendar().get(Calendar.YEAR);
        int mes=jDCFechaIni.getCalendar().get(Calendar.MONTH);
        int dia=jDCFechaIni.getCalendar().get(Calendar.DAY_OF_MONTH);
        fecha=anio+"-"+(mes+1)+"-"+dia;
        return fecha;
    } 
    
    public String getMiFechaFin(){
        String   fecha="" ;
        int anio=jDCFechaFin.getCalendar().get(Calendar.YEAR);
        int mes=jDCFechaFin.getCalendar().get(Calendar.MONTH);
        int dia=jDCFechaFin.getCalendar().get(Calendar.DAY_OF_MONTH);
        fecha=anio+"-"+(mes+1)+"-"+dia;
        return fecha;
    }
    
    
    public void buscarEnTiempoReal(String texto){
        borrarJtable();//borro lo que hay en el JTABLE
        modelo=(DefaultTableModel)tblReporFactura.getModel();
        elqueOrdena=new TableRowSorter<TableModel>(modelo);
        tblReporFactura.setRowSorter(elqueOrdena);//con esto se puede ordenar por col el jtable de manera asc o desc
                        
        ArrayList<Factura> listado=new ArrayList();
        listado=objCtrlF.busquedaTiempoReal(texto);
        Object []col=new Object[modelo.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
        String nomEmpleado="";
        int tam=listado.size();
        lblTotalRegistros.setText("Total Registros: "+tam);
        for(int index=0;index<tam;index++){//recorro el arrayList
            col[0]=listado.get(index).getNumeroDocumento();
            col[1]=listado.get(index).getDescDocumento();
            col[2]=listado.get(index).getFecha();
            col[3]=listado.get(index).getHora();
            col[4]=listado.get(index).getDescCaja();               
            nomEmpleado=listado.get(index).getUsuario().getPrimerNombre()+" "+listado.get(index).getUsuario().getPrimerApellido();
            col[5]=nomEmpleado;
            col[6]=listado.get(index).getCliente().getNombre()+" "+listado.get(index).getCliente().getApellido();
            col[7]=listado.get(index).getCliente().getNumeroDocumento();
            col[8]=listado.get(index).getNroResolucionFactura();     
             modelo.addRow(col);//añado el object a la fila
        } 
       
      tblReporFactura.setModel(modelo);
         
     }
    
    
    public void buscarFactPorRango(String fechaIni,String fechaFin){
        borrarJtable();//borro lo que hay en el JTABLE
        modelo=(DefaultTableModel)tblReporFactura.getModel();
        elqueOrdena=new TableRowSorter<TableModel>(modelo);
        tblReporFactura.setRowSorter(elqueOrdena);//con esto se puede ordenar por col el jtable de manera asc o desc
                        
        ArrayList<Factura> listado=new ArrayList();
        listado=objCtrlF.traerTodasLasFactRango(fechaIni,fechaFin);
        Object []col=new Object[modelo.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
        String nomEmpleado="";
        int tam=listado.size();
        lblTotalRegistros.setText("Total Registros: "+tam);
        for(int index=0;index<tam;index++){//recorro el arrayList
            col[0]=listado.get(index).getNumeroDocumento();
            col[1]=listado.get(index).getDescDocumento();
            col[2]=listado.get(index).getFecha();
            col[3]=listado.get(index).getHora();
            col[4]=listado.get(index).getDescCaja();               
            nomEmpleado=listado.get(index).getUsuario().getPrimerNombre()+" "+listado.get(index).getUsuario().getPrimerApellido();
            col[5]=nomEmpleado;
            col[6]=listado.get(index).getCliente().getNombre()+" "+listado.get(index).getCliente().getApellido();
            col[7]=listado.get(index).getCliente().getNumeroDocumento();
            col[8]=listado.get(index).getNroResolucionFactura();     
             modelo.addRow(col);//añado el object a la fila
        } 
       
      tblReporFactura.setModel(modelo);
         
     }
     
    private void borrarJtable(){
        for (int i = tblReporFactura.getRowCount() -1; i >= 0; i--){ 
                modelo.removeRow(i); 
        }      
    }
    
    /**
     * @param args the command line arguments
     */
    
    public void llenarJTable(){
        
        modelo=(DefaultTableModel)tblReporFactura.getModel();                
        elqueOrdena=new TableRowSorter<TableModel>(modelo);
        tblReporFactura.setRowSorter(elqueOrdena);//con esto se puede ordenar por col el jtable de manera asc o desc
        Factura objF=new Factura();
        ArrayList<Factura> listado=new ArrayList<Factura>();
        listado=objCtrlF.traerTodasLasFact();
        Object []col=new Object[modelo.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
        String nomEmpleado="";
        String nomCliente="";
        int tam=listado.size();
        lblTotalRegistros.setText("Total Registros: "+tam);
        for(int index=0;index<listado.size();index++){
            
            col[0]=listado.get(index).getNumeroDocumento();
            col[1]=listado.get(index).getDescDocumento();
            col[2]=listado.get(index).getFecha();
            col[3]=listado.get(index).getHora();
            col[4]=listado.get(index).getDescCaja();               
            nomEmpleado=listado.get(index).getUsuario().getPrimerNombre()+" "+listado.get(index).getUsuario().getPrimerApellido();
            col[5]=nomEmpleado;
            col[6]=listado.get(index).getCliente().getNombre()+" "+listado.get(index).getCliente().getApellido();
            col[7]=listado.get(index).getCliente().getNumeroDocumento();
            col[8]=listado.get(index).getNroResolucionFactura(); 
            modelo.addRow(col);
        }
           
    }
    
    
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
//            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ClienteGui dialog = new ClienteGui(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarRango;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private com.toedter.calendar.JDateChooser jDCFechaFin;
    private com.toedter.calendar.JDateChooser jDCFechaIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalRegistros;
    public static javax.swing.JTable tblReporFactura;
    private javax.swing.JTextField txtBuscarFactura;
    // End of variables declaration//GEN-END:variables
}