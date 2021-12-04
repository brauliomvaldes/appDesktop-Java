/**
 * fecha de creacion: junio de 2018
 * nombre: ArriendosDetalle
 * Su función: como recordset de la tabla arriendosdetalle
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class ArriendosDetalle {
    
    private long id_folio_comprobante_arriendo;
    private String serie;
    private int cantidad_libro;
    private int valor_arriendo;
    private int estado;

    public ArriendosDetalle(long id_folio_comprobante_arriendo, String serie, int cantidad_libro, 
            int valor_arriendo, int estado) {
        this.id_folio_comprobante_arriendo = id_folio_comprobante_arriendo;
        this.serie = serie;
        this.cantidad_libro = cantidad_libro;
        this.valor_arriendo = valor_arriendo;
        this.estado = estado;
    }

    public long getId_folio_comprobante_arriendo() {
        return id_folio_comprobante_arriendo;
    }

    public void setId_folio_comprobante_arriendo(long id_folio_comprobante_arriendo) {
        this.id_folio_comprobante_arriendo = id_folio_comprobante_arriendo;
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

    public int getValor_arriendo() {
        return valor_arriendo;
    }

    public void setValor_arriendo(int valor_arriendo) {
        this.valor_arriendo = valor_arriendo;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "ArriendosDetalle{" + "id_folio_comprobante_arriendo=" + id_folio_comprobante_arriendo + 
                ", serie=" + serie + ", cantidad_libro=" + cantidad_libro + ", valor_arriendo=" + 
                valor_arriendo + ", estado=" + estado + '}';
    }
    
}
