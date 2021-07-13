package oop.task49;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<T extends Comparable<T>> implements NodeList<T> {

    private ListItem<T> root;

    public MyLinkedList(ListItem<T> item) {
        this.root = item;
    }

    public MyLinkedList() {
    }

    @Override
    public ListItem<T> getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem<T> item) {
        if (item == null || item.value == null) {
            return false;
        }
        if (root == null) {
            root = item;
            return true;
        }
        ListItem<T> currentItem = root;
        while (currentItem != null) {
            int comparison = item.value.compareTo(currentItem.value);
            if (comparison > 0) {
                if (currentItem.next() != null)
                    currentItem = currentItem.next();
                else {
                    //the rightmost
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison < 0) {
                if (currentItem.previous() != null) {
                    //before the current
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                } else {
                    //the leftmost
                    item.setNext(root).setPrevious(item);
                    root = item;
                }
                return true;
            } else {
                //isPresent
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem<T> item) {
        if (item == null || item.value == null) {
            return false;
        }
        ListItem<T> currentItem = root;
        while (currentItem != null) {
            int comparison = item.value.compareTo(currentItem.value);
            if (comparison == 0) {
                if (currentItem == root) {
                    root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison > 0)
                currentItem = currentItem.next();
            else {
                // we are at an item greater than the one to be deleted
                return false;
            }
        }
        // reached the end
        return false;
    }

    @Override
    public List<T> traverse(ListItem<T> root) {
        List<T> list = new ArrayList<>();
        while (root != null) {
            list.add(root.value);
            root = root.next();
        }
        return list;
    }
}
