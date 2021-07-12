package oop.task49;

public class Node<T extends Comparable<T>> extends ListItem<T> {
    public Node(T value) {
        super(value);
    }

    @Override
    ListItem<T> next() {
        return rightLink;
    }

    @Override
    ListItem<T> setNext(ListItem<T> item) {
        rightLink = item;
        return rightLink;
    }

    @Override
    ListItem<T> previous() {
        return leftLink;
    }

    @Override
    ListItem<T> setPrevious(ListItem<T> item) {
        leftLink = item;
        return leftLink;
    }
}
