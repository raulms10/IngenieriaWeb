package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

/*
 * Para manejar nuestras propias excepciones
 * y mandarlas a un nivel(capa) superior 
 * 
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public class MyException extends Exception{
	
	Logger log = Logger.getLogger(this.getClass());
	
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
		log.error(message, cause);
	}

	public MyException(String message) {
		super(message);
		log.error(message);
	}

	public MyException(Throwable cause) {
		super(cause);
		log.error(cause);
	}

}
