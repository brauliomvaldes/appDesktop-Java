/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorCategoria
 * Su función: patron MVC, controlador clase DAOCategoria
 * entrada: objeto Categoria
 * salida: objeto Categoria
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;



/**
 *
 * @author LENOVO L450
 */
public class ControladorCategoria {
    
    public boolean agregar(String nombre){
       
        CategoriaDAO ad = new CategoriaDAO();
        if(ad.insert(nombre)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Categoria c){
       
        CategoriaDAO ad = new CategoriaDAO();
        if(ad.update(c)>0){
            return true;
        }
        return false;
    }
    
    public boolean cambiaEstado(Integer id, boolean estado){
        CategoriaDAO ad = new CategoriaDAO();
        if (ad.cambiaEstado(id,estado)>0){
            return true;
        }
        return false;
    }
    
    public Categoria leer(String nombre){
        CategoriaDAO ad = new CategoriaDAO();
        return ad.read(nombre);
    }
    
    public Categoria leerXid_categoria(int id_categoria){
        CategoriaDAO ad = new CategoriaDAO();
        return ad.leerXid(id_categoria);
    }
    
    public ArrayList<Categoria> consultarTodo(){
        CategoriaDAO ad = new CategoriaDAO();
        ArrayList<Categoria> lista = ad.readAll();
        return lista;
    }
}
