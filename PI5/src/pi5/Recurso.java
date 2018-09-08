/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi5;

/**
 *
 * @author gamez
 */
public class Recurso {

    private int id;
    private int numLikes;
    private int numConsultas;
    private String categoria;
    private String formato;
    private String nombre;
    private String autor;
    private String edicion;
    private String[] etiquetas;
    private String descripcion;

    public Recurso() {
        this.id = -1;
        this.numLikes = -1;
        this.numConsultas = -1;
        this.categoria = new String();
        this.formato = new String();
        this.nombre = new String();
        this.autor = new String();
        this.edicion = new String();
        this.etiquetas = new String[0];
        this.descripcion = new String();
    }

    public Recurso(int id, int numLikes, int numConsultas, String categoria, String formato, String nombre, String autor, String edicion, String[] etiquetas, String descripcion) {
        this.id = id;
        this.numLikes = numLikes;
        this.numConsultas = numConsultas;
        this.categoria = categoria;
        this.formato = formato;
        this.nombre = nombre;
        this.autor = autor;
        this.edicion = edicion;
        this.etiquetas = etiquetas;
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numLikes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * @param numLikes the numLikes to set
     */
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * @return the numConsultas
     */
    public int getNumConsultas() {
        return numConsultas;
    }

    /**
     * @param numConsultas the numConsultas to set
     */
    public void setNumConsultas(int numConsultas) {
        this.numConsultas = numConsultas;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the etiquetas
     */
    public String[] getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
