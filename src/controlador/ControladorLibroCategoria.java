/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorLibroCategoria
 * Su función: patron MVC, controlador clase DAOLibroCategoria
 * entrada: objeto LibroCategoria
 * salida: objeto LibroCategoria
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorLibroCategoria {
    
    public boolean agregar(String libro, int categoria){
       
        LibroCategoriaDAO ad = new LibroCategoriaDAO();
        if(ad.insert(libro,categoria)>0){
            return true;
        }
        return false;
    }
    
    public boolean actualizar(String libro, int categoria){
       
        LibroCategoriaDAO ad = new LibroCategoriaDAO();
        if(ad.update(libro, categoria)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean eliminar(String libro){
        LibroCategoriaDAO ad = new LibroCategoriaDAO();
        if (ad.delete(libro)>0){
            return true;
        }
        return false;
    }
    public LibroCategoria leer(String serie){
        LibroCategoriaDAO lc = new LibroCategoriaDAO();
        return lc.read(serie);
    }
    
    public ArrayList<LibroCategoria> consultarTodoxLibro(String serie){
        LibroCategoriaDAO ad = new LibroCategoriaDAO();
        ArrayList<LibroCategoria> lista = ad.readAllxLibro(serie);
        return lista;
    }
    
}
