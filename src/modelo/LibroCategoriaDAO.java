/**
 * fecha de creacion: junio de 2018
 * nombre: LibroCategoriaDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto LibroCategoria 
 * salida: objeto LibroCategoria
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

public class LibroCategoriaDAO {

    CallableStatement ps;
    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String serie, int libroCategoria) {
        int flag = 0;
        try {            
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertLibroCategoria (?,?)}");
            ps.setString(1, serie);
            ps.setInt(2, libroCategoria);
            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(String libro, int categoria) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateLibroCategoria (?,?)}");
            ps.setString(1, libro);
            ps.setInt(2, categoria);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int delete(String libro) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareCall("{call sp_deleteLibroCategoria (?)}");
            ps.setString(1, libro);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<LibroCategoria> readAllxLibro(String serie) {
        ArrayList<LibroCategoria> libroCategoria = null;
        try {
            libroCategoria = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllLibroCategoria (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                libroCategoria.add(new LibroCategoria(res.getString("id_libro"),res.getInt("id_categoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libroCategoria;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Categoria (solo 1)
    public LibroCategoria read(String serie) {
        LibroCategoria libroCategoria = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectLibroCategoria (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libroCategoria =  new LibroCategoria(res.getString("id_libro"),res.getInt("id_categoria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libroCategoria;
    }

    
}
