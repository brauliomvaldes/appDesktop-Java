/**
 * fecha de creacion: junio de 2018
 * nombre: Personas
 * Su función: como recordset de la tabla personas
 * @author: braulio valdes 
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author LENOVO L450
 */
public class Personas {
    private int id_persona_rut;
    private String dv_persona;
    private int tipo_persona;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private int direccion;
    private int telefono;
    private int email;
    private int dia_contrato;
    private int mes_contrato;
    private int year_contrato;
    private int dia_incorporado;
    private int mes_incorporado;
    private int year_incorporado;
    private int estado;

    public Personas(int id_persona_rut, String dv_persona, int tipo_persona, String nombre, String apaterno, 
              String amaterno, int direccion, int telefono, int email, int dia_contrato, 
               int mes_contrato, int year_contrato, int dia_incorporado, int mes_incorporado, 
               int year_incorporado, int estado) {
        this.id_persona_rut = id_persona_rut;
        this.dv_persona = dv_persona;
        this.tipo_persona = tipo_persona;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.dia_contrato = dia_contrato;
        this.mes_contrato = mes_contrato;
        this.year_contrato = year_contrato;
        this.dia_incorporado = dia_incorporado;
        this.mes_incorporado = mes_incorporado;
        this.year_incorporado = year_incorporado;
        this.estado = estado;
    }

    public int getId_persona_rut() {
        return id_persona_rut;
    }

    public void setId_persona_rut(int id_persona_rut) {
        this.id_persona_rut = id_persona_rut;
    }

    public int getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona_rut(int tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getDv_persona() {
        return dv_persona;
    }

    public void setDv_persona(String dv_persona) {
        this.dv_persona = dv_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getDia_contrato() {
        return dia_contrato;
    }

    public void setDia_contrato(int dia_contrato) {
        this.dia_contrato = dia_contrato;
    }

    public int getMes_contrato() {
        return mes_contrato;
    }

    public void setMes_contrato(int mes_contrato) {
        this.mes_contrato = mes_contrato;
    }

    public int getYear_contrato() {
        return year_contrato;
    }

    public void setYear_contrato(int year_contrato) {
        this.year_contrato = year_contrato;
    }

    public int getDia_incorporado() {
        return dia_incorporado;
    }

    public void setDia_incorporado(int dia_incorporado) {
        this.dia_incorporado = dia_incorporado;
    }

    public int getMes_incorporado() {
        return mes_incorporado;
    }

    public void setMes_incorporado(int mes_incorporado) {
        this.mes_incorporado = mes_incorporado;
    }

    public int getYear_incorporado() {
        return year_incorporado;
    }

    public void setYear_incorporado(int year_incorporado) {
        this.year_incorporado = year_incorporado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Personas{" + "id_persona_rut=" + id_persona_rut + ", dv_persona=" + dv_persona + 
                ", tipo_persona=" + tipo_persona + ", nombre=" + nombre + ", apaterno=" + apaterno + 
                ", amaterno=" + amaterno + ", direccion=" + direccion + ", telefono=" + telefono + 
                ", email=" + email + ", dia_contrato=" + dia_contrato + ", mes_contrato=" + mes_contrato + 
                ", year_contrato=" + year_contrato + ", dia_incorporado=" + dia_incorporado + 
                ", mes_incorporado=" + mes_incorporado + ", year_incorporado=" + year_incorporado + 
                ", estado=" + estado + '}';
    }

}
