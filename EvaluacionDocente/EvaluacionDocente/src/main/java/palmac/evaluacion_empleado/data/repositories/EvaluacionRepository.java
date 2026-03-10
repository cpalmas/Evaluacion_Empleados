package palmac.evaluacion_empleado.data.repositories;

import palmac.evaluacion_empleado.data.entities.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    List<Evaluacion> findByEstudianteId(Long estudianteId);

    List<Evaluacion> findByDocenteId(Long docenteId);
}
