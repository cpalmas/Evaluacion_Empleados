package palmac.evaluacion_empleado.mappers;

import org.mapstruct.Mapper;
import palmac.evaluacion_empleado.data.entities.Docente;
import palmac.evaluacion_empleado.dtos.DocenteDTO;

@Mapper(componentModel = "spring")
public interface DocenteMapper {

    DocenteDTO toDTO(Docente docente);
    Docente toEntity(DocenteDTO docenteDTO);
}