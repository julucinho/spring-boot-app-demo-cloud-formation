package julucin.demoawscloudformation.service.impl;

import julucin.demoawscloudformation.entity.DemoRegistryEntity;
import julucin.demoawscloudformation.exception.IdNotPresentOnUpdateException;
import julucin.demoawscloudformation.exception.InstanceDoesNotExistException;
import julucin.demoawscloudformation.repository.DemoRegistryEntityRepository;
import julucin.demoawscloudformation.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRegistryEntityRepository demoRegistryEntityRepository;

    @Override
    public void deleteById(Long id) {
        if (this.retrieveById(id).isPresent())
            this.demoRegistryEntityRepository.deleteById(id);
        else throw new InstanceDoesNotExistException(id);
    }

    @Override
    public Page<DemoRegistryEntity> retrievePaginated(int page, int pageSize) {
        return this.demoRegistryEntityRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public List<DemoRegistryEntity> retrieveAll() {
        return this.demoRegistryEntityRepository.findAll();
    }

    @Override
    public Optional<DemoRegistryEntity> retrieveById(Long id) {
        return this.demoRegistryEntityRepository.findById(id);
    }

    @Override
    public DemoRegistryEntity saveNew(DemoRegistryEntity entity) {
        entity.setCreationDate(LocalDateTime.now());
        return this.demoRegistryEntityRepository.save(entity);
    }

    @Override
    public void update(DemoRegistryEntity entity) {
        if (ofNullable(entity.getId()).isPresent())
            this.demoRegistryEntityRepository.save(entity);
        else throw new IdNotPresentOnUpdateException();
    }
}
