package QA.exceptions;

public class RepeatedIngredientException extends BurguerException {

    public RepeatedIngredientException(String message) {
        super(message + "Error: Ingrediente repetido");
    }

    public RepeatedIngredientException() {
        super("Error: Ingrediente repetido");
    }

    public RepeatedIngredientException(String message, Throwable cause) {
        super(message + "Error: Ingrediente repetido", cause);
    }

    public RepeatedIngredientException(Throwable cause) {
        super("Error: Ingrediente repetido", cause);
    }
}
