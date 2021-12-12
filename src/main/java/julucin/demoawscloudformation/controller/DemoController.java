package julucin.demoawscloudformation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demoOnGetMethod(){
        return this.returnSuccessfulMessageFor("GET");
    }

    @PostMapping
    public ResponseEntity<String> demoOnPostMethod(){
        return this.returnSuccessfulMessageFor("POST");
    }

    @PutMapping
    public ResponseEntity<String> demoOnPutMethod(){
        return this.returnSuccessfulMessageFor("PUT");
    }

    @DeleteMapping
    public ResponseEntity<String> demoOnDeleteMethod(){
        return this.returnSuccessfulMessageFor("DELETE");
    }

    private ResponseEntity<String> returnSuccessfulMessageFor(String method){
        var message = method.concat(" method invoked successfully");
        log.info(message);
        return ResponseEntity.ok(message);
    }

}
