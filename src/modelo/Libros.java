/**
 * fecha de creacion: junio de 2018
 * nombre: Libros
 * Su función: como recordset de la tabla libros
 * @author: braulio valdes 
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class Libros {
    
    private String serie;
    private String isbn;
    private String titulo;
    private int pagina;
    private int precioReferencia;
    private int yearr; 
    private int idioma;
    private int autor;
    private int categoria;
    private int editorial;
    private int estado;
    private int stock;
    private int enArriendo;
    private int PrecioVenta;
    private int PrecioArriendo;

    public Libros(){}
    
    public Libros(String serie, String isbn, String titulo, int pagina, int precioReferencia, int yearr, int idioma, int autor, int categoria, int editorial, int estado, int stock, int enArriendo, int PrecioVenta, int PrecioArriendo) {
        this.serie = serie;
        this.isbn = isbn;
        this.titulo = titulo;
        this.pagina = pagina;
        this.precioReferencia = precioReferencia;
        this.yearr = yearr;
        this.idioma = idioma;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.estado = estado;
        this.stock = stock;
        this.enArriendo = enArriendo;
        this.PrecioVenta = PrecioVenta;
        this.PrecioArriendo = PrecioArriendo;
    }

    public String getSerie() {
        return serie;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPagina() {
        return pagina;
    }

    public int getPrecioReferencia() {
        return precioReferencia;
    }

    public int getYearr() {
        return yearr;
    }

    public int getIdioma() {
        return idioma;
    }

    public int getAutor() {
        return autor;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getEditorial() {
        return editorial;
    }

    public int getEstado() {
        return estado;
    }

    public int getStock() {
        return stock;
    }

    public int getEnArriendo() {
        return enArriendo;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public int getPrecioArriendo() {
        return PrecioArriendo;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public void setPrecioReferencia(int precioReferencia) {
        this.precioReferencia = precioReferencia;
    }

    public void setYearr(int yearr) {
        this.yearr = yearr;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setEnArriendo(int enArriendo) {
        this.enArriendo = enArriendo;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public void setPrecioArriendo(int PrecioArriendo) {
        this.PrecioArriendo = PrecioArriendo;
    }

    @Override
    public String toString() {
        return "Libros{" + "serie=" + serie + ", isbn=" + isbn + ", titulo=" + titulo + ", pagina=" + pagina + ", precioReferencia=" + precioReferencia + ", yearr=" + yearr + ", idioma=" + idioma + ", autor=" + autor + ", categoria=" + categoria + ", editorial=" + editorial + ", estado=" + estado + ", stock=" + stock + ", enArriendo=" + enArriendo + ", PrecioVenta=" + PrecioVenta + ", PrecioArriendo=" + PrecioArriendo + '}';
    }
    
    
    
}
