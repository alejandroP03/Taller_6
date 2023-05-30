package QA.exceptions;

public class RepeatedProductException extends BurguerException {

    public RepeatedProductException(String message) {
        super(message + " Error: Producto repetido");
    }

    public RepeatedProductException() {
        super("Error: Producto repetido");
    }

    public RepeatedProductException(String message, Throwable cause) {
        super(message + " Error: Producto repetido", cause);
    }

    public RepeatedProductException(Throwable cause) {
        super("Error: Producto repetido", cause);
    }

}
