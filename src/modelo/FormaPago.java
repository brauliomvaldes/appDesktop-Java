/**
 * fecha de creacion: junio de 2018
 * nombre: FormaPago
 * Su función: como recordset de la tabla formapago
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class FormaPago {
    
    private String descripcion;

    public FormaPago(String descripcion) {
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
        return "FormaPago{" + "descripcion=" + descripcion + '}';
    }
    
    
}
