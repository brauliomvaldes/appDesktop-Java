/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaDireccion
 * Su función: como recordset de la tabla personadireccion
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class PersonaDireccion {
    
    private int id_persona;
    private int id_direccion;
    private int id_estado;

    public PersonaDireccion(int id_persona, int id_direccion, int id_estado) {
        this.id_persona = id_persona;
        this.id_direccion = id_direccion;
        this.id_estado = id_estado;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        return "Detalle_direccion{" + "id_persona=" + id_persona + ", id_direccion=" + id_direccion + ", id_estado=" + id_estado + '}';
    }
    
    
}
