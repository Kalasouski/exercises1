package oop.task49;

import java.util.ArrayList;
import java.util.List;

public class SearchTree<T extends Comparable<T>> implements NodeList<T> {

    private ListItem<T> root;

    //private boolean isDeleted = true;

    public SearchTree(ListItem<T> root) {
        this.root = root;
    }

    public SearchTree() {

    }

    class Pair {
        final ListItem<T> item;
        final boolean isDeleted;

        public Pair(ListItem<T> item, boolean isDeleted) {
            this.item = item;
            this.isDeleted = isDeleted;
        }
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
        return addItemRecursively(item, root);
    }

    private boolean addItemRecursively(ListItem<T> item, ListItem<T> parentItem) {
        int comparison = item.value.compareTo(parentItem.value);
        if (comparison < 0) {
            if (parentItem.previous() != null) {
                return addItemRecursively(item, parentItem.previous());
            } else {
                parentItem.setPrevious(item);
            }
            return true;
        } else if (comparison > 0) {
            if (parentItem.next() != null) {
                return addItemRecursively(item, parentItem.next());
            } else {
                parentItem.setNext(item);
            }
            return true;
        } else return false;
    }

    @Override
    public boolean removeItem(ListItem<T> item) {
        return removeItemRecursively(item, root).isDeleted;
    }

    private Pair removeItemRecursively(ListItem<T> item, ListItem<T> parentItem) {
        if (parentItem == null) {
            return new Pair(null, false);
        }
        int comparison = item.value.compareTo(parentItem.value);
        boolean isDeleted;
        if (comparison < 0) {
            Pair leftResult = removeItemRecursively(item, parentItem.previous());
            parentItem.setPrevious(leftResult.item);
            isDeleted = leftResult.isDeleted;
        } else if (comparison > 0) {
            Pair rightResult = removeItemRecursively(item, parentItem.next());
            parentItem.setNext(rightResult.item);
            isDeleted = rightResult.isDeleted;
        } else {
            if (parentItem.previous() == null) {
                return new Pair(parentItem.next(), true);
            } else if (parentItem.next() == null) {
                return new Pair(parentItem.previous(), true);
            }
            parentItem.value = minValue(parentItem.next()).value;
            parentItem.setNext(removeItemRecursively(parentItem, parentItem.next()).item);
            isDeleted = true;
        }
        return new Pair(parentItem, isDeleted);
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
