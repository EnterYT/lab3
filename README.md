# lab3
# MyArrayListStack / MyLinkedListStack
# push() function

**Description**: Method that adds an element to the top of the stack.

**Solution**:

    public void push(T element) {
        list.add(element, 0);
    }
    
# pop() function

**Description**: Method that removes and returns the top element of the stack.

**Solution**:

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) list.remove(0);
    }
    
# peek() function

**Description**: Method that returns the top element of the stack without removing it.

**Solution**: 

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) list.get(0);
    }
    
# isEmpty() function

**Description**: Method that returns true if the stack is empty or false if it is not.

**Solution**: 

    public boolean isEmpty() {
        return list.size() == 0;
    }
    
# size() function

**Description**: Method that returns the number of elements in the stack.

**Solution**: 

    public int size() {
        return list.size();
    }
    
# MyArrayListQueue / MyLinkedListQueue
    
# enqueue() function

**Description**: Method that adds an element to the back of the queue.

**Solution**: 

    public void enqueue(T element) {
        list.add(element);
    }
    
# dequeue() function

**Description**: Method that removes and returns the front element of the queue.

**Solution**: 

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) list.remove(0);
    }
    
# peek() function

**Description**: Method that returns the top element of the stack without removing it.

**Solution**: 

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) list.get(0);
    }
    
# isEmpty() function

**Description**: Method that returns true if the stack is empty or false if it is not.

**Solution**: 

    public boolean isEmpty() {
        return list.size() == 0;
    }
    
# size() function

**Description**: Method that returns the number of elements in the stack.

**Solution**: 

    public int size() {
        return list.size();
    }
