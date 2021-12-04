/**
 * fecha de creacion: junio de 2018
 * nombre: ControladorLibros
 * Su función: patron MVC, controlador clase DAOLibros
 * entrada: objeto Libros
 * salida: objeto Libros
 * @author: braulio valdes 
 */
package controlador;

import java.util.ArrayList;
import modelo.*;


public class ControladorLibros {
    
    public boolean agregar(Libros libros){
       
        LibrosDAO ad = new LibrosDAO();
        if(ad.insert(libros)>0){
            return true;
        }
        return false;
    }
    
    public boolean actualizar(Libros l){
        LibrosDAO ad = new LibrosDAO();
        if(ad.update(l)>0){
            return true;
        }
        return false;
    }
    
    public boolean actualizaStockYprecio(String serieLibro, int nuevoStock, int nuevoPrecio){
        LibrosDAO ad = new LibrosDAO();
        if(ad.updateStockYprecio(serieLibro, nuevoStock, nuevoPrecio)>0){
            return true;
        }
        return false;
    }
    
    public boolean actualizaStockArriendos(String serieLibro, int nuevoStockArriendo){
        LibrosDAO ad = new LibrosDAO();
        if(ad.updateStockArriendo(serieLibro, nuevoStockArriendo)>0){
            return true;
        }
        return false;
    }
    
  
    
    public Libros leerAutorEnLibro(int id_autor){
        LibrosDAO ad = new LibrosDAO();
        return ad.buscarAutorEnLibro(id_autor);
    }
    
    public Libros leerCategoriaEnLibro(int id_categoria){
        LibrosDAO ad = new LibrosDAO();
        return ad.buscarCategoriaEnLibro(id_categoria);
    }
    
    public Libros leerEditorialEnLibro(int id_editorial){
        LibrosDAO ad = new LibrosDAO();
        return ad.buscarEditorialEnLibro(id_editorial);
    }
    
      public Libros leerIdiomaEnLibro(int id_idioma){
        LibrosDAO ad = new LibrosDAO();
        return ad.buscarIdiomaEnLibro(id_idioma);
    }
    
    
    public Libros leer(String serie){
        LibrosDAO ad = new LibrosDAO();
        return ad.read(serie);
    }
    
    public ArrayList<Libros> consultarTodo(){
        LibrosDAO ad = new LibrosDAO();
        
        ArrayList<Libros> lista = ad.readAll();
        return lista;
    }
    
    public ArrayList<Libros> consultarTodoParametroTitulo(String buscar){
        LibrosDAO ad = new LibrosDAO();      
        ArrayList<Libros> lista = ad.readAllBuscarXtitulo(buscar);
        return lista;
    }
   
     public ArrayList<Libros> consultarTodoParametroSerie(String buscar){
        LibrosDAO ad = new LibrosDAO();      
        ArrayList<Libros> lista = ad.readAllBuscarXserie(buscar);
        return lista;
    }
    
}
