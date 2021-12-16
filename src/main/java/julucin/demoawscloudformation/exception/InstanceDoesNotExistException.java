package julucin.demoawscloudformation.exception;

public class InstanceDoesNotExistException extends RuntimeException {
    public InstanceDoesNotExistException(Long id) {
        super("The referenced instance of id ".concat(id.toString()).concat(" does not exist."));
    }
}
