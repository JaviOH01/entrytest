package entrytest.t2c.concesionarios.entrytest.mapper;

import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import entrytest.t2c.concesionarios.entrytest.service.dto.CocheDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CocheDTOToCoche implements IMapper<CocheDTO, Coche>{
    @Override
    public Coche map(CocheDTO in) {
        Coche coche = new Coche();
        coche.setMatricula(in.getMatricula());
        coche.setMarca(in.getMarca());
        coche.setCoste(in.getCoste());
        coche.setVendido(in.isVendido());
        coche.setPrecioVenta(in.getPrecioVenta());
        coche.setFechaIngreso(LocalDate.now());
        return coche;
    }
}
