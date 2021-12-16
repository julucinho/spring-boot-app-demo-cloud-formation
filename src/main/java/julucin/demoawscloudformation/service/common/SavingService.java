package julucin.demoawscloudformation.service.common;

public interface SavingService<E> {

    E saveNew(E entity);
    void update(E entity);

}
