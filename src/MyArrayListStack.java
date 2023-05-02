import java.util.EmptyStackException;
public class MyArrayListStack extends MyArrayList {
    private MyArrayList list;

    MyArrayListStack() {
        list = new MyArrayList<>();
    }

    /**
     * push() - method that adds an element to the top of the stack.
     * @param element - element that you need to add.
     */
    public void push(Object element) {
        list.add(element, 0);
    }

    /**
     * pop() - method that removes and returns the top element of the stack.
     * @return the top element of the stack.
     */
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(0);
    }

    /**
     * peek() - method that returns the top element of the stack without removing it.
     * @return the top element of the stack without removing it.
     */
    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }

    /**
     * isEmpty() - method that returns true if the stack is empty or false if it is not.
     * @return true if the stack is empty or false if it is not.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * size() - method that returns the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    public int size() {
        return list.size();
    }
}