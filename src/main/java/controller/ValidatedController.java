package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import validation.FirstStepValidation;
import validation.SecondStepValidation;
import validation.ValidOb;
import validation.ValidService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@RestController
@Validated
public class ValidatedController {

    @Autowired
    private ValidService validService;

    @PostMapping("/addValidated")
    public ValidOb addValidated(@Validated ValidOb valid){
        //Will throw only default exception without group
        System.out.println("wykonałem metodę validated na obiekcie: "+valid);
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
        System.out.println("wykonałem metodę First level validated na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/addSecondLvlValidated")
    public ValidOb addSecondLvlValidated(@Validated(SecondStepValidation.class) ValidOb valid){
        System.out.println("wykonałem metodę Second level validated na obiekcie: "+valid);
        return validService.addEntityValid(valid);
    }

    @PostMapping("/methodLvlValidation")
    public String methodLvlValidation(@RequestParam @Size(min =2, max = 6) String nazwa, @RequestParam @Max(5) int id){
        String x = "wykonuje validacje na poziomie metody dla wartości nazwa: " + nazwa + " id: "+id;
        System.out.println(x);
        return x;
    }

    @PostMapping("/methodwithOutValidation")
    public String methodwithOutValidation(String nazwa, int id){
        String x = "nie wykonuje validacje na poziomie metody dla wartości nazwa: " + nazwa + ", id: " + id;
        System.out.println(x);
        return x;
    }
}