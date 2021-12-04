/**
 * fecha de creacion: junio de 2018
 * nombre: EditorialDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Editorial 
 * salida: objeto Editorial
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

public class EditorialDAO {

    CallableStatement ps;
    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String nombre) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertEditorial (?)}");
            ps.setString(1, nombre);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Editorial editorial) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateE (?,?)}");
            ps.setInt(1, editorial.getId_editorial());
            ps.setString(2, editorial.getNombre());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
   
      public int cambiaEstado(Integer id, boolean estado) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_cambiaEstadoEditorial (?,?)}");
            ps.setInt(1, id);
            ps.setBoolean(2, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<Editorial> readAll() {
        ArrayList<Editorial> editorial = null;
        try {
            editorial = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllEditoriales}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                editorial.add(new Editorial(res.getInt("id_editorial"),res.getString("nombre"),res.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return editorial;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Editorial (solo 1)
    public Editorial read(String n) {
        Editorial editorial = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectE (?)}");
            ps.setString(1, n);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                editorial =  new Editorial(res.getInt("id_editorial"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return editorial;
    }

    public Editorial leerXid(int id_editorial) {
        Editorial editorial = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectExId (?)}");
            ps.setInt(1, id_editorial);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                editorial =  new Editorial(res.getInt("id_editorial"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return editorial;
    }
    
    
}
