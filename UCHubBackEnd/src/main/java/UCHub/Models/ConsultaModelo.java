package UCHub.Models;

import javax.persistence.*;

@Entity
public class ConsultaModelo {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private int numLikes;
    private int numConsultas;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private RecursoModel recurso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")

    private UsuarioModel usuario;
    private int[] comentarios;
    private int[] etiquetas;

    public ConsultaModelo() {
        this.id = 0;
        this.numLikes = -1;
        this.numConsultas = -1;
        this.recurso = new RecursoModel();
        this.usuario = new UsuarioModel();
        this.comentarios = new int[1];
        this.etiquetas = new int[1];
    }

    public ConsultaModelo(int numLikes, int numConsultas, RecursoModel idRecurso, UsuarioModel idUsuario,
                          int[] comentarios, int[] etiquetas) {
        this.usuario = idUsuario;
        this.numLikes = numLikes;
        this.numConsultas = numConsultas;
        this.recurso = idRecurso;
        this.comentarios = comentarios;
        this.etiquetas = etiquetas;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumConsultas() {
        return numConsultas;
    }

    public void setNumConsultas(int numConsultas) {
        this.numConsultas = numConsultas;
    }

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

    public int[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(int[] comentarios) {
        this.comentarios = comentarios;
    }

    public int[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(int[] etiquetas) {
        this.etiquetas = etiquetas;
    }
}
