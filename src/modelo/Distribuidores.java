/**
 * fecha de creacion: junio de 2018
 * nombre: Distribuidores
 * Su función: como recordset de la tabla distribuidores
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Distribuidores {
    private int id_distribuidor_rut;
    private String dv_distribuidor;
    private String nombre;
    private String direccion;
    private String telefono;
    private int estado;
    private int year_incorporacion;
    
    public Distribuidores(){}

    public Distribuidores(int id_distribuidor_rut, String dv_distribuidor, String nombre, String direccion, 
            String telefono, int estado, int year_incorporacion) {
        this.id_distribuidor_rut = id_distribuidor_rut;
        this.dv_distribuidor = dv_distribuidor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.year_incorporacion = year_incorporacion;
    }

    public int getId_distribuidor_rut() {
        return id_distribuidor_rut;
    }

    public void setId_distribuidor_rut(int id_distribuidor_rut) {
        this.id_distribuidor_rut = id_distribuidor_rut;
    }

    public String getDv_distribuidor() {
        return dv_distribuidor;
    }

    public void setDv_distribuidor(String dv_distribuidor) {
        this.dv_distribuidor = dv_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getYear_incorporacion() {
        return year_incorporacion;
    }

    public void setYear_incorporacion(int year_incorporacion) {
        this.year_incorporacion = year_incorporacion;
    }

    @Override
    public String toString() {
        return "Distribuidores{" + "id_distribuidor_rut=" + id_distribuidor_rut + ", dv_distribuidor=" + dv_distribuidor + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", estado=" + estado + ", year_incorporacion=" + year_incorporacion + '}';
    }

    

}
