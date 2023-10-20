package entrytest.t2c.concesionarios.entrytest.service.dto;

import lombok.Data;

@Data
public class CocheDTO {
    private String matricula;
    private String marca;
    private double coste;
    private boolean vendido;
    private double precioVenta;
}
