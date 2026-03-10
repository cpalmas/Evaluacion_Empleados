package palmac.evaluacion_empleado.data;

import palmac.evaluacion_empleado.data.entities.*;
import palmac.evaluacion_empleado.data.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import palmac.evaluacion_empleado.data.entities.*;
import palmac.evaluacion_empleado.data.repositories.CuestionarioRepository;
import palmac.evaluacion_empleado.data.repositories.DocenteRepository;
import palmac.evaluacion_empleado.data.repositories.EstudianteRepository;
import palmac.evaluacion_empleado.data.repositories.EvaluacionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

        @Autowired
        private EstudianteRepository estudianteRepository;

        @Autowired
        private DocenteRepository docenteRepository;

        @Autowired
        private CuestionarioRepository cuestionarioRepository;

        @Autowired
        private EvaluacionRepository evaluacionRepository;

        @Override
        public void run(String... args) {
                long estudianteCount = estudianteRepository.count();
                if (estudianteCount > 0) {
                        log.info("Los datos ya existen, omitiendo la carga inicial.");
                        return;
                }

                log.info("========== INICIANDO CARGA DE DATOS DE PRUEBA ==========");

                List<Estudiante> estudiantes = cargarEstudiantes();
                List<Docente> docentes = cargarDocentes();
                List<Cuestionario> cuestionarios = cargarCuestionarios();
                cargarEvaluaciones(estudiantes, docentes, cuestionarios);

                log.info("========== CARGA DE DATOS COMPLETADA ==========");
                log.info("Estudiantes: {}", estudianteRepository.count());
                log.info("Docentes: {}", docenteRepository.count());
                log.info("Cuestionarios: {}", cuestionarioRepository.count());
                log.info("Evaluaciones: {}", evaluacionRepository.count());
        }

        private List<Estudiante> cargarEstudiantes() {
                log.info("Cargando estudiantes...");
                List<Estudiante> estudiantes = new ArrayList<>();

                String[][] datos = {
                                { "Carlos", "García López", "A20230001", "carlos.garcia@universidad.edu.mx" },
                                { "María", "Hernández Ruiz", "A20230002", "maria.hernandez@universidad.edu.mx" },
                                { "José", "Martínez Flores", "A20230003", "jose.martinez@universidad.edu.mx" },
                                { "Ana", "López Sánchez", "A20230004", "ana.lopez@universidad.edu.mx" },
                                { "Luis", "González Ramírez", "A20230005", "luis.gonzalez@universidad.edu.mx" },
                                { "Laura", "Rodríguez Castro", "A20230006", "laura.rodriguez@universidad.edu.mx" },
                                { "Miguel", "Pérez Jiménez", "A20230007", "miguel.perez@universidad.edu.mx" },
                                { "Sofía", "Sánchez Morales", "A20230008", "sofia.sanchez@universidad.edu.mx" },
                                { "Diego", "Ramírez Torres", "A20230009", "diego.ramirez@universidad.edu.mx" },
                                { "Valentina", "Torres Vargas", "A20230010", "valentina.torres@universidad.edu.mx" },
                                { "Andrés", "Flores Mendoza", "A20230011", "andres.flores@universidad.edu.mx" },
                                { "Camila", "Vargas Guzmán", "A20230012", "camila.vargas@universidad.edu.mx" },
                                { "Fernando", "Castro Herrera", "A20230013", "fernando.castro@universidad.edu.mx" },
                                { "Daniela", "Jiménez Ortega", "A20230014", "daniela.jimenez@universidad.edu.mx" },
                                { "Ricardo", "Morales Reyes", "A20230015", "ricardo.morales@universidad.edu.mx" },
                                { "Isabella", "Mendoza Cruz", "A20230016", "isabella.mendoza@universidad.edu.mx" },
                                { "Alejandro", "Guzmán Ramos", "A20230017", "alejandro.guzman@universidad.edu.mx" },
                                { "Gabriela", "Herrera Silva", "A20230018", "gabriela.herrera@universidad.edu.mx" },
                                { "Eduardo", "Ortega Díaz", "A20230019", "eduardo.ortega@universidad.edu.mx" },
                                { "Mariana", "Reyes Aguilar", "A20230020", "mariana.reyes@universidad.edu.mx" },
                                { "Javier", "Cruz Navarro", "A20230021", "javier.cruz@universidad.edu.mx" },
                                { "Paulina", "Ramos Medina", "A20230022", "paulina.ramos@universidad.edu.mx" },
                                { "Héctor", "Silva Domínguez", "A20230023", "hector.silva@universidad.edu.mx" },
                                { "Renata", "Díaz Guerrero", "A20230024", "renata.diaz@universidad.edu.mx" },
                                { "Óscar", "Aguilar Paredes", "A20230025", "oscar.aguilar@universidad.edu.mx" },
                };

                for (String[] d : datos) {
                        Estudiante e = new Estudiante();
                        e.setNombre(d[0]);
                        e.setApellido(d[1]);
                        e.setMatricula(d[2]);
                        e.setEmail(d[3]);
                        estudiantes.add(e);
                }

                return estudianteRepository.saveAll(estudiantes);
        }

        private List<Docente> cargarDocentes() {
                log.info("Cargando docentes...");
                List<Docente> docentes = new ArrayList<>();

                String[][] datos = {
                                { "Roberto", "Vega Castillo", "D10001", "Programación Orientada a Objetos" },
                                { "Patricia", "Luna Espinoza", "D10002", "Bases de Datos" },
                                { "Alberto", "Ríos Contreras", "D10003", "Estructuras de Datos" },
                                { "Carmen", "Soto Figueroa", "D10004", "Redes de Computadoras" },
                                { "Francisco", "Medina Sandoval", "D10005", "Sistemas Operativos" },
                                { "Elena", "Navarro Peña", "D10006", "Ingeniería de Software" },
                                { "Raúl", "Domínguez Cervantes", "D10007", "Inteligencia Artificial" },
                                { "Gloria", "Guerrero Ibarra", "D10008", "Matemáticas Discretas" },
                                { "Manuel", "Paredes Lozano", "D10009", "Cálculo Diferencial" },
                                { "Teresa", "Espinoza Rojas", "D10010", "Física para Ingeniería" },
                                { "Jorge", "Castillo Acosta", "D10011", "Arquitectura de Computadoras" },
                                { "Adriana", "Figueroa Valdez", "D10012", "Desarrollo Web" },
                                { "Sergio", "Sandoval Mora", "D10013", "Compiladores" },
                                { "Mónica", "Peña Fuentes", "D10014", "Álgebra Lineal" },
                                { "Arturo", "Cervantes Delgado", "D10015", "Probabilidad y Estadística" },
                };

                for (String[] d : datos) {
                        Docente doc = new Docente();
                        doc.setNombre(d[0]);
                        doc.setApellido(d[1]);
                        doc.setNumeroEmpleado(d[2]);
                        doc.setMateria(d[3]);
                        docentes.add(doc);
                }

                return docenteRepository.saveAll(docentes);
        }

        private List<Cuestionario> cargarCuestionarios() {
                log.info("Cargando cuestionarios...");
                List<Cuestionario> cuestionarios = new ArrayList<>();

                // -- Cuestionario 1: Desempeño General --
                Cuestionario c1 = new Cuestionario();
                c1.setTitulo("Cuestionario de Desempeño Académico General");
                c1.setDescripcion("Evaluación general del desempeño del docente en el aula");
                c1.setPreguntas(new ArrayList<>());

                agregarPregunta(c1, "¿Cómo calificarías la claridad de las explicaciones del docente?",
                                "Excelente (10)", "Bueno (8)", "Regular (5)", "Deficiente (2)", 10);
                agregarPregunta(c1, "¿El docente fomenta la participación de los estudiantes?",
                                "Siempre (10)", "Casi siempre (8)", "A veces (5)", "Nunca (2)", 10);
                agregarPregunta(c1, "¿El docente cumple con el programa de la materia?",
                                "Totalmente (10)", "En su mayoría (8)", "Parcialmente (5)", "No cumple (2)", 10);

                cuestionarios.add(c1);

                // -- Cuestionario 2: Metodología de Enseñanza --
                Cuestionario c2 = new Cuestionario();
                c2.setTitulo("Cuestionario de Metodología de Enseñanza");
                c2.setDescripcion("Evaluación de las técnicas y métodos de enseñanza utilizados por el docente");
                c2.setPreguntas(new ArrayList<>());

                agregarPregunta(c2,
                                "¿El docente utiliza recursos didácticos variados (presentaciones, videos, ejercicios prácticos)?",
                                "Siempre (10)", "Frecuentemente (8)", "Ocasionalmente (5)", "Nunca (2)", 10);
                agregarPregunta(c2, "¿Las actividades y tareas asignadas contribuyen al aprendizaje?",
                                "Totalmente de acuerdo (10)", "De acuerdo (8)", "Parcialmente (5)", "En desacuerdo (2)",
                                10);
                agregarPregunta(c2, "¿El docente relaciona los temas con aplicaciones prácticas o del mundo real?",
                                "Siempre (10)", "Casi siempre (8)", "Rara vez (5)", "Nunca (2)", 10);

                cuestionarios.add(c2);

                // -- Cuestionario 3: Comunicación y Retroalimentación --
                Cuestionario c3 = new Cuestionario();
                c3.setTitulo("Cuestionario de Comunicación y Retroalimentación");
                c3.setDescripcion("Evaluación de la comunicación del docente y la retroalimentación proporcionada");
                c3.setPreguntas(new ArrayList<>());

                agregarPregunta(c3, "¿El docente es accesible para resolver dudas fuera de clase?",
                                "Muy accesible (10)", "Accesible (8)", "Poco accesible (5)", "Inaccesible (2)", 10);
                agregarPregunta(c3, "¿La retroalimentación en exámenes y trabajos es útil para mejorar?",
                                "Muy útil (10)", "Útil (8)", "Poco útil (5)", "Nada útil (2)", 10);
                agregarPregunta(c3, "¿El docente comunica claramente los criterios de evaluación?",
                                "Totalmente (10)", "En general sí (8)", "Parcialmente (5)", "No los comunica (2)", 10);

                cuestionarios.add(c3);

                // -- Cuestionario 4: Dominio de la Materia --
                Cuestionario c4 = new Cuestionario();
                c4.setTitulo("Cuestionario de Dominio de la Materia");
                c4.setDescripcion("Evaluación del conocimiento y dominio que demuestra el docente sobre su materia");
                c4.setPreguntas(new ArrayList<>());

                agregarPregunta(c4, "¿El docente demuestra un amplio conocimiento sobre los temas de la materia?",
                                "Definitivamente (10)", "En su mayoría (8)", "Parcialmente (5)", "No lo demuestra (2)",
                                10);
                agregarPregunta(c4, "¿El docente puede responder preguntas complejas sobre la materia?",
                                "Siempre (10)", "Casi siempre (8)", "A veces (5)", "Rara vez (2)", 10);
                agregarPregunta(c4, "¿El docente se mantiene actualizado en los temas de su área?",
                                "Totalmente (10)", "En general (8)", "Poco (5)", "Nada (2)", 10);

                cuestionarios.add(c4);

                // -- Cuestionario 5: Ambiente en el Aula --
                Cuestionario c5 = new Cuestionario();
                c5.setTitulo("Cuestionario de Ambiente en el Aula");
                c5.setDescripcion(
                                "Evaluación del ambiente de aprendizaje y el trato del docente hacia los estudiantes");
                c5.setPreguntas(new ArrayList<>());

                agregarPregunta(c5, "¿El docente trata a todos los estudiantes con respeto e igualdad?",
                                "Siempre (10)", "Casi siempre (8)", "A veces (5)", "Nunca (2)", 10);
                agregarPregunta(c5, "¿El docente promueve un ambiente de aprendizaje positivo y motivador?",
                                "Totalmente (10)", "En general (8)", "Parcialmente (5)", "No lo promueve (2)", 10);
                agregarPregunta(c5, "¿El docente es puntual y organizado en sus clases?",
                                "Siempre (10)", "Casi siempre (8)", "A veces (5)", "Rara vez (2)", 10);

                cuestionarios.add(c5);

                return cuestionarioRepository.saveAll(cuestionarios);
        }

        private void agregarPregunta(Cuestionario cuestionario, String texto, String a, String b, String c, String d,
                        Integer puntajeMax) {
                Pregunta p = new Pregunta();
                p.setTextoPregunta(texto);
                p.setOpcionA(a);
                p.setOpcionB(b);
                p.setOpcionC(c);
                p.setOpcionD(d);
                p.setPuntajeMaximo(puntajeMax);
                p.setCuestionario(cuestionario);
                cuestionario.getPreguntas().add(p);
        }

        private void cargarEvaluaciones(List<Estudiante> estudiantes, List<Docente> docentes,
                        List<Cuestionario> cuestionarios) {
                log.info("Cargando evaluaciones...");
                Random random = new Random(42); // Seed fija para datos reproducibles
                List<Evaluacion> evaluaciones = new ArrayList<>();

                int[] puntajesDisponibles = { 2, 5, 8, 10 };

                String[] comentarios = {
                                "Excelente docente, muy claro en sus explicaciones y siempre dispuesto a ayudar.",
                                "Buen profesor, aunque a veces va muy rápido con los temas.",
                                "Me gusta su forma de enseñar, utiliza muchos ejemplos prácticos.",
                                "Necesita mejorar la organización de sus clases.",
                                "Muy buen dominio de la materia, se nota su experiencia.",
                                "Las clases son interesantes pero los exámenes son muy difíciles.",
                                "Es un profesor dedicado que se preocupa por el aprendizaje de sus alumnos.",
                                "Podría mejorar en la retroalimentación de tareas y proyectos.",
                                "El mejor profesor que he tenido en la carrera, totalmente recomendado.",
                                "Regular, no siempre cumple con el programa del curso.",
                                "Muy puntual y organizado, siempre preparado para la clase.",
                                "Fomenta mucho la participación y el trabajo en equipo.",
                                "Le falta actualizar el material de sus presentaciones.",
                                "Excelente forma de evaluar, justa y acorde a lo visto en clase.",
                                "A veces es difícil de contactar fuera del horario de clase.",
                                "Sus ejemplos prácticos hacen que la materia sea más fácil de entender.",
                                "Necesita ser más paciente con los estudiantes que tienen dudas.",
                                "Muy accesible y amable, crea un buen ambiente en el aula.",
                                "Las tareas son excesivas pero ayudan a reforzar el conocimiento.",
                                "Domina perfectamente los temas pero a veces no explica bien.",
                                "Me gustaría que usara más recursos tecnológicos en clase.",
                                "Profesor comprometido, siempre busca que todos entiendan.",
                                "Las clases son algo monótonas, podría variar su metodología.",
                                "Calificaciones justas y retroalimentación oportuna.",
                                "Necesita mejorar la puntualidad al iniciar las clases.",
                                "Excelente manejo de los temas difíciles, los hace comprensibles.",
                                "Me hubiera gustado más práctica y menos teoría.",
                                "Es un profesor estricto pero justo en sus evaluaciones.",
                                "Promueve el pensamiento crítico y la investigación.",
                                "Buena disposición para asesorías fuera de clase.",
                };

                // Cada estudiante evalúa entre 3 y 6 docentes con diferentes cuestionarios
                for (Estudiante estudiante : estudiantes) {
                        int numEvaluaciones = 3 + random.nextInt(4); // 3 a 6 evaluaciones por estudiante
                        List<Integer> docentesEvaluados = new ArrayList<>();

                        for (int i = 0; i < numEvaluaciones; i++) {
                                int docenteIdx;
                                do {
                                        docenteIdx = random.nextInt(docentes.size());
                                } while (docentesEvaluados.contains(docenteIdx));
                                docentesEvaluados.add(docenteIdx);

                                Docente docente = docentes.get(docenteIdx);
                                Cuestionario cuestionario = cuestionarios.get(random.nextInt(cuestionarios.size()));

                                Evaluacion evaluacion = new Evaluacion();
                                evaluacion.setEstudiante(estudiante);
                                evaluacion.setDocente(docente);
                                evaluacion.setCuestionario(cuestionario);
                                evaluacion.setPuntajePregunta1(
                                                puntajesDisponibles[random.nextInt(puntajesDisponibles.length)]);
                                evaluacion.setPuntajePregunta2(
                                                puntajesDisponibles[random.nextInt(puntajesDisponibles.length)]);
                                evaluacion.setPuntajePregunta3(
                                                puntajesDisponibles[random.nextInt(puntajesDisponibles.length)]);
                                evaluacion.setComentarioGeneral(comentarios[random.nextInt(comentarios.length)]);

                                evaluaciones.add(evaluacion);
                        }
                }

                evaluacionRepository.saveAll(evaluaciones);
                log.info("Se generaron {} evaluaciones de prueba.", evaluaciones.size());
        }
}
