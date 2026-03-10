package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.data.entities.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante save(Estudiante estudiante);

    Estudiante update(Estudiante estudiante, Long id);

    Optional<Estudiante> findById(Long id);

    List<Estudiante> findAll();

    void deleteById(Long id);

    // ✅ Método agregado para paginación con Pageable
    Page<Estudiante> findAll(Pageable pageable);

    // Método de paginación por enteros (mantener compatibilidad)
    Page<Estudiante> findAll(Integer page, Integer pageSize);
}