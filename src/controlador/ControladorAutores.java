/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorAutores
 * Su función: patron MVC, controlador clase DAOAutores
 * entrada: objeto Autores
 * salida: objeto Autores
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorAutores {
    
    public boolean agregar(String nombre){
       
        AutoresDAO ad = new AutoresDAO();
        if(ad.insert(nombre)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Autores a){
       
        AutoresDAO ad = new AutoresDAO();
        if(ad.update(a)>0){
            return true;
        }
        return false;
    }
    
    
    
    public boolean cambiaEstado(Integer id, boolean estado){
        AutoresDAO ad = new AutoresDAO();
        if (ad.cambiaEstado(id,estado)>0){
            return true;
        }
        return false;
    }
    public Autores leer(String nombre){
        AutoresDAO ad = new AutoresDAO();
        return ad.read(nombre);
    }
    
    public ArrayList<Autores> consultarTodo(){
        AutoresDAO ad = new AutoresDAO();
        ArrayList<Autores> lista = ad.readAll();
        return lista;
    }
    public Autores leerXid_autor(int id_autor){
        AutoresDAO ad = new AutoresDAO();
        return ad.leerXid(id_autor);
    }
    


}
