package palmac.evaluacion_empleado.common;

public class NotFoundElementException extends RuntimeException {

    public NotFoundElementException() {
        super();
    }

    public NotFoundElementException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String message = "Elemento no encontrado";
        return super.getMessage() != null ? super.getMessage() : message;
    }
}
