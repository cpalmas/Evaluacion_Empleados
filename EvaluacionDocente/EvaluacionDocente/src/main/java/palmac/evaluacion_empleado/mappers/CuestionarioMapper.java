package palmac.evaluacion_empleado.mappers;

import org.mapstruct.Mapper;
import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.dtos.CuestionarioDTO;

@Mapper(componentModel = "spring", uses = {PreguntaMapper.class})
public interface CuestionarioMapper {
    CuestionarioDTO toDTO(Cuestionario cuestionario);
}