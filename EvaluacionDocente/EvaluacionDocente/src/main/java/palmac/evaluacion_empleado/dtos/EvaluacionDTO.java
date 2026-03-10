package palmac.evaluacion_empleado.dtos;

import java.time.LocalDateTime;

public class EvaluacionDTO {
    private Long id;
    private String comentarioGeneral;
    private Double puntajeFinal;
    private Double puntajePregunta1;
    private Double puntajePregunta2;
    private Double puntajePregunta3;
    private LocalDateTime fechaEvaluacion; // ✅ coincide con la entidad
    private Long cuestionarioId;
    private Long estudianteId; // ✅ mapear solo el ID

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getComentarioGeneral() { return comentarioGeneral; }
    public void setComentarioGeneral(String comentarioGeneral) { this.comentarioGeneral = comentarioGeneral; }
    public Double getPuntajeFinal() { return puntajeFinal; }
    public void setPuntajeFinal(Double puntajeFinal) { this.puntajeFinal = puntajeFinal; }
    public Double getPuntajePregunta1() { return puntajePregunta1; }
    public void setPuntajePregunta1(Double puntajePregunta1) { this.puntajePregunta1 = puntajePregunta1; }
    public Double getPuntajePregunta2() { return puntajePregunta2; }
    public void setPuntajePregunta2(Double puntajePregunta2) { this.puntajePregunta2 = puntajePregunta2; }
    public Double getPuntajePregunta3() { return puntajePregunta3; }
    public void setPuntajePregunta3(Double puntajePregunta3) { this.puntajePregunta3 = puntajePregunta3; }
    public LocalDateTime getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }
    public Long getCuestionarioId() { return cuestionarioId; }
    public void setCuestionarioId(Long cuestionarioId) { this.cuestionarioId = cuestionarioId; }
    public Long getEstudianteId() { return estudianteId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
}