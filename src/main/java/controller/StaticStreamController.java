package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import streamAPI.StaticTests;

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

    public void testStream(){

    }
}
