/**
 * fecha de creacion: junio de 2018
 * nombre: CategoriaDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Categoria 
 * salida: objeto Categoria
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

public class CategoriaDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(String nombre) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertC (?)}");
            ps.setString(1, nombre);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Categoria categoria) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateC (?,?)}");
            ps.setInt(1, categoria.getId_categoria());
            ps.setString(2, categoria.getNombre());
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
            ps = con.getCnn().prepareCall("{call sp_cambiaEstadoCategoria (?,?)}");
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
   

    public ArrayList<Categoria> readAll() {
        ArrayList<Categoria> categoria = null;
        try {
            categoria = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllCategorias}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                categoria.add(new Categoria(res.getInt("id_categoria"),
                        res.getString("nombre"),
                        res.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return categoria;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo Categoria (solo 1)
    public Categoria read(String n) {
        Categoria categoria = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectC (?)}");
            ps.setString(1, n);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                categoria =  new Categoria(res.getInt("id_categoria"),
                        res.getString("nombre"),
                        res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return categoria;
    }

    public Categoria leerXid(int id_categoria) {
        Categoria categoria = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectCxId (?)}");
            ps.setInt(1, id_categoria);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                categoria =  new Categoria(res.getInt("id_categoria"),res.getString("nombre"),res.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return categoria;
    }
    
    
}
