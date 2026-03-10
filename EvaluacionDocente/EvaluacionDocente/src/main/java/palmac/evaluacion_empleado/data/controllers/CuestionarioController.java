package palmac.evaluacion_empleado.data.controllers;

import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.data.services.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cuestionarios")
public class CuestionarioController {

    @Autowired
    private CuestionarioService cuestionarioService;

    @GetMapping("/all")
    public List<Cuestionario> getAllCuestionarios() {
        return cuestionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuestionario> getCuestionarioById(@PathVariable Long id) {
        return ResponseEntity.of(cuestionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cuestionario> createCuestionario(@RequestBody Cuestionario cuestionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cuestionarioService.save(cuestionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuestionario> updateCuestionario(@RequestBody Cuestionario cuestionario,
            @PathVariable Long id) {
        return ResponseEntity.ok(cuestionarioService.update(cuestionario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuestionario(@PathVariable Long id) {
        cuestionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
