/**
 * fecha de creacion: junio de 2018
 * nombre: EmailDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Email 
 * salida: objeto Email
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

public class EmailDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Email email) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertEmail (?)}");
            ps.setString(1, email.getEmail());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Email email) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateEmail (?,?)}");
            ps.setInt(1, email.getId_email());
            ps.setString(2, email.getEmail());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<Email> readAll() {
        ArrayList<Email> email = null;
        try {
            email = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllEmail}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                email.add(new Email(
                res.getInt("id_email"),
                res.getString("email")
                ));         
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return email;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Direccion (solo 1)
    public Email read(int id_email) {
        Email email = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectEmail (?)}");
            ps.setInt(1, id_email);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                email =  new Email(
                        res.getInt("id_email"),
                        res.getString("email")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return email;
    }

    public Email readXemail(String email) {
        Email e = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectXemail (?)}");
            ps.setString(1, email);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                e =  new Email(
                        res.getInt("id_email"),
                        res.getString("email")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerrar();
        }
        return e;
    }

    
}
