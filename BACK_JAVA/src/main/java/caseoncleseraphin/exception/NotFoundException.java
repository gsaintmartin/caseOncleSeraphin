
package caseoncleseraphin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = -2842558997630961942L;

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

