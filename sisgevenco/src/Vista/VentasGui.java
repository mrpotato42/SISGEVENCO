/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.CtrlArticulo;
import Control.CtrlCaja;
import Control.CtrlDetalleVenta;
import Control.CtrlFactura;
import Control.CtrlResolucionFactura;
import Control.CtrlTipoDocumento;
import Control.CtrlUsuario;
import Modelo.Caja;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Factura;
import Modelo.ResolucionFactura;
import Modelo.TipoDocumento;
import Modelo.Usuario;
import java.awt.event.KeyEvent;
import java.util.List;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JEFERSSON
 */
public class VentasGui extends javax.swing.JInternalFrame {
    
    CtrlUsuario objCtrlUsu=new CtrlUsuario();            
    CtrlTipoDocumento objCtrlTD=new CtrlTipoDocumento();
    CtrlCaja objCtrlC=new CtrlCaja();
    CtrlResolucionFactura objCtrlRF=new CtrlResolucionFactura();
    CtrlFactura objCtrlF=new CtrlFactura();
    CtrlArticulo objCtrlAr=new CtrlArticulo();        
    
    
    
    static double  superTotal=0.0;
    static double iva=0.0;
    
    DefaultTableModel modelo;//modelo de datos
    TableRowSorter<TableModel> elqueOrdena;
    
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
    public VentasGui() {
        initComponents();
        txtNumeroDocumento.setHorizontalAlignment(JTextField.RIGHT); 
        txtNumeroDocumento.setText(String.valueOf(objCtrlF.ConsecutivoCodigoDB()));
        txtCodigoCliente.setVisible(false);
        txtIdTipoDocumento.setVisible(false);
        lblDescripcionCaja.setText(MenuPrincipal.DESCRIPCIONCAJA);
//        txtCodigoCaja.setVisible(false);
        txtIdResolucion.setVisible(false);
//        txtPorcenDescuento.setEnabled(false);
        objCtrlTD.cargarCB(cbxTipoDocumento);
//        objCtrlC.cargarCB(cbxCaja);
        objCtrlRF.cargarCB(cbxResolucionFactura);
        lblFechaActual.setText(fechaNow());
        lblNombreEmpleado.setText(MenuPrincipal.MPNOMBREUSUARIO);
        //        traerNombreEmpleado();
        cargarListenerModeloTabla();//llamo al metodo que actualiza el table de Articulos
        System.out.println("Abri Ventas Gui");
    }
    
    
    public void cargarListenerModeloTabla(){//el escucha o se da cuenta de algun cambio en el jtable y actualiza
        modelo=(DefaultTableModel)tblArticulosEnVentas.getModel();
        modelo.addTableModelListener(new TableModelListener() {//

            @Override
            public void tableChanged(TableModelEvent e) {//cambios en la tabla al añadir una fila o quitarla o modificar un
                //valor en alguna columna
                int numFilas=modelo.getRowCount();
                double sumaSupetTotal=0.0;
                double sumSuperIva=0.0;
                double total=0.0;
                double iva=0.0;
                for(int i=0;i<numFilas;i++){
                   total=Double.parseDouble(modelo.getValueAt(i, 8).toString());
                   iva=Double.parseDouble(modelo.getValueAt(i, 7).toString());
                   sumaSupetTotal+=total;//suma de totales ya con iva
                   sumSuperIva+=iva;//suma de toda la columna Iva el valor
                }
//                txtPorcenDescuento.setEnabled(true);
                superTotal=sumaSupetTotal;
                txtIva.setText(String.valueOf(nf.format(sumSuperIva)));
                lblTotalCompra.setText(String.valueOf(nf.format(superTotal)));
               
            }
        });
    }
    
//    public void traerNombreEmpleado(){
//        ArrayList<Usuario> listadoU=new ArrayList<Usuario>();        
//        listadoU=objCtrlUsu.traer();
////        Usuario  usu= null;
//        String pn="",sn="",pa="",sa="";
//        for(int index=0;index<listadoU.size();index++){//recorro el arrayList              
//              pn=listadoU.get(index).getPrimerNombre();
//              sn=listadoU.get(index).getSegundoNombre();
//              pa=listadoU.get(index).getPrimerApellido(); 
//              sa=listadoU.get(index).getSegundoApellido(); 
//       }  
//        
//        if(sn.compareTo("")==0 && sa.compareTo("")==0){
//           lblNombreEmpleado.setText(pn+" "+pa); 
//        }else  if(sn.compareTo("")==0){
//           lblNombreEmpleado.setText(pn+" "+pa+" "+sa); 
//        }else if(sa.compareTo("")==0){
//           lblNombreEmpleado.setText(pn+" "+sn+" "+pa); 
//        }else{
//            lblNombreEmpleado.setText(pn+" "+sn+" "+pa); 
//        }
//    }
    
      public String fechaNow(){
        String fecha="";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha=dateFormat.format(date);
        return fecha;
    }
    
    public String horaNow(){
        String hora="";
        Date date = new Date();
//        Caso 1: obtener la hora y salida por pantalla con formato:
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        hora=hourFormat.format(date);      
        return hora;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopuMenuActualizar = new javax.swing.JPopupMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiActualizar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jPanel1 = new javax.swing.JPanel();
        cbxTipoDocumento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblResolucionFactura = new javax.swing.JLabel();
        cbxResolucionFactura = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDescripcionCaja = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNumeroDocumento = new javax.swing.JTextField();
        txtIdTipoDocumento = new javax.swing.JTextField();
        txtNomCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        txtIdResolucion = new javax.swing.JTextField();
        lblFechaActual = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBusArticulo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArticulosEnVentas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
        btnQuitarArti = new javax.swing.JButton();
        btnCancelVenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();

        jPopuMenuActualizar.add(jSeparator2);

        jmiActualizar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jmiActualizar.setText("Actualizar");
        jmiActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiActualizarActionPerformed(evt);
            }
        });
        jPopuMenuActualizar.add(jmiActualizar);
        jPopuMenuActualizar.add(jSeparator1);

        setClosable(true);
        setTitle("Gestion de Ventas");
        setComponentPopupMenu(jPopuMenuActualizar);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "item1", "item2" }));
        cbxTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo documento");

        lblResolucionFactura.setText("Resolucion Factura:");

        cbxResolucionFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxResolucionFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxResolucionFacturaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Empleado:");

        lblNombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblNombreEmpleado.setText("Nombre empleado");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caja:");

        lblDescripcionCaja.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblDescripcionCaja.setText("Caja");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblDescripcionCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescripcionCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nro Documento"));

        txtNumeroDocumento.setEditable(false);
        txtNumeroDocumento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtIdTipoDocumento.setEditable(false);

        txtNomCliente.setEditable(false);
        txtNomCliente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Cliente:");

        txtCodigoCliente.setEditable(false);

        btnBuscarCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtIdResolucion.setEditable(false);

        lblFechaActual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFechaActual.setText("YYYY-MM-DD");

        jLabel8.setText("Fecha Actual:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtIdTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtIdResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxResolucionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblResolucionFactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblResolucionFactura)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomCliente)
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(cbxResolucionFactura)
                                    .addComponent(txtIdResolucion)
                                    .addComponent(txtCodigoCliente)
                                    .addComponent(cbxTipoDocumento)
                                    .addComponent(txtIdTipoDocumento)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnBusArticulo.setBackground(new java.awt.Color(204, 204, 204));
        btnBusArticulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBusArticulo.setText("Buscar Articulo");
        btnBusArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusArticuloActionPerformed(evt);
            }
        });

        tblArticulosEnVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblArticulosEnVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Articulo", "Articulo", "Descripcion", "Cantidad", "Precio Venta", "Sub total", "% Iva", "Iva", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArticulosEnVentas.setRowHeight(22);
        tblArticulosEnVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblArticulosEnVentasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblArticulosEnVentas);
        if (tblArticulosEnVentas.getColumnModel().getColumnCount() > 0) {
            tblArticulosEnVentas.getColumnModel().getColumn(0).setMinWidth(110);
            tblArticulosEnVentas.getColumnModel().getColumn(0).setMaxWidth(110);
            tblArticulosEnVentas.getColumnModel().getColumn(3).setMinWidth(80);
            tblArticulosEnVentas.getColumnModel().getColumn(3).setMaxWidth(80);
            tblArticulosEnVentas.getColumnModel().getColumn(6).setMinWidth(50);
            tblArticulosEnVentas.getColumnModel().getColumn(6).setMaxWidth(50);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRealizarVenta.setBackground(new java.awt.Color(0, 204, 204));
        btnRealizarVenta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel11.setText("Total Venta:");

        lblTotalCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lblTotalCompra.setForeground(new java.awt.Color(0, 0, 153));
        lblTotalCompra.setText("0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 212, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addGap(37, 37, 37)
                .addComponent(lblTotalCompra)
                .addGap(35, 35, 35)
                .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnQuitarArti.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuitarArti.setText("Quitar Articulo");
        btnQuitarArti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarArtiActionPerformed(evt);
            }
        });

        btnCancelVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelVenta.setText("Cancelar Venta");
        btnCancelVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelVentaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Total Iva:");

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(204, 204, 204));
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBusArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnQuitarArti)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelVenta)
                                .addGap(343, 343, 343)
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarArti, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusArticuloActionPerformed
        ListadoArticuloGui articuloVentana=new ListadoArticuloGui(null, true);
        articuloVentana.setVisible(true);
    }//GEN-LAST:event_btnBusArticuloActionPerformed

    private void btnQuitarArtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarArtiActionPerformed
        modelo=(DefaultTableModel)tblArticulosEnVentas.getModel();
        int filasele=tblArticulosEnVentas.getSelectedRow();//indice fila seleccionada
        int cantFilas=tblArticulosEnVentas.getRowCount();//cantidad de filas en el table
        int cantFilasSelecc=tblArticulosEnVentas.getSelectedRowCount();////Obtener el número de filas seleccionadas
        
        if(cantFilas>0){//se evalua si hay filas o no en el jtable
            if(cantFilasSelecc==1){//evalua si por lo menos tiene seleccionada una fila en el Jtable
                  int rspta=JOptionPane.showConfirmDialog(null, "¿Esta seguro de Quitar este Articulo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);        
                  if(rspta==0){
                    modelo.removeRow(filasele);
//                    txtPorcenDescuento.setText("");
//                    txtTotalDescuento.setText("");
//                    txtPorcenDescuento.setEnabled(false);
                  } 
            }          
        }
        
    }//GEN-LAST:event_btnQuitarArtiActionPerformed

    private void btnCancelVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelVentaActionPerformed
        int rpta=1;
        int cantFilas=tblArticulosEnVentas.getRowCount();//cantidad de filas en el table
        if(cantFilas>0){
           rpta=JOptionPane.showConfirmDialog(null, "¿Esta seguro de Cancelar la Venta?","Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(rpta==0){
              borrarJtableArticulos();
//              txtPorcenDescuento.setText("");
//              txtTotalDescuento.setText("");
//              txtPorcenDescuento.setEnabled(false);
            } 
        }       
       
    }//GEN-LAST:event_btnCancelVentaActionPerformed
    
    private void tblArticulosEnVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblArticulosEnVentasKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           int filaSeleccionada=tblArticulosEnVentas.getSelectedRow();
           int codigoArticulo=Integer.valueOf(modelo.getValueAt(filaSeleccionada, 0).toString());
           int cantidadEnExistencia=objCtrlAr.cantidadEnExistencia(codigoArticulo);
           String nombreArticulo=modelo.getValueAt(filaSeleccionada, 1).toString();
           
           int cantidad=0;
           boolean bandera=true;
           
           do {
               try{
                  cantidad = Integer.valueOf(JOptionPane.showInputDialog("Modificar Cantidad:"));
               }catch(NumberFormatException e){
                   JOptionPane.showMessageDialog(null, "La cantidad no se modifico!");
                   bandera=false;
                   break;
               }
               
               if(cantidad <= 0){
                   JOptionPane.showMessageDialog(null,"Digite una cantidad mayor que (0)");
                   bandera=false;
               }else if(cantidad > cantidadEnExistencia){
                    JOptionPane.showMessageDialog(null,"No hay esa cantidad disponible de "+nombreArticulo);
                    bandera=false;
               }else{
                   bandera=true;
               }
           } while (bandera==false);
              
           if(bandera){
                String precioVenta=String.valueOf(modelo.getValueAt(filaSeleccionada, 4));
                double total=cantidad*Double.parseDouble(precioVenta);
                String totalString=String.valueOf(total);
                modelo.setValueAt(cantidad, filaSeleccionada,3);
                modelo.setValueAt(totalString, filaSeleccionada,6);
           }
           
       }
    }//GEN-LAST:event_tblArticulosEnVentasKeyPressed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
          int rpta=JOptionPane.showConfirmDialog(null, "¿Esta seguro de Realizar la Venta?","Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(rpta==0){
                int numeroFilas=tblArticulosEnVentas.getRowCount();            

                if(txtCodigoCliente.getText().length()>0){//valida que seleccione un cliente
                    if(numeroFilas>0){//valida que seleccione productos
                        realizarVenta();
                        borrarJtableArticulos();
                        limpiarVentana();
//                        txtPorcenDescuento.setText("");
//                        txtTotalDescuento.setText("");
//                        txtPorcenDescuento.setEnabled(false);
                       
                    }else{
                        JOptionPane.showMessageDialog(null,"Seleccione productos primero");
                        btnBusArticulo.requestFocus();
                    }
                }else{
                     JOptionPane.showMessageDialog(null,"Seleccione un cliente");
                     btnBuscarCliente.requestFocus();
                }
          }
          
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        ListadoClienteGui clienteVentana=new ListadoClienteGui(null, true);
        clienteVentana.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cbxResolucionFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxResolucionFacturaActionPerformed
        ResolucionFactura rf=(ResolucionFactura) cbxResolucionFactura.getSelectedItem();
        String idResolucionFactura = String.valueOf(rf.getIdResolucionFactura());
        txtIdResolucion.setText(idResolucionFactura);
    }//GEN-LAST:event_cbxResolucionFacturaActionPerformed

    private void cbxTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoDocumentoActionPerformed
        TipoDocumento tp=(TipoDocumento) cbxTipoDocumento.getSelectedItem();
        String id = String.valueOf(tp.getCodigoDocumento());
        txtIdTipoDocumento.setText(id);

        if(tp.getDescripcion().equalsIgnoreCase("Cotizacion") || tp.getDescripcion().equalsIgnoreCase("Cotizaciones")){
            btnRealizarVenta.setText("Realizar Cotizacion");
            cbxResolucionFactura.setVisible(false);
            lblResolucionFactura.setVisible(false);
            txtIdResolucion.setText("0");//envio numero 0 para que al guardarlo en el ctrl comparo y mando resulucion null
            
        }else{
            btnRealizarVenta.setText("Realizar Venta");
            cbxResolucionFactura.setVisible(true);
            lblResolucionFactura.setVisible(true);
            objCtrlRF.cargarCB(cbxResolucionFactura);//con esto se actualiza el txtidResolucion con el id
        }

    }//GEN-LAST:event_cbxTipoDocumentoActionPerformed

    private void jmiActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiActualizarActionPerformed
//        objCtrlC.cargarCB(cbxCaja);
        objCtrlRF.cargarCB(cbxResolucionFactura);
        objCtrlTD.cargarCB(cbxTipoDocumento);
    }//GEN-LAST:event_jmiActualizarActionPerformed
    
    public void limpiarVentana(){
         txtNumeroDocumento.setText(String.valueOf(objCtrlF.ConsecutivoCodigoDB()));
         txtCodigoCliente.setText("");
         txtNomCliente.setText("");
         
    }
        
    private void realizarVenta(){
        Factura objF=new Factura();
        DetalleVenta objDv=new DetalleVenta();
        CtrlDetalleVenta objCtrlDv=new CtrlDetalleVenta();
        Cliente objCli=new Cliente();
        Usuario objU=new Usuario();
        int cantidadEnExistencia=0;
        int cantidaArestarDB=0;
        
        //ARRAYLIST PARA IMPRIMIR
        ArrayList<DetalleVenta> listado=new ArrayList<>();
        
        objF.setNumeroDocumento(Integer.valueOf(txtNumeroDocumento.getText()));
        objF.setCodigoDocumento(Integer.valueOf(txtIdTipoDocumento.getText()));
        java.sql.Date fechaSql=new java.sql.Date(setDarFormatoFecha(lblFechaActual.getText()).getTime());
        objF.setFecha(fechaSql); 
        objF.setHora(setFormatoHora(horaNow()));
        objF.setCodigoCaja(Integer.valueOf(MenuPrincipal.CODIGOCAJA));//CODIGO CAJA DESDE LA VENTANA MENUPRINCIPAL
             objCli.setCodigoCliente(Integer.valueOf(txtCodigoCliente.getText()));
        objF.setCliente(objCli);
       
        objF.setIdResolucionFactura(Integer.valueOf(txtIdResolucion.getText()));
            objU.setIdUsuario(MenuPrincipal.MPIDUSUARIO);//********CODIGO DE USUARIO LOGUEADO!********
        objF.setUsuario(objU);
                
        if(objCtrlF.guardar(objF)){
            int numeroFilas=tblArticulosEnVentas.getRowCount();
            for(int i=0;i<numeroFilas;i++){//ciclo para DETALLE VENTA IR AGREGANDO ARTICULOS
                cantidadEnExistencia=objCtrlAr.cantidadEnExistencia(Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 0).toString()));
                objDv.setNumeroDocumento(Integer.valueOf(txtNumeroDocumento.getText()));
                objDv.setCodigoArticulo(Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 0).toString()));
                objDv.setCantidad(Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 3).toString()));
                objDv.setIva(Double.valueOf(tblArticulosEnVentas.getValueAt(i, 7).toString()));
           
//                if(txtPorcenDescuento.getText().length()>0){
//                   objDv.setPorcentajeDescuento(Double.parseDouble(txtPorcenDescuento.getText()));
//                   objDv.setTotalDescuento(Double.parseDouble(txtTotalDescuento.getText())); 
//                }
                
                objDv.setTotal(Double.valueOf(tblArticulosEnVentas.getValueAt(i, 8).toString()));
                //cantidad a restar en la DB
                
                listado.add(objDv);
                objCtrlDv.guardar(objDv);//GUARDO PRIMERO Y SEGUIDAMENTE MODIFICO INVENTARIO DE CADA ARTICULO
                if(cbxTipoDocumento.getSelectedItem().toString().equalsIgnoreCase("Factura") || 
                        cbxTipoDocumento.getSelectedItem().toString().equalsIgnoreCase("Facturacion")){
                    cantidaArestarDB=cantidadEnExistencia-Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 3).toString());
                    objCtrlAr.ActualizarIventarioArti(Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 0).toString()),
                            cantidaArestarDB);//actualiza la cantidad de X articulo en la BD
                }
            }
            
           if(cbxTipoDocumento.getSelectedItem().toString().equalsIgnoreCase("Cotizacion") || 
                cbxTipoDocumento.getSelectedItem().toString().equalsIgnoreCase("Cotizacion")){
               JOptionPane.showMessageDialog(null, "<html><h1 style='color:blue;'>Cotizacion Realizada con exito!</h1></html>"); 
           }else{
              JOptionPane.showMessageDialog(null, "<html><h1 style='color:blue;'>Venta Realizada con exito!</h1></html>"); 
               imprimirFactura();
           }            
            
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar!!!");
        }
        
    }
    
    public void imprimirFactura(){
        List listado= new ArrayList();
         listaDT objlis;
       int numeroFilas=tblArticulosEnVentas.getRowCount();
        for(int i=0;i<3;i++){
            System.out.println("entre imprimir"+(i+1));
            objlis=new listaDT(Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 0).toString()),
                    tblArticulosEnVentas.getValueAt(i, 1).toString(),
                    Integer.valueOf(tblArticulosEnVentas.getValueAt(i, 3).toString()),
                    Double.valueOf(tblArticulosEnVentas.getValueAt(i, 4).toString()),
                    Double.valueOf(tblArticulosEnVentas.getValueAt(i, 5).toString()),
                    Double.valueOf(tblArticulosEnVentas.getValueAt(i, 6).toString()),
                    Double.valueOf(tblArticulosEnVentas.getValueAt(i, 7).toString()),        
                    Double.valueOf(tblArticulosEnVentas.getValueAt(i, 8).toString()));
//            objlis=new listaDT(123,"primer ar "+(i+1), 2, 123444, 3000807, 17, 12123, 5000334);
            
            listado.add(objlis);
        }
//          for(int i=0;i<listado.size();i++){
//              System.out.println("-->DT"+i+" {"+listado.get(i).getCodigoArticulo()+"--"+listado.get(i).getNomArticulo()+"--"+listado.get(i).getCantidad()
//              +"--"+listado.get(i).getPrecioVenta()+"--"+listado.get(i).getSubTotal()+"--"+listado.get(i).getPorIva()+"--"+
//                      listado.get(i).getIva()+"--"+listado.get(i).getTotal());
//        }
        try {
            JasperReport reporte=(JasperReport)JRLoader.loadObject("imprimirFactura.jasper");
            Map parametro=new HashMap();
            parametro.put("descDocumento", cbxTipoDocumento.getSelectedItem().toString());
            parametro.put("numeroDocumento", txtNumeroDocumento.getText());
            parametro.put("nombre", txtNomCliente.getText());
            parametro.put("primerNombre",lblNombreEmpleado.getText());
            parametro.put("descripcion", lblDescripcionCaja.getText());
            
            JasperPrint jprint=JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(listado));
            JasperViewer.viewReport(jprint, false);//false para que no cierre todo el programa
            
            
        } catch (JRException ex) {
            Logger.getLogger(VentasGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public Date setDarFormatoFecha(String fechaParametro){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha =fechaParametro;
        Date fecha = null;
        try {
          fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
        return fecha;
    }
     
    public Time setFormatoHora(String horaParametro){
        String horaStr =horaParametro;
        SimpleDateFormat miFormato = new SimpleDateFormat("HH:mm:ss");
        Time t =null;
        long horaSql=0l;
        try {
           horaSql = miFormato.parse(horaStr).getTime();
           t=new Time(horaSql);
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
        return t;
    } 
        
     private void borrarJtableArticulos(){
        modelo=(DefaultTableModel)tblArticulosEnVentas.getModel();//
        for (int i = tblArticulosEnVentas.getRowCount() -1; i >= 0; i--){ 
                modelo.removeRow(i); 
        } 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusArticulo;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelVenta;
    private javax.swing.JButton btnQuitarArti;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JComboBox cbxResolucionFactura;
    private javax.swing.JComboBox cbxTipoDocumento;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopuMenuActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jmiActualizar;
    private javax.swing.JLabel lblDescripcionCaja;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblResolucionFactura;
    private javax.swing.JLabel lblTotalCompra;
    public static javax.swing.JTable tblArticulosEnVentas;
    public static javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtIdResolucion;
    private javax.swing.JTextField txtIdTipoDocumento;
    private javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNumeroDocumento;
    // End of variables declaration//GEN-END:variables
}
