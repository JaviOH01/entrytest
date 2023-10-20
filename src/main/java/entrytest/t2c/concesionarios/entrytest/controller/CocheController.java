package entrytest.t2c.concesionarios.entrytest.controller;

import entrytest.t2c.concesionarios.entrytest.service.CocheService;
import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import entrytest.t2c.concesionarios.entrytest.service.dto.CocheDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coches")
public class CocheController {

    private final CocheService cocheService;

    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @PostMapping
    public Coche createCoche(@RequestBody CocheDTO cocheDTO){
        return this.cocheService.createCoche(cocheDTO);
    }

    @GetMapping
    public List<Coche> getAllCoches(){
        return this.cocheService.getAllCoches();
    }

    @GetMapping("{matricula}")
    public Coche buscarCocheMatricula(@PathVariable("matricula") String matricula){
        return cocheService.getCocheByMatricula(matricula);
    }

    @DeleteMapping("{coche}")
    public void deleteCocheMatricula(@PathVariable("coche") Coche coche){
        if(coche.isVendido()){
            cocheService.deleteCoche(cocheService.getCocheByMatricula(coche.getMatricula()));
        }
    }
}
