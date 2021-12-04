/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaDireccionDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto PersonaDireccion 
 * salida: objeto PersonaDireccion
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

public class PersonaDireccionDAO {

    CallableStatement ps;

    private static final Conexion con = Conexion.getInstance();
      
    public int insert(int persona, int direccion, int estado) {
        int flag = 0;
        try {            
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertPersonaDireccion (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, direccion);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(int persona, int direccion, int estado) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updatePersonaDirecccion (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, direccion);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int cambioEstado(int persona, int direccion, int estado) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_deleteDireccion (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, direccion);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<PersonaDireccion> readAllxPersona(int persona) {
        ArrayList<PersonaDireccion> personaDireccion = null;
        try {
            personaDireccion = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllPersonaDireccion (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                personaDireccion.add(new PersonaDireccion(res.getInt("id_persona"),
                          res.getInt("id_direccion"),res.getInt("id_estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaDireccion;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Persona (solo 1)
    public PersonaDireccion read(int persona) {
        PersonaDireccion personaDireccion = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonaDireccion (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                personaDireccion =  new PersonaDireccion(res.getInt("id_persona"),
                        res.getInt("id_direccion"), res.getInt("id_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaDireccion;
    }
    
}
