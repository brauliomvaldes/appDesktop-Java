/**
 * fecha de creacion: junio de 2018
 * nombre: FFrameClientesEnMora
 * Su función lista clientes morosos
 * entrada null
 * salida null
 * @author: braulio valdes 
 */
package vista;

import controlador.ControladorArriendos;
import controlador.ControladorArriendosDetalle;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Arriendos;
import modelo.ArriendosDetalle;

/**
 *
 * @author BRAULIOMARIANO
 */
public class JFrameClientesEnMora extends javax.swing.JFrame {

    /**
     * Creates new form JFrameListaCompras
     */
    
    String [] titulos = {"RUT","N° RECIBO","SERIE LIBRO","FECHA ARRIENDO",
                            "FECHA DEVOLUCION","ESTADO","DIAS ATRASO","EN MULTA"};
    String [] campos = new String [8];
    DefaultTableModel modelTable;
   
    public JFrameClientesEnMora() {
        initComponents();
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        llenarTablaArriendos();
    }
    
    void llenarTablaArriendos(){
        boolean hayMorosos=false;
        long idFolio=0;
        modelTable = new DefaultTableModel(null,titulos);
        TableColumnModel columnModel = jTableCompras.getColumnModel();
        ControladorArriendos cArriendos = new ControladorArriendos();
        ControladorArriendosDetalle cAD = new ControladorArriendosDetalle();
        ArrayList<Arriendos> arriendos;
        ArrayList<ArriendosDetalle> librosArrendados;
        arriendos = cArriendos.consultarTodo();
        String fechaArriendo, fechaDevolucion, estado;
        Date fDevolucion, fechaHoy;
        int diasAtraso;
        fechaHoy = new Date();
        // alinear texto celdas de una tabla
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();        
        if(arriendos!=null){
            int largo=arriendos.size();
            while (largo>0){
                //si estado es 3 esta en mora
                if(arriendos.get(largo-1).getEstado()==3){
                    idFolio = arriendos.get(largo-1).getId_folio_comprobante_arriendo();
                    librosArrendados = cAD.leerAllXfolio(idFolio);
                    if(librosArrendados!=null){
                        int lArrayList = librosArrendados.size();
                        while(lArrayList>0){
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
                            hayMorosos=true;
                            estado="";
                            if(diasAtraso>0){
                                estado="DEVOLUCION RETRASADA";
                                campos[7]="EN MULTA";
                            }else{
                                diasAtraso=0;
                                estado="LIBRO EN ARRIENDO";
                                campos[7]="";
                            }
                            campos[5]=estado;
                            campos[6]=String.valueOf(diasAtraso);
                            modelTable.addRow(campos);                            
                            lArrayList--;
                        }
                    }                    
                }
                largo--;
            }
            if(hayMorosos){
                jTableCompras.removeAll();
                jTableCompras.setModel(modelTable);
                Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER   
                jTableCompras.getColumnModel().getColumn(0).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(1).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(2).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(3).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(4).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(6).setCellRenderer(Alinear);
                Alinear.setHorizontalAlignment(SwingConstants.LEFT);//.LEFT .RIGHT .CENTER                           
                jTableCompras.getColumnModel().getColumn(5).setCellRenderer(Alinear);
                jTableCompras.getColumnModel().getColumn(7).setCellRenderer(Alinear);
                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(20);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(100);
                columnModel.getColumn(5).setPreferredWidth(100);
                columnModel.getColumn(6).setPreferredWidth(50);
                columnModel.getColumn(7).setPreferredWidth(50);    
            }else{
                if(this.isVisible()){
                    JOptionPane.showMessageDialog(null, "Atención!, Al día de hoy no existen Clientes en mora", "",1);
                }
            }
            if(this.isVisible()){
                JOptionPane.showMessageDialog(null, "Atención!, Al día de hoy no existen Clientes en mora", "",1);
            }
        }else{
            
        }
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCompras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));
        setUndecorated(true);

        jTableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCompras);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(" < LISTADO CLIENTES CON ARRIENDO EN MORA > ");

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComprasMouseClicked
        // TODO add your handling code here:
        
        //hacer click en tabla
        
        String sLibro = "";
        
        int dialogResult = JOptionPane.showConfirmDialog(null,"","Atención",1);
        
        
    }//GEN-LAST:event_jTableComprasMouseClicked

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
            java.util.logging.Logger.getLogger(JFrameClientesEnMora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameClientesEnMora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameClientesEnMora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameClientesEnMora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameClientesEnMora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCompras;
    // End of variables declaration//GEN-END:variables
}
