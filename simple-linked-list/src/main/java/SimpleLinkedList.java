import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    private int size;
    private Node head;

    class Node{
        private T data;
        Node next;

        public Node()
        {

        }
        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    SimpleLinkedList(T[] values) {
        this.head = new Node(values[0]);
        Node temp = this.head;
        this.size = values.length;
        for(int i = 1; i < values.length; ++i)
        {
            Node element = new Node(values[i]);
            temp.next = element;
            temp = temp.next;
        }
    }

    void push(T value) {
        this.size = this.size + 1;
        if(this.head == null)
        {
            this.head = new Node(value);
            return;
        }
        Node temp = this.head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        Node element = new Node(value);
        element.next = temp.next;
        temp.next = element;
    }

    T pop() {
        if(this.size == 0)
            throw new NoSuchElementException();
        T popElement = null;
        if(this.size == 1)
        {
            this.size = 0;
            popElement = this.head.data;
            this.head = null;
            return popElement;
        }
        this.size = this.size - 1;
        Node temp = this.head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        popElement = temp.next.data;
        System.out.println(popElement);
        temp.next = temp.next.next;
        return popElement;
    }

    void reverse() {
        Node temp = null, tempHead = this.head, newHead = null;
        while(tempHead != null)
        {
            temp = tempHead.next;
            tempHead.next = newHead;
            newHead = tempHead;
            tempHead = temp;
        }
        this.head = newHead;
    }

    T[] asArray(Class<T> clazz) {

        T[] res = (T[])Array.newInstance(clazz,this.size);
        this.reverse();
        Node tempHead = this.head;
        for(int i=0;i<this.size;++i)
        {
            res[i] = tempHead.data;
            tempHead = tempHead.next;
        }
        return res;
    }

    int size() {
        return this.size;
    }
}
