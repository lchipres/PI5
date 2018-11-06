package UCHub.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class RepositorioModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private String etiquetas;

    @OneToMany
    @JsonManagedReference
    private List<RecursoModel> recursos;

    @OneToOne
    private UsuarioModel propietario;

    public RepositorioModel(){}

    public RepositorioModel(String nombre, String descripcion, String etiquetas, UsuarioModel propietario){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.propietario = propietario;
    }


//    Setters and getters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<RecursoModel> getRecursos() {
        return recursos;
    }

    public void addRecurso(RecursoModel recurso) {
        this.recursos.add(recurso);
    }
}
