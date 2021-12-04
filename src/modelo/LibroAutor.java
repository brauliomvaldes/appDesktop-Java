/**
 * fecha de creacion: junio de 2018
 * nombre: LibroAutor
 * Su función: como recordset de la tabla libroautor
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class LibroAutor {
    
    private String id_libro;
    private int id_autor;
    
    public LibroAutor(){};
    
    public LibroAutor(String id_libro, int id_autor) {
        this.id_libro = id_libro;
        this.id_autor = id_autor;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public String toString() {
        return "AutoresDetalle{" + "id_libro=" + id_libro + ", id_autor=" + id_autor + '}';
    }
    
    
}
