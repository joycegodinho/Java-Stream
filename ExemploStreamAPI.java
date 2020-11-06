package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {
        List<String> estudantes = new ArrayList<>();

        estudantes.add("Pedro");
        estudantes.add("Thayse");
        estudantes.add("Marcelo");
        estudantes.add("Carla");
        estudantes.add("Juliana");
        estudantes.add("Thiago");
        estudantes.add("Rafael");

        // count() - retorna a contagem
        System.out.println("count()");
        System.out.println("Contagem: " + estudantes.stream().count());
        //Contagem: 7

        // max(Comparator.comparingInt(String::length)) - retorna maior string
        System.out.println();
        System.out.println("max(Comparator.comparingInt(String::length))");
        System.out.println("Maior número de letras: " + estudantes.stream().max(Comparator.comparingInt(String::length)));
        //Maior número de letras: Optional[Marcelo]

        // min(Comparator.comparingInt(String::length)) - retorna menor string
        System.out.println();
        System.out.println("min(Comparator.comparingInt(String::length))");
        System.out.println("Menor número de letras: " + estudantes.stream().min(Comparator.comparingInt(String::length)));
        //Menor número de letras: Optional[Pedro]

        // filter() + collect()  - retorna aqueles com a substring passada
        System.out.println();
        System.out.println("filter() + collect()");
        System.out.println("Com a letra r no nome: " + estudantes.stream().filter((estudante) -> estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
        //Com a letra r no nome: [Pedro, Marcelo, Carla, Rafael]

        // map() + collect() - Retorna uma nova coleção com a quantidade de letras
        System.out.println();
        System.out.println("map() + collect()");
        System.out.println("Retorna uma nova coleção com a quantidade de letras: " + estudantes.stream().map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));
        //Retorna uma nova coleção com a quantidade de letras: [Pedro - 5, Thayse - 6, Marcelo - 7, Carla - 5, Juliana - 7, Thiago - 6, Rafael - 6]

        // limit() + collect()  - retorna os 3 primeiros
        System.out.println();
        System.out.println("limit() + collect()");
        System.out.println("Retorna os 3 primeiros elementos: " + estudantes.stream().limit(3).collect(Collectors.toList()));
        //Retorna os 3 primeiros elementos: [Pedro, Thayse, Marcelo]

        // peek() + collect()  - retorna cada elemento e depois retorna ca coleção
        System.out.println();
        System.out.println("peek() + collect()");
        System.out.println("Retorna os elementos: " + estudantes.stream().peek(System.out::println).collect(Collectors.toList()));
        //Pedro
        //Thayse
        //Marcelo
        //Carla
        //Juliana
        //Thiago
        //Rafael
        //Retorna os elementos: [Pedro, Thayse, Marcelo, Carla, Juliana, Thiago, Rafael]

        // forEach()  - retorna cada elemento
        System.out.println();
        System.out.println("forEach()");
        System.out.println("Retorna os elementos: " );
        estudantes.stream().forEach(System.out::println);
        //Pedro
        //Thayse
        //Marcelo
        //Carla
        //Juliana
        //Thiago
        //Rafael


        // allMatch()  - retorna um boleano se todos os elementos possuem a substring ou não
        System.out.println();
        System.out.println("allMatch()");
        System.out.println("Os elementos tem w no nome? " + estudantes.stream().allMatch((elemento) -> elemento.contains("w")));
        //Os elementos tem w no nome? false

        // anyMatch()  - retorna um boleano se algum dos elementos possuem a substring ou não
        System.out.println();
        System.out.println("anyMatch()");
        System.out.println("Algum elemento tem a no nome? " + estudantes.stream().anyMatch((elemento) -> elemento.contains("a")));
        //Algum elemento tem a no nome? true

        // findFirst() + ifPresent() - retorna o primeiro elemento
        System.out.println();
        System.out.println("findFirst() + ifPresent()");
        estudantes.stream().findFirst().ifPresent(System.out::println);
        //Pedro

        // Operações Encadeadas
        System.out.println();
        System.out.println("Operações Encadeadas");
        System.out.println(estudantes.stream()
        .peek(System.out::println)
        .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
        .peek(System.out::println)
        .filter((estudante) -> estudante.toLowerCase().contains("r"))
        .collect(Collectors.toList())) ;
       // .collect(Collectors.joining(", ")));
        // .collect(Collectors.toSet()));
        //.collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))));




    }
}
