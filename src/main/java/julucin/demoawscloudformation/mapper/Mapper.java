package julucin.demoawscloudformation.mapper;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
class Mapper {

    public MapperAux map(Object source){
        return MapperAux.of(source);
    }

    @AllArgsConstructor
    public static class MapperAux{
        private final Object source;

        static MapperAux of(Object source){
            return new MapperAux(source);
        }

        public <T> T to(Class<T> destination){
            return new ModelMapper().map(this.source, destination);
        }

    }

}
