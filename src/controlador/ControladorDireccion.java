/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorDireccion
 * Su función: patron MVC, controlador clase DAODireccion
 * entrada: objeto Direccion
 * salida: objeto Direccion
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.Direccion;
import modelo.DireccionDAO;



/**
 *
 */
public class ControladorDireccion {
    
    public boolean agregar(Direccion direccion){
       
        DireccionDAO ad = new DireccionDAO();
        if(ad.insert(direccion)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Direccion direccion){
       
        DireccionDAO ad = new DireccionDAO();
        if(ad.update(direccion)>0){
            return true;
        }
        return false;
    }
    
    
    public Direccion leer(int id_direccion){
        DireccionDAO ad = new DireccionDAO();
        return ad.read(id_direccion);
    }

    public Direccion leerXdireccion(String direccion){
        DireccionDAO ad = new DireccionDAO();
        return ad.readXdireccion(direccion);
    }
    
    
    public ArrayList<Direccion> consultarTodo(){
        DireccionDAO ad = new DireccionDAO();
        ArrayList<Direccion> lista = ad.readAll();
        return lista;
    }

}
