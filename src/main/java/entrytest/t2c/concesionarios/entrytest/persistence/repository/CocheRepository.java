package entrytest.t2c.concesionarios.entrytest.persistence.repository;

import entrytest.t2c.concesionarios.entrytest.persistence.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Long> {
}
