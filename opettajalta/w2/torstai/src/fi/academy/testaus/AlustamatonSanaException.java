package fi.academy.testaus;

public class AlustamatonSanaException extends RuntimeException {
    public AlustamatonSanaException() {
    }

    public AlustamatonSanaException(String message) {
        super(message);
    }

    public AlustamatonSanaException(String message, Throwable cause) {
        super(message, cause);
    }
}
