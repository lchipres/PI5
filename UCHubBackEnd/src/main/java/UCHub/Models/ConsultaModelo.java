package UCHub.Models;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;

@Entity
public class ConsultaModelo {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private Date fecha;
//    private int numLikes;
//    private int numConsultas;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private RecursoModel recurso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    public ConsultaModelo() {
    }

    public ConsultaModelo(RecursoModel idRecurso, UsuarioModel idUsuario) {
        this.fecha = Calendar.getInstance().getTime();
        this.usuario = idUsuario;
//        this.numLikes = numLikes;
//        this.numConsultas = numConsultas;
        this.recurso = idRecurso;
    }

//    public int getNumLikes() {
//        return numLikes;
//    }
//
//    public void setNumLikes(int numLikes) {
//        this.numLikes = numLikes;
//    }
//
//    public int getNumConsultas() {
//        return numConsultas;
//    }
//
//    public void setNumConsultas(int numConsultas) {
//        this.numConsultas = numConsultas;
//    }

    public RecursoModel getIdRecurso() {
        return recurso;
    }

    public void setIdRecurso(RecursoModel idRecurso) {
        this.recurso = idRecurso;
    }

    public UsuarioModel getIdUsuario() {
        return this.usuario;
    }

    public void setIdUsuario(UsuarioModel idUsuario) {
        this.usuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
