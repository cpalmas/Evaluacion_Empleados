package palmac.evaluacion_empleado.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tr_evaluaciones")
@Data           // ✅ Genera getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "cuestionario_id", nullable = false)
    private Cuestionario cuestionario;

    @Column(nullable = false)
    private Integer puntajePregunta1;

    @Column(nullable = false)
    private Integer puntajePregunta2;

    @Column(nullable = false)
    private Integer puntajePregunta3;

    @Column(length = 1000)
    private String comentarioGeneral;

    @Column(nullable = false)
    private Double puntajeFinal;

    @Column(nullable = false)
    private LocalDateTime fechaEvaluacion;

    @PrePersist
    public void prePersist() {
        this.fechaEvaluacion = LocalDateTime.now();
        this.puntajeFinal = (puntajePregunta1 + puntajePregunta2 + puntajePregunta3) / 3.0;
    }
}