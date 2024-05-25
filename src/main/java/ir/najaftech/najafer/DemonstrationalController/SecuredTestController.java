package ir.najaftech.najafer.DemonstrationalController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/good")
public class SecuredTestController {

    @GetMapping
    public String helloWorld() {
        return "Hello from secured endPoint";
    }
}
