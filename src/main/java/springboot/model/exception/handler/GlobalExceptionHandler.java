package springboot.model.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorInfo handleError(HttpServletRequest req, Exception ex) {
		LOG.error("Request: " + req.getRequestURL() + " raised " + ex);
		ex.printStackTrace();
		
		return new ErrorInfo(req.getRequestURL().toString(), ex);

	}

}
