package palmac.evaluacion_empleado.dtos;

public class DocenteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String numeroEmpleado;
    private String materia;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getNumeroEmpleado() { return numeroEmpleado; }
    public void setNumeroEmpleado(String numeroEmpleado) { this.numeroEmpleado = numeroEmpleado; }
    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }
}