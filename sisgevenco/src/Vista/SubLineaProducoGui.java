/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Control.CtrlCiudad;
import Control.CtrlLineaProducto;
import Control.CtrlSubLinea;
import Modelo.Ciudad;
import Modelo.LineaProducto;
import Modelo.SubLineaProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JEFERSSON
 */
public class SubLineaProducoGui extends javax.swing.JDialog {
 
  //VARIABLES GLOBALES EN TODA ESTA CLASE  
  CtrlSubLinea objCtrlSlp=new CtrlSubLinea();
    CtrlLineaProducto objCtrlLinP=new CtrlLineaProducto();
  DefaultTableModel modelo;//modelo de datos
  TableRowSorter<TableModel> elqueOrdena;
  
    public SubLineaProducoGui(java.awt.Frame parent, boolean modal) {// constructor de la GUI
        super(parent, modal);
        initComponents();
        txtIdLineaProducto.setVisible(false);
        txtIdSubLinea.setVisible(false);//esconde el campo del idBarrio ya que el usuario no tiene porque ver el id
        btnGuardar.setEnabled(false);//desactiva el boton
        btnEliminar.setEnabled(false);//desactiva el boton
        btnEditar.setEnabled(false);//desactiva el boton
        txtSubLineaDescripcion.setEnabled(false);
        cbxLineaProducto.setEnabled(false);
        setLocationRelativeTo(null);//centra la ventana
        objCtrlLinP.cargarCB(cbxLineaProducto);
        EsconderColumnaCodigo();//llamado de metodo, que esconde la columna de la tabla que contiene todos los idBarrio 
        traerDatosTable();//al darle run a esta ventana se carga todos los datos desde la BD en la tabla
        //al ser este metodo lo primero que se carga cuando le damos run a la ventana, es aqui donde ponemos todo lo que 
        //queramos que se ejecute en primera medida.
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSubLineaDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubLineaProducto = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        txtIdSubLinea = new javax.swing.JTextField();
        txtBuscarSubLinePro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        cbxLineaProducto = new javax.swing.JComboBox();
        txtIdLineaProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("GESTION DE SUB LINEA PRODUCTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Linea Producto:");

        btnGuardar.setBackground(new java.awt.Color(25, 115, 14));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(241, 100, 14));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblSubLineaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSubLineaProducto", "Descripcion", "Linea Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubLineaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubLineaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSubLineaProducto);

        btnEliminar.setBackground(new java.awt.Color(227, 9, 42));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtIdSubLinea.setEditable(false);

        txtBuscarSubLinePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarSubLineProKeyReleased(evt);
            }
        });

        jLabel4.setText("Buscar:");

        btnNuevo.setBackground(new java.awt.Color(23, 165, 174));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nueva");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        cbxLineaProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLineaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLineaProductoActionPerformed(evt);
            }
        });

        txtIdLineaProducto.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarSubLinePro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(75, 75, 75))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnNuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar)
                                        .addGap(19, 19, 19)
                                        .addComponent(btnEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(txtIdSubLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxLineaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIdLineaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtSubLineaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtIdSubLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubLineaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdLineaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbxLineaProducto))
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarSubLinePro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      guardar();//llamamos al metodo guardar() que mas abajo esta todo lo que contiene
    }//GEN-LAST:event_btnGuardarActionPerformed
    
      public void guardar(){// metodo que ejecuta algo en este caso instrucciones para insertar en la base de datos      
        SubLineaProducto objSlp=new SubLineaProducto();//creamos el objeto a partir de la clase Barrio
        objSlp.setSubLineaDescripcion(txtSubLineaDescripcion.getText());//seteamos la variable Nombre con lo que contenga el textfield llamado txtNombre
        objSlp.setIdLinea(Integer.valueOf(txtIdLineaProducto.getText()));//seteamos la variable Comuna con lo que contenga el textfield llamado txtComuna
        
        if(objCtrlSlp.guardar(objSlp)){// como el metodo guardar nos arroja true o false lo metemos en esta condicion
            //si todo salio bien al momento de insertar nos arroja true y entra a las siguientes acciones
            JOptionPane.showMessageDialog(null,"La Sub linea de producto se registro!");//mensaje
            borrarJtable();//Hacemos un llamado al metodo borrarJtable(); esto con el fin de hacer el efecto de actualizar el table
            traerDatosTable();//hacemos el llamado del metodo traerDatos que nos traer todo la lista de barrios de la BD
            //como arriba borramos todo lo que habia en el table con esto volvemos a traer datos dando el efecto de actualizar
            limpiar();//hacemos el llamado del metodo limpiar que lo que hace es limpiar los campos idBarrio(escondido),nombre,comuna
            btnGuardar.setEnabled(false);//si existe algo en el jtextfield activa el boton guardar
            btnEliminar.setEnabled(false);
            btnEditar.setEnabled(false);
            txtSubLineaDescripcion.setEnabled(false);
            cbxLineaProducto.setEnabled(false);
        }else{
           JOptionPane.showMessageDialog(null,"La Sub linea de producto NO Fue Registrada!");  
         }      
    }
    
    //este metodo es propio del JTable es decir usamos el evento MouseClicked que no es mas que cada vez que hacemos click en 
    //una fila sucede algo y ese algo es lo que hay dentro de este metodo  
    private void tblSubLineaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubLineaProductoMouseClicked
            int filasele=0;//variable entera que contendra el numero de la variable donde dimos click
            filasele=tblSubLineaProducto.getSelectedRow();//nos arroja el numero da fila seleccionada que empieza de 0 a n filas
            System.out.println("filasele="+filasele);//aqui se dan cuenta en consola que numero de fila es la clickeada
            
            txtIdSubLinea.setText(tblSubLineaProducto.getValueAt(filasele, 0).toString());
            txtSubLineaDescripcion.setText(tblSubLineaProducto.getValueAt(filasele, 1).toString());
//            txtDepartamento.setText(tblSubLineaProducto.getValueAt(filasele, 2).toString());
            posicioneCBLineaPro(tblSubLineaProducto.getValueAt(filasele, 2).toString());
            
            btnGuardar.setEnabled(false);//desactive el boton guardar
            btnEliminar.setEnabled(true);//activa el boton
            btnEditar.setEnabled(true);//activa el boton
            txtSubLineaDescripcion.setEnabled(true);
           cbxLineaProducto.setEnabled(true);
            
    }//GEN-LAST:event_tblSubLineaProductoMouseClicked

   public void posicioneCBLineaPro(String LineaPro){
        int n= cbxLineaProducto.getItemCount();
        String desc="";
        for(int i=0;i<n;i++){
            desc=cbxLineaProducto.getItemAt(i).toString();                      
            if(LineaPro.compareTo(desc)==0){
                cbxLineaProducto.setSelectedIndex(i);
                break;
            }
        }
    }
    
     
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       editar();//hacemos llamado del metodo editar() mas abajo esta!
    }//GEN-LAST:event_btnEditarActionPerformed
    
       public void editar(){// metodo editar que hace unas instrucciones para editar un registro
        SubLineaProducto objSlp=new SubLineaProducto();// referenciamos el objeto Barrio
        int idSublinea=Integer.valueOf(txtIdSubLinea.getText());//almacenamos en esta variable lo que hay en el txtfield oculto que tiene el idBario
        String descripcion=txtSubLineaDescripcion.getText();//almacenamos en esta variable lo que hay en el txtfield nombre
        String idLineaProducto=(txtIdLineaProducto.getText());//almacenamos en esta variable lo que hay en el txtfield comuna
        
        objSlp.setIdSubLinea(idSublinea);
        objSlp.setSubLineaDescripcion(descripcion);//seteamos la variable Nombre con lo que contenga el textfield llamado txtNombre
        objSlp.setIdLinea(Integer.valueOf(idLineaProducto));
        
        if(objCtrlSlp.modificar(objSlp)){// validamos que se cumpla todo la modificacion recordemos que el metodo modificar arroja true o false
            JOptionPane.showMessageDialog(null,"La Sub Linea de Producto se Edito con Exito!");
            //actualizamos el table
            borrarJtable();
            traerDatosTable();
            //limpiamos los campos textfield
            limpiar();
            
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnEditar.setEnabled(false);
            txtSubLineaDescripcion.setEnabled(false);
            cbxLineaProducto.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null,"La Sub Linea de Producto No se Edito!");
        }   
        
    }
       
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       eliminar();//hacemos el llamado de el metodo ellimiar, abajo esta!
    }//GEN-LAST:event_btnEliminarActionPerformed
    public void eliminar(){
        int idSublinea=Integer.valueOf(txtIdSubLinea.getText());//almacenamos en esta variable lo que hay en el txtfield oculto que tiene el idBario
        int rspta=JOptionPane.showConfirmDialog(null, "??Esta seguro de Eliminar esta Sub Linea de Producto?",
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//preguntamos si realmente quiere eliminar el barrio
        //esa respuesta la almacenamos en una variable entero puesto que este metodo nos arroja 0 si clickeamos Aceptar
        // y 1 si clickeamos Cancelar
        if(rspta==0){//comparamos la rspta, si se cumple hace lo siguiente
            if(objCtrlSlp.eliminar(idSublinea)){//recordemos que el metodo eliminar()arroja true o false si todo salio bien o mal
                JOptionPane.showMessageDialog(null,"Se elimino la Sub Linea de Producto!");
                //actualizamos el jtable
                borrarJtable();
                traerDatosTable();
                //limpiamos los jtextfield
                limpiar();
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnEditar.setEnabled(false); 
                txtSubLineaDescripcion.setEnabled(false);
                cbxLineaProducto.setEnabled(false);
                
            }
        }
    }
    
    
    private void txtBuscarSubLineProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarSubLineProKeyReleased
       String buscarC;
        buscarC=txtBuscarSubLinePro.getText();
        buscarEnTiempoReal(buscarC);
    }//GEN-LAST:event_txtBuscarSubLineProKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnGuardar.setEnabled(true);//desactiva el boton
        btnEliminar.setEnabled(false);//desactiva el boton
        btnEditar.setEnabled(false);//desactiva el boton
        txtSubLineaDescripcion.setEnabled(true);
        cbxLineaProducto.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbxLineaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLineaProductoActionPerformed
        LineaProducto lp=(LineaProducto) cbxLineaProducto.getSelectedItem();
        String idLinea = String.valueOf(lp.getidLinea());
        txtIdLineaProducto.setText(idLinea);        
    }//GEN-LAST:event_cbxLineaProductoActionPerformed
    
     public void buscarEnTiempoReal(String texto){
        borrarJtable();//borro lo que hay en el JTABLE
        modelo=(DefaultTableModel)tblSubLineaProducto.getModel();
        elqueOrdena=new TableRowSorter<TableModel>(modelo);
        tblSubLineaProducto.setRowSorter(elqueOrdena);//con esto se puede ordenar por col el jtable de manera asc o desc
                        
        ArrayList<SubLineaProducto> listado=new ArrayList();
        listado=objCtrlSlp.BusquedaTiempoReal(texto);
        Object []col=new Object[modelo.getColumnCount()];//creo un obj tipo Object del tama??o de las columnas de mi Table
        for(int index=0;index<listado.size();index++){//recorro el arrayList
            col[0]=listado.get(index).getIdSubLinea();
            col[1]=listado.get(index).getSubLineaDescripcion();
            col[2]=listado.get(index).getDescLineaProd();
                       
            modelo.addRow(col);
        } 
       
      tblSubLineaProducto.setModel(modelo);
         
     }
    
    public void limpiar(){//metodo que limpia los jtextfield
        //como vemos no tiene ciencia, es solo setear lo campos y ponerlos en blanco con "", y listo
        txtIdSubLinea.setText("");
        txtSubLineaDescripcion.setText("");
        
    }
    
    private void borrarJtable(){// este metodo limpia todo el jtable
        for (int i = tblSubLineaProducto.getRowCount() -1; i >= 0; i--){ 
                modelo.removeRow(i); 
        }      
    }
    
    public void traerDatosTable(){//como su nombre lo indica va a traer todos los datos en el jtable desde la base de datos
        modelo=(DefaultTableModel)tblSubLineaProducto.getModel();//nos arroja el modelo es decir el jtable
        elqueOrdena=new TableRowSorter<TableModel>(modelo);//ordena por columnas descendiente o ascendente lo que hay en el jtable
        tblSubLineaProducto.setRowSorter(elqueOrdena);//con esto se puede ordenar por col el jtable de manera asc o desc
                       
        ArrayList<SubLineaProducto> listado=new ArrayList();//declaramos e instanciamos un array list de tipo Barrio llamado listado
        listado=objCtrlSlp.listadoSubLineaProducto();//almacenamos en listado lo que arroja el metodo listadoBarrio() que esta en la clase CtrlBarrio
        //recordemos que ese metodo lo que arroja es un arraylist(arrayList es como un vector mejorado mil veces) INVESTIGUEN MEJOR!
        Object []col=new Object[modelo.getColumnCount()];//creo un obj tipo Object del tama??o de las columnas de mi Table
               
       for(int index=0;index<listado.size();index++){//recorro el arrayList
                col[0]=listado.get(index).getIdSubLinea();
                col[1]=listado.get(index).getSubLineaDescripcion();
                col[2]=listado.get(index).getDescLineaProd();                       
                modelo.addRow(col);//a??ado el object a la fila
       }
     
    }
    
    public void EsconderColumnaCodigo(){
        //metodo para esconder la columna que contiene el codigo de los Barios
        tblSubLineaProducto.getColumnModel().getColumn(0).setMaxWidth(0);
        tblSubLineaProducto.getColumnModel().getColumn(0).setMinWidth(0);
        tblSubLineaProducto.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblSubLineaProducto.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
            java.util.logging.Logger.getLogger(SubLineaProducoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubLineaProducoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubLineaProducoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubLineaProducoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SubLineaProducoGui dialog = new SubLineaProducoGui(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbxLineaProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblSubLineaProducto;
    private javax.swing.JTextField txtBuscarSubLinePro;
    private javax.swing.JTextField txtIdLineaProducto;
    private javax.swing.JTextField txtIdSubLinea;
    private javax.swing.JTextField txtSubLineaDescripcion;
    // End of variables declaration//GEN-END:variables
}
