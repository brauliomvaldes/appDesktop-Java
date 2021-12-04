/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorArriendos
 * Su función: patron MVC, controlador clase DAOArriendos
 * entrada: objeto Arriendos
 * salida: objeto Arriendos
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 */
public class ControladorArriendos {
    
    public boolean agregar(Arriendos arriendo){
       
        ArriendosDAO ad = new ArriendosDAO();
        if(ad.insert(arriendo)>0){
            return true;
        }
        return false;
    }
        
    public Arriendos leer(long id_folio_comprobante_arriendo){
        ArriendosDAO ad = new ArriendosDAO(); 
        return ad.read(id_folio_comprobante_arriendo);
    }

    public ArrayList<Arriendos> leerPersonasEnArriendos( int id_persona){
       
        ArriendosDAO ad = new ArriendosDAO();
        return ad.readArriendosXcliente(id_persona);
    }
    
    
    public boolean cambiarEstado(long id_folio_comprobante_arriendo, int dia, int mes, int year){
       
        ArriendosDAO ad = new ArriendosDAO();
        if(ad.updateEstado(id_folio_comprobante_arriendo, dia, mes, year)>0){
            return true;
        }
        return false;
    }
    
    public ArrayList<Arriendos> consultarTodo(){
        ArriendosDAO ad = new ArriendosDAO();
        ArrayList<Arriendos> lista = ad.readAll();
        return lista;
    }

    public ArrayList<Arriendos> leerPersonaEnArriendo(int id_persona){
        ArriendosDAO ad = new ArriendosDAO();
        ArrayList<Arriendos> lista = ad.readPersonaEnArriendo(id_persona);
        return lista;
    }
    
    public Arriendos leerPersonasEnArriendos( int id_cliente, int id_trabajador){
       
        ArriendosDAO ad = new ArriendosDAO();
        return ad.readPersonasEnArriendos(id_cliente, id_trabajador);
    }
    
    
    public long buscarFolio(){
       
        ArriendosDAO ad = new ArriendosDAO();
        return ad.buscarFolioEnArriendos();
    }
    

}
