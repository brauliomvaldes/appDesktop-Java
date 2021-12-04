/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorComprasDetalle
 * Su función: patron MVC, controlador clase DAOComprasDetalle
 * entrada: objeto ComprasDetalle
 * salida: objeto ComprasDetalle
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 */
public class ControladorComprasDetalle {
    
    public boolean agregar(ComprasDetalle comprasDetalle){
       
        ComprasDetalleDAO ad = new ComprasDetalleDAO();
        if(ad.insert(comprasDetalle)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(ComprasDetalle comprasDetalle){
       
        ComprasDetalleDAO ad = new ComprasDetalleDAO();
        if(ad.update(comprasDetalle)>0){
            return true;
        }
        return false;
    }
    
    
    public ComprasDetalle leer(int folio_factura){
        ComprasDetalleDAO ad = new ComprasDetalleDAO();
        return ad.read(folio_factura);
    }

    public ArrayList<ComprasDetalle> leerXlibro(String serieLibro){
        ComprasDetalleDAO ad = new ComprasDetalleDAO();
        ArrayList<ComprasDetalle> lista = ad.leerXlibro(serieLibro);
        return lista;
    }
    
    public ArrayList<ComprasDetalle> consultarTodo(){
        ComprasDetalleDAO ad = new ComprasDetalleDAO();
        ArrayList<ComprasDetalle> lista = ad.readAll();
        return lista;
    }

}
