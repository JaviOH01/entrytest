package entrytest.t2c.concesionarios.entrytest.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

@Data
@Entity
@Table(name = "coches")
public class Coche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricula;
    //Tengo que darle el formato de matricula
    //Pattern pattern = Pattern.compile("(\\d{1,4})([A-z]{1,3})");
    private String marca;
    private double coste;
    private LocalDate fechaIngreso;
    private boolean vendido;
    private double precioVenta;

    /*Relacion uno a muchos entre las tablas coches y concesionarios*/
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "concesionarios_direccion")
    private Concesionario cocheConcesionario;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
