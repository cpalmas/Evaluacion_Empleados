package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.common.NotFoundElementException;
import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.data.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Guardar un nuevo estudiante
    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Actualizar estudiante existente
    @Override
    public Estudiante update(Estudiante estudianteBody, Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Estudiante no encontrado con id: " + id));

        estudiante.setNombre(estudianteBody.getNombre());
        estudiante.setApellido(estudianteBody.getApellido());
        estudiante.setMatricula(estudianteBody.getMatricula());
        estudiante.setEmail(estudianteBody.getEmail());

        return estudianteRepository.save(estudiante);
    }

    // Buscar estudiante por ID
    @Override
    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    // Listar todos los estudiantes (sin paginación)
    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    // Eliminar estudiante por ID
    @Override
    public void deleteById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Estudiante no encontrado con id: " + id));
        estudianteRepository.delete(estudiante);
    }

    // Listar estudiantes con paginación usando Pageable
    @Override
    public Page<Estudiante> findAll(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    // Método de conveniencia para paginación por enteros
    @Override
    public Page<Estudiante> findAll(Integer page, Integer pageSize) {
        if (page < 0) page = 0;
        if (pageSize <= 0) pageSize = 50;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "nombre"));
        return findAll(pageable);
    }
}