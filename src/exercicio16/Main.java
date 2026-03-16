package exercicio16;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myInt = Arrays.asList(5, 2, 10);
        printList(myInt);

        List<String> myStrs = Arrays.asList("João", "Maria", "Lucas");
        printList(myStrs);
    }

    // tipo coringa serve para informar que uma lista pode ser de qualquer tipo
    public static  void printList(List<?> list) {
        // não é possível adicionar dados em uma lista de tipo coringa
        // list.add(3); -> daria erro
        for (Object obj : list) {
            IO.println(obj);
        }
    }
}
