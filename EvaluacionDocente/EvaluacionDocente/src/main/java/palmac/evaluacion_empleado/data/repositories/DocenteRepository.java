package palmac.evaluacion_empleado.data.repositories;

import palmac.evaluacion_empleado.data.entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
