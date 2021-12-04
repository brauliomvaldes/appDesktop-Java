/**
 * fecha de creacion: junio de 2018
 * nombre: Email
 * Su función: como recordset de la tabla email
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Email {
    private int id_email;
    private String email;

public Email(String email) {
        this.email = email;
    }
    
    
    public Email(int id_email, String email) {
        this.id_email = id_email;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_email() {
        return id_email;
    }

    public void setId_email(int id_email) {
        this.id_email = id_email;
    }

    @Override
    public String toString() {
        return "Email{" + "id_email=" + id_email + ", email=" + email + '}';
    }

    
    
    
}
