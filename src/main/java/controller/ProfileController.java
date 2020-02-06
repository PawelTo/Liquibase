package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${controllerReturned:wartoscDomyslna}")
    private String controllerReturn;

    @Value("${controllerReturnedProfile:wartoscDomyslnaProfile}")
    private String controllerReturnedProfile;

    public ProfileController() {
        this.controllerReturn = controllerReturn;
    }

    @GetMapping("/print")
    public String printValue(){
        System.out.println("wartość: "+controllerReturn+ " profile: "+controllerReturnedProfile);
        return controllerReturn+" _ "+controllerReturnedProfile;
    }
}
