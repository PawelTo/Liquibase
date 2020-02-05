package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${controllerReturned:wartoscDomyslna}")
    private String controllerReturn;

    public ProfileController() {
        this.controllerReturn = controllerReturn;
    }

    @GetMapping("/print")
    public String printValue(){
        System.out.println("wartość: "+controllerReturn);
        return controllerReturn;
    }
}
