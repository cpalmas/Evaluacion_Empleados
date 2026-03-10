package palmac.evaluacion_empleado.data.controllers;

import palmac.evaluacion_empleado.data.services.DocenteService;
import palmac.evaluacion_empleado.dtos.DocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/all")
    public List<DocenteDTO> getAllDocentes() {
        return docenteService.findAll();
    }

    // ✅ Correcto
    public ResponseEntity<DocenteDTO> getDocenteById(@PathVariable Long id) {
        DocenteDTO docente = docenteService.findById(id);
        if (docente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(docente);
    }

    @PostMapping
    public ResponseEntity<DocenteDTO> createDocente(@RequestBody DocenteDTO docente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.save(docente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> updateDocente(@RequestBody DocenteDTO docente, @PathVariable Long id) {
        return ResponseEntity.ok(docenteService.update(docente, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Long id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DocenteDTO>> findAllDocentes(
            @RequestParam(defaultValue = "0", value = "page") Integer pageNumber,
            @RequestParam(defaultValue = "50", value = "size") Integer pageSize) {
        return ResponseEntity.ok(docenteService.findAll(pageNumber, pageSize));
    }
}