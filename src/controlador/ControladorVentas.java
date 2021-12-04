/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorVentas
 * Su función: patron MVC, controlador clase DAOVentas
 * entrada: objeto Ventas
 * salida: objeto Ventas
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 */
public class ControladorVentas {
    
    public boolean agregar(Ventas venta){
       
        VentasDAO ad = new VentasDAO();
        if(ad.insert(venta)>0){
            return true;
        }
        return false;
    }
    
        
    public Ventas leer(long id_folio_boleta){
        VentasDAO ad = new VentasDAO(); 
        return ad.read(id_folio_boleta);
    }
    
    public ArrayList<Ventas> consultarTodo(){
        VentasDAO ad = new VentasDAO();
        ArrayList<Ventas> lista = ad.readAll();
        return lista;
    }

    public ArrayList<Ventas> leerPersonasEnVentas( int id_persona){
       
        VentasDAO ad = new VentasDAO();
        return ad.readPersonasEnVentas(id_persona);
    }
      
    public long buscarFolio(){
       
        VentasDAO ad = new VentasDAO();
        return ad.buscarFolioEnVentas();
    }
    

}
