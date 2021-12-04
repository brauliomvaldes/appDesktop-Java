/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorPersona
 * Su función: patron MVC, controlador clase DAOPersona
 * entrada: objeto Persona
 * salida: objeto Persona
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.Personas;
import modelo.PersonaDAO;



/**
 *
 */
public class ControladorPersona {
    
    public boolean agregar(Personas persona){
       
        PersonaDAO ad = new PersonaDAO();
        if(ad.insert(persona)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Personas persona){
       
        PersonaDAO ad = new PersonaDAO();
        if(ad.update(persona)>0){
            return true;
        }
        return false;
    }
        
    public boolean cambiaEstado(Integer rut, int estado){
        PersonaDAO ad = new PersonaDAO();
        if (ad.cambiaEstado(rut,estado)>0){
            return true;
        }
        return false;
    }

    public boolean bloquearPersonaXmora(int id_persona_rut){
        PersonaDAO ad = new PersonaDAO();
        if (ad.bloquaPersonaXmora(id_persona_rut)>0){
            return true;
        }
        return false;
    }
    
    public Personas leer(int rut){
        PersonaDAO ad = new PersonaDAO();
        return ad.read(rut);
    }
    
    public ArrayList<Personas> consultarTodo(){
        PersonaDAO ad = new PersonaDAO();
        ArrayList<Personas> lista = ad.readAll();
        return lista;
    }

}
