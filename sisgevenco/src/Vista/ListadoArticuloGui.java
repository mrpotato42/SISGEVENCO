/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Control.CtrlArticulo;
import Modelo.Articulo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Windows 10
 */
public class ListadoArticuloGui extends javax.swing.JDialog {
    
    CtrlArticulo objCtrlAr=new CtrlArticulo();
    DefaultTableModel modeloArti,modeloArtiEnVen;//modelo de datos de tables, uno para la tabla Articulos de esta ventana y 
    //otro modelo para la tabla de articulo pero de la ventana ventas
    TableRowSorter<TableModel> elqueOrdena1,elqueOrdena2;
    public ListadoArticuloGui(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarDatosJtable();
        setLocationRelativeTo(null);
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
        txtBuscarArticulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArticulos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Articulos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        txtBuscarArticulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarArticuloKeyReleased(evt);
            }
        });

        tblArticulos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "nombre", "Descripcion", "Sub Linea", "Proveedor", "Cantidad", "Precio Venta", "% Iva"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArticulos.setRowHeight(23);
        tblArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblArticulosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblArticulos);
        if (tblArticulos.getColumnModel().getColumnCount() > 0) {
            tblArticulos.getColumnModel().getColumn(0).setMinWidth(85);
            tblArticulos.getColumnModel().getColumn(1).setMinWidth(150);
            tblArticulos.getColumnModel().getColumn(2).setMinWidth(200);
            tblArticulos.getColumnModel().getColumn(5).setMinWidth(70);
            tblArticulos.getColumnModel().getColumn(5).setMaxWidth(70);
            tblArticulos.getColumnModel().getColumn(6).setMinWidth(100);
            tblArticulos.getColumnModel().getColumn(6).setMaxWidth(100);
            tblArticulos.getColumnModel().getColumn(7).setMinWidth(70);
            tblArticulos.getColumnModel().getColumn(7).setMaxWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarArticuloKeyReleased
        String buscarC;
        buscarC=txtBuscarArticulo.getText();
        buscarEnTiempoReal(buscarC);
    }//GEN-LAST:event_txtBuscarArticuloKeyReleased
    
     public void buscarEnTiempoReal(String texto){
        borrarJtable();//borro lo que hay en el JTABLE
        modeloArti=(DefaultTableModel)tblArticulos.getModel();
        elqueOrdena1=new TableRowSorter<TableModel>(modeloArti);
        tblArticulos.setRowSorter(elqueOrdena1);//con esto se puede ordenar por col el jtable de manera asc o desc
        
                
        ArrayList<Articulo> listado=new ArrayList();
        listado=objCtrlAr.BusquedaTiempoReal(texto);
        Object []col=new Object[modeloArti.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
        for(int index=0;index<listado.size();index++){//recorro el arrayList
            col[0]=listado.get(index).getCodigoArticulo();             
            col[1]=listado.get(index).getNombreArticulo();
            col[2]=listado.get(index).getDescripcion();
            col[3]=listado.get(index).getSublineaProducto().getSubLineaDescripcion();
            col[4]=listado.get(index).getNomProvee();
            col[5]=listado.get(index).getCantidad();
            col[6]=listado.get(index).getPrecioVenta();
            col[7]=listado.get(index).getIva();            
                     
            modeloArti.addRow(col);//añado el object a la fila
        } 
       
      tblArticulos.setModel(modeloArti);
         
     }
     
     private void borrarJtable(){
        for (int i = tblArticulos.getRowCount() -1; i >= 0; i--){ 
                modeloArti.removeRow(i); 
        }      
    }
    
    
    private void tblArticulosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblArticulosKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String codigoArticulo="";            
            String nombreArti="";
            String descripcion="";
            int cantidad=0;           
            double precioVenta=0.0;
            double porcentajeIva=0.0;
            int filasele=0;
            filasele=tblArticulos.getSelectedRow();
            
            codigoArticulo=tblArticulos.getValueAt(filasele, 0).toString();
            nombreArti=tblArticulos.getValueAt(filasele, 1).toString();
            descripcion=tblArticulos.getValueAt(filasele, 2).toString();
            cantidad=Integer.valueOf(tblArticulos.getValueAt(filasele, 5).toString());
            precioVenta=Double.valueOf(tblArticulos.getValueAt(filasele, 6).toString());
            porcentajeIva=Double.valueOf(tblArticulos.getValueAt(filasele, 7).toString());
            ActualizarTablaEnVentasGui(codigoArticulo, nombreArti, descripcion,cantidad, precioVenta,porcentajeIva);
       }
    }//GEN-LAST:event_tblArticulosKeyPressed
    
    
     public void ActualizarTablaEnVentasGui(String codigoArticulo,String nombreArticulo,String descripcion,
          int cantidad,double precioVenta,double porcentajeIva){
         
        modeloArtiEnVen=(DefaultTableModel)VentasGui.tblArticulosEnVentas.getModel();
        elqueOrdena2=new TableRowSorter<TableModel>(modeloArtiEnVen);
        VentasGui.tblArticulosEnVentas.setRowSorter(elqueOrdena2);//con esto se puede ordenar por col el jtable de manera asc o desc
        
        int numFilArtiEnVenGui=VentasGui.tblArticulosEnVentas.getRowCount();
        boolean adicioneArticulo=true;
        boolean bandera=true;
        double totalIva=0.0;
        double superTotal=0.0;        
        
        if(numFilArtiEnVenGui>0){//Miramos si hay algun articulo en tblArticulosEnVentas
            for(int i=0;i<numFilArtiEnVenGui;i++){                
                if(codigoArticulo.compareTo(VentasGui.tblArticulosEnVentas.getValueAt(i, 0).toString())==0){
                    JOptionPane.showMessageDialog(null, "Ya selecciono este articulo, seleccione otro!");
                    adicioneArticulo=false;//si ya encontro
                    break;//rompo el ciclo for                    
                }
            }            
        }
        
                
        if(adicioneArticulo){
            int cantidadInput=0;
            do{
               try{ 
                cantidadInput=Integer.parseInt(JOptionPane.showInputDialog("Digite la Cantidad a comprar de "+nombreArticulo));
               }catch(NumberFormatException e){
                   JOptionPane.showMessageDialog(null, "El articulo no se adicionara hasta que digites una cantidad valida!");
                   bandera=false;
                   break;
               }
              if(cantidadInput <= 0){
                   JOptionPane.showMessageDialog(null,"Digite una cantidad mayor que (0)");
                   bandera=false;
               }else if(cantidadInput > cantidad){
                    JOptionPane.showMessageDialog(null,"No hay esa cantidad disponible de "+nombreArticulo);
                    bandera=false;
               }else{
                   bandera=true;
               }
               
            }while(bandera==false);
            
            if(bandera){
                double total=0.0;
                Object []col=new Object[modeloArtiEnVen.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
                col[0]=codigoArticulo;
                col[1]=nombreArticulo;
                col[2]=descripcion;
                col[3]=cantidadInput;
                col[4]=precioVenta;
                
                total=precioVenta*cantidadInput;
                col[5]=total;
                col[6]=porcentajeIva;
                
                
                totalIva=(total*porcentajeIva)/100;
                superTotal=total+totalIva;
                
                col[7]=totalIva;                
                col[8]=superTotal;                 
                modeloArtiEnVen.addRow(col);//añado el object a la fila

                VentasGui.tblArticulosEnVentas.setModel(modeloArtiEnVen);
                JOptionPane.showMessageDialog(null, "Se añadio el Articulo"); 
            }  
        }
        
    }
    
    public void llenarDatosJtable(){
        
        modeloArti=(DefaultTableModel)tblArticulos.getModel();                
        elqueOrdena1=new TableRowSorter<TableModel>(modeloArti);
        tblArticulos.setRowSorter(elqueOrdena1);//con esto se puede ordenar por col el jtable de manera asc o desc
        Articulo objB=new Articulo();
        ArrayList<Articulo> listado=new ArrayList<Articulo>();
        listado=objCtrlAr.traerTodos();
        Object []col=new Object[modeloArti.getColumnCount()];//creo un obj tipo Object del tamaño de las columnas de mi Table
        
        for(int index=0;index<listado.size();index++){
            col[0]=listado.get(index).getCodigoArticulo();             
            col[1]=listado.get(index).getNombreArticulo();
            col[2]=listado.get(index).getDescripcion();
            col[3]=listado.get(index).getSublineaProducto().getSubLineaDescripcion();
            col[4]=listado.get(index).getNomProvee();
            col[5]=listado.get(index).getCantidad();
            col[6]=listado.get(index).getPrecioVenta();
            col[7]=listado.get(index).getIva();
            
            modeloArti.addRow(col);
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
            java.util.logging.Logger.getLogger(ListadoArticuloGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoArticuloGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoArticuloGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoArticuloGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoArticuloGui dialog = new ListadoArticuloGui(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArticulos;
    private javax.swing.JTextField txtBuscarArticulo;
    // End of variables declaration//GEN-END:variables
}