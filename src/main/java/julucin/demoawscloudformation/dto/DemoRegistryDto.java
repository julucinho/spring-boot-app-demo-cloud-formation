package julucin.demoawscloudformation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DemoRegistryDto {
    private Long id;
    private LocalDateTime creationDate;
    private String method;
}
