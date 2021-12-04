/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author BRAULIOMARIANO
 */
public class CategoriaDetalle {
    
    private int id_libro;
    private int id_categoria;


    public CategoriaDetalle(int id_libro, int id_categoria) {
        this.id_libro = id_libro;
        this.id_categoria = id_categoria;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "CategoriaDetalle{" + "id_libro=" + id_libro + ", id_categoria=" + id_categoria + '}';
    }
    
    
}
