/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.CtrLogin;
import Control.CtrlArticulo;
import Control.CtrlCaja;
import Modelo.TurnoCaja;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author JEFERSSON
 */
public class MenuPrincipal extends javax.swing.JFrame {
    CtrlCaja objCtrlCa=new CtrlCaja();
    CtrLogin objCtrlL=new CtrLogin();
    public static int CODIGOCAJA;
    public static String DESCRIPCIONCAJA;
    public static int MPIDUSUARIO;
    public static String MPNOMBREUSUARIO; 
    
    public static int IDTURNOCAJA;
    
    VentasGui ventas;
    ClienteGui cliente;
    ProveedorGui proveedor;
    ArticulosGui articulos;
    UsuarioGui usuario;
    ReporFacturaGui reporFactura;
    ReporCotizacionGui reporCotizacion;
    
    public MenuPrincipal() {
        initComponents();
        CODIGOCAJA=0;
        DESCRIPCIONCAJA="";
        MPIDUSUARIO=0;
        MPNOMBREUSUARIO="";
        IDTURNOCAJA=0;
        this.getContentPane().setBackground(Color.WHITE);        
        setLocationRelativeTo(null);
        pedirCodigoCaja();
        
        
        if(Principal.NOMROL.equalsIgnoreCase("Empleado")){
            
            btnUsuario.setEnabled(false);           
            btnProveedor.setEnabled(false);
            
            jMenuCiudad.setEnabled(false);
            jMenuTipoIdentidad.setEnabled(false);
            jMenuCargos.setEnabled(false);
            jMenuRol.setEnabled(false);
            jMenuLineaProducto.setEnabled(false);
            jMenuSublineaPro.setEnabled(false);
            jMenuCaja.setEnabled(false);
            jMenuHorarioLaboral.setEnabled(false);
            jMenuResoFactura.setEnabled(false);
//            jMenuResoFactura.setEnabled(false);no va
//            jMenuReportes.setEnabled(false);no va
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JToggleButton();
        btnClientes = new javax.swing.JToggleButton();
        btnProveedor = new javax.swing.JToggleButton();
        btnArticulo = new javax.swing.JToggleButton();
        btnUsuario = new javax.swing.JToggleButton();
        contenedor = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCiudad = new javax.swing.JMenuItem();
        jMenuTipoIdentidad = new javax.swing.JMenuItem();
        jMenuCargos = new javax.swing.JMenuItem();
        jMenuRol = new javax.swing.JMenuItem();
        jMenuLineaProducto = new javax.swing.JMenuItem();
        jMenuSublineaPro = new javax.swing.JMenuItem();
        jMenuCaja = new javax.swing.JMenuItem();
        jMenuHorarioLaboral = new javax.swing.JMenuItem();
        jMenuResoFactura = new javax.swing.JMenuItem();
        jMenuCerrarSesion = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuReporFac = new javax.swing.JMenuItem();
        jMenuReporCotiza = new javax.swing.JMenuItem();
        jMenuArtiMasVendido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(77, 182, 172));

        buttonGroup1.add(btnVentas);
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/ventas.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setToolTipText("Accede a Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnClientes);
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setToolTipText("Accede a Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnProveedor);
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/proveedores.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setToolTipText("Accede a Proveedores");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnArticulo);
        btnArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/articulos.png"))); // NOI18N
        btnArticulo.setText("Articulo");
        btnArticulo.setToolTipText("Accede a Articulos");
        btnArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticuloActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnUsuario);
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/jefe.png"))); // NOI18N
        btnUsuario.setText("Usuario");
        btnUsuario.setToolTipText("Accede a Usuarios");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(535, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escoge en el menu de la parte superior, el modulo al que quieres acceder.");

        contenedor.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(265, 265, 265))
        );

        jMenuBar.setBackground(new java.awt.Color(178, 223, 219));

        jMenu1.setText("Configuracion");

        jMenuCiudad.setText("Ciudad");
        jMenuCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCiudadActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCiudad);

        jMenuTipoIdentidad.setText("Tipo Identidad");
        jMenuTipoIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTipoIdentidadActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuTipoIdentidad);

        jMenuCargos.setText("Cargos");
        jMenuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCargosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCargos);

        jMenuRol.setText("Rol");
        jMenuRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRolActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuRol);

        jMenuLineaProducto.setText("Linea Producto");
        jMenuLineaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLineaProductoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuLineaProducto);

        jMenuSublineaPro.setText("Sub Linea Producto");
        jMenuSublineaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSublineaProActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSublineaPro);

        jMenuCaja.setText("Caja");
        jMenuCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCajaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCaja);

        jMenuHorarioLaboral.setText("Horario Laboral");
        jMenuHorarioLaboral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHorarioLaboralActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuHorarioLaboral);

        jMenuResoFactura.setText("Resolucion Factura");
        jMenuResoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuResoFacturaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuResoFactura);

        jMenuCerrarSesion.setText("Cerrar Sesión");
        jMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCerrarSesion);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar.add(jMenu1);

        jMenuReportes.setText("Reportes");
        jMenuReportes.setToolTipText("Accede a Repotes");

        jMenuReporFac.setText("Facturas");
        jMenuReporFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReporFacActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuReporFac);

        jMenuReporCotiza.setText("Cotizaciones");
        jMenuReporCotiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReporCotizaActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuReporCotiza);

        jMenuArtiMasVendido.setText("Articulo Mas Vendido");
        jMenuArtiMasVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArtiMasVendidoActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuArtiMasVendido);

        jMenuBar.add(jMenuReportes);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedor)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void pedirCodigoCaja(){
        boolean bandera=true;
        int codigoCaja=0;
        do{
            try{
               codigoCaja=Integer.valueOf(JOptionPane.showInputDialog("<html><h2>Digite por favor el codigo de la caja:</h2></html>"));
              // JOptionPane.showMessageDialog(null,"codigoCaja="+codigoCaja+" \nfechaActual="+fechaNow()+" Hora inicial="+ horaNow());
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"<html><h3 style='color:red;'>Codigo de caja Invalido!</h3></html>"); 
               bandera=false;
            }
            
            if(objCtrlCa.buscarCajaXcodigo(codigoCaja)==1){//BUSCA QUE EL CODIGO DIGITADO EXISTA! osea que aqui deja SEGUIR!
                bandera=true;
                JOptionPane.showMessageDialog(null,"<html><h3 style='color:green;'>Codigo de caja Aceptado</h3></html>");
                CODIGOCAJA=codigoCaja;
                DESCRIPCIONCAJA=objCtrlCa.buscarDescCaja(codigoCaja);
                MPIDUSUARIO=Principal.IDUSUARIO;
                MPNOMBREUSUARIO=Principal.NOMBREEMPLEADO;
                IDTURNOCAJA=objCtrlCa.ConsecutivoCodigoDB();
                TurnoCaja tc=new TurnoCaja();
                    tc.setIdTurnoCaja(IDTURNOCAJA);
                    tc.setIdUsuario(Principal.IDUSUARIO);
                    tc.setCodCaja(codigoCaja);
                    tc.setFecha(Date.valueOf(objCtrlL.fechaNow()));
                    tc.setHoraInicial(Time.valueOf(objCtrlL.horaNow()));                
                objCtrlCa.insertTurnoCaja(tc);//inserta el turnoCaja
            }else{
                bandera=false;
                JOptionPane.showMessageDialog(null,"<html><h3 style='color:red;'>No existe ese codigo de Caja!</h3></html>"); 
            }
            
            if(bandera==false){//MENSAJE PARA CONTINUAR DIGITANDO CODIGO CAJA O NO SEGUIR Y SALIR DEL SISTEMA
                int rpta=JOptionPane.showConfirmDialog(null, "<html><h3>¿Desea digitar otra vez el Codigo de Caja?</h3></html>");
                if(rpta==1){
                    System.exit(0);
                    return;                
                }
            }            
            
        }while(bandera==false);
    }
    
    
    private void jMenuLineaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLineaProductoActionPerformed
        LineaProductoGui objL=new LineaProductoGui(null, true);
        objL.setVisible(true);
    }//GEN-LAST:event_jMenuLineaProductoActionPerformed

    private void jMenuCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCiudadActionPerformed
        CiudadGui objC=new CiudadGui(null, true);
        objC.setVisible(true);
    }//GEN-LAST:event_jMenuCiudadActionPerformed

    private void jMenuTipoIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTipoIdentidadActionPerformed
      TipoIdentidadGui objTP=new TipoIdentidadGui(null,true);
      objTP.setVisible(true);
    }//GEN-LAST:event_jMenuTipoIdentidadActionPerformed

    private void jMenuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCargosActionPerformed
        CargoGui objCar=new CargoGui(null, true);
        objCar.setVisible(true);
    }//GEN-LAST:event_jMenuCargosActionPerformed

    private void jMenuRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRolActionPerformed
       RolGui objR=new RolGui(null, true);
       objR.setVisible(true);
    }//GEN-LAST:event_jMenuRolActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        objCtrlCa.modificarTurnoCaja(IDTURNOCAJA,objCtrlL.horaNow());//modifica hora final de turnocaja
        JOptionPane.showMessageDialog(null, "<html><h2 style=color:'green';>Saliste del Sistema!</h2></html>");
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCajaActionPerformed
        CajaGui objCajaGui=new CajaGui(null, true);
        objCajaGui.setVisible(true);
    }//GEN-LAST:event_jMenuCajaActionPerformed

    private void jMenuHorarioLaboralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHorarioLaboralActionPerformed
        HorarioLaboralGui objHL=new HorarioLaboralGui(null,true);
        objHL.setVisible(true);
    }//GEN-LAST:event_jMenuHorarioLaboralActionPerformed

    private void jMenuResoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuResoFacturaActionPerformed
       ResolucionFacturaGUI objReFacGui=new ResolucionFacturaGUI(null, true);
       objReFacGui.setVisible(true);
    }//GEN-LAST:event_jMenuResoFacturaActionPerformed

    private void jMenuReporFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReporFacActionPerformed
//       if(reporFactura==null){
               reporFactura=new ReporFacturaGui();
               contenedor.add(reporFactura);
               contenedor.getDesktopManager().maximizeFrame(reporFactura);
               reporFactura.setVisible(true);
//           }else{
//               contenedor.getDesktopManager().maximizeFrame(reporFactura);
//           }  
    }//GEN-LAST:event_jMenuReporFacActionPerformed

    private void jMenuReporCotizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReporCotizaActionPerformed
//        if(reporCotizacion==null){
               reporCotizacion=new ReporCotizacionGui();
               contenedor.add(reporCotizacion);
               contenedor.getDesktopManager().maximizeFrame(reporCotizacion);
               reporCotizacion.setVisible(true);
//           }else{
//               contenedor.getDesktopManager().maximizeFrame(reporCotizacion);
//           }
    }//GEN-LAST:event_jMenuReporCotizaActionPerformed

    private void jMenuArtiMasVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArtiMasVendidoActionPerformed
        CtrlArticulo objCtrlAr=new CtrlArticulo();
        String mensaje=objCtrlAr.articuloMasVendido();
        JOptionPane.showMessageDialog(null, mensaje,"Articulo Mas Vendido",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuArtiMasVendidoActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
//        if(ventas==null){
        ventas=new VentasGui();
        contenedor.add(ventas);
        contenedor.getDesktopManager().maximizeFrame(ventas);
        ventas.setVisible(true);
//       }else{
//           contenedor.getDesktopManager().maximizeFrame(ventas);
//       }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
//        if(cliente==null){
            cliente=new ClienteGui();
            contenedor.add(cliente);
            contenedor.getDesktopManager().maximizeFrame(cliente);
            cliente.setVisible(true);
//        }else{
//            contenedor.getDesktopManager().maximizeFrame(cliente);
//        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
//       if(proveedor==null){
            proveedor=new ProveedorGui();
            contenedor.add(proveedor);
            contenedor.getDesktopManager().maximizeFrame(proveedor);
            proveedor.setVisible(true);
//        }else{
//            contenedor.getDesktopManager().maximizeFrame(proveedor);
//        }
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloActionPerformed
//         if(articulos==null){
            articulos=new ArticulosGui();
            contenedor.add(articulos);
            contenedor.getDesktopManager().maximizeFrame(articulos);
            articulos.setVisible(true);
//        }else{
//            contenedor.getDesktopManager().maximizeFrame(articulos);
//        }
    }//GEN-LAST:event_btnArticuloActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
//        if(usuario==null){
               usuario=new UsuarioGui();
               contenedor.add(usuario);
               contenedor.getDesktopManager().maximizeFrame(usuario);
               usuario.setVisible(true);
//           }else{
//               contenedor.getDesktopManager().maximizeFrame(usuario);
//           }  
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void jMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCerrarSesionActionPerformed
        int rpta=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar sesión?");
        
        if(rpta==0){
            JOptionPane.showMessageDialog(null,"Hasta Pronto!");
            objCtrlCa.modificarTurnoCaja(IDTURNOCAJA,objCtrlL.horaNow());//modifica hora final de turnocaja
            Principal objP=new Principal();
            objP.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuCerrarSesionActionPerformed

    private void jMenuSublineaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSublineaProActionPerformed
        SubLineaProducoGui objSLP=new SubLineaProducoGui(null,true);
        objSLP.setVisible(true);
    }//GEN-LAST:event_jMenuSublineaProActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnArticulo;
    private javax.swing.JToggleButton btnClientes;
    private javax.swing.JToggleButton btnProveedor;
    private javax.swing.JToggleButton btnUsuario;
    private javax.swing.JToggleButton btnVentas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuArtiMasVendido;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuCaja;
    private javax.swing.JMenuItem jMenuCargos;
    private javax.swing.JMenuItem jMenuCerrarSesion;
    private javax.swing.JMenuItem jMenuCiudad;
    private javax.swing.JMenuItem jMenuHorarioLaboral;
    private javax.swing.JMenuItem jMenuLineaProducto;
    private javax.swing.JMenuItem jMenuReporCotiza;
    private javax.swing.JMenuItem jMenuReporFac;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenuItem jMenuResoFactura;
    private javax.swing.JMenuItem jMenuRol;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuSublineaPro;
    private javax.swing.JMenuItem jMenuTipoIdentidad;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
