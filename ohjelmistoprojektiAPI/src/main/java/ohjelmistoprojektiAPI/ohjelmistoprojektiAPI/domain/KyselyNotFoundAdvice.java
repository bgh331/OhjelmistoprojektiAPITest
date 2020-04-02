package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class KyselyNotFoundAdvice {

	 @ResponseBody
	  @ExceptionHandler(KyselyNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(KyselyNotFoundException ex) {
	    return ex.getMessage();
	  }
	}
