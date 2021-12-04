/**
 * fecha de creacion: junio de 2018
 * nombre: Direccion
 * Su función: como recordset de la tabla direccion
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Direccion {
    private int id_direccion;
    private String direccion;

    public Direccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Direccion(int id_direccion, String direccion) {
        this.id_direccion = id_direccion;
        this.direccion = direccion;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id_direccion=" + id_direccion + ", direccion=" + direccion + '}';
    }
    
    
    
}
