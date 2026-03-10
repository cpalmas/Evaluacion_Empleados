package palmac.evaluacion_empleado.data.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import palmac.evaluacion_empleado.data.entities.Docente;
import palmac.evaluacion_empleado.data.repositories.DocenteRepository;
import palmac.evaluacion_empleado.data.services.DocenteService;
import palmac.evaluacion_empleado.dtos.DocenteDTO;
import palmac.evaluacion_empleado.mappers.DocenteMapper;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    @Override
    public DocenteDTO save(DocenteDTO docenteDTO) {
        log.info("Guardando docente: {}", docenteDTO);
        Docente docente = docenteMapper.toEntity(docenteDTO);
        Docente saved = docenteRepository.save(docente);
        return docenteMapper.toDTO(saved);
    }

    @Override
    public DocenteDTO update(DocenteDTO docenteDTO, Long id) {
        log.info("Actualizando docente con id: {}", id);
        Docente existing = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado con id: " + id));
        docenteDTO.setId(existing.getId());
        Docente updated = docenteRepository.save(docenteMapper.toEntity(docenteDTO));
        return docenteMapper.toDTO(updated);
    }

    @Override
    public DocenteDTO findById(Long id) {
        log.info("Buscando docente con id: {}", id);
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado con id: " + id));
        return docenteMapper.toDTO(docente);
    }

    @Override
    public List<DocenteDTO> findAll() {
        log.info("Listando todos los docentes");
        return docenteRepository.findAll()
                .stream()
                .map(docenteMapper::toDTO)
                .toList();
    }

    @Override
    public Page<DocenteDTO> findAll(Integer page, Integer pageSize) {
        log.info("Listando docentes - página: {}, tamaño: {}", page, pageSize);
        return docenteRepository.findAll(PageRequest.of(page, pageSize))
                .map(docenteMapper::toDTO);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Eliminando docente con id: {}", id);
        if (!docenteRepository.existsById(id)) {
            throw new RuntimeException("Docente no encontrado con id: " + id);
        }
        docenteRepository.deleteById(id);
    }
}