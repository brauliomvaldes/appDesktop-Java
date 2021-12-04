/**
 * fecha de creacion: junio de 2018
 * nombre: VentasDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Ventas 
 * salida: objeto Ventas
 * @author: braulio valdes 
 */
package modelo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentasDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
  
    public int insert(Ventas venta) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertVenta (?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setLong(1, venta.getId_folio_boleta());
            ps.setInt(2, venta.getTotal());
            ps.setInt(3, venta.getDia());
            ps.setInt(4, venta.getMes());
            ps.setInt(5, venta.getYear());
            ps.setTime(6, venta.getHora_venta());
            ps.setInt(7, venta.getId_fpafo());
            ps.setInt(8, venta.getId_cliente());  
            ps.setInt(9, venta.getId_trabajador());
            ps.setInt(10, venta.getCuotas());
            ps.setString(11, venta.getGlosa());
            ps.setInt(12, venta.getLibrosvendidos());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        
    public ArrayList<Ventas> readAll() {
        ArrayList<Ventas> venta = null;
        try {
            venta = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllVentas}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {             
                
            venta.add(new Ventas(res.getLong("id_folio_boleta"),res.getInt("total"),
                             res.getInt("dia"),res.getInt("mes"),res.getInt("yearr"),
                                  res.getTime("hora_venta"), res.getInt("id_fpago"),
                                   res.getInt("id_cliente"),res.getInt("id_trabajador"),
                                     res.getInt("cuotas"),res.getString("glosa"),
                                       res.getInt("librosvendidos")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return venta;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo venta (solo 1)
    public Ventas read(long id_folio_boleta) {
        Ventas venta = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectVentas (?)}");
            ps.setLong(1, id_folio_boleta);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                venta =  new Ventas(res.getLong("id_folio_boleta"),res.getInt("id_total"),
                             res.getInt("dia"),res.getInt("mes"),res.getInt("yearr"),
                               res.getTime("hora_venta"), res.getInt("fpago"),res.getInt("id_cliente"),
                                  res.getInt("id_trabajador"),res.getInt("cuotas"),
                                res.getString("glosa"),res.getInt("librosvendidos"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return venta;
    }

    public ArrayList<Ventas> readPersonasEnVentas(int id_persona) {         
        ArrayList<Ventas> venta = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonaEnVentas (?)}");
            ps.setInt(1, id_persona);
            ResultSet res = ps.executeQuery();
            while (res.next()) {            
            venta.add(  new Ventas(res.getLong("id_folio_boleta"),res.getInt("id_total"),
                             res.getInt("dia"),res.getInt("mes"),res.getInt("yearr"),
                               res.getTime("hora_venta"), res.getInt("fpago"),res.getInt("id_cliente"),
                                  res.getInt("id_trabajador"),res.getInt("cuotas"),
                                res.getString("glosa"),res.getInt("librosvendidos")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return venta;
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
    public long buscarFolioEnVentas() {
        long ultimoFolio=0;
        try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            ps = con.getCnn().prepareCall(" CALL buscarUltimoFolio(?,?) ");
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
