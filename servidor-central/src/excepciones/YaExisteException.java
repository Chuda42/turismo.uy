package excepciones;

@SuppressWarnings("serial")
public class YaExisteException extends Exception {
	public YaExisteException(String msg) {
		super(msg);
	}
}