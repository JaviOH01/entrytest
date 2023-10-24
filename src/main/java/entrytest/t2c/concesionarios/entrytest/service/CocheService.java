package entrytest.t2c.concesionarios.entrytest.service;

import entrytest.t2c.concesionarios.entrytest.exceptions.MyExceptions;
import entrytest.t2c.concesionarios.entrytest.mapper.CocheDTOToCoche;
import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import entrytest.t2c.concesionarios.entrytest.persistence.repository.CocheRepository;
import entrytest.t2c.concesionarios.entrytest.service.dto.CocheDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;
    private final CocheDTOToCoche cocheMapper;

    public CocheService(CocheRepository cocheRepository, CocheDTOToCoche cocheMapper) {
        this.cocheRepository = cocheRepository;
        this.cocheMapper = cocheMapper;
    }

    public Coche createCoche(CocheDTO car){
        Coche coche = cocheMapper.map(car);
        return this.cocheRepository.save(coche);
    }

    public List<LocalDate> getCocheByFechaIngreso(LocalDate fechaIngreso){
        return this.cocheRepository.findAllByFechaIngreso(fechaIngreso);
    }

    public List<Coche> getAllCoches(){
        return this.cocheRepository.findAll();
    }

    @Transactional
    public void modificarCocheVendido(Long id){
        /*Optional<Coche> optionalCoche = this.cocheRepository.findById(id);
        if (optionalCoche.isEmpty()){
            throw new MyExceptions("Este coche no existe", HttpStatus.NOT_FOUND);
        }*/
        this.cocheRepository.modificarCocheVendido(id);
    }

    public void deleteCoche(Long id){
        this.cocheRepository.deleteById(id);
    }

    /*public void deleteCoche(Coche coche){
        if(!coche.isVendido()){
            Optional<Coche> optionalCoche = this.cocheRepository.findById(coche.getId());
        if (optionalCoche.isEmpty()){
            throw new MyExceptions("Este coche no existe", HttpStatus.NOT_FOUND);
        }
            this.cocheRepository.deleteById(coche.getId());
        }
    }*/
}
