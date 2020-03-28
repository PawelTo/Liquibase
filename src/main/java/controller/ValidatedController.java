package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.FirstStepValidation;
import validation.SecondStepValidation;
import validation.ValidOb;
import validation.ValidService;

@RestController
public class ValidatedController {

    @Autowired
    private ValidService validService;

    @PostMapping("/addValidated")
    public ValidOb addValidated(@Validated ValidOb valid){
        //Will throw only default exception without group
        System.out.println("wykonałem metodę Unvalid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/addUnValidated")
    public ValidOb addUnValidated(ValidOb valid){
        //Will throw only database exceptions from constraints
        System.out.println("wykonałem metodę Unvalid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/addFirstLvlValidated")
    public ValidOb addFirstLvlValidated(@Validated(FirstStepValidation.class) ValidOb valid){
        System.out.println("wykonałem metodę Unvalid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/addSecondLvlValidated")
    public ValidOb addSecondLvlValidated(@Validated(SecondStepValidation.class) ValidOb valid){
        System.out.println("wykonałem metodę Unvalid na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }
}
