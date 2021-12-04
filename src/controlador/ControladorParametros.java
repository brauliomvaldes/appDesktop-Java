/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorParametros
 * Su función: patron MVC, controlador clase DAOParametros
 * entrada: objeto Parametros
 * salida: objeto Parametros
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorParametros {
    
    public boolean agregar(){
        ParametrosDAO ad = new ParametrosDAO();
        if(ad.insert()>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Parametros parametros){
       
        ParametrosDAO ad = new ParametrosDAO();
        if(ad.update(parametros)>0){
            return true;
        }
        return false;
    }
    
    public Parametros leer(int id_parametros){
        ParametrosDAO ad = new ParametrosDAO();
        return ad.read(id_parametros);
    }
    
}
