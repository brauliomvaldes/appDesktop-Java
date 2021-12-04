/**
 * fecha de creacion: junio de 2018
 * nombre: LibrosDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Libroos 
 * salida: objeto Libros
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

public class LibrosDAO {

    CallableStatement ps;
    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert(Libros libro) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertL (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setString(1, libro.getSerie());
            ps.setString(2,libro.getIsbn());
            ps.setString(3,libro.getTitulo());
            ps.setInt(4,libro.getPagina());
            ps.setInt(5,libro.getPrecioReferencia());
            ps.setInt(6,libro.getYearr()); 
            ps.setInt(7,libro.getIdioma());
            ps.setInt(8,libro.getAutor());
            ps.setInt(9,libro.getCategoria());
            ps.setInt(10,libro.getEditorial());
            ps.setInt(11,libro.getEstado());
            ps.setInt(12,libro.getStock());
            ps.setInt(13,libro.getEnArriendo());
            ps.setInt(14,libro.getPrecioVenta());
            ps.setInt(15,libro.getPrecioArriendo());

            flag = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        //  no operativo 
        //
        public int update(Libros libro) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateL (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setString(1,libro.getSerie());
            ps.setString(2,libro.getIsbn());
            ps.setString(3,libro.getTitulo());
            ps.setInt(4,libro.getPagina());
            ps.setInt(5,libro.getPrecioReferencia());
            ps.setInt(6,libro.getYearr()); 
            ps.setInt(7,libro.getIdioma());
            ps.setInt(8,libro.getAutor());
            ps.setInt(9,libro.getCategoria());
            ps.setInt(10,libro.getEditorial());
            ps.setInt(11,libro.getEstado());
            ps.setInt(12,libro.getStock());
            ps.setInt(13,libro.getEnArriendo());
            ps.setInt(14,libro.getPrecioVenta());
            ps.setInt(15,libro.getPrecioArriendo());

            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int updateStockYprecio(String serieLibro, int nuevoStock, int nuevoPrecio) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateStockYprecioLibro (?,?,?)}");
            ps.setString(1,serieLibro);
            ps.setInt(2,nuevoStock);
            ps.setInt(3,nuevoPrecio);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public int updateStockArriendo(String serieLibro, int nuevoStockArriendo) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateStockArriendos (?,?)}");
            ps.setString(1,serieLibro);
            ps.setInt(2,nuevoStockArriendo);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    public ArrayList<Libros> readAll() {
        ArrayList<Libros> libros = null;
        try {
            libros = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllLibros}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                libros.add(new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),
                        res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),
                        res.getInt("autor"), res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),
                        res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }
    
    public ArrayList<Libros> readAllBuscarXtitulo(String buscado) {
        ArrayList<Libros> libros = null;
        try {
            libros = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllLibrosParametro (?)}");
            ps.setString(1,buscado);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                libros.add(new Libros(res.getString("id_libro_serie"),res.getString("isbn"),
                        res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),
                        res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),
                        res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),
                        res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }
    
    public ArrayList<Libros> readAllBuscarXserie(String buscado) {
        ArrayList<Libros> libros = null;
        try {
            libros = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllLibrosParametroSerie (?)}");
            ps.setString(1,buscado);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                libros.add(new Libros(res.getString("id_libro_serie"),res.getString("isbn"),
                        res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),
                        res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),
                        res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),
                        res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }
    
    
    
    
//me devuelve (si lo encuentra) un objeto de tipo Libro (solo 1)
    public Libros read(String serie) {
        Libros libros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectL (?)}");
            ps.setString(1, serie);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libros =  new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }

    public Libros buscarAutorEnLibro(int id_autor) {
        Libros libros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectAenLibros (?)}");
            ps.setInt(1, id_autor);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libros =  new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }

        public Libros buscarCategoriaEnLibro(int id_categoria) {
        Libros libros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectCenLibros (?)}");
            ps.setInt(1, id_categoria);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libros =  new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }
    public Libros buscarEditorialEnLibro(int id_editorial) {
        Libros libros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectEenLibros (?)}");
            ps.setInt(1, id_editorial);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libros =  new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }

public Libros buscarIdiomaEnLibro(int id_idioma) {
        Libros libros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectIenLibros (?)}");
            ps.setInt(1, id_idioma);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                libros =  new Libros(res.getString("id_libro_serie"),res.getString("isbn"),res.getString("titulo"),res.getInt("npaginas"),res.getInt("precio_referencias"),res.getInt("yearr"),res.getInt("id_idioma"),res.getInt("autor"),res.getInt("categoria"),res.getInt("id_editorial"),res.getInt("estado"),res.getInt("stock"),res.getInt("en_arriendo"),res.getInt("valor_venta"),res.getInt("valor_arriendo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return libros;
    }

    
}
