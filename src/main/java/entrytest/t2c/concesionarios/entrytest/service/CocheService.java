package entrytest.t2c.concesionarios.entrytest.service;

import entrytest.t2c.concesionarios.entrytest.mapper.CocheDTOToCoche;
import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import entrytest.t2c.concesionarios.entrytest.persistence.repository.CocheRepository;
import entrytest.t2c.concesionarios.entrytest.service.dto.CocheDTO;
import org.springframework.stereotype.Service;

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

    public Coche getCocheByMatricula(String matricula){
        Optional<Coche> optionalCoche = cocheRepository.findById(matricula);
        return optionalCoche.get();
    }

    public List<Coche> getAllCoches(){
        return this.cocheRepository.findAll();
    }

    public void deleteCoche(Coche coche){
        if(!coche.isVendido()){
            cocheRepository.deleteById(coche.getMatricula());
        }
    }
}
