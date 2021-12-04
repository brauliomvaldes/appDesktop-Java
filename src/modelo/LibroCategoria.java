/**
 * fecha de creacion: junio de 2018
 * nombre: LibroCategoria
 * Su función: como recordset de la tabla librocategoria
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class LibroCategoria {
    
    private String id_libro;
    private int id_categoria;

    public LibroCategoria(){}
    
    public LibroCategoria(String id_libro, int id_categoria) {
        this.id_libro = id_libro;
        this.id_categoria = id_categoria;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Detalle_categoria{" + "id_libro=" + id_libro + ", id_categoria=" + id_categoria + '}';
    }




}
