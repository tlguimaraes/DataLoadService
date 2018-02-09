package dataload;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataLoadController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/loadservice")
    public DataLoad loadservice(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in dataload ====");
        return new DataLoad(counter.incrementAndGet(), String.format(template, name));
    }
    
    /*
    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/dataload")
    public loadservice dataload(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in dataload ====");
        return new loadservice(counter.incrementAndGet(), String.format(template, name));
    }
    */
    
    
    @GetMapping("/loadservice-javaconfig")
    public DataLoad loadserviceWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in dataload ====");
        return new DataLoad(counter.incrementAndGet(), String.format(template, name));
    }
    
}   