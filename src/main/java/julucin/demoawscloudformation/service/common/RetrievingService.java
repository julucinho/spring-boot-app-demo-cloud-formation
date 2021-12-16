package julucin.demoawscloudformation.service.common;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RetrievingService<E, I> {

    Page<E> retrievePaginated(int page, int pageSize);
    List<E> retrieveAll();
    Optional<E> retrieveById(I id);

}
