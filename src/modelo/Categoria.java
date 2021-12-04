/**
 * fecha de creacion: junio de 2018
 * nombre: Categoria
 * Su función: como recordset de la tabla categoria
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Categoria {
    private int id_categoria;
    private String nombre;
    private boolean estado;

    public Categoria(){}
    
    public Categoria(int id_categoria, String nombre, boolean estado) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
}
