package julucin.demoawscloudformation.exception.handler;

import julucin.demoawscloudformation.exception.IdNotPresentOnUpdateException;
import julucin.demoawscloudformation.exception.InstanceDoesNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(value = {IdNotPresentOnUpdateException.class, InstanceDoesNotExistException.class})
    public ResponseEntity<ExceptionMessage> handleBadRequest(RuntimeException exception){
        return ResponseEntity.badRequest().body(new ExceptionMessage(exception.getMessage()));
    }

}
