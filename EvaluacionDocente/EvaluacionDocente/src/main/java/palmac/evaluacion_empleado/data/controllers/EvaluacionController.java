package palmac.evaluacion_empleado.data.controllers;

import palmac.evaluacion_empleado.data.entities.Evaluacion;
import palmac.evaluacion_empleado.data.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping("/all")
    public List<Evaluacion> getAllEvaluaciones() {
        return evaluacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> getEvaluacionById(@PathVariable Long id) {
        return ResponseEntity.of(evaluacionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> createEvaluacion(
            @RequestBody Evaluacion evaluacion,
            @RequestParam Long estudianteId,
            @RequestParam Long docenteId,
            @RequestParam Long cuestionarioId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(evaluacionService.save(evaluacion, estudianteId, docenteId, cuestionarioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluacion(@PathVariable Long id) {
        evaluacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Evaluacion> getEvaluacionesByEstudiante(@PathVariable Long estudianteId) {
        return evaluacionService.findByEstudianteId(estudianteId);
    }

    @GetMapping("/docente/{docenteId}")
    public List<Evaluacion> getEvaluacionesByDocente(@PathVariable Long docenteId) {
        return evaluacionService.findByDocenteId(docenteId);
    }
}
