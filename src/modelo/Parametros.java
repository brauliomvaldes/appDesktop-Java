/**
 * fecha de creacion: junio de 2018
 * nombre: Parametros
 * Su función: como recordset de la tabla parametros
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * 
 */
public class Parametros {
    private int id_parametros;
    private int impuesto_iva;
    private int multa_atraso_diario;
    private int descuento_especial;
    private int monto_minimo_descuento;

    public Parametros(int id_parametros, int impuesto_iva, int multa_atraso_diario, int descuento_especial, int monto_minimo_descuento) {
        this.id_parametros = id_parametros;
        this.impuesto_iva = impuesto_iva;
        this.multa_atraso_diario = multa_atraso_diario;
        this.descuento_especial = descuento_especial;
        this.monto_minimo_descuento = monto_minimo_descuento;
    }

    public int getId_parametros() {
        return id_parametros;
    }

    public void setId_parametros(int id_parametros) {
        this.id_parametros = id_parametros;
    }

    public int getImpuesto_iva() {
        return impuesto_iva;
    }

    public void setImpuesto_iva(int impuesto_iva) {
        this.impuesto_iva = impuesto_iva;
    }

    public int getMulta_atraso_diario() {
        return multa_atraso_diario;
    }

    public void setMulta_atraso_diario(int multa_atraso_diario) {
        this.multa_atraso_diario = multa_atraso_diario;
    }

    public int getDescuento_especial() {
        return descuento_especial;
    }

    public void setDescuento_especial(int descuento_especial) {
        this.descuento_especial = descuento_especial;
    }

    public int getMonto_minimo_descuento() {
        return monto_minimo_descuento;
    }

    public void setMonto_minimo_descuento(int monto_minimo_descuento) {
        this.monto_minimo_descuento = monto_minimo_descuento;
    }

    @Override
    public String toString() {
        return "Parametros{" + "id_parametros=" + id_parametros + ", impuesto_iva=" + impuesto_iva + ", multa_atraso_diario=" + multa_atraso_diario + ", descuento_especial=" + descuento_especial + ", monto_minimo_descuento=" + monto_minimo_descuento + '}';
    }

    

}
