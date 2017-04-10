package co.edu.udea.iw.exception;

/*
 * Para manejar nuestras propias excepciones
 * y mandarlas a un nivel(capa) superior 
 * 
 * 
 * @author Raul Martinez Silgado
 * @version 1.1
 * 
 * */

public class MyException extends Exception {

	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
