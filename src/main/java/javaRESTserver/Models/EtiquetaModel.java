package javaRESTserver.Models;


import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;

@Entity
public class EtiquetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;

    public EtiquetaModel(){
    }

    public EtiquetaModel(String nombre){
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
