package palmac.evaluacion_empleado.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import palmac.evaluacion_empleado.data.entities.Evaluacion;
import palmac.evaluacion_empleado.dtos.EvaluacionDTO;

@Mapper(componentModel = "spring")
public interface EvaluacionMapper {

    @Mapping(source = "cuestionario.id", target = "cuestionarioId")
    @Mapping(source = "estudiante.id", target = "estudianteId")
    EvaluacionDTO toDTO(Evaluacion evaluacion);
}