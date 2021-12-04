/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaTelefonoDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto PersonaTelefono 
 * salida: objeto PersonaTelefono
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

public class PersonaTelefonoDAO {

    CallableStatement ps;

    private static final Conexion con = Conexion.getInstance();
      
    public int insert(int persona, int telefono, int estado) {
        int flag = 0;
        try {            
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertPersonaTelefono (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, telefono);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(int persona, int telefono, int estado) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updatePersonaTelefono (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, telefono);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int cambioEstado(int persona, int telefono, int estado) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_deleteTelefono (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, telefono);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<PersonaTelefono> readAllxPersona(int persona) {
        ArrayList<PersonaTelefono> personaTelefono = null;
        try {
            personaTelefono = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllPersonaTelefono (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                personaTelefono.add(new PersonaTelefono(res.getInt("id_persona"),
                          res.getInt("id_telefono"),res.getInt("id_estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaTelefonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaTelefono;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Persona (solo 1)
    public PersonaTelefono read(int persona) {
        PersonaTelefono personaTelefono = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonaTelefono (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                personaTelefono =  new PersonaTelefono(res.getInt("id_persona"),
                        res.getInt("id_telefono"), res.getInt("id_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaTelefonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaTelefono;
    }
    
}
