package excepciones;

@SuppressWarnings("serial")
public class CompraFailException extends Exception {
    public CompraFailException(String msg) {
        super(msg);
    }
}