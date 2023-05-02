public class MyLinkedList<E> implements MyList {

    private static class Node<E> {
        public E item;
        public Node<E> previous;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * size() - returns size of the array
     * @return size;
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * contains() - checks whether there is an element in the array or not
     * @param o - element that we need
     * @return false - if not contains, true - if contains
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i) == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * add() - adds one element to the array
     * @param item - element that we add
     */
    @Override
    public void add(Object item) {
        Node<E> node = new Node<> ((E)item);
        if (head == null) {
            node.next = null;
            node.previous = null;
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    /**
     * add() - adds one element to the array by the index
     * @param item - element that we add
     * @param index - index of element that we need to add
     */
    @Override
    public void add(Object item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * remove() - removes one element from the array
     * @param item - element that we need to remove
     * @return true - if the function removes the element, otherwise, false
     */
    @Override
    public boolean remove(Object item) {
        if (head == null) {
            return false;
        }
        if (head.item.equals(item)) {
            head = head.next;
            return true;
        }
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.item.equals(item)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * remove() - removes one element from the array by the index
     * @param index - index of the element that we need to remove
     * @return Successfully - if function removes the element, otherwise, exception
     */
    @Override
    public Object remove(int index) {
        if (head == null) {
            return null;
        }
        if (index == 0) {
            Node<E> removedNode = head;
            head = head.next;
            return removedNode;
        }
        Node<E> current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            return null;
        }
        Node<E> removedNode = current.next;
        current.next = current.next.next;
        return removedNode;
    }

    /**
     * clear() - creates new clear array
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * get() - shows element of the index
     * @param index - index of the element that we need
     * @return element, otherwise, index not found
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * indexOf() - returns index of the element
     * @param o - element index of we need
     * @return index, otherwise, 1 - false
     */
    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * lastIndexOf() - returns last index of the element
     * @param o - element index of we need
     * @return index, otherwise, 1 - false
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<E> current = head;
        int lastIndex = -1;
        int index = 0;
        while (current != null) {
            if (current.item.equals(o)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    /**
     * sort() - sorts the array
     */
    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node<E> prev = null;
            Node<E> current = head;
            Node<E> next = head.next;
            while (next != null) {
                if (((Comparable)current.item).compareTo(next.item) > 0) {
                    if (prev != null) {
                        prev.next = next;
                    } else {
                        head = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    prev = next;
                    next = current.next;
                    swapped = true;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }
}