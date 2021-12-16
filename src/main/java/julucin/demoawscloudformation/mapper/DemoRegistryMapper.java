package julucin.demoawscloudformation.mapper;

import julucin.demoawscloudformation.dto.DemoRegistryDto;
import julucin.demoawscloudformation.entity.DemoRegistryEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DemoRegistryMapper {

    public DemoRegistryDto toDto(DemoRegistryEntity entity){
        return Mapper.map(entity).to(DemoRegistryDto.class);
    }

    public DemoRegistryEntity toEntity(DemoRegistryDto dto){
        return Mapper.map(dto).to(DemoRegistryEntity.class);
    }
}
