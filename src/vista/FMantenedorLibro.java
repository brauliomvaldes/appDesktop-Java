/**
 * fecha de creacion: junio de 2018
 * nombre: FMantenedorLibro
 * Su función mantenedor libros
 * entrada datos del libro
 * salida null
 * @author: braulio valdes 
 */
package vista;

import controlador.ControladorAutores;
import controlador.ControladorCategoria;
import controlador.ControladorCompras;
import controlador.ControladorComprasDetalle;
import controlador.ControladorEditorial;
import controlador.ControladorIdioma;
import controlador.ControladorLibroAutor;
import controlador.ControladorLibroCategoria;
import controlador.ControladorLibros;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Autores;
import modelo.AutoresDAO;
import modelo.Categoria;
import modelo.Editorial;
import modelo.EditorialDAO;
import modelo.Idioma;
import modelo.IdiomaDAO;
import modelo.LibroAutor;
import modelo.LibroCategoria;
import modelo.Libros;
import static vista.MenuPrincipalBiblioteca.yearSistema;



/**
 *
 * @author BRAULIOMARIANO
 */
public class FMantenedorLibro extends javax.swing.JFrame {
    //interfaces para mantener editorial, autor, categoria,idioma
    FEditorial fe = new FEditorial();
    FAutor fa = new FAutor();
    FCategoria fc = new FCategoria();
    FIdioma fi = new FIdioma();
    DefaultListModel modelC = new DefaultListModel();
    DefaultListModel modelA = new DefaultListModel();
    DefaultTableModel modelTable;
    //contenedores para seleccionar componentes del libro
    DefaultComboBoxModel comboAutor = new DefaultComboBoxModel();
    DefaultComboBoxModel comboIdioma = new DefaultComboBoxModel();
    DefaultComboBoxModel comboEditorial = new DefaultComboBoxModel();
    DefaultComboBoxModel comboCategoria = new DefaultComboBoxModel();
    //formateo de contenedor de libros existentes
    String [] titulos = {"Serie","Isbn","Titulo","Editorial","Autor","Idioma",
        "Stock","Estado","Valor Venta","Valor Arriendo"};
    String [] campos = new String [10];
    //contenedores de autores y categorias de un libro antes de grabarlas
    int[] listaLibroAutor;
    int[] listaLibroCategoria;
    // variable mantiene estado del libro para su cambio de estado
    int suEstado;
    // maantiene cantidad original de autores y categorias de un libro a modificar
    int originalAutores;
    int originalCategorias;
    // variable insertalibro en true para insertar movimientos
    //                       en false para actualizar movimiento    
    boolean insertaLibro = true;
    
    /**
     * Creates new form FCategoria
     */
    public FMantenedorLibro() {
        initComponents();
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        txtIdioma.setEditable(false);
        txtYear.setEditable(false);
        txtEditorial.setEditable(false);
        if(MenuPrincipalBiblioteca.procesoCompraLibro){
            
            labelTitulo.setText(" <R E G I S T R O   D E   L I B R O   N U E V O> ");
        }else{
            
            labelTitulo.setText(" <M A N T E N E D O R   D E   L I B R O S> ");
        }
        limpiar();
    }
    
    private void poblarAutor(){
        ControladorAutores c = new ControladorAutores();
        ArrayList<Autores> autores = c.consultarTodo();
        // limpia combobox antes de cargar, no funcional el removeAlltItems
        // cmbAutor.removeAllItems();
        comboAutor = new DefaultComboBoxModel();
        for (Autores a : autores) {
            //solo se muestran los autores vigentes
            if(a.isEstado()){
                comboAutor.addElement(a.getNombre()+"("+a.getId_autor()+")");
                cmbAutor.setModel(comboAutor);
            }
        }
    }
    
    
    private void poblarCategoria(){
        ControladorCategoria c = new ControladorCategoria();
        ArrayList<Categoria> categoria = c.consultarTodo();
        // limpia combobox antes de cargar, no funcional el removeAlltItems
        comboCategoria = new DefaultComboBoxModel();
        for (Categoria cat : categoria) {
            //solo se muestras las categorias vigentes
            if(cat.isEstado()){
                comboCategoria.addElement(cat.getNombre()+"("+cat.getId_categoria()+")");
                cmbCategoria.setModel(comboCategoria);
            }
        }
    }

    private void poblarEditorial(){
        ControladorEditorial c = new ControladorEditorial();
        ArrayList<Editorial> editorial = c.consultarTodo();
        // limpia combobox antes de cargar, no funcional el removeAlltItems
        comboEditorial = new DefaultComboBoxModel();
        for (Editorial ed : editorial) {
            if(ed.isEstado()){
                comboEditorial.addElement(ed.getNombre()+"("+ed.getId_editorial()+")");
                cmbEditorial.setModel(comboEditorial);
            }
        }
    }
    
    private void poblarIdioma(){
        ControladorIdioma c = new ControladorIdioma();
        ArrayList<Idioma> idioma = c.consultarTodo();
        // limpia combobox antes de cargar, no funcional el removeAlltItems        
        comboIdioma = new DefaultComboBoxModel();
        
        for (Idioma i : idioma) {
            if(i.isEstado()){
                comboIdioma.addElement(i.getNombre()+"("+i.getId_idioma()+")");
                cmbIdioma.setModel(comboIdioma);
            }
        }
    }
     
    private void poblarYear(){
        for(int i=yearSistema;i>1950;i--){
            cmbYear.addItem(String.valueOf(i));
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

        jButton4 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        txtEditorial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbYear = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbIdioma = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        txtReferencia = new javax.swing.JTextField();
        txtArriendo = new javax.swing.JTextField();
        txtVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        btnCategoria = new javax.swing.JButton();
        btnEditorial = new javax.swing.JButton();
        btnAutor = new javax.swing.JButton();
        btnIdioma = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCategoria = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableLibros = new javax.swing.JTable();
        txtBuscarTitulo = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtIdioma = new javax.swing.JTextField();
        txtPaginas = new javax.swing.JTextField();
        txtBuscarSerie = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnRCategoria = new javax.swing.JButton();
        btnRAutor = new javax.swing.JButton();
        btnRIdioma = new javax.swing.JButton();
        btnREditorial = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListAutor = new javax.swing.JList<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        jButton4.setText("Nuevo");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(100, 50));
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("Cargar Libro Seleccionado");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 435, -1, 32));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("Registrar Libro");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 293, 149, 40));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 0, -1, -1));

        cmbEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditorialActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 300, -1));

        txtEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditorialActionPerformed(evt);
            }
        });
        getContentPane().add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 300, -1));

        jLabel2.setText("Categoria");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cerrar Mantenedor");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 150, 40));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 149, 40));

        jLabel3.setText("TITULO LIBRO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel4.setText("Editorial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 298, -1));

        cmbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearActionPerformed(evt);
            }
        });
        getContentPane().add(cmbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 256, 120, -1));

        jLabel5.setText("Año");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 256, -1, 20));

        jLabel6.setText("Idioma");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        cmbIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 300, -1));

        jLabel7.setText("ISBN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 183, -1));

        txtIsbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIsbnKeyTyped(evt);
            }
        });
        getContentPane().add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 183, -1));

        jLabel8.setText("Serie");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 16));

        jLabel9.setText("N° Páginas");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));
        getContentPane().add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 256, 173, -1));
        getContentPane().add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 319, 125, -1));
        getContentPane().add(txtArriendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 374, 125, -1));

        txtVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVentaActionPerformed(evt);
            }
        });
        getContentPane().add(txtVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 345, 125, -1));

        jLabel11.setText("Referencia $");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 322, -1, -1));

        jLabel12.setText("Venta $");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 348, -1, -1));

        jLabel13.setText("Arriendo $");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 377, -1, -1));

        jLabel14.setText("Autor");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        cmbAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAutorActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 297, -1));

        btnCategoria.setText("+");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        btnEditorial.setText("+");
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 40, 20));

        btnAutor.setText("+");
        btnAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 40, 20));

        btnIdioma.setText("+");
        btnIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 40, 20));

        jListCategoria.setBackground(new java.awt.Color(204, 255, 204));
        jListCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListCategoria);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 300, 78));

        jTableLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableLibros.setEnabled(false);
        jTableLibros.setRowSelectionAllowed(false);
        jTableLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLibrosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableLibros);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 467, 840, 148));

        txtBuscarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarTituloActionPerformed(evt);
            }
        });
        txtBuscarTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTituloKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 199, -1));

        txtTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 340, -1));

        txtIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 300, -1));
        getContentPane().add(txtPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 70, -1));

        txtBuscarSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarSerieActionPerformed(evt);
            }
        });
        txtBuscarSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarSerieKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscarSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 441, 225, -1));

        jLabel16.setText("busca por TITULO");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 444, -1, -1));

        jLabel17.setText("busca por SERIE");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 444, -1, -1));

        jLabel15.setText("PRECIOS CON IVA");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 303, -1, -1));

        btnRCategoria.setText("@");
        btnRCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 20));

        btnRAutor.setText("@");
        btnRAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAutorActionPerformed(evt);
            }
        });
        getContentPane().add(btnRAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 50, 20));

        btnRIdioma.setText("@");
        btnRIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        btnREditorial.setText("@");
        btnREditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREditorialActionPerformed(evt);
            }
        });
        getContentPane().add(btnREditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 180, -1, 20));

        btnEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEstado.setText("Cambia estado");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 403, 157, -1));

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
            }
        });
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 377, 157, -1));

        jListAutor.setBackground(new java.awt.Color(204, 255, 204));
        jListAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAutorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListAutor);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 298, 78));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 20, 10));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("*");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 20, 10));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("*");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 20, 10));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 20, 10));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 20, 10));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 20, 10));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 20, 10));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("*");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 20, 10));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setText("*");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 20, 10));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("*");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 20, 10));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("*");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 20, 10));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("*");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 20, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    void muestraEstado(){
        if (suEstado == 0){
            txtEstado.setText("   ¡ELIMINADO!");
            txtEstado.setForeground(Color.red);
        }else{
            txtEstado.setText("     VIGENTE");
            txtEstado.setForeground(Color.blue);
        }    
    }
    
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // carga los datos del libro seleccionado en la casilla SERIE
        //  modo actualización o modificacion
        if(!MenuPrincipalBiblioteca.procesoCompraLibro){    
            if (txtSerie.getText().isEmpty()){
                // comprueba que se haya ingresado algo
                JOptionPane.showMessageDialog(null, "Debe ingresar la SERIE del libro", "Error", 1);
                txtSerie.setFocusable(true);
            }else{
                btnBuscar.setEnabled(false);
                String serie = txtSerie.getText().trim();
                ControladorLibros buscaLibro = new ControladorLibros();
                Libros libros = buscaLibro.leer(serie); //recupera objeto libros si lo encuentra
                if (libros!=null){
                    txtIsbn.setEnabled(true);
                    txtTitulo.setEnabled(true);
                    txtEditorial.setEnabled(true);
                    txtIdioma.setEnabled(true);
                    txtPaginas.setEnabled(true);
                    txtYear.setEnabled(true);
                    txtReferencia.setEnabled(true);
                    txtVenta.setEnabled(true);
                    txtArriendo.setEnabled(true);
                    
                    jTableLibros.setEnabled(false);
                    txtBuscarTitulo.setEnabled(false);
                    txtBuscarSerie.setEnabled(false);
                    insertaLibro = false;
                    btnGuardar.setText("Actualizar");
                    btnEstado.setEnabled(true);
                    txtSerie.setEditable(false);
                    txtSerie.setEnabled(false);
                    txtIsbn.setText(libros.getIsbn());
                    
                    int auxEditorial = libros.getEditorial();
                    ControladorEditorial ced = new ControladorEditorial();
                    Editorial editorial = ced.leerXid_editorial(auxEditorial);                
                    txtEditorial.setText(editorial.getNombre()+"("+editorial.getId_editorial()+")");
            
                    int auxIdioma = libros.getIdioma();
                    ControladorIdioma cidioma = new ControladorIdioma();
                    Idioma idioma = cidioma.leerXid_idioma(auxIdioma);
                    txtIdioma.setText(idioma.getNombre()+"("+idioma.getId_idioma()+")");
                    suEstado = libros.getEstado();
                    muestraEstado();
 
                    txtYear.setText(String.valueOf(libros.getYearr()));
                    txtReferencia.setText(String.valueOf(libros.getPrecioReferencia()));
                    txtReferencia.setHorizontalAlignment(JTextField.RIGHT);
                    txtVenta.setText(String.valueOf(libros.getPrecioVenta()));
                    txtVenta.setHorizontalAlignment(JTextField.RIGHT);
                    txtArriendo.setText(String.valueOf(libros.getPrecioArriendo()));
                    txtArriendo.setHorizontalAlignment(JTextField.RIGHT);
                    txtPaginas.setText(String.valueOf(libros.getPagina()));
                    txtPaginas.setHorizontalAlignment(JTextField.RIGHT);
                    txtTitulo.setText(libros.getTitulo());
                
                    //poblar listado de libros
                    //prepara contenedor de libros y categorias
                    // buscar autores del libro
                    originalAutores = libros.getAutor();
                    originalCategorias = libros.getCategoria();
                    listaLibroAutor = new int[originalAutores];
                    listaLibroCategoria = new int[originalCategorias];
                
                    ControladorLibroAutor cla = new ControladorLibroAutor();                
                    String autorEncontrado;
                    ArrayList<LibroAutor> libroautor = cla.consultarTodoxLibro(serie);
                    // ahora recupero id del autor almacenado
                    if(libroautor!=null){
                        for(int xa=0;xa<originalAutores;xa++){
                            int id_autor = libroautor.get(xa).getId_autor();
                            ControladorAutores cAutor = new ControladorAutores();
                            Autores autoresLibro = cAutor.leerXid_autor(id_autor);
                            if(autoresLibro!=null){
                                autorEncontrado = autoresLibro.getNombre()+"("+autoresLibro.getId_autor()+")";
                                jListAutor.setModel(modelListA(autorEncontrado));
                            }else{
                                JOptionPane.showMessageDialog(null, "Autor no hallado", "Error", 1);
                            } 
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Autor no hallado", "Error", 1);
                    }
                //poblar listado de categorias
                ControladorLibroCategoria clc = new ControladorLibroCategoria();                        
                String categoriaEncontrada;
                ArrayList<LibroCategoria> librocategoria = clc.consultarTodoxLibro(serie);
                    // ahora recupero id de la categoria almacenado
                if(librocategoria!=null){
                    for(int xc=0;xc<originalCategorias;xc++){
                        int id_categoria = librocategoria.get(xc).getId_categoria();
                        ControladorCategoria cCategoria = new ControladorCategoria();
                        Categoria categoriaLibro = cCategoria.leerXid_categoria(id_categoria);
                        if(categoriaLibro!=null){
                            categoriaEncontrada = categoriaLibro.getNombre()+"("+categoriaLibro.getId_categoria()+")";
                            jListCategoria.setModel(modelListC(categoriaEncontrada));
                        }else{
                            JOptionPane.showMessageDialog(null, "Categoria no hallada", "Error", 1);
                        }                        }                        
                    }
                }       
            }
        }   
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        // controla que todos los campos tengan un dato, si autores y categorias no fueron seleccionadas tampoco pasa 
        txtSerie.setEditable(true);
        txtSerie.setEnabled(true);
        if(txtEditorial.getText().isEmpty() || txtSerie.getText().isEmpty() || !esNumero(txtYear.getText()) 
                || txtIsbn.getText().isEmpty() || !esNumero(txtReferencia.getText()) || 
                !esNumero(txtVenta.getText()) 
                || (modelA.getSize() < 1) || (modelC.getSize() < 1) || !esNumero(txtArriendo.getText())){
            JOptionPane.showMessageDialog(null, "Debe ingresar valores números y completar todos los campos", 
                               "Error de Ingreso", 1);
        }else{            
            // prepara registro libro
            String serie = txtSerie.getText().trim();
            String isbn = txtIsbn.getText();
            String titulo = txtTitulo.getText();
            int paginas = Integer.parseInt(txtPaginas.getText());
            int referencia = Integer.parseInt(txtReferencia.getText());            
            int yearr = Integer.parseInt(txtYear.getText());            
            String i = txtIdioma.getText();   
            int idioma = Integer.parseInt(i.substring(i.indexOf("(") + 1, i.indexOf(")")));
            String edt = txtEditorial.getText();
            int editorial = Integer.parseInt(edt.substring(edt.indexOf("(") + 1, edt.indexOf(")")));
            int stock = 0;
            int enArriendo = 0;
            int venta = Integer.parseInt(txtVenta.getText());
            int arriendo = Integer.parseInt(txtArriendo.getText());
  
            // grabar una vez creado el registro
            // guarda la cantidad de autores para este libro
            int autor = modelA.size();
            // guarda la cantidad de categorias que contempla el libro
            int categoria = modelC.size();
            // con los datos ingresados 
            // creamos el registro libro
            Libros registroLibro = new Libros(serie,isbn,titulo,paginas,referencia,
                    yearr,idioma,autor,categoria,editorial,suEstado,stock,enArriendo,venta,arriendo);

            // luego se registra el movimiento en las 
            //tablas auxiliares libro-autor y libro-categoria
            poblarAutoresCategorias();
            //revisa si existe el SERIE en libros y dependiendo si es una
            // actualización o creación se toma laa decisión
            ControladorLibros l = new ControladorLibros();
            Libros libros = l.leer(serie);
            if (insertaLibro){    
                if (libros!=null){
                // error se intenta crear un libro con SERIE existente
                    JOptionPane.showMessageDialog(null, "Serie de Libro existente, no se registra", 
                            "Error de Ingreso", 1);
                }else{
                    if(l.agregar(registroLibro)){
                        //grabo libro y ahora
                        //a grabar registros en libroautor y librocategoria 
                        ControladorLibroAutor cLibroAutor = new ControladorLibroAutor();
                        while(autor>0){
                            cLibroAutor.agregar(serie,listaLibroAutor[autor-1]);
                            autor--;
                        }
                        ControladorLibroCategoria cLibroCategoria = new ControladorLibroCategoria();
                        while(categoria>0){
                            cLibroCategoria.agregar(serie,listaLibroCategoria[categoria-1]);
                            categoria--;
                        }
                        // traspasa nuevo libro(titulo) al mantenedor de compras
                        FComprasLibros.txtTituloLibroComprado.setText(txtTitulo.getText());
                        FComprasLibros.txtPrecio.setText(String.valueOf(referencia));
                        FComprasLibros.txtCantidad.setText(String.valueOf(stock));
                        JOptionPane.showMessageDialog(null, "Libro creado exitosamente", 
                                    "Ingreso Válido",1);
                       if(MenuPrincipalBiblioteca.procesoCompraLibro){
                            dispose();
                        }else{
                            btnLimpiar.setEnabled(true);
                            //btnCancelar.setEnabled(true);
                            txtSerie.setEditable(true);
                        }
                        limpiar();
                    }
                }
            }else{
                if(l.actualizar(registroLibro)){
                    //grabo libro y ahora
                    //a grabar registros en libroautor y librocategoria                
                    // primero eliminaremos todos los registros para crear los nuevos    
                    ControladorLibroAutor cla = new ControladorLibroAutor();     
                    if(cla.eliminar(serie)){
                        ControladorLibroCategoria clc = new ControladorLibroCategoria();
                        if(clc.eliminar(serie)){
                                   //eliminación exitosa
                        }
                    }
                    ControladorLibroAutor cLibroAutor = new ControladorLibroAutor();
                    while(autor>0){
                        cLibroAutor.agregar(serie,listaLibroAutor[autor-1]);
                        autor--;
                    }
                    ControladorLibroCategoria cLibroCategoria = new ControladorLibroCategoria();
                    while(categoria>0){
                        cLibroCategoria.agregar(serie,listaLibroCategoria[categoria-1]);
                        categoria--;
                    }
                   JOptionPane.showMessageDialog(null, "Libro actualizado exitosamente", 
                                    "Ingreso Válido",1);
                   // consulta si este mantenedor fue lanzado por el proceso de compra
              
                   limpiar();
                }
            }
        }  
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    private boolean esNumero(String dato){
        try{
            if(!dato.isEmpty()){
            int cambio = Integer.parseInt(dato);
            return true;
            }
        }catch(NumberFormatException ex){
            return false;
        }
        return false;
    }
    
    void poblarAutoresCategorias(){
        
        int lAutores = modelA.size();
        int lCategorias = modelC.size();
        // estos vectores almacenas los id_autor y los id_categoria para
        // crear los registros de las tablas libroautor y librocategoria
        // sus largos dependen del tamaño de las listas que los contienen
        listaLibroAutor = new int[lAutores];
        listaLibroCategoria = new int[lCategorias];
        
        // almacenando autores
        while(lAutores>0){
            String a = modelA.get(lAutores-1).toString();
            int autor = Integer.parseInt(a.substring(a.indexOf("(") + 1, a.indexOf(")")));
            listaLibroAutor[lAutores-1]=autor;
            lAutores--;
        }
        // almacenando categorias
        while(lCategorias>0){
            String c = modelC.get(lCategorias-1).toString();
            int categoria = Integer.parseInt(c.substring(c.indexOf("(") + 1, c.indexOf(")")));
            listaLibroCategoria[lCategorias-1] = categoria;
            lCategorias--;
        }
        
    }
    
    
    private void btnIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdiomaActionPerformed
        // TODO add your handling code here:
        
        if (!fi.isVisible()){
            
            fi.setVisible(true);
        }
    }//GEN-LAST:event_btnIdiomaActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        // TODO add your handling code here:
        
        if (!fa.isVisible()){
         
            fa.setVisible(true);
        }
        
    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        
        if (!fc.isVisible()){
            fc.setVisible(true);
        }
    }//GEN-LAST:event_btnCategoriaActionPerformed

    
    
    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        // TODO add your handling code here:
        
        if (!fe.isVisible()){
            fe.setVisible(true);
        }
    }//GEN-LAST:event_btnEditorialActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        limpiar();
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
        try{
            String categoria = cmbCategoria.getItemAt(cmbCategoria.getSelectedIndex());
                          
            jListCategoria.setModel(modelListC(categoria));
         
        }catch(Exception e){       
                JOptionPane.showMessageDialog(null, e+" recargar", "",0);
        }
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private DefaultListModel modelListC(String categoria){
   
        int l = modelC.getSize();
        boolean existe = false;
        
        // controla que siempre haya una categoria seleccionada 
        
        while(l>0){
            if (modelC.get(l-1).equals(categoria)){
                existe = true;
                break;
            }
            l--;
        }
        if (existe){
            modelC.removeElement(categoria);
        }else{
            modelC.addElement(categoria);
        }       
        return modelC;
    }
    
    
    private void jListCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCategoriaMouseClicked
        // TODO add your handling code here:

        String categoriaBorrar=jListCategoria.getSelectedValue();
        //  
        if(categoriaBorrar!=null){
            jListCategoria.setModel(modelListC(categoriaBorrar));
        }

        
    }//GEN-LAST:event_jListCategoriaMouseClicked

    private void cmbAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAutorActionPerformed
        // TODO add your handling code here:
        try{
            String autor = cmbAutor.getItemAt(cmbAutor.getSelectedIndex());
                          
            jListAutor.setModel(modelListA(autor));
         
        }catch(Exception e){       
                JOptionPane.showMessageDialog(null, e+" recargar", "",0);
        }
        
    }//GEN-LAST:event_cmbAutorActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarTituloActionPerformed

    private void txtBuscarTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTituloKeyReleased
        // TODO add your handling code here:
        
        llenarTablaConLibros("titulo",txtBuscarTitulo.getText());
    }//GEN-LAST:event_txtBuscarTituloKeyReleased

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        // TODO add your handling code here:
        //largo de serie en libros, como el empleado en código de barras
        int numerocaracteres = 13;
    if (txtSerie.getText().length() >= numerocaracteres)
        {
        evt.consume();
            JOptionPane.showMessageDialog(rootPane,"solo 13 caracteres","",1);
        }
        
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtIsbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsbnKeyTyped
        // TODO add your handling code here:
        
        // largo isbn que figura en libros, incluye los guiones
        int numerocaracteres = 17;
    if (txtSerie.getText().length() >= numerocaracteres)
        {
        evt.consume();
        JOptionPane.showMessageDialog(rootPane,"solo 17 caracteres","",1);
        }
        
        
    }//GEN-LAST:event_txtIsbnKeyTyped

    private void jTableLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLibrosMouseClicked
        // TODO add your handling code here:
        
        if(!MenuPrincipalBiblioteca.procesoCompraLibro){
            txtSerie.setText(String.valueOf(modelTable.getValueAt(jTableLibros.getSelectedRow(),0)));
        }
        
    }//GEN-LAST:event_jTableLibrosMouseClicked

    private void txtIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdiomaActionPerformed
        // TODO add your handling code here:
        
        txtIdioma.setText(cmbIdioma.getItemAt(cmbIdioma.getSelectedIndex()));
    }//GEN-LAST:event_txtIdiomaActionPerformed

    private void cmbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearActionPerformed
        // TODO add your handling code here:
        
        txtYear.setText(cmbYear.getItemAt(cmbYear.getSelectedIndex()));
        
    }//GEN-LAST:event_cmbYearActionPerformed

    private void txtEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditorialActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtEditorialActionPerformed

    private void cmbIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdiomaActionPerformed
        // TODO add your handling code here:
        txtIdioma.setText(cmbIdioma.getItemAt(cmbIdioma.getSelectedIndex()));
    }//GEN-LAST:event_cmbIdiomaActionPerformed

    private void cmbEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditorialActionPerformed
        // TODO add your handling code here:
        
        txtEditorial.setText(cmbEditorial.getItemAt(cmbEditorial.getSelectedIndex()));
    }//GEN-LAST:event_cmbEditorialActionPerformed

    private void txtBuscarSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarSerieActionPerformed

    private void txtBuscarSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarSerieKeyReleased
        // TODO add your handling code here:
        llenarTablaConLibros("id_libro_serie",txtBuscarSerie.getText());
    }//GEN-LAST:event_txtBuscarSerieKeyReleased

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btnRCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRCategoriaActionPerformed
        // TODO add your handling code here:
        poblarCategoria();
    }//GEN-LAST:event_btnRCategoriaActionPerformed

    private void btnRAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAutorActionPerformed
        // TODO add your handling code here:
        poblarAutor();
    }//GEN-LAST:event_btnRAutorActionPerformed

    private void btnRIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRIdiomaActionPerformed
        // TODO add your handling code here:
        poblarIdioma();
    }//GEN-LAST:event_btnRIdiomaActionPerformed

    private void btnREditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREditorialActionPerformed
        // TODO add your handling code here:
        poblarEditorial();
    }//GEN-LAST:event_btnREditorialActionPerformed

    private void txtVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        // TODO add your handling code here:
        if (suEstado > 0){
            suEstado = 0;
        }else{
            suEstado = 1;
        }
        muestraEstado();
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoKeyTyped

    private void jListAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAutorMouseClicked
        // TODO add your handling code here:
        String autorBorrar=jListAutor.getSelectedValue();
        //  
        if(autorBorrar!=null){
            jListAutor.setModel(modelListA(autorBorrar));
        }

    }//GEN-LAST:event_jListAutorMouseClicked

        private DefaultListModel modelListA(String autor){
   
        int l = modelA.getSize();
        boolean existe = false;
 
        // controla que siempre haya un autor seleccionado
        while(l>0){
            if (modelA.get(l-1).equals(autor)){
                existe = true;
                break;
            }
            l--;
        }
        if (existe){
            modelA.removeElement(autor);
        }else{
            modelA.addElement(autor);
        }
        return modelA;
    }

    private void limpiar(){
        poblarCategoria();
        poblarEditorial();
        poblarIdioma();
        poblarYear();
        poblarAutor();   
        txtSerie.setText("");
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtEditorial.setText("");
        txtIdioma.setText("");
        txtPaginas.setText("");
        txtYear.setText("");
        txtReferencia.setText("");
        txtVenta.setText("");
        txtArriendo.setText("");
        
        listaLibroAutor=null;
        listaLibroCategoria=null;
        txtSerie.setEnabled(false);
        txtSerie.setEditable(false);
        if(!MenuPrincipalBiblioteca.procesoCompraLibro){
            jTableLibros.setEnabled(true);
            txtBuscarTitulo.setEnabled(true);
            txtBuscarSerie.setEnabled(true);
            btnBuscar.setEnabled(true);
            txtIsbn.setEnabled(false);
            txtTitulo.setEnabled(false);
            txtEditorial.setEnabled(false);
            txtIdioma.setEnabled(false);
            txtPaginas.setEnabled(false);
            txtYear.setEnabled(false);
            txtReferencia.setEnabled(false);
            txtVenta.setEnabled(false);
            txtArriendo.setEnabled(false);
        }
        llenarTablaConLibros("titulo","");
        modelA.clear();
        modelC.clear();
        
        btnGuardar.setText("Grabar");
        txtEstado.setText("");
        txtEstado.setForeground(Color.white);
        txtEstado.setEditable(false);
        //prepara para insertar o crear registro libro 
        insertaLibro = true;
        // estado 1 es vigente
        suEstado=1;
        btnEstado.setEnabled(false);
        
    }
  
    void llenarTablaConLibros(String campo, String buscado){
        modelTable = new DefaultTableModel(null,titulos);
        ControladorLibros clibros = new ControladorLibros();
        ArrayList<Libros> lib;
        if (campo.equals("titulo")){
            lib = clibros.consultarTodoParametroTitulo(buscado);
        }else{
            lib = clibros.consultarTodoParametroSerie(buscado);
            }
        if(lib!=null){
            int largo=lib.size();
            while (largo>0){
                //extrae datos del arraylist para poblar tabla libros                
                
                AutoresDAO a = new AutoresDAO();
                int id_autor = lib.get(largo-1).getAutor();
                Autores autor = a.leerXid(id_autor);
                IdiomaDAO i = new IdiomaDAO();
                int id_idioma = lib.get(largo-1).getIdioma();
                Idioma idioma = i.leerXid(id_idioma);
                EditorialDAO edit = new EditorialDAO();
                int id_editorial = lib.get(largo-1).getEditorial();
                Editorial editorial = edit.leerXid(id_editorial);

                //Serie-Isbn-Titulo-Editorial-Autor-Idioma-Stock-Estado-$Venta-$Arriendo
                
                campos[0]=lib.get(largo-1).getSerie();
                campos[1]=lib.get(largo-1).getIsbn();
                campos[2]=lib.get(largo-1).getTitulo();
                if(editorial!=null){
                    campos[3]=editorial.getNombre();
                }else{
                    campos[3]="sin editorial";
                }
                if(autor!=null){
                    campos[4]=autor.getNombre();
                }else{
                    campos[4]="sin autor";
                }
                if(idioma!=null){
                    campos[5]=idioma.getNombre();
                }else{
                    campos[5]="sin idioma";
                }
                campos[6]=String.valueOf(lib.get(largo-1).getStock());
                int estado = lib.get(largo-1).getEstado();
                String e = "disponible";
                if (estado==0){
                    e = "no disponible";
                }
                campos[7]=e;
                campos[8]=String.valueOf(lib.get(largo-1).getPrecioVenta());
                campos[9]=String.valueOf(lib.get(largo-1).getPrecioArriendo());
                
                modelTable.addRow(campos);
                
                largo--;
            }
         jTableLibros.removeAll();
         jTableLibros.setModel(modelTable);
                 //ALINEA CELDAS TABLAS
         DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
         alinear.setHorizontalAlignment(SwingConstants.RIGHT);//.LEFT .RIGHT .CENTER
         jTableLibros.getColumnModel().getColumn(0).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(1).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(2).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(3).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(4).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(5).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(6).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(7).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(8).setCellRenderer(alinear);
         jTableLibros.getColumnModel().getColumn(9).setCellRenderer(alinear);
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
            java.util.logging.Logger.getLogger(FMantenedorLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMantenedorLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMantenedorLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMantenedorLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMantenedorLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutor;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnEditorial;
    public static javax.swing.JButton btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdioma;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRAutor;
    private javax.swing.JButton btnRCategoria;
    private javax.swing.JButton btnREditorial;
    private javax.swing.JButton btnRIdioma;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JComboBox<String> cmbIdioma;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListAutor;
    private javax.swing.JList<String> jListCategoria;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable jTableLibros;
    public javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField txtArriendo;
    public javax.swing.JTextField txtBuscarSerie;
    public javax.swing.JTextField txtBuscarTitulo;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtReferencia;
    public static javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtVenta;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
