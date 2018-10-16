package UCHub.Models;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class EtiquetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String nombre;

    public EtiquetaModel(){
        this.id = 0;
        this.nombre = "";
    }

    public EtiquetaModel(String nombre){
        this.nombre = nombre;
    }

}
