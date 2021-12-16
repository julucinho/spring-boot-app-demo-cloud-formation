package julucin.demoawscloudformation.service;

import julucin.demoawscloudformation.entity.DemoRegistryEntity;
import julucin.demoawscloudformation.service.common.DeletingService;
import julucin.demoawscloudformation.service.common.RetrievingService;
import julucin.demoawscloudformation.service.common.SavingService;
import org.springframework.stereotype.Service;

@Service
public interface DemoService extends SavingService<DemoRegistryEntity>,
        RetrievingService<DemoRegistryEntity, Long>,
        DeletingService<Long> {
}
