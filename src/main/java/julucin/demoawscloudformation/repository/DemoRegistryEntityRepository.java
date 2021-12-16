package julucin.demoawscloudformation.repository;

import julucin.demoawscloudformation.entity.DemoRegistryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRegistryEntityRepository extends JpaRepository<DemoRegistryEntity, Long> {
}
