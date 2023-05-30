package QA.exceptions;

public class ExceededOrderPrice extends BurguerException {
    public ExceededOrderPrice(String message) {
        super(message + " Error: El pedido excede el precio máximo");
    }

    public ExceededOrderPrice() {
        super(" Error: El pedido excede el precio máximo");
    }

    public ExceededOrderPrice(String message, Throwable cause) {
        super(message + " Error: El pedido excede el precio máximo", cause);
    }

    public ExceededOrderPrice(Throwable cause) {
        super(" Error: El pedido excede el precio máximo", cause);
    }

}
