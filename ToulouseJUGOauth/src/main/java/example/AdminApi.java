package example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminApi {

    @GetMapping("/ping")
    public ResponseEntity<String> getAdmin(){
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }

}
