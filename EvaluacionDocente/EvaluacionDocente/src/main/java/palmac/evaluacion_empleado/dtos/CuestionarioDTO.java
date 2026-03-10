package palmac.evaluacion_empleado.dtos;

import lombok.Data;
import java.util.List;

@Data
public class CuestionarioDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private List<PreguntaDTO> preguntas;
}