/**
 * fecha de creacion: junio de 2018
 * nombre: VentasDetalle
 * Su función: como recordset de la tabla ventasdetalle
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class VentasDetalle {
    
    private long id_folio_boleta;
    private String serie;
    private int cantidad_libro;
    private int valor_venta;

    
    public VentasDetalle(long id_folio_boleta, String serie, int cantidad_libro, int valor_venta) {
        this.id_folio_boleta = id_folio_boleta;
        this.serie = serie;
        this.cantidad_libro = cantidad_libro;
        this.valor_venta = valor_venta;
    }

    public long getId_folio_boleta() {
        return id_folio_boleta;
    }

    public void setId_folio_boleta(long id_folio_boleta) {
        this.id_folio_boleta = id_folio_boleta;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCantidad_libro() {
        return cantidad_libro;
    }

    public void setCantidad_libro(int cantidad_libro) {
        this.cantidad_libro = cantidad_libro;
    }

    public int getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(int valor_venta) {
        this.valor_venta = valor_venta;
    }

    @Override
    public String toString() {
        return "VentasDetalle{" + "id_folio_boleta=" + id_folio_boleta + ", serie=" + serie + ", cantidad_libro=" + cantidad_libro + ", valor_venta=" + valor_venta + '}';
    }

    
}
