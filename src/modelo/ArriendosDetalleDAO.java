/**
 * fecha de creacion: junio de 2018
 * nombre: ArriendosDetalleDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto ArriendosDetalle 
 * salida: objeto ArriendosDetalle
 * @author: braulio valdes 
 */
package modelo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import modelo.*;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArriendosDetalleDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
   
    public int insert(ArriendosDetalle arriendoDetalle) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            
            ps = con.getCnn().prepareCall("{call sp_insertArriendosDetalle (?,?,?,?,?)}");
            ps.setLong(1, arriendoDetalle.getId_folio_comprobante_arriendo());
            ps.setString(2, arriendoDetalle.getSerie());
            ps.setInt(3, arriendoDetalle.getCantidad_libro());
            ps.setInt(4, arriendoDetalle.getValor_arriendo());
            ps.setInt(5, arriendoDetalle.getEstado());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(ArriendosDetalle arriendoDetalle) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateComprasDetalle (?,?,?,?,?)}");
            ps.setLong(1, arriendoDetalle.getId_folio_comprobante_arriendo());
            ps.setString(2, arriendoDetalle.getSerie());
            ps.setInt(3, arriendoDetalle.getCantidad_libro());
            ps.setInt(4, arriendoDetalle.getValor_arriendo());
            ps.setInt(5, arriendoDetalle.getEstado());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }

    public int updateEstado(long Id_folio_comprobante_arriendo, String serie) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateArriendosDetalle (?,?)}");
            ps.setLong(1, Id_folio_comprobante_arriendo);
            ps.setString(2, serie);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
        
        
        
        
    public ArrayList<ArriendosDetalle> readAll() {
        ArrayList<ArriendosDetalle> arriendoDetalle = null;
        try {
            arriendoDetalle = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllArriendosDetalle}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                         
            arriendoDetalle.add(new ArriendosDetalle(res.getInt("id_folio_comprobante_arriendo"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_arriendo"), res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendoDetalle;
    }
    
    public ArrayList<ArriendosDetalle> readAllXfolio(long id_folio_comprobante_arriendo) {
        ArrayList<ArriendosDetalle> arriendoDetalle = null;
        try {
            arriendoDetalle = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectArriendosXfolio(?)}");
            ps.setLong(1, id_folio_comprobante_arriendo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                         
            arriendoDetalle.add(new ArriendosDetalle(res.getInt("id_folio_comprobante_arriendo"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_arriendo"), res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendoDetalle;
    }
    
    
    
//me devuelve (si lo encuentra) un objeto de tipo ventas (solo 1)
    public ArriendosDetalle read(long id_folio_comprobante_arriendo) {
        ArriendosDetalle arriendoDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectArriendosDetalle (?)}");
            ps.setLong(1, id_folio_comprobante_arriendo);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                arriendoDetalle =  new ArriendosDetalle(res.getInt("id_folio_comprobante_arriendo"),
                        res.getString("serie"), res.getInt("cantidad_libro"), 
                        res.getInt("valor_arriendo"), res.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendoDetalle;
    }

    public ArriendosDetalle readLibroEnArriendos(String serie) {         
        ArriendosDetalle arriendoDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectLibroEnArriendos (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
            arriendoDetalle =  new ArriendosDetalle(res.getInt("id_folio_comprobante_arriendo"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_arriendo"), res.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return arriendoDetalle;
    }

    
    
    
    
    
}
