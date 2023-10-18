package entrytest.t2c.concesionarios.entrytest.controller;

import entrytest.t2c.concesionarios.entrytest.CocheService;
import entrytest.t2c.concesionarios.entrytest.model.Coche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @PostMapping
    public Coche createCoche(Coche coche){
        return cocheService.createCoche(coche);
    }

    @GetMapping
    public List<Coche> getAllCoches(){
        return cocheService.getAllCoches();
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
