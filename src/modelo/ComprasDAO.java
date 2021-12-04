/**
 * fecha de creacion: junio de 2018
 * nombre: ComprasDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Compras 
 * salida: objeto Compras
 * @author: braulio valdes 
 */
package modelo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ComprasDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
   
    
    public int insert(Compras compras) {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_insertCDL (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, compras.getId_distribuidor());
            ps.setInt(2, compras.getFolio_factura());
            ps.setInt(3, compras.getTotal());
            ps.setInt(4, compras.getDia_compra());
            ps.setInt(5, compras.getMes_compra());
            ps.setInt(6, compras.getYear_compra());  
            ps.setInt(7, compras.getHora_compra());
            ps.setInt(8, compras.getMinuto_compra());
            ps.setInt(9, compras.getSegundo_compra());
            ps.setInt(10, compras.getId_fpago());
            ps.setInt(11, compras.getCuotas());
            ps.setString(12, compras.getGlosa());
            ps.setInt(13, compras.getNumero_libros());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Compras compras) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateCDL (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, compras.getId_distribuidor());
            ps.setInt(2, compras.getFolio_factura());
            ps.setInt(3, compras.getTotal());
            ps.setInt(4, compras.getDia_compra());
            ps.setInt(5, compras.getMes_compra());
            ps.setInt(6, compras.getYear_compra());
            ps.setInt(7, compras.getHora_compra());
            ps.setInt(8, compras.getMinuto_compra());
            ps.setInt(9, compras.getSegundo_compra());
            ps.setInt(10, compras.getId_fpago());
            ps.setInt(11, compras.getCuotas());
            ps.setString(12, compras.getGlosa());
            ps.setInt(13, compras.getNumero_libros());
            ps.setInt(14, compras.getId_compras());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }

        
    public ArrayList<Compras> readAll() {
        ArrayList<Compras> compras = null;
        try {
            compras = new ArrayList<>();            
            ps = con.getCnn().prepareCall("{call sp_selectAllCompras}");
            ResultSet res = ps.executeQuery();
            while (res.next()) {             
                
            compras.add(new Compras(res.getInt("id_compras"),res.getInt("id_distribuidor"),res.getInt("folio_factura"),res.getInt("total"),
                                res.getInt("dia_compra"),res.getInt("mes_compra"),res.getInt("year_compra"),
            res.getInt("hora_compra"),res.getInt("minuto_compra"),res.getInt("segundo_compra"),

                    res.getInt("id_fpago"),res.getInt("cuotas"),
                                res.getString("glosa"),res.getInt("numero_libros")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return compras;
    }
    
//me devuelve (si lo encuentra) un objeto de tipo compras (solo 1)
    public Compras read(int id_distribuidor, int folio_factura) {
        Compras compras = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectCompras (?,?)}");
            ps.setInt(1, id_distribuidor);
            ps.setInt(2, folio_factura);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                compras =  new Compras(res.getInt("id_compras"),res.getInt("id_distribuidor"),res.getInt("folio_factura"),
                        res.getInt("total"),res.getInt("dia_compra"),res.getInt("mes_compra"),res.getInt("year_compra"),
                        res.getInt("hora_compra"),res.getInt("minuto_compra"),res.getInt("segundo_compra"),
                        res.getInt("id_fpago"),res.getInt("cuotas"),
                        res.getString("glosa"),res.getInt("numero_libros"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return compras;
    }

    public Compras readDistribuidorEnCompras(int id_distribuidor) {         
        Compras compras = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectDistribuidorEnCompras (?)}");
            ps.setInt(1, id_distribuidor);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
            compras =  new Compras(res.getInt("id_compras"),res.getInt("id_distribuidor"),res.getInt("folio_factura"),
                    res.getInt("total"),res.getInt("dia_compra"),res.getInt("mes_compra"),res.getInt("year_compra"),
                    res.getInt("hora_compra"),res.getInt("minuto_compra"),res.getInt("segundo_compra"),
                    res.getInt("id_fpago"),res.getInt("cuotas"),
                    res.getString("glosa"),res.getInt("numero_libros"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return compras;
    }

    
        public Compras leerXid_Compra(int id_compras) {
        Compras compras = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectAxIdCompras (?)}");
            ps.setInt(1, id_compras);
            ResultSet res = ps.executeQuery();

            if(res.next()) {                
                compras =  new Compras(res.getInt("id_compras"),res.getInt("id_distribuidor"),
                        res.getInt("folio_factura"),res.getInt("total"),
                        res.getInt("dia_compra"),res.getInt("mes_compra"),res.getInt("year_compra"),
                        res.getInt("hora_compra"),res.getInt("minuto_compra"),res.getInt("segundo_compra"),
                        res.getInt("id_fpago"),res.getInt("cuotas"),
                        res.getString("glosa"),res.getInt("numero_libros"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return compras;
    }
    
}
