/**
 * fecha de creacion: junio de 2018
 * nombre: TelefonoDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Telefono 
 * salida: objeto Telefono
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

public class TelefonoDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Telefono telefono) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertTelefono (?)}");
            ps.setString(1, telefono.getTelefono());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Telefono telefono) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateTelefono (?,?)}");
            ps.setInt(1, telefono.getId_telefono());
            ps.setString(2, telefono.getTelefono());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<Telefono> readAll() {
        ArrayList<Telefono> telefono = null;
        try {
            telefono = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllTelefono}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                telefono.add(new Telefono(
                res.getInt("id_telefono"),
                res.getString("telefono")
                ));         
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return telefono;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Telefono (solo 1)
    public Telefono read(int id_telefono) {
        Telefono telefono = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectTelefono (?)}");
            ps.setInt(1, id_telefono);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                telefono =  new Telefono(
                        res.getInt("id_telefono"),
                        res.getString("telefono")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefonoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return telefono;
    }

    public Telefono readXtelefono(String telefono) {
        Telefono t = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectXtelefono (?)}");
            ps.setString(1, telefono);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                t =  new Telefono(
                        res.getInt("id_telefono"),
                        res.getString("telefono")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefonoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return t;
    }
    
}
