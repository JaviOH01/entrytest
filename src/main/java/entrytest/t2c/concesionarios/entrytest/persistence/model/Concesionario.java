package entrytest.t2c.concesionarios.entrytest.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;*/

@Data
@Entity
@Table(name = "concesionarios")
public class Concesionario implements Serializable {
    @Id
    private String direccion;

    /*Relacion uno a muchos entre las tablas coches y concesionarios*/
    @OneToMany(mappedBy = "cocheConcesionario", cascade = CascadeType.ALL)
    private List<Coche> listaCoches;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
