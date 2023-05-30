package QA.exceptions;

public class BurguerException extends IllegalArgumentException {
    public BurguerException(String message) {
        super(message);
    }

    public BurguerException() {
        super();
    }

    public BurguerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BurguerException(Throwable cause) {
        super(cause);
    }

}
