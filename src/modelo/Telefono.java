/**
 * fecha de creacion: junio de 2018
 * nombre: Telefono
 * Su función: como recordset de la tabla telefono
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Telefono {
    private int id_telefono;
    private String telefono;

public Telefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public Telefono(int id_telefono, String telefono) {
        this.id_telefono = id_telefono;
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    @Override
    public String toString() {
        return "Telefono{" + "id_telefono=" + id_telefono + ", telefono=" + telefono + '}';
    }
    
    
}
