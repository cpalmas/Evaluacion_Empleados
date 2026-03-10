package palmac.evaluacion_empleado.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.dtos.EstudianteDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T05:24:29-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class EstudianteMapperImpl implements EstudianteMapper {

    @Override
    public EstudianteDTO toDTO(Estudiante estudiante) {
        if ( estudiante == null ) {
            return null;
        }

        EstudianteDTO estudianteDTO = new EstudianteDTO();

        estudianteDTO.setId( estudiante.getId() );
        estudianteDTO.setNombre( estudiante.getNombre() );
        estudianteDTO.setApellido( estudiante.getApellido() );
        estudianteDTO.setMatricula( estudiante.getMatricula() );

        return estudianteDTO;
    }
}
