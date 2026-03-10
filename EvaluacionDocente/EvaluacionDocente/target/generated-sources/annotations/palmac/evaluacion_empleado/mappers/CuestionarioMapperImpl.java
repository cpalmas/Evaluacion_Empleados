package palmac.evaluacion_empleado.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.data.entities.Pregunta;
import palmac.evaluacion_empleado.dtos.CuestionarioDTO;
import palmac.evaluacion_empleado.dtos.PreguntaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T05:24:29-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CuestionarioMapperImpl implements CuestionarioMapper {

    @Autowired
    private PreguntaMapper preguntaMapper;

    @Override
    public CuestionarioDTO toDTO(Cuestionario cuestionario) {
        if ( cuestionario == null ) {
            return null;
        }

        CuestionarioDTO cuestionarioDTO = new CuestionarioDTO();

        cuestionarioDTO.setId( cuestionario.getId() );
        cuestionarioDTO.setTitulo( cuestionario.getTitulo() );
        cuestionarioDTO.setDescripcion( cuestionario.getDescripcion() );
        cuestionarioDTO.setPreguntas( preguntaListToPreguntaDTOList( cuestionario.getPreguntas() ) );

        return cuestionarioDTO;
    }

    protected List<PreguntaDTO> preguntaListToPreguntaDTOList(List<Pregunta> list) {
        if ( list == null ) {
            return null;
        }

        List<PreguntaDTO> list1 = new ArrayList<PreguntaDTO>( list.size() );
        for ( Pregunta pregunta : list ) {
            list1.add( preguntaMapper.toDTO( pregunta ) );
        }

        return list1;
    }
}
