package julucin.demoawscloudformation.exception;

public class IdNotPresentOnUpdateException extends RuntimeException {

    public IdNotPresentOnUpdateException(){
        super("Id must be present on payload to perform update on registries.");
    }

}
