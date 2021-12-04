/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaTelefono
 * Su función: como recordset de la tabla personatelefono
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class PersonaTelefono {

    private int id_persona;
    private int id_telefono;
    private int id_estado;

    public PersonaTelefono(int id_persona, int id_telefono, int id_estado) {
        this.id_persona = id_persona;
        this.id_telefono = id_telefono;
        this.id_estado = id_estado;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        return "Detalle_telefono{" + "id_persona=" + id_persona + ", id_telefono=" + id_telefono + ", id_estado=" + id_estado + '}';
    }
    
    
    
}
