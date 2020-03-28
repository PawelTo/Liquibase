package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.ValidOb;
import validation.ValidService;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;

@RestController
public class ValidController {

    @Autowired
    private ValidService validService;

    @PostMapping("/addValid")
    public ValidOb addValid(@Valid ValidOb valid){
        System.out.println("wykonałem metodę valid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/addUnValid")
    public ValidOb addUnValid(ValidOb valid){
        System.out.println("wykonałem metodę Unvalid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @GetMapping("/ValidOb")
    public String ValidOb(){
        ValidOb validOb = new ValidOb(3,"nie null",-3,2);
        ValidOb validOb1 = new ValidOb(3,null,3,-10);
        ValidOb validOb2 = new ValidOb(3,"poprawny",3,2);
        List<ValidOb> validObs = Arrays.asList(validOb, validOb1, validOb2);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        for (ValidOb va : validObs) {
            System.out.println(validator.validate(va));
        }
        return validator.validate(validOb).toString();
    }
}
