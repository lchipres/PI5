package UCHub.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "recurso_model" )
public class RecursoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private int numLikes;
    private int numConsultas;
    private String categoria;
    private String formato;
    private String nombre;
    private String autor;
    private String edicion;
    private String etiquetas;
    private String descripcion;

    @OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ComentarioModel> comentarios;

    public RecursoModel() {
    }

    public RecursoModel(int numLikes, int numConsultas, String categoria, String formato, String nombre,
                        String autor, String edicion, String etiquetas, String descripcion) {
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
    public long getId() {
        return id;
    }

    /**
     * @return the numLikes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * Gives a like
     */
    public void giveLike() {
        this.numLikes += 1 ;
    }

    /**
     * @return the numConsultas
     */
    public int getNumConsultas() {
        return numConsultas;
    }

    /**
     * when the resource is seen
     */
    public void seen() {
        this.numConsultas += 1 ;
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
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(String etiquetas) {
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

     public List<ComentarioModel> getComentarios(){
         return this.comentarios;
     }

     public void setComentarios(List<ComentarioModel> comentarios){
         this.comentarios = comentarios;
     }
}
