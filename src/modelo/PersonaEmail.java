/**
 * fecha de creacion: junio de 2018
 * nombre: PersonaEmail
 * Su función: como recordset de la tabla personaemail
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class PersonaEmail {
    
    private int id_persona;
    private int id_email;
    private int id_estado;

    public PersonaEmail(int id_persona, int id_email, int id_estado) {
        this.id_persona = id_persona;
        this.id_email = id_email;
        this.id_estado = id_estado;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_email() {
        return id_email;
    }

    public void setId_email(int id_email) {
        this.id_email = id_email;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        return "Detalle_email{" + "id_persona=" + id_persona + ", id_email=" + id_email + ", id_estado=" + id_estado + '}';
    }
    
    
}
