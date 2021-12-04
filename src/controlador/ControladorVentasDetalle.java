/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorVentasDetalle
 * Su función: patron MVC, controlador clase DAOVentasDetalle
 * entrada: objeto VentasDetalle
 * salida: objeto VentasDetalle
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;

/**
 *
 */
public class ControladorVentasDetalle {
    
    public boolean agregar(VentasDetalle ventaDetalle){
       
        VentasDetalleDAO ad = new VentasDetalleDAO();
        if(ad.insert(ventaDetalle)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(VentasDetalle ventaDetalle){
       
        VentasDetalleDAO ad = new VentasDetalleDAO();
        if(ad.update(ventaDetalle)>0){
            return true;
        }
        return false;
    }
    
    public VentasDetalle leer(long id_folio_boleta){
        VentasDetalleDAO ad = new VentasDetalleDAO();
        return ad.read(id_folio_boleta);
    }

    //busca libro vendido
    public VentasDetalle leerXlibro(String serieLibro){
        VentasDetalleDAO ad = new VentasDetalleDAO();
        return ad.readLibroEnVentas(serieLibro);
    }
    
    public ArrayList<VentasDetalle> consultarTodo(){
        VentasDetalleDAO ad = new VentasDetalleDAO();
        ArrayList<VentasDetalle> lista = ad.readAll();
        return lista;
    }

}
