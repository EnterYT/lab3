import java.util.NoSuchElementException;
public class MyArrayListQueue extends MyArrayList{
    private MyArrayList list;

    MyArrayListQueue() {
        list = new MyArrayList<>();
    }

    /**
     * enqueue() - method that adds an element to the back of the queue.
     * @param element - element that you need to add.
     */
    public void enqueue(Object element) {
        list.add(element);
    }

    /**
     * dequeue() - method that removes and returns the front element of the queue.
     * @return the front element of the queue.
     */
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }

    /**
     * peek() - method that returns the front element of the queue without removing it.
     * @return the front element of the queue without removing it.
     */
    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    /**
     * isEmpty() - method that returns true if the queue is empty or false if it is not.
     * @return true if the queue is empty or false if it is not.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * size() - method that returns the number of elements in the queue.
     * @return the number of elements in the queue.
     */
    public int size() {
        return list.size();
    }
}