package palmac.evaluacion_empleado.data.controllers;

import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.data.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // ✅ Listar todos los estudiantes
    @GetMapping("/all")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.findAll();
    }

    // ✅ Buscar estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            return ResponseEntity.ok(estudiante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Crear estudiante
    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante saved = estudianteService.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ✅ Actualizar estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id) {
        Estudiante updated = estudianteService.update(estudiante, id);
        return ResponseEntity.ok(updated);
    }

    // ✅ Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Listar estudiantes paginados
    @GetMapping("/page")
    public ResponseEntity<Page<Estudiante>> getEstudiantesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        Page<Estudiante> estudiantesPage = estudianteService.findAll(page, size);
        if (estudiantesPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantesPage);
    }
}