import compositions.MusicComposition;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A custom list implementation for MusicComposition objects using a doubly linked list.
 */
public class MusicCompositionList implements List<MusicComposition> {

    /**
     * Node class representing each element in the doubly linked list.
     */
    private static class Node {
        MusicComposition data;
        Node prev;
        Node next;

        Node(MusicComposition data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty MusicCompositionList.
     */
    public MusicCompositionList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a MusicCompositionList with a single MusicComposition object.
     *
     * @param composition The MusicComposition object to add.
     */
    public MusicCompositionList(MusicComposition composition) {
        this();
        add(composition);
    }

    /**
     * Constructs a MusicCompositionList from a collection of MusicComposition objects.
     *
     * @param compositions The collection of MusicComposition objects.
     */
    public MusicCompositionList(Collection<? extends MusicComposition> compositions) {
        this();
        addAll(compositions);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the list contains a specific MusicComposition.
     *
     * @param o The MusicComposition object to check.
     * @return True if the list contains the object, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof MusicComposition)) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<MusicComposition> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public MusicComposition next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                MusicComposition data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // Suppress unchecked warning
        @SuppressWarnings("unchecked")
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(), size);
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = (T) current.data;
        }
        return array;
    }

    /**
     * Adds a MusicComposition to the end of the list.
     *
     * @param composition The MusicComposition to add.
     * @return True after adding the composition.
     */
    @Override
    public boolean add(MusicComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        Node newNode = new Node(composition);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o The object to remove.
     * @return True if the object was removed, false otherwise.
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof MusicComposition)) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Unlinks a node from the list.
     *
     * @param node The node to unlink.
     */
    private void unlink(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode == null) { // Node is head
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) { // Node is tail
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        node.data = null;
        size--;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends MusicComposition> c) {
        boolean modified = false;
        for (MusicComposition composition : c) {
            add(composition);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MusicComposition> c) {
        checkPositionIndex(index);
        boolean modified = false;
        for (MusicComposition composition : c) {
            add(index++, composition);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object obj : c) {
            while (remove(obj)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                Node next = current.next;
                unlink(current);
                current = next;
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public MusicComposition get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    @Override
    public MusicComposition set(int index, MusicComposition element) {
        checkElementIndex(index);
        Node targetNode = node(index);
        MusicComposition oldData = targetNode.data;
        targetNode.data = element;
        return oldData;
    }

    @Override
    public void add(int index, MusicComposition element) {
        checkPositionIndex(index);
        if (element == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        if (index == size) {
            add(element);
        } else {
            Node succ = node(index);
            Node pred = succ.prev;
            Node newNode = new Node(element);
            newNode.next = succ;
            newNode.prev = pred;
            succ.prev = newNode;
            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }
            size++;
        }
    }

    @Override
    public MusicComposition remove(int index) {
        checkElementIndex(index);
        Node targetNode = node(index);
        MusicComposition removedData = targetNode.data;
        unlink(targetNode);
        return removedData;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (!(o instanceof MusicComposition)) {
            return -1;
        }
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (!(o instanceof MusicComposition)) {
            return -1;
        }
        Node current = tail;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            index--;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<MusicComposition> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<MusicComposition> listIterator(int index) {
        checkPositionIndex(index);
        return new ListIterator<>() {
            private Node lastReturned = null;
            private Node nextNode = (index == size) ? null : node(index);
            private int nextIndex = index;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public MusicComposition next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                lastReturned = nextNode;
                nextNode = nextNode.next;
                nextIndex++;
                return lastReturned.data;
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            public MusicComposition previous() {
                if (!hasPrevious())
                    throw new NoSuchElementException();
                nextNode = (nextNode == null) ? tail : nextNode.prev;
                lastReturned = nextNode;
                nextIndex--;
                return lastReturned.data;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException();
                Node lastNext = lastReturned.next;
                unlink(lastReturned);
                if (nextNode == lastReturned) {
                    nextNode = lastNext;
                } else {
                    nextIndex--;
                }
                lastReturned = null;
            }

            @Override
            public void set(MusicComposition e) {
                if (lastReturned == null)
                    throw new IllegalStateException();
                lastReturned.data = e;
            }

            @Override
            public void add(MusicComposition e) {
                Node newNode = new Node(e);
                if (nextNode == null) {
                    if (tail == null) {
                        head = tail = newNode;
                    } else {
                        tail.next = newNode;
                        newNode.prev = tail;
                        tail = newNode;
                    }
                } else {
                    Node prevNode = nextNode.prev;
                    newNode.next = nextNode;
                    newNode.prev = prevNode;
                    nextNode.prev = newNode;
                    if (prevNode == null) {
                        head = newNode;
                    } else {
                        prevNode.next = newNode;
                    }
                }
                size++;
                nextIndex++;
                lastReturned = null;
            }
        };
    }

    @Override
    public List<MusicComposition> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        MusicCompositionList sublist = new MusicCompositionList();
        Node current = node(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(current.data);
            current = current.next;
        }
        return sublist;
    }

    /**
     * Retrieves the node at the specified index.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     */
    private Node node(int index) {
        Node current;
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    /**
     * Checks if the index is in the range of existing elements.
     *
     * @param index The index to check.
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Checks if the index is in the range of possible positions for new elements.
     *
     * @param index The index to check.
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Returns true if the index is in the range of existing elements.
     *
     * @param index The index to check.
     * @return True if index is valid, false otherwise.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Returns true if the index is in the range of possible positions for new elements.
     *
     * @param index The index to check.
     * @return True if index is valid, false otherwise.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     *
     * @param index The index that caused the exception.
     * @return The detail message.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
