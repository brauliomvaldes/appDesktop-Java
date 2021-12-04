/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorPersonaTelefono
 * Su función: patron MVC, controlador clase DAOPersonaTelefono
 * entrada: objeto PersonaTelefono
 * salida: objeto PersonaTelefono
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorPersonaTelefono {
    
    public boolean agregar(int persona, int telefono, int estado){
       
        PersonaTelefonoDAO ad = new PersonaTelefonoDAO();
        if(ad.insert(persona,telefono,estado)>0){
            return true;
        }
        return false;
    }
    
    
    public boolean actualizar(int persona, int direccion, int estado){
       
        PersonaTelefonoDAO ad = new PersonaTelefonoDAO();
        if(ad.update(persona,direccion,estado)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean delete(int persona, int direccion, int estado){
        PersonaTelefonoDAO ad = new PersonaTelefonoDAO();
        if (ad.cambioEstado(persona,direccion,estado)>0){
            return true;
        }
        return false;
    }
    public PersonaTelefono leer(int persona){
        PersonaTelefonoDAO ad = new PersonaTelefonoDAO();
        return ad.read(persona);
    }
    
    public ArrayList<PersonaTelefono> consultarTodoxPersona(int persona){
        PersonaTelefonoDAO ad = new PersonaTelefonoDAO();
        ArrayList<PersonaTelefono> lista = ad.readAllxPersona(persona);
        return lista;
    }
}
