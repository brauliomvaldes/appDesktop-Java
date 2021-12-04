/**
 * fecha de creacion: junio de 2018
 * nombre: DistribuidorDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Distribuidor 
 * salida: objeto Distribuidor
 * @author: braulio valdes 
 */
package modelo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DistribuidorDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Distribuidores distribuidor) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertDistribuidor (?,?,?,?,?,?,?)}");
            ps.setInt(1, distribuidor.getId_distribuidor_rut());
            ps.setString(2, distribuidor.getDv_distribuidor());
            ps.setString(3, distribuidor.getNombre());
            ps.setString(4, distribuidor.getDireccion());
            ps.setString(5, distribuidor.getTelefono());
            ps.setInt(6, distribuidor.getEstado());
            ps.setInt(7, distribuidor.getYear_incorporacion());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Distribuidores distribuidor) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateDistribuidor (?,?,?,?,?,?,?)}");
            ps.setInt(1, distribuidor.getId_distribuidor_rut());
            ps.setString(2, distribuidor.getDv_distribuidor());
            ps.setString(3, distribuidor.getNombre());
            ps.setString(4, distribuidor.getDireccion());
            ps.setString(5, distribuidor.getTelefono());
            ps.setInt(6, distribuidor.getEstado());
            ps.setInt(7, distribuidor.getYear_incorporacion());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int cambiaEstado(Integer rut, int estado) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_cambiaEstadoDistribuidor (?,?)}");
            ps.setInt(1, rut);
            ps.setInt(2, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<Distribuidores> readAll() {
        ArrayList<Distribuidores> distribuidor = null;
        try {
            distribuidor = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllDistribuidores}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                distribuidor.add(new Distribuidores(
                res.getInt("id_distribuidor_rut"),
                res.getString("dv_distribuidor"),
                res.getString("nombre"),
                res.getString("direccion"),
                res.getString("telefono"),
                res.getInt("estado"), 
                res.getInt("year_incorporacion")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return distribuidor;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Distribuidor (solo 1)
    public Distribuidores read(int rut) {
        Distribuidores distribuidor = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectDistribuidorXrut (?)}");
            ps.setInt(1, rut);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                distribuidor =  new Distribuidores(
                        res.getInt("id_distribuidor_rut"),
                        res.getString("dv_distribuidor"),
                        res.getString("nombre"),
                        res.getString("direccion"),
                        res.getString("telefono"),
                        res.getInt("estado"),
                        res.getInt("year_incorporacion")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidorDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return distribuidor;
    }

    
}
