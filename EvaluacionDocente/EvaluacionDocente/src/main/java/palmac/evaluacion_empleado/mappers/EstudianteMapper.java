package palmac.evaluacion_empleado.mappers;

import org.mapstruct.Mapper;
import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.dtos.EstudianteDTO;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteDTO toDTO(Estudiante estudiante);
}