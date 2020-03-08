package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Student;
import streamAPI.StaticTests;
import streamAPI.StreamAPI;

import java.util.Map;
import java.util.function.BiFunction;

@RestController
public class StaticStreamController {

    @GetMapping("/checkStaticTest")
    public void checkStaticTest(){
        System.out.println("----testy metody statycznej----");
        StaticTests.staticMethod("statyczny param");
        StaticTests.getPublicStaticStringValue();
        StaticTests.getPrivateStaticString();
        StaticTests.getPublicStaticString();
        StaticTests.setPublicStaticStringValue("ustawiona wartość");
        System.out.println("Wartość po ustawieniu: "+StaticTests.getPublicStaticStringValue());

        System.out.println("----testy metody nie statycznej----");
        StaticTests st = new StaticTests();
        System.out.println("Wartosć obiektu ze statycznego pola: "+st.publicStaticStringValue);
        System.out.println("Wartość statyczna z niestatycznej metody: "+st.getPrivateStaticStringByNonStatic());
        st.setPrivateStaticStringByNonStatic("po ustawieniu");
        System.out.println("Wartość statyczna z niestatycznej metody: "+st.getPrivateStaticStringByNonStatic());
    }

    @GetMapping("/testStream")
    public Map<String, String> testStream(){
        StreamAPI sa = new StreamAPI();
        return sa.checkStream();
    }

    @PostMapping("/PosttestLambda")
    public int testBiFunction(Student student){
        BiFunction<Integer,String, Integer> loger = (in,st) -> {
            System.out.println("wywołuję moją metode logera in: "+in + " st: "+st);
            return in+3;
        };
        return loger.apply(student.getId(), student.getPassportSerialNumber());
    }

    @GetMapping("/methodRef")
    public String testMethodRef(Student student){
        return new StreamAPI().testMethodReference(student);
    }

    @GetMapping("/changeStaticValue")
    public void changeStatic(){
        StaticTests st1 = new StaticTests();
        System.out.println("Wartość przed zmianą: "+st1.publicStaticStringValue);

        StaticTests.publicStaticStringValue = "zmieniona wartość";
        StaticTests st2 = new StaticTests();
        System.out.println("Wartość po zmianie: "+ st2.publicStaticStringValue);
    }
}
