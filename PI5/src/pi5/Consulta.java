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
public class Consulta {

    private int numLikes;
    private int numConsultas;
    private int idRecurso;
    private String[] comentarios;
    private String[] etiquetas;

    public Consulta() {
        this.numLikes = -1;
        this.numConsultas = -1;
        this.idRecurso = -1;
        this.comentarios = new String[1];
        this.etiquetas = new String[1];
    }

    public Consulta(int numLikes, int numConsultas, int idRecurso, String[] comentarios, String[] etiquetas) {
        this.numLikes = numLikes;
        this.numConsultas = numConsultas;
        this.idRecurso = idRecurso;
        this.comentarios = comentarios;
        this.etiquetas = etiquetas;
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
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return the comentarios
     */
    public String[] getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
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
}
