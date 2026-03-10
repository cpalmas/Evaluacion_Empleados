package palmac.evaluacion_empleado.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.Docente;
import palmac.evaluacion_empleado.dtos.DocenteDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T05:24:29-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class DocenteMapperImpl implements DocenteMapper {

    @Override
    public DocenteDTO toDTO(Docente docente) {
        if ( docente == null ) {
            return null;
        }

        DocenteDTO docenteDTO = new DocenteDTO();

        docenteDTO.setId( docente.getId() );
        docenteDTO.setNombre( docente.getNombre() );
        docenteDTO.setApellido( docente.getApellido() );
        docenteDTO.setNumeroEmpleado( docente.getNumeroEmpleado() );
        docenteDTO.setMateria( docente.getMateria() );

        return docenteDTO;
    }

    @Override
    public Docente toEntity(DocenteDTO docenteDTO) {
        if ( docenteDTO == null ) {
            return null;
        }

        Docente docente = new Docente();

        docente.setId( docenteDTO.getId() );
        docente.setNombre( docenteDTO.getNombre() );
        docente.setApellido( docenteDTO.getApellido() );
        docente.setNumeroEmpleado( docenteDTO.getNumeroEmpleado() );
        docente.setMateria( docenteDTO.getMateria() );

        return docente;
    }
}
