/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Persona 
 * salida: objeto Persona
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

public class PersonaDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Personas persona) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertPersonas (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, persona.getId_persona_rut());
            ps.setString(2, persona.getDv_persona());
            ps.setInt(3, persona.getTipo_persona());
            ps.setString(4, persona.getNombre());
            ps.setString(5, persona.getApaterno());
            ps.setString(6, persona.getAmaterno());
            ps.setInt(7, persona.getDireccion());
            ps.setInt(8, persona.getTelefono());
            ps.setInt(9, persona.getEmail());
            ps.setInt(10, persona.getDia_contrato());
            ps.setInt(11, persona.getMes_contrato());
            ps.setInt(12, persona.getYear_contrato());
            ps.setInt(13, persona.getDia_incorporado());
            ps.setInt(14, persona.getMes_incorporado());
            ps.setInt(15, persona.getYear_incorporado());
            ps.setInt(16, persona.getEstado());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Personas persona) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updatePersonas (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, persona.getId_persona_rut());
            ps.setString(2, persona.getDv_persona());
            ps.setInt(3, persona.getTipo_persona());
            ps.setString(4, persona.getNombre());
            ps.setString(5, persona.getApaterno());
            ps.setString(6, persona.getAmaterno());
            ps.setInt(7, persona.getDireccion());
            ps.setInt(8, persona.getTelefono());
            ps.setInt(9, persona.getEmail());
            ps.setInt(10, persona.getDia_contrato());
            ps.setInt(11, persona.getMes_contrato());
            ps.setInt(12, persona.getYear_contrato());
            ps.setInt(13, persona.getDia_incorporado());
            ps.setInt(14, persona.getMes_incorporado());
            ps.setInt(15, persona.getYear_incorporado());
            ps.setInt(16, persona.getEstado());            
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
            ps = con.getCnn().prepareCall("{call sp_cambiaEstadoPersonas (?,?)}");
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

    public int bloquaPersonaXmora(Integer id_persona_rut) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_bloqueaPersonaXmora (?)}");
            ps.setInt(1, id_persona_rut);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }


    public ArrayList<Personas> readAll() {
        ArrayList<Personas> persona = null;
        try {
            persona = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllPersonas}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                persona.add(new Personas(
                res.getInt("id_persona_rut"),
                res.getString("dv_persona"),
                res.getInt("tipo_persona"),
                res.getString("nombre"),
                res.getString("apaterno"),
                res.getString("amaterno"),
                res.getInt("direccion"),
                res.getInt("telefono"),
                res.getInt("email"),
                res.getInt("dia_contrato"),
                res.getInt("mes_contrato"),
                res.getInt("year_contrato"),
                res.getInt("dia_incorporacion"),
                res.getInt("mes_incorporacion"),        
                res.getInt("year_incorporacion"),
                res.getInt("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return persona;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Persona (solo 1)
    public Personas read(int rut) {
        Personas persona = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectPersonaXrut (?)}");
            ps.setInt(1, rut);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                persona =  new Personas(
                res.getInt("id_persona_rut"),
                res.getString("dv_persona"),        
                res.getInt("tipo_persona"),
                res.getString("nombre"),
                res.getString("apaterno"),
                res.getString("amaterno"),
                res.getInt("direccion"),
                res.getInt("telefono"),
                res.getInt("email"),
                res.getInt("dia_contrato"),
                res.getInt("mes_contrato"),
                res.getInt("year_contrato"),
                res.getInt("dia_incorporacion"),
                res.getInt("mes_incorporacion"),        
                res.getInt("year_incorporacion"),
                res.getInt("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return persona;
    }
}
