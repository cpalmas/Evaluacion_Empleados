package palmac.evaluacion_empleado.mappers;

import org.mapstruct.Mapper;
import palmac.evaluacion_empleado.data.entities.Pregunta;
import palmac.evaluacion_empleado.dtos.PreguntaDTO;

@Mapper(componentModel = "spring")
public interface PreguntaMapper {
    PreguntaDTO toDTO(Pregunta pregunta);
}