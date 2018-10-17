package UCHub.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    private Date fechaPublicacion;

    @ManyToOne
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    @JsonBackReference
    private RecursoModel recurso;

    private String contenido;

    public ComentarioModel(){
    }

    public ComentarioModel(RecursoModel r, UsuarioModel u, String contenido){
        this.setFechaPublicacion(Calendar.getInstance().getTime());
        this.setContenido(contenido);
        this.setUsuario(u);
        this.setRecurso(r);
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RecursoModel getRecurso(){
        return this.recurso;
    }

    public void setRecurso(RecursoModel recurso){
        this.recurso = recurso;
    }
}
