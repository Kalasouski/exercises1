package oop.task49;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MyLinkedList<T extends Comparable<T>> implements NodeList<T> {

    private ListItem<T> root;

    @Override
    public ListItem<T> getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem<T> item) {
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
