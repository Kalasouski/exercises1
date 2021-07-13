package oop.task49;

import java.util.ArrayList;
import java.util.List;

public class SearchTree<T extends Comparable<T>> implements NodeList<T> {

    private ListItem<T> root;

    private boolean isDeleted = true;

    public SearchTree(ListItem<T> root) {
        this.root = root;
    }

    public SearchTree() {

    }

    @Override
    public ListItem<T> getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem<T> item) {
        if (item == null || item.value == null)
            return false;
        if (root == null) {
            root = item;
            return true;
        }
        return addItem(item, root);
    }

    public boolean addItem(ListItem<T> item, ListItem<T> root) {
        int comparison = item.value.compareTo(root.value);
        if (comparison < 0) {
            if (root.previous() != null)
                return addItem(item, root.previous());
            else
                root.setPrevious(item);
            return true;
        } else if (comparison > 0) {
            if (root.next() != null)
                return addItem(item, root.next());
            else
                root.setNext(item);
            return true;
        } else return false;
    }

    @Override
    public boolean removeItem(ListItem<T> item) {
        removeItem(item, root);
        return isDeleted;
    }

    private ListItem<T> removeItem(ListItem<T> item, ListItem<T> root) {
        if (root == null) {
            isDeleted = false;
            return null; //false
        }
        isDeleted = true;

        int comparison = item.value.compareTo(root.value);

        if (comparison < 0)
            root.setPrevious(removeItem(item, root.previous()));
        else if (comparison > 0)
            root.setNext(removeItem(item, root.next()));
        else {
            if (root.previous() == null)
                return root.next();
            else if (root.next() == null)
                return root.previous();
            root.value = minValue(root.next()).value;
            root.setNext(removeItem(root, root.next()));
        }
        return root;
    }

    private ListItem<T> minValue(ListItem<T> root) {
        ListItem<T> minItem = root;
        while (root.previous() != null) {
            minItem = root.previous();
            root = root.previous();
        }
        return minItem;
    }

    @Override
    public List<T> traverse(ListItem<T> root) {
        if (root == null)
            return null;
        List<T> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    private void traverse(List<T> result, ListItem<T> current) {
        if (current == null)
            return;
        traverse(result, current.previous());
        result.add(current.value);
        traverse(result, current.next());
    }
}
