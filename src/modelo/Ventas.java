/**
 * fecha de creacion: junio de 2018
 * nombre: Ventas
 * Su función: como recordset de la tabla ventas
 * @author: braulio valdes 
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Ventas {
    private long id_folio_boleta;
    private int total;
    private int dia;
    private int mes;
    private int year;
    private Time hora_venta;
    private int id_fpafo;
    private int id_cliente;
    private int id_trabajador;
    private int cuotas;
    private String glosa;
    private int librosvendidos;

    public Ventas(long id_folio_boleta, int total, int dia, int mes, int year, Time hora_venta, int id_fpafo, 
                    int id_cliente, int id_trabajador, int cuotas, String glosa, int librosvendidos) {
        this.id_folio_boleta = id_folio_boleta;
        this.total = total;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.hora_venta = hora_venta;
        this.id_fpafo = id_fpafo;
        this.id_cliente = id_cliente;
        this.id_trabajador = id_trabajador;
        this.cuotas = cuotas;
        this.glosa = glosa;
        this.librosvendidos = librosvendidos;
    }

        public Ventas(int total, int dia, int mes, int year, Time hora_venta, int id_fpafo, 
                    int id_cliente, int id_trabajador, int cuotas, String glosa, int librosvendidos) {
        this.total = total;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.hora_venta = hora_venta;
        this.id_fpafo = id_fpafo;
        this.id_cliente = id_cliente;
        this.id_trabajador = id_trabajador;
        this.cuotas = cuotas;
        this.glosa = glosa;
        this.librosvendidos = librosvendidos;
    }

    public long getId_folio_boleta() {
        return id_folio_boleta;
    }

    public void setId_folio_boleta(long id_folio_boleta) {
        this.id_folio_boleta = id_folio_boleta;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Time getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    public int getId_fpafo() {
        return id_fpafo;
    }

    public void setId_fpafo(int id_fpafo) {
        this.id_fpafo = id_fpafo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLibrosvendidos() {
        return librosvendidos;
    }

    public void setLibrosvendidos(int librosvendidos) {
        this.librosvendidos = librosvendidos;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id_folio_boleta=" + id_folio_boleta + ", total=" + total + ", dia=" + dia + ", mes=" + mes + ", year=" + year + ", hora_venta=" + hora_venta + ", id_fpafo=" + id_fpafo + ", id_cliente=" + id_cliente + ", id_trabajador=" + id_trabajador + ", cuotas=" + cuotas + ", glosa=" + glosa + ", librosvendidos=" + librosvendidos + '}';
    }

    
}
