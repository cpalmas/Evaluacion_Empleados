package palmac.evaluacion_empleado.dtos;

import lombok.Data;

@Data
public class PreguntaDTO {
    private Long id;
    private String textoPregunta;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private Integer puntajeMaximo;
}