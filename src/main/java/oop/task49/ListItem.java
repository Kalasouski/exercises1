package oop.task49;

public abstract class ListItem<T extends Comparable<T>> {
    protected ListItem<T> leftLink;
    protected ListItem<T> rightLink;

    T value;

    public ListItem(T value) {
        this.value = value;
    }

    abstract ListItem<T> next();

    abstract ListItem<T> setNext(ListItem<T> item);

    abstract ListItem<T> previous();

    abstract ListItem<T> setPrevious(ListItem<T> item);


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
