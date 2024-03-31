/**
 * fecha de creacion: junio de 2018
 * nombre: MenuPrincipalBiblioteca
 * Punto de inicio de la aplicacion, proporciona el menu para acceder a los procesos
 * entrada null
 * salida ejecuta los módulos: 
 * @author: braulio valdes 
 */
package vista;

import controlador.ControladorArriendos;
import controlador.ControladorPersona;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Arriendos;
import modelo.Personas;

/**
 *
 * @author BRAULIOMARIANO
 */
public class MenuPrincipalBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalBiblioteca
     */
    
    public static boolean procesoCompraLibro;
    public static int rutClienteDevolucion;
    FParametros fpm = new FParametros();
    FComprasLibros fcl = new FComprasLibros();
    FVentasLibros fvl = new FVentasLibros();
    FMantenedorLibro fml = new FMantenedorLibro();
    FArriendosLibros fal = new FArriendosLibros();
    FPersona fp = new FPersona();
    JFrameListaHistorialArriendos flha = new JFrameListaHistorialArriendos();
    JFrameListaCompras flc = new JFrameListaCompras();
    JFrameListaVentas flv = new JFrameListaVentas();
    JFrameClientesEnMora fcem = new JFrameClientesEnMora();
    FEditorial fe = new FEditorial();
    FAutor fa = new FAutor();
    FIdioma fi = new FIdioma();
    FCategoria fc = new FCategoria();
    FDistribuidor fd = new FDistribuidor();
    FDevoluciones fdv  = new FDevoluciones();
    FCambioDeFecha fcf = new FCambioDeFecha();
    JFrameListaLibros fll = new JFrameListaLibros();
    JFrameListaPersonas flp = new JFrameListaPersonas();
    public static Calendar cal = Calendar.getInstance();
    public static int diaSistema,mesSistema,yearSistema;
    int ImpuestoIva, MultaAtrasoDiario, DescuentoTipo1, DescuentoTipo2;
   
    public MenuPrincipalBiblioteca() {
    
        initComponents(); 
        this.getContentPane().setBackground(Color.GREEN);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Color JPanel
        //jPanel1.setBackground(Color.GREEN);       
        //this.setLocationRelativeTo(null);     
        diaSistema=cal.get(Calendar.DATE);
        mesSistema=cal.get(Calendar.MONTH);
        //mes aumentar en 1 porque enero = 0
        mesSistema++;
        yearSistema=cal.get(Calendar.YEAR);
        
        //JOptionPane.showMessageDialog(null, "fecha:"+diaSistema+"/"+mesSistema+"/"+yearSistema, "",0);
 
        lbFechaSistema.setText(String.valueOf(diaSistema)+"/"+String.valueOf(mesSistema)+"/"+String.valueOf(yearSistema));
        chequeoClientesEnMora();
        
    }

 /**
 * método       : chequeoClientesEnMora
 * entrada      : ninguno
 * salida       : ninguno
 * descripcion  : bloquea chilente con arriendos en mora 
 */
    
    public void chequeoClientesEnMora(){
        //busca clientes(personas) en mora arriendos
        Date fechaDevolucion;
 	Date fechaHoy = new Date(); 
        String fecha;
        boolean clienteConLibrosEnArriendo = false;
        int largoPersonas, largoArriendos, rut;
        
        ControladorArriendos cArriendos = new ControladorArriendos();
        ArrayList<Arriendos> arriendos;

        ControladorPersona cP = new ControladorPersona();
        ArrayList<Personas> personas = cP.consultarTodo();
        //consulta si existen personas
        if(personas!=null){
            largoPersonas = personas.size();
            while (largoPersonas>0){
                if (personas.get(largoPersonas-1).getTipo_persona()==0 || personas.get(largoPersonas-1).getTipo_persona()==3){
                    //es cliente
                    rut = personas.get(largoPersonas-1).getId_persona_rut();
                    arriendos = cArriendos.leerPersonaEnArriendo(rut);
                    //busca arriendos del cliente
                    largoArriendos = arriendos.size();
                    while(largoArriendos>0){
                        fecha = arriendos.get(largoArriendos-1).getDia_devolucion_estimada()+"/"+
                                 arriendos.get(largoArriendos-1).getMes_devolucion_estimada()+"/"+
                                  arriendos.get(largoArriendos-1).getYear_devolucion_estimada();
                        fechaDevolucion = ParseFecha(fecha);
                        //compara fecha, si resultado > 0 es
                        
                        //java.util.Date.compareTo(Date anotherDate) method compares two Dates.
                        //0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; 
                        //and a value greater than 0 if this Date is after the Date argument.
                        
                        if(fechaHoy.compareTo(fechaDevolucion)==0){
                            //esta en mora
                            if(!cP.bloquearPersonaXmora(rut)){
                                //error bloqueo cliente
                                JOptionPane.showMessageDialog(null, "Atención!, ocurrio un error durante actualización registro cliente", "",1);
                            }
                            break;
                        }
                        largoArriendos--;
                    }   
                }
                largoPersonas--;
            }
        }
    }

 /**
 * método       : ParseFecha
 * entrada      : String fecha
 * salida       : fecha Date o null 
 * descripcion  : valida fecha 
 */
 
    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        lbFechaSistema = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSalida = new javax.swing.JMenu();
        mnuSalidaCerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnProcesosCompras = new javax.swing.JMenuItem();
        mnProcesosVentas = new javax.swing.JMenuItem();
        mnProcesosArriendos = new javax.swing.JMenuItem();
        mnProcesosDevoluciones = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuMantenedorLibros = new javax.swing.JMenuItem();
        mnuMantenedorDistribuidor = new javax.swing.JMenuItem();
        mnuMantenedorPersonas = new javax.swing.JMenuItem();
        mnuMantenedorCategorias = new javax.swing.JMenuItem();
        mnuMantenedorAutores = new javax.swing.JMenuItem();
        mnuMantenedorIdiomas = new javax.swing.JMenuItem();
        mnuMantenedorEditoriales = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        mnuInformeArriendos = new javax.swing.JMenuItem();
        mnuInformeVentas = new javax.swing.JMenuItem();
        mnuInformeCompras = new javax.swing.JMenuItem();
        jMenuPersonas = new javax.swing.JMenuItem();
        jMenuLibros = new javax.swing.JMenuItem();
        mnuInformeClientesEnMora = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        mnuConfiguracionParametros = new javax.swing.JMenuItem();
        mnuFechaProceso = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem12.setText("jMenuItem12");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar4.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar4.add(jMenu10);

        jMenuItem13.setText("jMenuItem13");

        jMenu11.setText("File");
        jMenuBar5.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar5.add(jMenu12);

        jMenu13.setText("File");
        jMenuBar6.add(jMenu13);

        jMenu14.setText("Edit");
        jMenuBar6.add(jMenu14);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setLocation(new java.awt.Point(300, 100));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("  BIBLIOTECA v1.0/2018");

        lbFechaSistema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbFechaSistema.setForeground(new java.awt.Color(0, 0, 255));
        lbFechaSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 255));

        jMenuSalida.setForeground(new java.awt.Color(0, 0, 255));
        jMenuSalida.setText(" Salida ");
        jMenuSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuSalidaCerrar.setText("Cerrar");
        mnuSalidaCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalidaCerrarActionPerformed(evt);
            }
        });
        jMenuSalida.add(mnuSalidaCerrar);

        jMenuBar1.add(jMenuSalida);

        jMenu2.setForeground(new java.awt.Color(0, 0, 255));
        jMenu2.setText(" Procesos ");
        jMenu2.setToolTipText("");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnProcesosCompras.setText("Compras");
        mnProcesosCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProcesosComprasActionPerformed(evt);
            }
        });
        jMenu2.add(mnProcesosCompras);

        mnProcesosVentas.setText("Ventas");
        mnProcesosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProcesosVentasActionPerformed(evt);
            }
        });
        jMenu2.add(mnProcesosVentas);

        mnProcesosArriendos.setText("Arriendos");
        mnProcesosArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProcesosArriendosActionPerformed(evt);
            }
        });
        jMenu2.add(mnProcesosArriendos);

        mnProcesosDevoluciones.setText("Devoluciones");
        mnProcesosDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProcesosDevolucionesActionPerformed(evt);
            }
        });
        jMenu2.add(mnProcesosDevoluciones);

        jMenuBar1.add(jMenu2);

        jMenu4.setForeground(new java.awt.Color(0, 0, 255));
        jMenu4.setText(" Mantenedores ");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuMantenedorLibros.setText("Libros");
        mnuMantenedorLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorLibrosActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorLibros);

        mnuMantenedorDistribuidor.setText("Distribuidores");
        mnuMantenedorDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorDistribuidorActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorDistribuidor);

        mnuMantenedorPersonas.setText("Personas");
        mnuMantenedorPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorPersonasActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorPersonas);

        mnuMantenedorCategorias.setText("Categorias");
        mnuMantenedorCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorCategoriasActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorCategorias);

        mnuMantenedorAutores.setText("Autores");
        mnuMantenedorAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorAutoresActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorAutores);

        mnuMantenedorIdiomas.setText("Idiomas");
        mnuMantenedorIdiomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorIdiomasActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorIdiomas);

        mnuMantenedorEditoriales.setText("Editoriales");
        mnuMantenedorEditoriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenedorEditorialesActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMantenedorEditoriales);

        jMenuBar1.add(jMenu4);

        jMenu16.setForeground(new java.awt.Color(0, 0, 255));
        jMenu16.setText(" Informes ");
        jMenu16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuInformeArriendos.setText("Arriendos");
        mnuInformeArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformeArriendosActionPerformed(evt);
            }
        });
        jMenu16.add(mnuInformeArriendos);

        mnuInformeVentas.setText("Ventas");
        mnuInformeVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformeVentasActionPerformed(evt);
            }
        });
        jMenu16.add(mnuInformeVentas);

        mnuInformeCompras.setText("Compras");
        mnuInformeCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformeComprasActionPerformed(evt);
            }
        });
        jMenu16.add(mnuInformeCompras);

        jMenuPersonas.setText("Personas");
        jMenuPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonasActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuPersonas);

        jMenuLibros.setText("Libros");
        jMenuLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLibrosActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuLibros);

        mnuInformeClientesEnMora.setText("Clientes en Mora");
        mnuInformeClientesEnMora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformeClientesEnMoraActionPerformed(evt);
            }
        });
        jMenu16.add(mnuInformeClientesEnMora);

        jMenuBar1.add(jMenu16);

        jMenu15.setForeground(new java.awt.Color(0, 0, 255));
        jMenu15.setText(" Configuracion ");
        jMenu15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuConfiguracionParametros.setText("Parametros");
        mnuConfiguracionParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfiguracionParametrosActionPerformed(evt);
            }
        });
        jMenu15.add(mnuConfiguracionParametros);

        mnuFechaProceso.setText("Fecha Proceso");
        mnuFechaProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFechaProcesoActionPerformed(evt);
            }
        });
        jMenu15.add(mnuFechaProceso);

        jMenuBar1.add(jMenu15);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFechaSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbFechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 /**
 * método       : esNumero
 * entrada      : String
 * salida       : boolean 
 * descripcion  : valida número 
 */
    
    public static boolean esNumero(String dato){
        try{
            int cambio = Integer.parseInt(dato);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
 /**
 * método       : modulo11
 * entrada      : String
 * salida       : String 
 * descripcion  : valida rut 
 */
    
    
    public static String modulo11(String rut){
        
        int largo=rut.length();
        int f = 2;
        int acumulador = 0;
        while(largo>0){
            largo--;
            int m = Integer.parseInt(rut.substring(largo,largo+1));
            acumulador = acumulador + (m*f);
            f = f + 1;
            if (f > 7){
                f = 2;
            }
        }
   
        acumulador = acumulador % 11;                
        acumulador = 11 - acumulador;
        if (acumulador == 10){
            return "0";
        }
        if (acumulador == 11){
            return "K";
        }
        return String.valueOf(acumulador);
    }
 
    
    private void mnProcesosComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProcesosComprasActionPerformed
        // TODO add your handling code here:
        if(!fcl.isVisible()){
            fcl = new FComprasLibros();
            fml.jTableLibros.setEnabled(false);
            fml.btnBuscar.setEnabled(false);
            fml.txtBuscarSerie.setEnabled(false);
            fml.txtBuscarTitulo.setEnabled(false);
            fml.btnEstado.setEnabled(false);
            procesoCompraLibro=true;
            fcl.setVisible(true);
        }    
        
    }//GEN-LAST:event_mnProcesosComprasActionPerformed

    private void mnProcesosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProcesosVentasActionPerformed
        // TODO add your handling code here:
        if(!fvl.isVisible()){
            fvl = new FVentasLibros();
            fvl.setVisible(true);
        }
        
    }//GEN-LAST:event_mnProcesosVentasActionPerformed

    private void mnProcesosArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProcesosArriendosActionPerformed
        // TODO add your handling code here:
        
        if(!fal.isVisible()){
            fal = new FArriendosLibros();
            fal.setVisible(true);
        }
        
    }//GEN-LAST:event_mnProcesosArriendosActionPerformed

    private void mnuMantenedorPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorPersonasActionPerformed
        // TODO add your handling code here:
        if(!fp.isVisible()){
            fp = new FPersona();
            fp.setVisible(true);
        }
        
        
    }//GEN-LAST:event_mnuMantenedorPersonasActionPerformed

    private void mnuMantenedorLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorLibrosActionPerformed
        // TODO add your handling code here:
        if(!fml.isVisible()){

            fml = new FMantenedorLibro();
            fml.jTableLibros.setEnabled(true);
            fml.btnBuscar.setEnabled(true);
            fml.txtBuscarSerie.setEnabled(true);
            fml.txtBuscarTitulo.setEnabled(true);
            procesoCompraLibro=false;
            fml.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuMantenedorLibrosActionPerformed

    private void mnuMantenedorEditorialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorEditorialesActionPerformed
        // TODO add your handling code here:
        
        if(!fe.isVisible()){
            fe = new FEditorial();
            fe.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuMantenedorEditorialesActionPerformed

    private void mnuMantenedorAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorAutoresActionPerformed
        // TODO add your handling code here:
        
        if(!fa.isVisible()){
            fa = new FAutor();
            fa.setVisible(true);
        }
    }//GEN-LAST:event_mnuMantenedorAutoresActionPerformed

    private void mnuMantenedorIdiomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorIdiomasActionPerformed
        // TODO add your handling code here:
        
        if(!fi.isVisible()){
            fi = new FIdioma();
            fi.setVisible(true);
        }
    }//GEN-LAST:event_mnuMantenedorIdiomasActionPerformed

    private void mnuMantenedorCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorCategoriasActionPerformed
        // TODO add your handling code here:
        
        if(!fc.isVisible()){
            fc = new FCategoria();
            fc.setVisible(true);
        }
    }//GEN-LAST:event_mnuMantenedorCategoriasActionPerformed

    private void mnuMantenedorDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenedorDistribuidorActionPerformed
        // TODO add your handling code here:
        if(!fd.isVisible()){
            fd = new FDistribuidor();
            fd.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuMantenedorDistribuidorActionPerformed

    private void mnuSalidaCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalidaCerrarActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
        
    }//GEN-LAST:event_mnuSalidaCerrarActionPerformed

    private void mnProcesosDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProcesosDevolucionesActionPerformed
        // TODO add your handling code here:
        
        if(!fdv.isVisible()){
            fdv = new FDevoluciones();
            fdv.setVisible(true);
        }
    }//GEN-LAST:event_mnProcesosDevolucionesActionPerformed

    private void mnuConfiguracionParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfiguracionParametrosActionPerformed
        // TODO add your handling code here:
        if(!fpm.isVisible()){
            fpm = new FParametros();
            fpm.setVisible(true);
        }
    }//GEN-LAST:event_mnuConfiguracionParametrosActionPerformed

    private void mnuInformeClientesEnMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformeClientesEnMoraActionPerformed
        // TODO add your handling code here:
        if(!fcem.isVisible()){
            fcem = new JFrameClientesEnMora();
            fcem.setVisible(true);
        }
        
        
    }//GEN-LAST:event_mnuInformeClientesEnMoraActionPerformed

    private void mnuInformeArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformeArriendosActionPerformed
        // TODO add your handling code here:
        if(!flha.isVisible()){
            flha = new JFrameListaHistorialArriendos();
            flha.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuInformeArriendosActionPerformed

    private void mnuInformeComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformeComprasActionPerformed
        // TODO add your handling code here:
        if(!flc.isVisible()){
            flc = new JFrameListaCompras();
            flc.setVisible(true);
        }
    }//GEN-LAST:event_mnuInformeComprasActionPerformed

    private void mnuInformeVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformeVentasActionPerformed
        // TODO add your handling code here:
        if(!flv.isVisible()){
            flv = new JFrameListaVentas();
            flv.setVisible(true);
        }
    }//GEN-LAST:event_mnuInformeVentasActionPerformed

    private void mnuFechaProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFechaProcesoActionPerformed
        // TODO add your handling code here:
        
        if(!fcf.isVisible()){
            fcf = new FCambioDeFecha();
            fcf.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuFechaProcesoActionPerformed

    private void jMenuLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLibrosActionPerformed
        // TODO add your handling code here:
        
        if(!fll.isVisible()){
            fll = new JFrameListaLibros();    
            fll.setVisible(true);
        }
        
    }//GEN-LAST:event_jMenuLibrosActionPerformed

    private void jMenuPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonasActionPerformed
        // TODO add your handling code here:
        if(!flp.isVisible()){
            flp = new JFrameListaPersonas();    
            flp.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jMenuPersonasActionPerformed

    
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
            java.util.logging.Logger.getLogger(MenuPrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuLibros;
    private javax.swing.JMenuItem jMenuPersonas;
    private javax.swing.JMenu jMenuSalida;
    public static javax.swing.JLabel lbFechaSistema;
    private javax.swing.JMenuItem mnProcesosArriendos;
    private javax.swing.JMenuItem mnProcesosCompras;
    private javax.swing.JMenuItem mnProcesosDevoluciones;
    private javax.swing.JMenuItem mnProcesosVentas;
    private javax.swing.JMenuItem mnuConfiguracionParametros;
    private javax.swing.JMenuItem mnuFechaProceso;
    private javax.swing.JMenuItem mnuInformeArriendos;
    private javax.swing.JMenuItem mnuInformeClientesEnMora;
    private javax.swing.JMenuItem mnuInformeCompras;
    private javax.swing.JMenuItem mnuInformeVentas;
    private javax.swing.JMenuItem mnuMantenedorAutores;
    private javax.swing.JMenuItem mnuMantenedorCategorias;
    private javax.swing.JMenuItem mnuMantenedorDistribuidor;
    private javax.swing.JMenuItem mnuMantenedorEditoriales;
    private javax.swing.JMenuItem mnuMantenedorIdiomas;
    private javax.swing.JMenuItem mnuMantenedorLibros;
    private javax.swing.JMenuItem mnuMantenedorPersonas;
    private javax.swing.JMenuItem mnuSalidaCerrar;
    // End of variables declaration//GEN-END:variables
}
