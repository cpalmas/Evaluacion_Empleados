package palmac.evaluacion_empleado.data.repositories;

import palmac.evaluacion_empleado.data.entities.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
}
