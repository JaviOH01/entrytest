package entrytest.t2c.concesionarios.entrytest.controller;

import entrytest.t2c.concesionarios.entrytest.service.CocheService;
import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import entrytest.t2c.concesionarios.entrytest.service.dto.CocheDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/fechaIngreso/{fechaIngreso}")
    public List<LocalDate> getCocheByFechaIngreso(@PathVariable("fechaIngreso") LocalDate fechaIngreso){
        return this.cocheService.getCocheByFechaIngreso(fechaIngreso);
    }

    @PatchMapping("/modificar_coche_vendido/{id}")
    public ResponseEntity<Void>modificarCocheVendido(@PathVariable("id") Long id){
        this.cocheService.modificarCocheVendido(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteCoche(@PathVariable("id") Long id){
        this.cocheService.deleteCoche(id);
        return ResponseEntity.noContent().build();
    }

    /*@DeleteMapping("{coche}")
    public void deleteCocheMatricula(@PathVariable("coche") Coche coche){
        if(coche.isVendido()){
            cocheService.deleteCoche(cocheService.getCocheByMatricula(coche.getMatricula()));
        }
    }*/
}
