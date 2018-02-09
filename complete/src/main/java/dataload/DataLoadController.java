package dataload;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataLoadController {

    private static final String template = "Thiago %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/loadservice")
    public DataLoad loadservice(@RequestParam(required=false, defaultValue="Leoncio") String name) {
        System.out.println("==== tguimaraes loading data from json file. ====");
        return new DataLoad(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/loadservice-javaconfig")
    public DataLoad loadserviceWithJavaconfig(@RequestParam(required=false, defaultValue="Leoncio") String name) {
        System.out.println("==== [tguimaraes loading data from json file.] ====");
        return new DataLoad(counter.incrementAndGet(), String.format(template, name));
    }

}
