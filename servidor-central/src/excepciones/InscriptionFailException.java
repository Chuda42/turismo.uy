package excepciones;

@SuppressWarnings("serial")
public class InscriptionFailException extends Exception {
	public InscriptionFailException(String msg) {
		super(msg);
	}
}