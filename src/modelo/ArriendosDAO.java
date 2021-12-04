/**
 * fecha de creacion: junio de 2018
 * nombre: ArriendosDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Arriendos 
 * salida: objeto Arriendos
 * @author: braulio valdes 
 */
package modelo;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArriendosDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
  
    public int insert(Arriendos arriendo) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertArriendo (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setLong(1, arriendo.getId_folio_comprobante_arriendo());
            ps.setInt(2, arriendo.getCosto_arriendo());
            ps.setInt(3, arriendo.getDia_arriendo());
            ps.setInt(4, arriendo.getMes_arriendo());
            ps.setInt(5, arriendo.getYear_arriendo());
            ps.setInt(6, arriendo.getDia_devolucion_estimada());
            ps.setInt(7, arriendo.getMes_devolucion_estimada());
            ps.setInt(8, arriendo.getYear_devolucion_estimada());
            ps.setInt(9, arriendo.getDia_devolucion_real());
            ps.setInt(10, arriendo.getMes_devolucion_real());
            ps.setInt(11, arriendo.getYear_devolucion_real());
            ps.setInt(12, arriendo.getId_cliente());  
            ps.setInt(13, arriendo.getId_trabajador());
            ps.setInt(14, arriendo.getId_fpago());
            ps.setInt(15, arriendo.getCuotas());
            ps.setInt(16, arriendo.getLibros_arrendados());
            ps.setInt(17, arriendo.getEstado());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        
    public ArrayList<Arriendos> readAll() {
        ArrayList<Arriendos> arriendo = null;
        try {
            arriendo = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllArriendos}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {             
                
            arriendo.add(new Arriendos(res.getLong("id_folio_comprobante_arriendo"),res.getInt("costo_arriendo"),
                             res.getInt("dia_arriendo"),res.getInt("mes_arriendo"),res.getInt("year_arriendo"),
                    res.getInt("dia_devolucion_estimada"),res.getInt("mes_devolucion_estimada"),
                    res.getInt("year_devolucion_estimada"), res.getInt("dia_devolucion_real"),
                    res.getInt("mes_devolucion_real"), res.getInt("year_devolucion_real"),res.getInt("id_cliente"),
                    res.getInt("id_trabajador"), res.getInt("id_fpago"), res.getInt("cuotas"), 
                    res.getInt("libros_arrendados"), res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendo;
    }
    
    public ArrayList<Arriendos> readArriendosXcliente(int id_cliente) {
        ArrayList<Arriendos> arriendo = null;
        try {
            arriendo = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllArriendosXcliente(?)}");
            ps.setInt(1, id_cliente);  
            ResultSet res = ps.executeQuery();
            while (res.next()) {             
            arriendo.add(new Arriendos(res.getLong("id_folio_comprobante_arriendo"),res.getInt("costo_arriendo"),
                             res.getInt("dia_arriendo"),res.getInt("mes_arriendo"),res.getInt("year_arriendo"),
                    res.getInt("dia_devolucion_estimada"),res.getInt("mes_devolucion_estimada"),
                    res.getInt("year_devolucion_estimada"), res.getInt("dia_devolucion_real"),
                    res.getInt("mes_devolucion_real"), res.getInt("year_devolucion_real"),res.getInt("id_cliente"),
                    res.getInt("id_trabajador"), res.getInt("id_fpago"), res.getInt("cuotas"), 
                    res.getInt("libros_arrendados"), res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendo;
    }

        public ArrayList<Arriendos> readPersonaEnArriendo(int id_persona) {
        ArrayList<Arriendos> arriendo = null;
        try {
            arriendo = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectPersonaEnArriendos(?)}");
            ps.setInt(1, id_persona);  
            ResultSet res = ps.executeQuery();
            while (res.next()) {             
            arriendo.add(new Arriendos(res.getLong("id_folio_comprobante_arriendo"),res.getInt("costo_arriendo"),
                             res.getInt("dia_arriendo"),res.getInt("mes_arriendo"),res.getInt("year_arriendo"),
                    res.getInt("dia_devolucion_estimada"),res.getInt("mes_devolucion_estimada"),
                    res.getInt("year_devolucion_estimada"), res.getInt("dia_devolucion_real"),
                    res.getInt("mes_devolucion_real"), res.getInt("year_devolucion_real"),res.getInt("id_cliente"),
                    res.getInt("id_trabajador"), res.getInt("id_fpago"), res.getInt("cuotas"), 
                    res.getInt("libros_arrendados"), res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendo;
    }

    
    
    
  public int updateEstado(long id_folio_comprobante_arriendo, int dia, int mes, int year) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateEstadoArriendo (?,?,?,?)}");
            ps.setLong(1, id_folio_comprobante_arriendo);
            ps.setInt(2, dia);
            ps.setInt(3, mes);
            ps.setInt(4, year);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }    
    
    
//me devuelve (si lo encuentra) un objeto de tipo venta (solo 1)
    public Arriendos read(long id_folio_comprobante_arriendo) {
        Arriendos arriendo = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectArriendos (?)}");
            ps.setLong(1, id_folio_comprobante_arriendo);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                arriendo =  new Arriendos(res.getLong("id_folio_comprobante_arriendo"),res.getInt("costo_arriendo"),
                             res.getInt("dia_arriendo"),res.getInt("mes_arriendo"),res.getInt("year_arriendo"),
                    res.getInt("dia_devolucion_estimada"),res.getInt("mes_devolucion_estimada"),
                    res.getInt("year_devolucion_estimada"), res.getInt("dia_devolucion_real"),
                    res.getInt("mes_devolucion_real"), res.getInt("year_devolucion_real"),res.getInt("id_cliente"),
                    res.getInt("id_trabajador"), res.getInt("id_fpago"), res.getInt("cuotas"), 
                        res.getInt("libros_arrendados"), res.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendo;
    }

    public Arriendos readPersonasEnArriendos(int id_cliente, int id_trabajador) {         
        Arriendos arriendo = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonasEnArriendos (?,?)}");
            ps.setInt(1, id_cliente);
            ps.setInt(2, id_trabajador);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
            arriendo =  new Arriendos(res.getLong("id_folio_comprobante_arriendo"),res.getInt("costo_arriendo"),
                             res.getInt("dia_arriendo"),res.getInt("mes_arriendo"),res.getInt("year_arriendo"),
                    res.getInt("dia_devolucion_estimada"),res.getInt("mes_devolucion_estimada"),
                    res.getInt("year_devolucion_estimada"), res.getInt("dia_devolucion_real"),
                    res.getInt("mes_devolucion_real"), res.getInt("year_devolucion_real"),res.getInt("id_cliente"),
                    res.getInt("id_trabajador"), res.getInt("id_fpago"), res.getInt("cuotas"), 
                    res.getInt("libros_arrendados"), res.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendo;
    }
/*
    public long buscarFolioEnVentas() {
        long id = 0;
        try {
            // Llamada al procedimiento almacenado  prepareCall("{ ? = call sp_buscaFolioBoleta(?) }");
            ps = con.getCnn().prepareCall("{? = call sp_buscaFolioBoleta(?) }");
            ps.registerOutParameter(1, Types.BIGINT);
            ps.execute();
            id = ps.getLong(1);
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return id;
    
    }
*/
    public long buscarFolioEnArriendos() {
        long ultimoFolio=0;
        try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            ps = con.getCnn().prepareCall(" CALL buscarUltimoFolioComprobante(?,?) ");
            // parametro de entrada
            long folio=0;
            ps.setLong("folio", folio);
            // parametro de salida
            ps.registerOutParameter("ultimoFolio", Types.BIGINT);
            // Se ejecuta el procedimiento almacenado
            ps.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            ultimoFolio = ps.getLong("ultimoFolio");
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
       return ultimoFolio;
    
    }
    
    
    
    
}
