package palmac.evaluacion_empleado.data.repositories;

import palmac.evaluacion_empleado.data.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
