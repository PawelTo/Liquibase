package app.streamAPI;

import app.service.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public StreamAPI() {
    }

    public Map<String, String> checkStream(){
        List<String> lista = Arrays.asList("pierwszy", "drugi","trzeci","pierwszy");

        Stream<String> stream = lista.stream();
        return stream.distinct().peek(s -> System.out.println(s+" peak wykonuje jakąś operację"))
                .map(s->s.concat("map zamienia jeden strumień w drugi "))
                .peek(s-> System.out.println(" po raz drugi "+s))
                .collect(Collectors.toMap(s -> s, Function.identity()));
    }

    public BinaryOperator<Integer> checkLambda(int var1, int var2){
        return (Integer a, Integer b) -> {
            System.out.println("wartości wynoszą: "+a + " oraz: "+b);
            return (a*2 + b*2);
        };
    }

    public String testMethodReference(Student student){
        Function<Student,String> string = Student::getName;
        System.out.println("bez tworzenia obiektu: "+string.apply(student));
        return  string.apply(student);
    };
}