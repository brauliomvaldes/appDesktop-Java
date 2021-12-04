/**
 * fecha de creacion: junio de 2018
 * nombre: LibroAutorDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto LibroAutor 
 * salida: objeto LibroAutor
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

public class LibroAutorDAO {

    CallableStatement ps;

    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String libro, int autor) {
        int flag = 0;
        try {            
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertLibroAutores (?,?)}");
            ps.setString(1, libro);
            ps.setInt(2, autor);
            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(String libro, int autor) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateLibroAutor (?,?)}");
            ps.setString(1, libro);
            ps.setInt(2, autor);
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
            ps = con.getCnn().prepareCall("{call sp_deleteLibroAutor (?)}");
            ps.setString(1, libro);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            con.cerrar();
        }
        return flag;
    }
   

    public ArrayList<LibroAutor> readAllxLibro(String serie) {
        ArrayList<LibroAutor> libroAutor = null;
        try {
            libroAutor = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllLibroAutor (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                libroAutor.add(new LibroAutor(res.getString("id_libro"),res.getInt("id_autor")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libroAutor;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Categoria (solo 1)
    public LibroAutor read(String serie) {
        LibroAutor libroAutor = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectLibroAutor (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                libroAutor =  new LibroAutor(res.getString("id_libro"),res.getInt("id_autor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libroAutor;
    }
    
}
