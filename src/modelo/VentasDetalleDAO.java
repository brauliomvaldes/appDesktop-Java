/**
 * fecha de creacion: junio de 2018
 * nombre: VentasDetalleDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto VentasDetalle 
 * salida: objeto VentasDetalle
 * @author: braulio valdes 
 */

package modelo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentasDetalleDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
   
    public int insert(VentasDetalle ventaDetalle) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            
            ps = con.getCnn().prepareCall("{call sp_insertVentasDetalle (?,?,?,?)}");
            ps.setLong(1, ventaDetalle.getId_folio_boleta());
            ps.setString(2, ventaDetalle.getSerie());
            ps.setInt(3, ventaDetalle.getCantidad_libro());
            ps.setInt(4, ventaDetalle.getValor_venta());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(VentasDetalle ventaDetalle) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateComprasDetalle (?,?,?,?)}");
            ps.setLong(1, ventaDetalle.getId_folio_boleta());
            ps.setString(2, ventaDetalle.getSerie());
            ps.setInt(3, ventaDetalle.getCantidad_libro());
            ps.setInt(4, ventaDetalle.getValor_venta());

            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }

        
    public ArrayList<VentasDetalle> readAll() {
        ArrayList<VentasDetalle> ventaDetalle = null;
        try {
            ventaDetalle = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllVentasDetalle}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                         
            ventaDetalle.add(new VentasDetalle(res.getInt("id_folio_boleta"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_venta")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ventaDetalle;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo ventas (solo 1)
    public VentasDetalle read(long id_folio_boleta) {
        VentasDetalle ventaDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectVentasDetalle (?)}");
            ps.setLong(1, id_folio_boleta);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                ventaDetalle =  new VentasDetalle(res.getInt("id_folio_boleta"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_venta"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ventaDetalle;
    }

    public VentasDetalle readLibroEnVentas(String serie) {         
        VentasDetalle ventaDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectLibroEnVentas (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
            ventaDetalle =  new VentasDetalle(res.getInt("id_folio_boleta"),res.getString("serie"),
                    res.getInt("cantidad_libro"), res.getInt("valor_venta"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ventaDetalle;
    }

    
}
