package julucin.demoawscloudformation.service.common;

public interface DeletingService<I> {
    void deleteById(I id);
}
