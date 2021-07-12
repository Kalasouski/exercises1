package oop.task49;

import java.util.List;

public interface NodeList<T extends Comparable<T>> {
    ListItem<T> getRoot();

    boolean addItem(ListItem<T> item);

    boolean removeItem(ListItem<T> item);

    List<T> traverse(ListItem<T> root);
}
