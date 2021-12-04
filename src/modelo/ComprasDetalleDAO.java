/**
 * fecha de creacion: junio de 2018
 * nombre: ComprasDetalleDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto ComprasDetalle 
 * salida: objeto ComprasDetalle
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

public class ComprasDetalleDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
   
    
    public int insert(ComprasDetalle comprasDetalle) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertComprasDetalle (?,?,?,?)}");
            ps.setInt(1, comprasDetalle.getId_compras());
            ps.setString(2, comprasDetalle.getId_libro());
            ps.setInt(3, comprasDetalle.getCantidad_libro());
            ps.setInt(4, comprasDetalle.getPrecio_referencia());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(ComprasDetalle comprasDetalle) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateComprasDetalle (?,?,?,?)}");
            ps.setInt(1, comprasDetalle.getId_compras());
            ps.setString(2, comprasDetalle.getId_libro());
            ps.setInt(3, comprasDetalle.getCantidad_libro());
            ps.setInt(4, comprasDetalle.getPrecio_referencia());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }

        
    public ArrayList<ComprasDetalle> readAll() {
        ArrayList<ComprasDetalle> comprasDetalle = null;
        try {
            comprasDetalle = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllComprasDetalle}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                         
            comprasDetalle.add(new ComprasDetalle(res.getInt("id_compras"),res.getString("id_libro"),
                    res.getInt("cantidad_libro"), res.getInt("precio_referencia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return comprasDetalle;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo compras (solo 1)
    public ComprasDetalle read(int folio_factura) {
        ComprasDetalle comprasDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectComprasDetalle (?)}");
            ps.setInt(1, folio_factura);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                comprasDetalle =  new ComprasDetalle(res.getInt("id_compras"),res.getString("id_libro"),
                    res.getInt("cantidad_libro"), res.getInt("precio_referencia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return comprasDetalle;
    }

    public ComprasDetalle readDistribuidorEnCompras(int id_distribuidor) {         
        ComprasDetalle comprasDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectDistribuidorEnCompras (?)}");
            ps.setInt(1, id_distribuidor);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
            comprasDetalle =  new ComprasDetalle(res.getInt("id_compras"),res.getString("id_libro"),
                    res.getInt("cantidad_libro"), res.getInt("precio_referencia"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return comprasDetalle;
    }

    
        public ComprasDetalle leerXid_Compra(int id_compra) {
        ComprasDetalle comprasDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectAxIdCompras (?)}");
            ps.setInt(1, id_compra);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                comprasDetalle =  new ComprasDetalle(res.getInt("id_compras"),res.getString("id_libro"),
                    res.getInt("cantidad_libro"), res.getInt("precio_referencia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return comprasDetalle;
    }

        public ArrayList<ComprasDetalle> leerXlibro(String serieLibro) {
        ArrayList<ComprasDetalle> comprasDetalle = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectLibroEnCompras (?)}");
            ps.setString(1, serieLibro);
            ResultSet res = ps.executeQuery();

            while (res.next()) {                         
            comprasDetalle.add(new ComprasDetalle(res.getInt("id_compras"),res.getString("id_libro"),
                    res.getInt("cantidad_libro"), res.getInt("precio_referencia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return comprasDetalle;
    }


}
