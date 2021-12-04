/**
 * fecha de creacion: junio de 2018
 * nombre: ComprasDetalle
 * Su función: como recordset de la tabla comprasdetalle
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class ComprasDetalle {
    
    private int id_compras;
    private String id_libro;
    private int cantidad_libro;
    private int precio_referencia;


    public ComprasDetalle(int id_compras, String id_libro, int cantidad_libro, int precio_referencia) {
        this.id_compras = id_compras;
        this.id_libro = id_libro;
        this.cantidad_libro = cantidad_libro;
        this.precio_referencia = precio_referencia;
    }
        

    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public int getCantidad_libro() {
        return cantidad_libro;
    }

    public void setCantidad_libro(int cantidad_libro) {
        this.cantidad_libro = cantidad_libro;
    }

    public int getPrecio_referencia() {
        return precio_referencia;
    }

    public void setPrecio_referencia(int precio_referencia) {
        this.precio_referencia = precio_referencia;
    }

    @Override
    public String toString() {
        return "ComprasDetalle{" + "id_compras=" + id_compras + ", id_libro=" + id_libro + ", cantidad_libro=" + cantidad_libro + ", precio_referencia=" + precio_referencia + '}';
    }
    
    
    
}
