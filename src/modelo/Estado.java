/**
 * fecha de creacion: junio de 2018
 * nombre: Estado
 * Su función: como recordset de la tabla estado
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Estado {
    
    private String descripcion;

    public Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estado{" + "descripcion=" + descripcion + '}';
    }
    
    
}
