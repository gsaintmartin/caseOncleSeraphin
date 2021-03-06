
package caseoncleseraphin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

	private static final long serialVersionUID = -3095912730839983115L;
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

