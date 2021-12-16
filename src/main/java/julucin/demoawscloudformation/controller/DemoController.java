package julucin.demoawscloudformation.controller;

import julucin.demoawscloudformation.dto.DemoRegistryDto;
import julucin.demoawscloudformation.mapper.DemoRegistryMapper;
import julucin.demoawscloudformation.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/demos")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public ResponseEntity<Page<DemoRegistryDto>> demoOnGetMethod(@RequestParam Integer page, @RequestParam Integer pageSize){
        return ResponseEntity.ok(this.demoService.retrievePaginated(page, pageSize).map(DemoRegistryMapper::toDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DemoRegistryDto>> demoOnGetMethodAgain(){
        return ResponseEntity.ok(this.demoService.retrieveAll().stream().map(DemoRegistryMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<DemoRegistryDto> demoOnPostMethod(@RequestBody DemoRegistryDto dto, @RequestHeader String host){
        var savedDemoRegistry = this.demoService.saveNew(DemoRegistryMapper.toEntity(dto));
        var savedDemoLocation = URI.create(host.concat("/demo/").concat(savedDemoRegistry.getId().toString()));
        return ResponseEntity.created(savedDemoLocation).body(DemoRegistryMapper.toDto(savedDemoRegistry));
    }

    @PutMapping("/{demoId}")
    public ResponseEntity<Void> demoOnPutMethod(@PathVariable Long demoId, @RequestBody DemoRegistryDto dto){
        dto.setId(demoId);
        this.demoService.update(DemoRegistryMapper.toEntity(dto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{demoId}")
    public ResponseEntity<Void> demoOnDeleteMethod(@PathVariable Long demoId){
        this.demoService.deleteById(demoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{demoId}")
    public ResponseEntity<DemoRegistryDto> anotherDemoOnGetMethod(@PathVariable Long demoId){
        return ResponseEntity.ok(this.demoService.retrieveById(demoId).map(DemoRegistryMapper::toDto).orElse(new DemoRegistryDto()));
    }

}
