/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorTelefono
 * Su función: patron MVC, controlador clase DAOTelefono
 * entrada: objeto Telefono
 * salida: objeto telefono
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.Telefono;
import modelo.TelefonoDAO;



/**
 *
 */
public class ControladorTelefono {
    
    public boolean agregar(Telefono telefono){
       
        TelefonoDAO ad = new TelefonoDAO();
        if(ad.insert(telefono)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Telefono telefono){
       
        TelefonoDAO ad = new TelefonoDAO();
        if(ad.update(telefono)>0){
            return true;
        }
        return false;
    }
    
    
    public Telefono leer(int id_telefono){
        TelefonoDAO ad = new TelefonoDAO();
        return ad.read(id_telefono);
    }
  
    public Telefono leerXtelefono(String telefono){
        TelefonoDAO ad = new TelefonoDAO();
        return ad.readXtelefono(telefono);
    }
  
    
    public ArrayList<Telefono> consultarTodo(){
        TelefonoDAO ad = new TelefonoDAO();
        ArrayList<Telefono> lista = ad.readAll();
        return lista;
    }

}
