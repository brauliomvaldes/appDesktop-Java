/**
 * fecha de creacion: junio de 2018
 * nombre: Arriendos
 * Su función: como recordset de la tabla arriendos
 * @author: braulio valdes 
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Arriendos {
    private long id_folio_comprobante_arriendo;
    private int costo_arriendo;
    private int dia_arriendo;
    private int mes_arriendo;
    private int year_arriendo;
    private int dia_devolucion_estimada;
    private int mes_devolucion_estimada;
    private int year_devolucion_estimada;
    private int dia_devolucion_real;
    private int mes_devolucion_real;
    private int year_devolucion_real;
    private int id_cliente;
    private int id_trabajador;
    private int id_fpago;
    private int cuotas;
    private int libros_arrendados;
    private int estado;
    
    public Arriendos(long id_folio_comprobante_arriendo, int costo_arriendo, int dia_arriendo, 
            int mes_arriendo, int year_arriendo, int dia_devolucion_estimada, int mes_devolucion_estimada, 
            int year_devolucion_estimada, int dia_devolucion_real, int mes_devolucion_real, 
            int year_devolucion_real, int id_cliente, int id_trabajador, int id_fpago, int cuotas, 
            int libros_arrendados, int estado) {
        this.id_folio_comprobante_arriendo = id_folio_comprobante_arriendo;
        this.costo_arriendo = costo_arriendo;
        this.dia_arriendo = dia_arriendo;
        this.mes_arriendo = mes_arriendo;
        this.year_arriendo = year_arriendo;
        this.dia_devolucion_estimada = dia_devolucion_estimada;
        this.mes_devolucion_estimada = mes_devolucion_estimada;
        this.year_devolucion_estimada = year_devolucion_estimada;
        this.dia_devolucion_real = dia_devolucion_real;
        this.mes_devolucion_real = mes_devolucion_real;
        this.year_devolucion_real = year_devolucion_real;
        this.id_cliente = id_cliente;
        this.id_trabajador = id_trabajador;
        this.id_fpago = id_fpago;
        this.cuotas = cuotas;
        this.libros_arrendados = libros_arrendados;
        this.estado = estado;
    }

    
    
    public long getId_folio_comprobante_arriendo() {
        return id_folio_comprobante_arriendo;
    }

    public void setId_folio_comprobante_arriendo(long id_folio_comprobante_arriendo) {
        this.id_folio_comprobante_arriendo = id_folio_comprobante_arriendo;
    }

    public int getCosto_arriendo() {
        return costo_arriendo;
    }

    public void setCosto_arriendo(int costo_arriendo) {
        this.costo_arriendo = costo_arriendo;
    }

    public int getDia_arriendo() {
        return dia_arriendo;
    }

    public void setDia_arriendo(int dia_arriendo) {
        this.dia_arriendo = dia_arriendo;
    }

    public int getMes_arriendo() {
        return mes_arriendo;
    }

    public void setMes_arriendo(int mes_arriendo) {
        this.mes_arriendo = mes_arriendo;
    }

    public int getYear_arriendo() {
        return year_arriendo;
    }

    public void setYear_arriendo(int year_arriendo) {
        this.year_arriendo = year_arriendo;
    }

    public int getDia_devolucion_estimada() {
        return dia_devolucion_estimada;
    }

    public void setDia_devolucion_estimada(int dia_devoluccion_estimada) {
        this.dia_devolucion_estimada = dia_devoluccion_estimada;
    }

    public int getMes_devolucion_estimada() {
        return mes_devolucion_estimada;
    }

    public void setMes_devolucion_estimada(int mes_devoluccion_estimada) {
        this.mes_devolucion_estimada = mes_devoluccion_estimada;
    }

    public int getYear_devolucion_estimada() {
        return year_devolucion_estimada;
    }

    public void setYear_devolucion_estimada(int year_devoluccion_estimada) {
        this.year_devolucion_estimada = year_devoluccion_estimada;
    }

    public int getDia_devolucion_real() {
        return dia_devolucion_real;
    }

    public void setDia_devolucion_real(int dia_devolucion_real) {
        this.dia_devolucion_real = dia_devolucion_real;
    }

    public int getMes_devolucion_real() {
        return mes_devolucion_real;
    }

    public void setMes_devolucion_real(int mes_devolucion_real) {
        this.mes_devolucion_real = mes_devolucion_real;
    }

    public int getYear_devolucion_real() {
        return year_devolucion_real;
    }

    public void setYear_devolucion_real(int year_devolucion_real) {
        this.year_devolucion_real = year_devolucion_real;
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

    public int getId_fpago() {
        return id_fpago;
    }

    public void setId_fpago(int id_fpago) {
        this.id_fpago = id_fpago;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getLibros_arrendados() {
        return libros_arrendados;
    }

    public void setLibros_arrendados(int libros_arrendados) {
        this.libros_arrendados = libros_arrendados;
    } 

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
        return "Arriendos{" + "id_folio_comprobante_arriendo=" + id_folio_comprobante_arriendo + 
                ", costo_arriendo=" + costo_arriendo + ", dia_arriendo=" + dia_arriendo + ", mes_arriendo=" +
                mes_arriendo + ", year_arriendo=" + year_arriendo + ", dia_devolucion_estimada=" + 
                dia_devolucion_estimada + ", mes_devolucion_estimada=" + mes_devolucion_estimada + 
                ", year_devolucion_estimada=" + year_devolucion_estimada + ", dia_devolucion_real=" + 
                dia_devolucion_real + ", mes_devolucion_real=" + mes_devolucion_real + ", year_devolucion_real=" + 
                year_devolucion_real + ", id_cliente=" + id_cliente + ", id_trabajador=" + id_trabajador + 
                ", id_fpago=" + id_fpago + ", cuotas=" + cuotas + ", libros_arrendados=" + libros_arrendados + 
                ", estado=" + estado + '}';
    }
    
}
