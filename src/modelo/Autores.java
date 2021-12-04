/**
 * fecha de creacion: junio de 2018
 * nombre: Autores
 * Su función: como recordset de la tabla autores
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Autores {
    private int id_autor;
    private String nombre;
    private boolean estado;
    
    public Autores(){}

    public Autores(int id_autor, String nombre, boolean estado) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Autores{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    
    
}
