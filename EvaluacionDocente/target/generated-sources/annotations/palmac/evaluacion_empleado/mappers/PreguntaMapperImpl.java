package palmac.evaluacion_empleado.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.Pregunta;
import palmac.evaluacion_empleado.dtos.PreguntaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T05:22:12-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PreguntaMapperImpl implements PreguntaMapper {

    @Override
    public PreguntaDTO toDTO(Pregunta pregunta) {
        if ( pregunta == null ) {
            return null;
        }

        PreguntaDTO preguntaDTO = new PreguntaDTO();

        preguntaDTO.setId( pregunta.getId() );
        preguntaDTO.setTextoPregunta( pregunta.getTextoPregunta() );
        preguntaDTO.setOpcionA( pregunta.getOpcionA() );
        preguntaDTO.setOpcionB( pregunta.getOpcionB() );
        preguntaDTO.setOpcionC( pregunta.getOpcionC() );
        preguntaDTO.setOpcionD( pregunta.getOpcionD() );
        preguntaDTO.setPuntajeMaximo( pregunta.getPuntajeMaximo() );

        return preguntaDTO;
    }
}
