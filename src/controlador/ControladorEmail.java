/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorEmail
 * Su función: patron MVC, controlador clase DAOEmail
 * entrada: objeto Email
 * salida: objeto Email
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.Email;
import modelo.EmailDAO;



/**
 *
 */
public class ControladorEmail {
    
    public boolean agregar(Email email){
       
        EmailDAO ad = new EmailDAO();
        if(ad.insert(email)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Email email){
       
        EmailDAO ad = new EmailDAO();
        if(ad.update(email)>0){
            return true;
        }
        return false;
    }
    
    
    public Email leer(int id_email){
        EmailDAO ad = new EmailDAO();
        return ad.read(id_email);
    }
   
     public Email leerXemail(String email){
        EmailDAO ad = new EmailDAO();
        return ad.readXemail(email);
    }
   
    
    public ArrayList<Email> consultarTodo(){
        EmailDAO ad = new EmailDAO();
        ArrayList<Email> lista = ad.readAll();
        return lista;
    }

}
