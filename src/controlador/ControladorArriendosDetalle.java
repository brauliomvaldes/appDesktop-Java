/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorArriendosDetalle
 * Su función: patron MVC, controlador clase DAOArriendosDetalle
 * entrada: objeto ArriendosDetalle
 * salida: objeto ArriendosDetalle
 * @author: braulio valdes 
 */
package controlador;

import modelo.ArriendosDetalleDAO;
import java.util.ArrayList;
import modelo.*;

/**
 *
 */
public class ControladorArriendosDetalle {
    
    public boolean agregar(ArriendosDetalle arriendoDetalle){
       
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        if(ad.insert(arriendoDetalle)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(ArriendosDetalle arriendoDetalle){
       
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        if(ad.update(arriendoDetalle)>0){
            return true;
        }
        return false;
    }

    public boolean modificarEstado(long folio_arriendo, String serie){
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        if(ad.updateEstado(folio_arriendo, serie)>0){
            return true;
        }
        return false;
    }

    
    public ArriendosDetalle leer(long id_folio_comprobante_arriendo){
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        return ad.read(id_folio_comprobante_arriendo);
    }

    public ArrayList<ArriendosDetalle> leerAllXfolio(long id_folio_comprobante_arriendo){
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        ArrayList<ArriendosDetalle> lista = ad.readAllXfolio(id_folio_comprobante_arriendo);
        return lista;
    }

    
    
    //busca libro vendido
    public ArriendosDetalle leerXlibro(String serieLibro){
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        return ad.readLibroEnArriendos(serieLibro);
    }
    
    public ArrayList<ArriendosDetalle> consultarTodo(){
        ArriendosDetalleDAO ad = new ArriendosDetalleDAO();
        ArrayList<ArriendosDetalle> lista = ad.readAll();
        return lista;
    }

}
