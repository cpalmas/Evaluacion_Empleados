package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.data.entities.Cuestionario;

import java.util.List;
import java.util.Optional;

public interface CuestionarioService {

    Cuestionario save(Cuestionario cuestionario);

    Cuestionario update(Cuestionario cuestionario, Long id);

    Optional<Cuestionario> findById(Long id);

    List<Cuestionario> findAll();

    void deleteById(Long id);
}
