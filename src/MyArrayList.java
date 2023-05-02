public class MyArrayList<T> implements MyList {
    private Object[] arr;
    private int size;
    MyArrayList () {
        this.size = 0;
        this.arr = new Object[5];
    }

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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * increaseBuffer() - increases the array
     */
    public void increaseBuffer() {
        Object[] newArr = new Object[arr.length*2];
        for(int i = 0; i == arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    /**
     * add() - adds one element to the array
     * @param item - element that we add
     */
    @Override
    public void add(Object item) {
        if (size == arr.length) {
            increaseBuffer();
        }
        else {
            arr[size++] = item;
        }
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
        if (size == arr.length) {
            increaseBuffer();
        }
        for(int i = size; i>index; i--) {
            arr[i] = arr[i-1];
        }
        size++;
        arr[index] = item;
    }

    /**
     * remove() - removes one element from the array
     * @param item - element that we need to remove
     * @return true - if the function removes the element, otherwise, false
     */
    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toString().equals(item.toString())) {
                System.out.println(remove(i));
                return true;
            }
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (; index < size; index++) {
            if (index < arr.length - 1) {
                arr[index] = arr[index + 1];
            }
        }
        size--;
        return "Successfully";

    }

    /**
     * clear() - creates new clear array
     */
    @Override
    public void clear() {
        this.arr = new Object[5];
        this.size = 0;
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
        if (index < arr.length) {
            return arr[index];
        }
        else {
            return "Index not found";
        }
    }

    /**
     * indexOf() - returns index of the element
     * @param o - element index of we need
     * @return index, otherwise, 1 - false
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toString().equals(o.toString())) {
                return i;
            }
        }
        return 1;
    }

    /**
     * lastIndexOf() - returns last index of the element
     * @param o - element index of we need
     * @return index, otherwise, 1 - false
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].toString().equals(o.toString())) {
                return i;
            }
        }
        return 1;
    }

    /**
     * sort() - sorts the array
     */
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if ((int) arr[j] < (int) arr[i]) {
                    Object box = arr[i];
                    arr[i] = arr[j];
                    arr[j] = box;
                }
            }
        }
    }
}