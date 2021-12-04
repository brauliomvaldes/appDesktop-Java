/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorEditorial
 * Su función: patron MVC, controlador clase DAOEditorial
 * entrada: objeto Editorial
 * salida: objeto Editorial
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorEditorial {
    
    public boolean agregar(String nombre){
       
        EditorialDAO ad = new EditorialDAO();
        if(ad.insert(nombre)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Editorial e){
       
        EditorialDAO ad = new EditorialDAO();
        if(ad.update(e)>0){
            return true;
        }
        return false;
    }
    
    public boolean cambiaEstado(Integer id, boolean estado){
        EditorialDAO ad = new EditorialDAO();
        if (ad.cambiaEstado(id,estado)>0){
            return true;
        }
        return false;
    }
    
    
    public Editorial leer(String nombre){
        EditorialDAO ad = new EditorialDAO();
        return ad.read(nombre);
    }
    public Editorial leerXid_editorial(int id_editorial){
        EditorialDAO ad = new EditorialDAO();
        return ad.leerXid(id_editorial);
    }
    
    
    
    public ArrayList<Editorial> consultarTodo(){
        EditorialDAO ad = new EditorialDAO();
        
        ArrayList<Editorial> lista = ad.readAll();
        return lista;
    }
}
