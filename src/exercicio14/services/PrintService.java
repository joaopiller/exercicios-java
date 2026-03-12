package exercicio14.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Lista está vazia");
        }
        return list.get(0);
    }

    public void print() {
        IO.print("[");
        if (!list.isEmpty()) {
            IO.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            IO.print(", " + list.get(i));
        }
        IO.println("]");
    }
}
