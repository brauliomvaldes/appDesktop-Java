/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorPersonaEmail
 * Su función: patron MVC, controlador clase DAOPersonaEmail
 * entrada: objeto PersonaEmail
 * salida: objeto PersonaEmail
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorPersonaEmail {
    
    public boolean agregar(int persona, int email, int estado){
       
        PersonaEmailDAO ad = new PersonaEmailDAO();
        if(ad.insert(persona,email,estado)>0){
            return true;
        }
        return false;
    }
    
    
    public boolean actualizar(int persona, int email, int estado){
       
        PersonaEmailDAO ad = new PersonaEmailDAO();
        if(ad.update(persona,email,estado)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean delete(int persona, int email, int estado){
        PersonaEmailDAO ad = new PersonaEmailDAO();
        if (ad.cambioEstado(persona,email,estado)>0){
            return true;
        }
        return false;
    }
    public PersonaEmail leer(int persona){
        PersonaEmailDAO ad = new PersonaEmailDAO();
        return ad.read(persona);
    }
    
    public ArrayList<PersonaEmail> consultarTodoxPersona(int persona){
        PersonaEmailDAO ad = new PersonaEmailDAO();
        ArrayList<PersonaEmail> lista = ad.readAllxPersona(persona);
        return lista;
    }
}
