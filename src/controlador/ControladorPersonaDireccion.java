/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorPersonaDireccion
 * Su función: patron MVC, controlador clase DAOPersonaDireccion
 * entrada: objeto PersonaDireccion
 * salida: objeto PersonaDireccion
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorPersonaDireccion {
    
    public boolean agregar(int persona, int direccion, int estado){
       
        PersonaDireccionDAO ad = new PersonaDireccionDAO();
        if(ad.insert(persona,direccion,estado)>0){
            return true;
        }
        return false;
    }
    
    
    public boolean actualizar(int persona, int direccion, int estado){
       
        PersonaDireccionDAO ad = new PersonaDireccionDAO();
        if(ad.update(persona,direccion,estado)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean delete(int persona, int direccion, int estado){
        PersonaDireccionDAO ad = new PersonaDireccionDAO();
        if (ad.cambioEstado(persona,direccion,estado)>0){
            return true;
        }
        return false;
    }
    public PersonaDireccion leer(int persona){
        PersonaDireccionDAO ad = new PersonaDireccionDAO();
        return ad.read(persona);
    }
    
    public ArrayList<PersonaDireccion> consultarTodoXpersona(int persona){
        PersonaDireccionDAO ad = new PersonaDireccionDAO();
        ArrayList<PersonaDireccion> lista = ad.readAllxPersona(persona);
        return lista;
    }
}
