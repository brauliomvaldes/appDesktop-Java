/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaEmailDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto PersonaEmail 
 * salida: objeto PersonaEmail
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


public class PersonaEmailDAO {

    CallableStatement ps;

    private static final Conexion con = Conexion.getInstance();
      
    public int insert(int persona, int email, int estado) {
        int flag = 0;
        try {            
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertPersonaEmail (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, email);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(int persona, int email, int estado) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updatePersonaEmail (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, email);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int cambioEstado(int persona, int email, int estado) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_deleteEmail (?,?,?)}");
            ps.setInt(1, persona);
            ps.setInt(2, email);
            ps.setInt(3, estado);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<PersonaEmail> readAllxPersona(int persona) {
        ArrayList<PersonaEmail> personaEmail = null;
        try {
            personaEmail = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllPersonaEmail (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                personaEmail.add(new PersonaEmail(res.getInt("id_persona"),
                          res.getInt("id_email"),res.getInt("id_estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaEmail;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Persona (solo 1)
    public PersonaEmail read(int persona) {
        PersonaEmail personaEmail = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonaEmail (?)}");
            ps.setInt(1, persona);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                personaEmail =  new PersonaEmail(res.getInt("id_persona"),
                        res.getInt("id_email"), res.getInt("id_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return personaEmail;
    }
    
}
