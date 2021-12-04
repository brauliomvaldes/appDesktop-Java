/**
 * fecha de creacion: junio de 2018
 * nombre: AutoresDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Autores 
 * salida: objeto Autores
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

public class AutoresDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String nombre) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertA (?)}");
            ps.setString(1, nombre);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Autores autores) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateA (?,?)}");
            ps.setInt(1, autores.getId_autor());
            ps.setString(2, autores.getNombre());
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
            ps = con.getCnn().prepareCall("{call sp_cambiaEstadoAutor (?,?)}");
            //ps = con.getCnn().prepareStatement(SQL_DELETE);
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
   

    public ArrayList<Autores> readAll() {
        ArrayList<Autores> autores = null;
        try {
            autores = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllAutores}");
            //ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                autores.add(new Autores(res.getInt("id_autor"),res.getString("nombre"),res.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return autores;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Categoria (solo 1)
    public Autores read(String n) {
        Autores autores = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectA (?)}");
            ps.setString(1, n);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                autores =  new Autores(res.getInt("id_autor"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return autores;
    }

        public Autores leerXid(int id_autor) {
        Autores autores = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectAxId (?)}");
            ps.setInt(1, id_autor);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                autores =  new Autores(res.getInt("id_autor"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return autores;
    }
    
}
