package julucin.demoawscloudformation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DemoRegistryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demoRegistryEntityId")
    private Long id;

    @Column(name = "demoRegistryEntityCreationDate")
    private LocalDateTime creationDate;

    @Column(name = "usedMethodId")
    private String method;
}
