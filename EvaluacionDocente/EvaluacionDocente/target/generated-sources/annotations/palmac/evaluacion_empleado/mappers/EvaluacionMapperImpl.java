package palmac.evaluacion_empleado.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.Cuestionario;
import palmac.evaluacion_empleado.data.entities.Estudiante;
import palmac.evaluacion_empleado.data.entities.Evaluacion;
import palmac.evaluacion_empleado.dtos.EvaluacionDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T05:24:29-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class EvaluacionMapperImpl implements EvaluacionMapper {

    @Override
    public EvaluacionDTO toDTO(Evaluacion evaluacion) {
        if ( evaluacion == null ) {
            return null;
        }

        EvaluacionDTO evaluacionDTO = new EvaluacionDTO();

        evaluacionDTO.setCuestionarioId( evaluacionCuestionarioId( evaluacion ) );
        evaluacionDTO.setEstudianteId( evaluacionEstudianteId( evaluacion ) );
        evaluacionDTO.setId( evaluacion.getId() );
        evaluacionDTO.setComentarioGeneral( evaluacion.getComentarioGeneral() );
        evaluacionDTO.setPuntajeFinal( evaluacion.getPuntajeFinal() );
        if ( evaluacion.getPuntajePregunta1() != null ) {
            evaluacionDTO.setPuntajePregunta1( evaluacion.getPuntajePregunta1().doubleValue() );
        }
        if ( evaluacion.getPuntajePregunta2() != null ) {
            evaluacionDTO.setPuntajePregunta2( evaluacion.getPuntajePregunta2().doubleValue() );
        }
        if ( evaluacion.getPuntajePregunta3() != null ) {
            evaluacionDTO.setPuntajePregunta3( evaluacion.getPuntajePregunta3().doubleValue() );
        }
        evaluacionDTO.setFechaEvaluacion( evaluacion.getFechaEvaluacion() );

        return evaluacionDTO;
    }

    private Long evaluacionCuestionarioId(Evaluacion evaluacion) {
        if ( evaluacion == null ) {
            return null;
        }
        Cuestionario cuestionario = evaluacion.getCuestionario();
        if ( cuestionario == null ) {
            return null;
        }
        Long id = cuestionario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long evaluacionEstudianteId(Evaluacion evaluacion) {
        if ( evaluacion == null ) {
            return null;
        }
        Estudiante estudiante = evaluacion.getEstudiante();
        if ( estudiante == null ) {
            return null;
        }
        Long id = estudiante.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
