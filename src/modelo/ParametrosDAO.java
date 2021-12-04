/**
 * fecha de creacion: junio de 2018
 * nombre: ParametrosDAO
 * Su función: patron MVC, parametriza procedimientos almacenados
 * entrada: objeto Parametros 
 * salida: objeto Parametros
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

public class ParametrosDAO {

    CallableStatement ps;

    
    private static final Conexion con = Conexion.getInstance();
      
    public int insert() {
        int flag = 0;
        try {                       
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_creaparametros ()}");
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
        public int update(Parametros parametros) {
        int flag = 0;
        try {
            // Llamada al procedimiento almacenado
            ps = con.getCnn().prepareCall("{call sp_updateParametros (?,?,?,?,?)}");
            ps.setInt(1, parametros.getId_parametros());
            ps.setInt(2, parametros.getImpuesto_iva());
            ps.setInt(3, parametros.getMulta_atraso_diario());
            ps.setInt(4, parametros.getDescuento_especial());
            ps.setInt(5, parametros.getMonto_minimo_descuento());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex.getMessage());
        }finally{
            con.cerrar();
        }
        return flag;
    }
    
    
//me devuelve (si lo encuentra) un objeto )
    public Parametros read(int id_parametros) {
        Parametros parametros = null;        
        try {
            ps = con.getCnn().prepareCall("{call sp_selectAll (?)}");
            ps.setInt(1, id_parametros);
            ResultSet res = ps.executeQuery();
            if(res.next()) {                
                parametros =  new Parametros(res.getInt("id_parametros"), res.getInt("impuesto_iva"),res.getInt("multa_atraso_diario"),
                res.getInt("descuento_especial"), res.getInt("monto_minimo_descuento"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return parametros;
    }
    
}
