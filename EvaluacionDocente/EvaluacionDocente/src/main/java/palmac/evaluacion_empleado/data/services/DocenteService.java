package palmac.evaluacion_empleado.data.services;

import palmac.evaluacion_empleado.dtos.DocenteDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DocenteService {
    DocenteDTO save(DocenteDTO docenteDTO);
    DocenteDTO update(DocenteDTO docenteDTO, Long id);
    DocenteDTO findById(Long id);
    List<DocenteDTO> findAll();
    Page<DocenteDTO> findAll(Integer page, Integer pageSize);
    void deleteById(Long id);
}