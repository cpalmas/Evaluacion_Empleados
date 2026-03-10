package palmac.evaluacion_empleado.data.repositories;

import palmac.evaluacion_empleado.data.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
