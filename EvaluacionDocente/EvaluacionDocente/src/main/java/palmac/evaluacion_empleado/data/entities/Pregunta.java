package palmac.evaluacion_empleado.data.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tc_preguntas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String textoPregunta;

    @Column(nullable = false, length = 200)
    private String opcionA;

    @Column(nullable = false, length = 200)
    private String opcionB;

    @Column(nullable = false, length = 200)
    private String opcionC;

    @Column(nullable = false, length = 200)
    private String opcionD;

    @Column(nullable = false)
    private Integer puntajeMaximo;

    @ManyToOne
    @JoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionario;
}