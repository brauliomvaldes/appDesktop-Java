/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorIdioma
 * Su función: patron MVC, controlador clase DAOIdioma
 * entrada: objeto Idioma
 * salida: objeto Idioma
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorIdioma {
    
    public boolean agregar(String nombre){
       
        IdiomaDAO ad = new IdiomaDAO();
        if(ad.insert(nombre)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Idioma i){
       
        IdiomaDAO ad = new IdiomaDAO();
        if(ad.update(i)>0){
            return true;
        }
        return false;
    }
    
    public boolean cambiaEstado(Integer id, boolean estado){
        IdiomaDAO ad = new IdiomaDAO();
        if (ad.cambiaEstado(id,estado)>0){
            return true;
        }
        return false;
    }
    
    public Idioma leer(String idioma){
        IdiomaDAO ad = new IdiomaDAO();
        return ad.read(idioma);
    }
    
    public Idioma leerXid_idioma(int id_idioma){
        IdiomaDAO ad = new IdiomaDAO();
        return ad.leerXid(id_idioma);
    }
    
    
    public ArrayList<Idioma> consultarTodo(){
        IdiomaDAO ad = new IdiomaDAO();
        
        ArrayList<Idioma> lista = ad.readAll();
        return lista;
    }
}
