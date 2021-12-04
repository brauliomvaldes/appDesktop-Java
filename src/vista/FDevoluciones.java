/**
 * fecha de creacion: junio de 2018
 * nombre: FDevoluciones
 * Su función realizar devoluciones de libros arrendados
 * entrada seleccionar arriendo
 * salida null
 * @author: braulio valdes 
 */
package vista;

import controlador.ControladorArriendos;
import controlador.ControladorArriendosDetalle;
import controlador.ControladorParametros;
import controlador.ControladorPersona;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Arriendos;
import modelo.ArriendosDetalle;
import modelo.Parametros;
import modelo.PersonaDAO;
import modelo.Personas;
import static vista.MenuPrincipalBiblioteca.cal;
import static vista.MenuPrincipalBiblioteca.diaSistema;
import static vista.MenuPrincipalBiblioteca.esNumero;
import static vista.MenuPrincipalBiblioteca.mesSistema;
import static vista.MenuPrincipalBiblioteca.modulo11;
import static vista.MenuPrincipalBiblioteca.yearSistema;

/**
 *
 * @author BRAULIOMARIANO
 */
public class FDevoluciones extends javax.swing.JFrame {

    /**
     * 
     */
    
    String [] titulos = {"RUT","N° RECIBO","SERIE LIBRO","FECHA ARRIENDO",
                            "FECHA DEVOLUCION","ESTADO","DIAS ATRASO","MULTA"};
    String [] campos = new String [8];
    DefaultTableModel modelTableDevoluciones;
    DefaultComboBoxModel comboClientes;
    int valorMulta, diasAtraso, valorArriendoDiario;
    public static int ImpuestoIva, MultaAtrasoDiario, DescuentoTipo1, DescuentoTipo2;   
    long idFolio;
    int topeDiaMes, dia, mes, year;
    int indexTotal;
    long [] comprobanteLibroEnArriendo;
    String [] serieLibroEnArriendo;
    int [][] estadoArriendo;
 
    public FDevoluciones() {
        
        initComponents();
        //this.setAlwaysOnTop(true);
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        lbFechaSistema.setText(String.valueOf(diaSistema)+"/"+String.valueOf(mesSistema)+"/"+String.valueOf(yearSistema));    
        leerParametros();
        poblarClientes();
        poblarCalendario();
        
    }
    
    private void leerParametros(){
        ControladorParametros c = new ControladorParametros();
        Parametros p = c.leer(1);
        if(p==null){
            c.agregar();
        }else{
            ImpuestoIva=p.getImpuesto_iva();
            MultaAtrasoDiario=p.getMulta_atraso_diario();
            DescuentoTipo1=p.getDescuento_especial();
            DescuentoTipo2=p.getMonto_minimo_descuento();
        }
    }

    
        
    private void listaArriendosCliente(int rutCliente){  
        PersonaDAO pDAO = new PersonaDAO();
        Personas cliente = pDAO.read(rutCliente);
        labelCliente.setText("CLIENTE: "+cliente.getNombre()+" "+cliente.getApaterno()+" RUT: "+ 
                         cliente.getId_persona_rut()+"-"+cliente.getDv_persona());
        ControladorArriendos cArriendos = new ControladorArriendos();
        ControladorArriendosDetalle cAD = new ControladorArriendosDetalle();
        ArrayList<Arriendos> arriendos;
        ArrayList<ArriendosDetalle> librosArrendados;
        arriendos = cArriendos.leerPersonaEnArriendo(rutCliente);
        if(arriendos.isEmpty()){
            if(this.isVisible()){
                JOptionPane.showMessageDialog(null, "¡Atención!, CLIENTE sin LIBROS en Arriendo", "",1);
            }
        }else{
            
            modelTableDevoluciones = new DefaultTableModel(null,titulos);                
            TableColumnModel columnModel = jTableDevolucionArriendos.getColumnModel();
            String fechaArriendo, fechaDevolucion, estado;
            Date fDevolucion, fechaHoy;
            String hoy = String.valueOf(dia).trim()+"/"+String.valueOf(mes).trim()+"/"+String.valueOf(year).trim();
            fechaHoy = ParseFecha(hoy);
            // alinear texto celdas de una tabla
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();        
            
            //pobar tabla con arriendos del cliente
            if(!arriendos.isEmpty()){
                //almacena números de arriendos del cliente
                int largo=arriendos.size();
                int puntero=0;
                int index=0;
                
                //busca total comprobantes de arriendo que tiene el cliente
                while(puntero<largo){
                    //acumula libros arrendados por cada comprobante
                    index=index+arriendos.get(puntero).getLibros_arrendados();
                    puntero++;
                }
                
                // coserva para la devolucion efectiva de libros
                indexTotal=index;
                //dimensiona contenedor de comprobante de arriendo
                comprobanteLibroEnArriendo = new long[index];
                //dimensiona contendor de serie del libro arrendado
                serieLibroEnArriendo = new String [index];
                //dimensiona estado del arriendo, estado actual, estado cambiado por devolcion
                estadoArriendo = new int[index][2];
                //index para almacenar datos en paralelo
                int nuevoIndex = 0;
                while (largo>0){
                    //determina el comprbante de arriendo para buscar los libros contenidos
                    idFolio = arriendos.get(largo-1).getId_folio_comprobante_arriendo();
                    librosArrendados = cAD.leerAllXfolio(idFolio);
                    //extrae libros por cada arriendo segun comprobante
                    if(librosArrendados!=null){
                        //almacena numero de libros contenidos en el arriendo
                        int lArrayList = librosArrendados.size();
                        while(lArrayList>0){
                            //almacena el egreso y serie libros
                            comprobanteLibroEnArriendo[nuevoIndex]=librosArrendados.get(lArrayList-1).getId_folio_comprobante_arriendo();
                            serieLibroEnArriendo[nuevoIndex]=librosArrendados.get(lArrayList-1).getSerie();
                            //almacena estado de arriendo del libro 
                            estadoArriendo[nuevoIndex][0]=librosArrendados.get(lArrayList-1).getEstado();
                            estadoArriendo[nuevoIndex][1]=librosArrendados.get(lArrayList-1).getEstado();
                            
                            campos[0]=String.valueOf(arriendos.get(largo-1).getId_cliente());
                            campos[1]=String.valueOf(idFolio);
                            fechaArriendo=String.valueOf(arriendos.get(largo-1).getDia_arriendo());
                            fechaArriendo=fechaArriendo+"/"+String.valueOf(arriendos.get(largo-1).getMes_arriendo());
                            fechaArriendo=fechaArriendo+"/"+String.valueOf(arriendos.get(largo-1).getYear_arriendo());
                            campos[3]=fechaArriendo;
                            campos[2]=String.valueOf(librosArrendados.get(lArrayList-1).getSerie());
                            fechaDevolucion=String.valueOf(arriendos.get(largo-1).getDia_devolucion_estimada());
                            fechaDevolucion=fechaDevolucion+"/"+String.valueOf(arriendos.get(largo-1).getMes_devolucion_estimada());
                            fechaDevolucion=fechaDevolucion+"/"+String.valueOf(arriendos.get(largo-1).getYear_devolucion_estimada());
                            campos[4]=fechaDevolucion;
                            fDevolucion=ParseFecha(fechaDevolucion);
                            
        
                            diasAtraso=(int) ((fechaHoy.getTime()-fDevolucion.getTime())/86400000);
                            estado="";
                            valorArriendoDiario=librosArrendados.get(lArrayList-1).getValor_arriendo();
                            valorMulta=0;
                            if(librosArrendados.get(lArrayList-1).getEstado()==0){
                                diasAtraso=0;
                                estado="devuelto********";
                            }else{
                                estado="LIBRO EN ARRIENDO";
                                if(diasAtraso>0){
                                    valorMulta=calculaMulta(valorArriendoDiario, diasAtraso);   
                                }else{
                                    diasAtraso=0;
                                }
                            }
                            campos[5]=estado;
                            campos[6]=String.valueOf(diasAtraso);
                            campos[7]=String.valueOf(valorMulta);
                            modelTableDevoluciones.addRow(campos);
                            nuevoIndex++;
                            lArrayList--;
                        }
                        largo--;
                    }
                }
                jTableDevolucionArriendos.removeAll();
                jTableDevolucionArriendos.setModel(modelTableDevoluciones);
                jTableDevolucionArriendos.setShowGrid(true);
                Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER   
                jTableDevolucionArriendos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
                Alinear.setHorizontalAlignment(SwingConstants.LEFT);//.LEFT .RIGHT .CENTER                           
                jTableDevolucionArriendos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
                jTableDevolucionArriendos.getColumnModel().getColumn(7).setCellRenderer(Alinear);
                columnModel.getColumn(0).setPreferredWidth(30);
                columnModel.getColumn(1).setPreferredWidth(30);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(50);
                columnModel.getColumn(6).setPreferredWidth(40);
                columnModel.getColumn(7).setPreferredWidth(40);                     
            }            
        }   
    }
    
        
    public int calculaMulta(int valorArriendoDiario, int diasAtraso){
        float aPago=(float) valorArriendoDiario;
        float valorPago=0;
        float multaDiaria = (float) MultaAtrasoDiario;
        int multa;
        multaDiaria = multaDiaria / 100f;
        multaDiaria = multaDiaria + 1f;
        for(int m=0;m<diasAtraso;m++){
            aPago=aPago*multaDiaria;
            valorPago=valorPago+aPago;
        }
        multa = (int)valorPago;
        return multa;
    }
    
    private boolean validaFecha(){
        topeDiaMes=0;
            
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes ==8 || mes==10 || mes==12){
            topeDiaMes = 31;
        }
        if(mes==4 || mes==6 || mes==9 || mes ==11){
            topeDiaMes = 30;
        }
        if(mes==2){
            topeDiaMes = 28;
        }
        if((year%4==0) & mes==2){
            topeDiaMes = 29;    
        }
        if(dia>topeDiaMes){
            return false;
        }
        return true;
    }
    
    
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
    
    private void poblarClientes(){
        ControladorPersona cD = new ControladorPersona();
        ArrayList<Personas> lista = cD.consultarTodo();
        comboClientes = new DefaultComboBoxModel();
        String estado;
        for (Personas p : lista) {
            // dependiente = 1
            if(p.getTipo_persona()!=1){  
                if(p.getEstado()==1){
                    estado = "vigente"; 
                    comboClientes.addElement(p.getNombre()+"("+p.getId_persona_rut()+")"+"["+estado+"]");
                    cmbCliente.setModel(comboClientes);
                }
            }
        }        
    }

    private void calculaTotalArriendo(int subTotal){
        float ivaParametro = (float)ImpuestoIva;
        float divisor = 100f;
        float porciento = 1f;

        ivaParametro = ivaParametro / divisor;
        ivaParametro = ivaParametro + porciento;

        float real = subTotal / ivaParametro;

        int neto = (int)real;
        int iva = subTotal - neto;
        txtNetoArriendo.setText(String.valueOf(neto));
        txtIvaArriendo.setText(String.valueOf(iva));
        txtTotalArriendo.setText(String.valueOf(subTotal));
        txtTotalArriendo.setHorizontalAlignment(JTextField.RIGHT);
        txtNetoArriendo.setHorizontalAlignment(JTextField.RIGHT);
        txtIvaArriendo.setHorizontalAlignment(JTextField.RIGHT);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDevolucionArriendos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTotalMulta = new javax.swing.JTextField();
        txtNetoArriendo = new javax.swing.JTextField();
        txtIvaArriendo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalArriendo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        btnConfirmarDevolucion = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        labelTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        cmbMesProceso = new javax.swing.JComboBox<>();
        cmbYearProceso = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbDiaProceso = new javax.swing.JComboBox<>();
        lbFechaSistema = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(50, 100));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDevolucionArriendos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "N° RECIBO", "SERIE LIBRO", "FECHA ARRIENDO", "FECHA DEVOLUCION", "ESTADO", "DIAS ATRASO", "MULTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDevolucionArriendos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDevolucionArriendosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDevolucionArriendos);
        if (jTableDevolucionArriendos.getColumnModel().getColumnCount() > 0) {
            jTableDevolucionArriendos.getColumnModel().getColumn(0).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(1).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(2).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(3).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(4).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(5).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(6).setResizable(false);
            jTableDevolucionArriendos.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 800, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("L i b r o s   A r r e n d a d o s  p o r  e l  C l i e n t e.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 160, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CLICK SOBRE REGISTRO PARA DEVOLVER LIBRO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        labelCliente.setText("CLIENTE :");
        getContentPane().add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 102, -1, -1));

        txtNetoArriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetoArriendoActionPerformed(evt);
            }
        });
        txtNetoArriendo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNetoArriendoPropertyChange(evt);
            }
        });

        txtIvaArriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaArriendoActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Multa");

        jLabel5.setText("NETO");

        jLabel6.setText("IVA 18%");

        jLabel7.setText("TOTAL");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Estado de Cuenta");

        btnCalcular.setText("Calcula");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnConfirmarDevolucion.setText("Confirma Devolucion");
        btnConfirmarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarDevolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIvaArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(txtNetoArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirmarDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnConfirmarDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNetoArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIvaArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 99, 259, -1));

        labelTitulo.setText("CLIENTE");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("< D  E V O L U C I O N E S   D E   L I B R O S  >");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 130, 1229, 29));

        jLabel9.setText("FECHA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, -1, 20));

        cmbMesProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMesProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 69, -1, -1));

        cmbYearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbYearProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 69, -1, -1));

        jLabel16.setText("/");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 69, -1, -1));

        jLabel17.setText("/");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 69, -1, -1));

        cmbDiaProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbDiaProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 69, -1, -1));

        lbFechaSistema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbFechaSistema.setForeground(new java.awt.Color(0, 0, 255));
        lbFechaSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbFechaSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 20, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableDevolucionArriendosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDevolucionArriendosMouseClicked
        // TODO add your handling code here:
        
        int xTotalMulta=0, y=0;
        if(!txtTotalMulta.getText().isEmpty()){
            xTotalMulta=Integer.parseInt(txtTotalMulta.getText());  
        }
        int fila = jTableDevolucionArriendos.getSelectedRow();
        int multa = 0;
        if(estadoArriendo[fila][0]==1){
            multa = Integer.parseInt(String.valueOf(modelTableDevoluciones.getValueAt(jTableDevolucionArriendos.getSelectedRow(),7)));
            if(estadoArriendo[fila][1]==1){
                //se cambia a devuelto
                y = xTotalMulta + multa;
                estadoArriendo[fila][1]=0;
                jTableDevolucionArriendos.setOpaque(true);
            }else{
                //se cambia a pendiente
                y = xTotalMulta - multa;
                estadoArriendo[fila][1]=1;
                jTableDevolucionArriendos.setOpaque(false);
            }
            txtTotalMulta.setText(String.valueOf(y));
            txtTotalMulta.setHorizontalAlignment(JTextField.RIGHT);
            calculaTotalArriendo(y);
        }
        //hacer click en tabla        
        
        
    }//GEN-LAST:event_jTableDevolucionArriendosMouseClicked

    private void txtNetoArriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetoArriendoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetoArriendoActionPerformed

    private void txtIvaArriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaArriendoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaArriendoActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
        String cCliente=(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        int rut_cliente = Integer.parseInt(cCliente.substring(cCliente.indexOf("(") + 1, cCliente.indexOf(")"))); 
        listaArriendosCliente(rut_cliente);        
   
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void txtNetoArriendoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNetoArriendoPropertyChange
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtNetoArriendoPropertyChange

    private void cmbMesProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesProcesoActionPerformed
        // TODO add your handling code here:

        mes = Integer.parseInt(cmbMesProceso.getItemAt(cmbMesProceso.getSelectedIndex()));
        String cCliente=(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        if(!cCliente.isEmpty()){
            int rut_cliente = Integer.parseInt(cCliente.substring(cCliente.indexOf("(") + 1, cCliente.indexOf(")"))); 
            listaArriendosCliente(rut_cliente);
        }
    }//GEN-LAST:event_cmbMesProcesoActionPerformed

    private void cmbYearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearProcesoActionPerformed
        // TODO add your handling code here:

        year = Integer.parseInt(cmbYearProceso.getItemAt(cmbYearProceso.getSelectedIndex()));
        String cCliente=(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        if(!cCliente.isEmpty()){
            int rut_cliente = Integer.parseInt(cCliente.substring(cCliente.indexOf("(") + 1, cCliente.indexOf(")"))); 
            listaArriendosCliente(rut_cliente);
        }
    }//GEN-LAST:event_cmbYearProcesoActionPerformed

    private void cmbDiaProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaProcesoActionPerformed
        // TODO add your handling code here:
        dia = Integer.parseInt(cmbDiaProceso.getItemAt(cmbDiaProceso.getSelectedIndex()));
        String cCliente=(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        if(!cCliente.isEmpty()){
            int rut_cliente = Integer.parseInt(cCliente.substring(cCliente.indexOf("(") + 1, cCliente.indexOf(")"))); 
            listaArriendosCliente(rut_cliente);
        }
    }//GEN-LAST:event_cmbDiaProcesoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        
        if(!txtTotalMulta.getText().isEmpty()){
            int subTotal = Integer.parseInt(txtTotalMulta.getText());
            calculaTotalArriendo(subTotal);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnConfirmarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDevolucionActionPerformed
        // TODO add your handling code here:
        ControladorArriendosDetalle cDA = new ControladorArriendosDetalle();
       
        long folio_arriendo;
        String serie_libro;
        for(int p=0;p<indexTotal;p++){
            //System.out.println("estados:"+estadoArriendo[p][0]+"->"+estadoArriendo[p][1]);
            
            if(estadoArriendo[p][0]==1 & estadoArriendo[p][1]==0){
                //libro fue devuelto, debe grabar esta modificacion en detalle libros arrendados
                folio_arriendo = comprobanteLibroEnArriendo[p];
                serie_libro = serieLibroEnArriendo[p];
                if(!cDA.modificarEstado(folio_arriendo, serie_libro)){
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar datos devolción", "",1);
                }
            }
        }
        String cCliente=(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        int rut_cliente = Integer.parseInt(cCliente.substring(cCliente.indexOf("(") + 1, cCliente.indexOf(")"))); 
        chequeoClientesConLibrosEnArriendo();
        listaArriendosCliente(rut_cliente);        
        JOptionPane.showMessageDialog(null, "TOTAL A PAGAR $ "+txtTotalArriendo.getText(), "",1);

    }//GEN-LAST:event_btnConfirmarDevolucionActionPerformed

        public void chequeoClientesConLibrosEnArriendo(){
        boolean enMora = false;
        boolean clienteConLibrosEnArriendo;
        long id_arriendo;
        int largoArriendos, largoDetalle;
        
        int diaRealDev = Integer.parseInt(cmbDiaProceso.getItemAt(cmbDiaProceso.getSelectedIndex()));
        int mesRealDev = Integer.parseInt(cmbMesProceso.getItemAt(cmbMesProceso.getSelectedIndex()));
        int yearRealDev = Integer.parseInt(cmbYearProceso.getItemAt(cmbYearProceso.getSelectedIndex()));        
                
        ControladorArriendos cArriendos = new ControladorArriendos();
        ControladorArriendosDetalle cAD = new ControladorArriendosDetalle();
        ArrayList<Arriendos> arriendos;
        ArrayList<ArriendosDetalle> librosArrendados;
        
        arriendos = cArriendos.consultarTodo();
        if(!arriendos.isEmpty()){
            largoArriendos = arriendos.size();
            while(largoArriendos>0){
                clienteConLibrosEnArriendo = false;               
                id_arriendo = arriendos.get(largoArriendos-1).getId_folio_comprobante_arriendo();
                librosArrendados = cAD.leerAllXfolio(id_arriendo);
                if(librosArrendados!=null){
                    largoDetalle = librosArrendados.size();
                    while(largoDetalle>0){
                        if(librosArrendados.get(largoDetalle-1).getEstado()==1){
                            clienteConLibrosEnArriendo=true;
                        }
                        largoDetalle--;
                    }
                    if(!clienteConLibrosEnArriendo){
                        //el cliente no tiene libros por devolver
                        
                        if(!cArriendos.cambiarEstado(id_arriendo,diaRealDev,mesRealDev,yearRealDev)){
                            //error cambio estado a todo devuelto
                            JOptionPane.showMessageDialog(null, "Atención!, ocurrio un error durante actualización registro arriendos", "",1);
                        }
                    }
                }
                largoArriendos--;
            }
        }
    }

    
    private void poblarCalendario(){
        try{
            for(int d=1;d<32;d++){
                cmbDiaProceso.addItem(String.valueOf(d));
            }
            for(int m=1;m<13;m++){
                cmbMesProceso.addItem(String.valueOf(m));
            }
      
            for(int a=yearSistema;a>2000;a--){
                cmbYearProceso.addItem(String.valueOf(a));
            }
            cmbDiaProceso.setSelectedIndex(diaSistema-1);
            cmbMesProceso.setSelectedIndex(mesSistema-1);
            cmbYearProceso.setSelectedIndex(0);
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "fecha:"+diaSistema+"/"+mesSistema+"/"+yearSistema, "",0);
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
            java.util.logging.Logger.getLogger(FDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDevoluciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnConfirmarDevolucion;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbDiaProceso;
    private javax.swing.JComboBox<String> cmbMesProceso;
    private javax.swing.JComboBox<String> cmbYearProceso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableDevolucionArriendos;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel lbFechaSistema;
    private javax.swing.JTextField txtIvaArriendo;
    private javax.swing.JTextField txtNetoArriendo;
    private javax.swing.JTextField txtTotalArriendo;
    private javax.swing.JTextField txtTotalMulta;
    // End of variables declaration//GEN-END:variables
}
