package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.common.NotFoundElementException;
import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.data.entities.Pregunta;
import palmac.evaluacion_empleado.data.repositories.CuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @Override
    public Cuestionario save(Cuestionario cuestionario) {
        if (cuestionario.getPreguntas() != null) {
            cuestionario.getPreguntas().forEach(p -> p.setCuestionario(cuestionario));
        }
        return cuestionarioRepository.save(cuestionario);
    }

    @Override
    public Cuestionario update(Cuestionario cuestionarioBody, Long id) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Cuestionario no encontrado con id: " + id));

        cuestionario.setTitulo(cuestionarioBody.getTitulo());
        cuestionario.setDescripcion(cuestionarioBody.getDescripcion());

        if (cuestionarioBody.getPreguntas() != null) {
            cuestionario.getPreguntas().clear();
            List<Pregunta> nuevasPreguntas = cuestionarioBody.getPreguntas();
            nuevasPreguntas.forEach(p -> p.setCuestionario(cuestionario));
            cuestionario.getPreguntas().addAll(nuevasPreguntas);
        }

        return cuestionarioRepository.save(cuestionario);
    }

    @Override
    public Optional<Cuestionario> findById(Long id) {
        return cuestionarioRepository.findById(id);
    }

    @Override
    public List<Cuestionario> findAll() {
        return cuestionarioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Cuestionario no encontrado con id: " + id));
        cuestionarioRepository.delete(cuestionario);
    }
}
