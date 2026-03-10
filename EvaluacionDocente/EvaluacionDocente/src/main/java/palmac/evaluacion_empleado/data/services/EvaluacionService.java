package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.data.entities.Evaluacion;

import java.util.List;
import java.util.Optional;

public interface EvaluacionService {

    Evaluacion save(Evaluacion evaluacion, Long estudianteId, Long docenteId, Long cuestionarioId);

    Optional<Evaluacion> findById(Long id);

    List<Evaluacion> findAll();

    void deleteById(Long id);

    List<Evaluacion> findByEstudianteId(Long estudianteId);

    List<Evaluacion> findByDocenteId(Long docenteId);
}
