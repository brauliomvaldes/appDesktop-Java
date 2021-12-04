/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorLibroAutor
 * Su función: patron MVC, controlador clase DAOLibroAutor
 * entrada: objeto LibroAutor
 * salida: objeto LibroAutor
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorLibroAutor {
    
    public boolean agregar(String serie, int libroAutor){
       
        LibroAutorDAO ad = new LibroAutorDAO();
        if(ad.insert(serie,libroAutor)>0){
            return true;
        }
        return false;
    }
    
    
    public boolean actualizar(String serie, int libroAutor){
       
        LibroAutorDAO ad = new LibroAutorDAO();
        if(ad.update(serie, libroAutor)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean eliminar(String libro){
        LibroAutorDAO ad = new LibroAutorDAO();
        if (ad.delete(libro)>0){
            return true;
        }
        return false;
    }
    public LibroAutor leer(String serie){
        LibroAutorDAO ad = new LibroAutorDAO();
        return ad.read(serie);
    }
    
    public ArrayList<LibroAutor> consultarTodoxLibro(String serie){
        LibroAutorDAO ad = new LibroAutorDAO();
        ArrayList<LibroAutor> lista = ad.readAllxLibro(serie);
        return lista;
    }
}
