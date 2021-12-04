/**
 * fecha de creacion: junio de 2018
 * nombre: Compras
 * Su función: como recordset de la tabla compras
 * @author: braulio valdes 
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Compras {
    private int id_compras;
    private int id_distribuidor;
    private int folio_factura;
    private int total;
    private int dia_compra;
    private int mes_compra;
    private int year_compra;
    private int hora_compra;
    private int minuto_compra;
    private int segundo_compra;
    private int id_fpago;
    private int cuotas;
    private String glosa;
    private int numero_libros;
  
    public Compras(){}

    public Compras(int id_compras, int id_distribuidor, int folio_factura, int total, int dia_compra, 
             int mes_compra, int year_compra, int hora_compra, int minuto_compra, int segundo_compra, 
                 int id_fpago, int cuotas, String glosa, int numero_libros) {
        this.id_compras = id_compras;
        this.id_distribuidor = id_distribuidor;
        this.folio_factura = folio_factura;
        this.total = total;
        this.dia_compra = dia_compra;
        this.mes_compra = mes_compra;
        this.year_compra = year_compra;
        this.hora_compra = hora_compra;
        this.minuto_compra = minuto_compra;
        this.segundo_compra = segundo_compra;
        this.id_fpago = id_fpago;
        this.cuotas = cuotas;
        this.glosa = glosa;
        this.numero_libros = numero_libros;
    }

        public Compras(int id_distribuidor, int folio_factura, int total, int dia_compra, 
                int mes_compra, int year_compra, int hora_compra, int minuto_compra, 
                int segundo_compra, int id_fpago, int cuotas, String glosa, int numero_libros) {
        this.id_distribuidor = id_distribuidor;
        this.folio_factura = folio_factura;
        this.total = total;
        this.dia_compra = dia_compra;
        this.mes_compra = mes_compra;
        this.year_compra = year_compra;
        this.hora_compra = hora_compra;
        this.minuto_compra = minuto_compra;
        this.segundo_compra = segundo_compra;
        this.id_fpago = id_fpago;
        this.cuotas = cuotas;
        this.glosa = glosa;
        this.numero_libros = numero_libros;
    }


    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public int getFolio_factura() {
        return folio_factura;
    }

    public void setFolio_factura(int folio_factura) {
        this.folio_factura = folio_factura;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDia_compra() {
        return dia_compra;
    }

    public void setDia_compra(int dia_compra) {
        this.dia_compra = dia_compra;
    }

    public int getMes_compra() {
        return mes_compra;
    }

    public void setMes_compra(int mes_compra) {
        this.mes_compra = mes_compra;
    }

    public int getYear_compra() {
        return year_compra;
    }

    public void setYear_compra(int year_compra) {
        this.year_compra = year_compra;
    }

    public int getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(int id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
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

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getNumero_libros() {
        return numero_libros;
    }

    public void setNumero_libros(int numero_libros) {
        this.numero_libros = numero_libros;
    }

    public int getHora_compra() {
        return hora_compra;
    }

    public void setHora_compra(int hora_compra) {
        this.hora_compra = hora_compra;
    }

    public int getMinuto_compra() {
        return minuto_compra;
    }

    public void setMinuto_compra(int minuto_compra) {
        this.minuto_compra = minuto_compra;
    }

    public int getSegundo_compra() {
        return segundo_compra;
    }

    public void setSegundo_compra(int segundo_compra) {
        this.segundo_compra = segundo_compra;
    }

    @Override
    public String toString() {
        return "Compras{" + "id_compras=" + id_compras + ", id_distribuidor=" + id_distribuidor + 
                ", folio_factura=" + folio_factura + ", total=" + total + ", dia_compra=" + dia_compra + 
                ", mes_compra=" + mes_compra + ", year_compra=" + year_compra + ", hora_compra=" + hora_compra + 
                ", minuto_compra=" + minuto_compra + ", segundo_compra=" + segundo_compra + ", id_fpago=" + 
                id_fpago + ", cuotas=" + cuotas + ", glosa=" + glosa + ", numero_libros=" + numero_libros + '}';
    }

   
   
    
}
