/**
 * fecha de creacion: junio de 2018
 * nombre: DireccionDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Direccion 
 * salida: objeto Direccion
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

public class DireccionDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Direccion direccion) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertDireccion (?)}");
            ps.setString(1, direccion.getDireccion());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Direccion direccion) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateDireccion (?,?)}");
            ps.setInt(1, direccion.getId_direccion());
            ps.setString(2, direccion.getDireccion());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<Direccion> readAll() {
        ArrayList<Direccion> direccion = null;
        try {
            direccion = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllDireccion}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                direccion.add(new Direccion(
                res.getInt("id_direccion"),
                res.getString("")
                ));         
            }
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return direccion;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Direccion (solo 1)
    public Direccion read(int id_direccion) {
        Direccion direccion = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectDireccion (?)}");
            ps.setInt(1, id_direccion);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                direccion =  new Direccion(
                        res.getInt("id_direccion"),
                        res.getString("direccion")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return direccion;
    }

    public Direccion readXdireccion(String direccion) {
        Direccion d = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectXdireccion (?)}");
            ps.setString(1, direccion);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                d =  new Direccion(
                    res.getInt("id_direccion"),
                    res.getString("direccion")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return d;
    }

    
    
    
}
