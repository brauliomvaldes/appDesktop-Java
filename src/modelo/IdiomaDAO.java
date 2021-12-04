/**
 * fecha de creacion: junio de 2018
 * nombre: IdiomaDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Idioma 
 * salida: objeto Idioma
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

public class IdiomaDAO {

    CallableStatement ps;
    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String nombre) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertI (?)}");
            ps.setString(1, nombre);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Idioma idioma) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateI (?,?)}");
            ps.setInt(1, idioma.getId_idioma());
            ps.setString(2, idioma.getNombre());
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
            ps = con.getCnn().prepareCall("{call sp_cambioEstadoIdioma (?,?)}");
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
   
    
    
    public ArrayList<Idioma> readAll() {
        ArrayList<Idioma> idioma = null;
        try {
            idioma = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllIdiomas}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                idioma.add(new Idioma(res.getInt("id_idioma"),res.getString("nombre"),res.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return idioma;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Idioma (solo 1)
    public Idioma read(String n) {
        Idioma idioma = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectI (?)}");
            ps.setString(1, n);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                idioma =  new Idioma(res.getInt("id_idioma"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return idioma;
    }

    public Idioma leerXid(int id_idioma) {
        Idioma idioma = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectIxId (?)}");
            ps.setInt(1, id_idioma);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                idioma =  new Idioma(res.getInt("id_idioma"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return idioma;
    }
    
}
