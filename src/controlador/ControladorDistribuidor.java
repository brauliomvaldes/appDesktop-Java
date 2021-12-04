/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorDistribuidor
 * Su función: patron MVC, controlador clase DAODistribuidor
 * entrada: objeto Distribuidor
 * salida: objeto Distribuidor
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 */
public class ControladorDistribuidor {
    
    public boolean agregar(Distribuidores distribuidor){
       
        DistribuidorDAO ad = new DistribuidorDAO();
        if(ad.insert(distribuidor)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Distribuidores distribuidor){
       
        DistribuidorDAO ad = new DistribuidorDAO();
        if(ad.update(distribuidor)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean cambiaEstado(Integer rut, int estado){
        DistribuidorDAO ad = new DistribuidorDAO();
        if (ad.cambiaEstado(rut,estado)>0){
            return true;
        }
        return false;
    }
    public Distribuidores leer(int rut){
        DistribuidorDAO ad = new DistribuidorDAO();
        return ad.read(rut);
    }
    
    public ArrayList<Distribuidores> consultarTodo(){
        DistribuidorDAO ad = new DistribuidorDAO();
        ArrayList<Distribuidores> lista = ad.readAll();
        return lista;
    }

}
