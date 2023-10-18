package entrytest.t2c.concesionarios.entrytest;

import entrytest.t2c.concesionarios.entrytest.model.Coche;
import entrytest.t2c.concesionarios.entrytest.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    public Coche createCoche(Coche car){
        return cocheRepository.save(car);
    }

    public Coche getCocheByMatricula(String matricula){
        Optional<Coche> optionalCoche = cocheRepository.findById(matricula);
        return optionalCoche.get();
    }

    public List<Coche> getAllCoches(){
        return cocheRepository.findAll();
    }

    public void deleteCoche(Coche coche){
        if(coche.isVendido()){
            cocheRepository.deleteById(coche.getMatricula());
        }
    }
}
