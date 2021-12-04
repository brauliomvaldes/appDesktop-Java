/**
 * fecha de creacion: junio de 2018
 * nombre: Editorial
 * Su función: como recordset de la tabla editorial
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Editorial {
    private int id_editorial;
    private String nombre;
    private boolean estado;

    public Editorial(int id_editorial, String nombre, boolean estado) {
        this.id_editorial = id_editorial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id_editorial=" + id_editorial + ", nombre=" + nombre + ", estado=" + estado + '}';
    }


    
}
