package entrytest.t2c.concesionarios.entrytest.persistence.repository;

import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

    public List<LocalDate> findAllByFechaIngreso(LocalDate fechaIngreso);

    @Modifying
    @Query(value = "UPDATE COCHE SET VENDIDO=true WHERE ID=:id", nativeQuery = true)
    public void modificarCocheVendido(@Param("id") Long id);
}
