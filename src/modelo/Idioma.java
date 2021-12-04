/**
 * fecha de creacion: junio de 2018
 * nombre: Idioma
 * Su función: como recordset de la tabla idioma
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Idioma {
    private int id_idioma;
    private String nombre;
    private boolean estado;

    public Idioma(int id_idioma, String nombre, boolean estado) {
        this.id_idioma = id_idioma;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Idioma{" + "id_idioma=" + id_idioma + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    

}
