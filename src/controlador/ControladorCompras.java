/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorCompras
 * Su función: patron MVC, controlador clase DAOCompras
 * entrada: objeto Compras
 * salida: objeto Compras
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 */
public class ControladorCompras {
    
    public boolean agregar(Compras compra){
       
        ComprasDAO ad = new ComprasDAO();
        if(ad.insert(compra)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Compras compra){
       
        ComprasDAO ad = new ComprasDAO();
        if(ad.update(compra)>0){
            return true;
        }
        return false;
    }
        
    public Compras leer(int id_distribuidor, int folio_factura){
        ComprasDAO ad = new ComprasDAO(); 
        return ad.read(id_distribuidor, folio_factura);
    }
    
    public ArrayList<Compras> consultarTodo(){
        ComprasDAO ad = new ComprasDAO();
        ArrayList<Compras> lista = ad.readAll();
        return lista;
    }

    public Compras leerDistribuidorEnCompras(int id_distribuidor){
       
        ComprasDAO ad = new ComprasDAO();
        return ad.readDistribuidorEnCompras(id_distribuidor);
    }
    

}
