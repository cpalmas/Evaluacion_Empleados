package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.common.NotFoundElementException;
import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.data.entities.Docente;
import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.data.entities.Evaluacion;
import palmac.evaluacion_empleado.data.repositories.CuestionarioRepository;
import palmac.evaluacion_empleado.data.repositories.DocenteRepository;
import palmac.evaluacion_empleado.data.repositories.EstudianteRepository;
import palmac.evaluacion_empleado.data.repositories.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @Override
    public Evaluacion save(Evaluacion evaluacion, Long estudianteId, Long docenteId, Long cuestionarioId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new NotFoundElementException("Estudiante no encontrado con id: " + estudianteId));

        Docente docente = docenteRepository.findById(docenteId)
                .orElseThrow(() -> new NotFoundElementException("Docente no encontrado con id: " + docenteId));

        Cuestionario cuestionario = cuestionarioRepository.findById(cuestionarioId)
                .orElseThrow(
                        () -> new NotFoundElementException("Cuestionario no encontrado con id: " + cuestionarioId));

        evaluacion.setEstudiante(estudiante);
        evaluacion.setDocente(docente);
        evaluacion.setCuestionario(cuestionario);

        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public Optional<Evaluacion> findById(Long id) {
        return evaluacionRepository.findById(id);
    }

    @Override
    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Evaluación no encontrada con id: " + id));
        evaluacionRepository.delete(evaluacion);
    }

    @Override
    public List<Evaluacion> findByEstudianteId(Long estudianteId) {
        return evaluacionRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public List<Evaluacion> findByDocenteId(Long docenteId) {
        return evaluacionRepository.findByDocenteId(docenteId);
    }
}
