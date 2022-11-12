package CardGameWar;

/*
 * Abler, Andrew Kevin M.
 * The Card Game War
 *
 */

class Node {
    // Attributes

    Object data;
    Node next;

    // Constructors

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {
    // Attributes

    private Node head = new Node(-1);
    public int size = 0; // Size of linked list in number of Node

    // Methods

    // Adds by default to the end
    /**
     * 
     * @param item
     */
    public void add(Object item) {
        addAfter(item, getNode(size));
    }

    /**
     * 
     * @param item
     * @param index
     */
    public void add(Object item, int index) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(item);
        }
        else {
            addAfter(item, getNode(index - 1));
        }
    }

    /**
     * 
     * @param item
     */
    public void addFirst(Object item) {
        Node first = new Node(item); // Create new first Node
        first.next = head.next;
        head.next = first;
        size++;
    }

    /**
     * 
     * @param item
     * @param target
     */
    public void addAfter(Object item, Node target) {
        Node after = new Node(item);
        after.next = target.next;
        target.next = after;
        size++;
    }

    /**
     * 
     * @return
     */
    public Object removeFirst() {
        if (size > 0) { 
            Node first = head.next;
            head.next = first.next;
            size--;

            return first.data;
        }

        return null;
    }

    /**
     * 
     * @param target
     * @return
     */
    public Object removeAfter(Node target) {
        if (target.next != null) {
            Node after = target.next;
            target.next = after.next;
            size--;

            return after.data;
        }

        return null;
    }

    /**
     * 
     * @param index
     * @return
     */
    public Node getNode(int index) {
        Node node = head;

        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        
        return node;
    }

    // Custom printList for cards
    /**
     * 
     * @param head
     */
    public void printList(Node head) {
        Node temp = head.next; // Start printing at node AFTER head

        while (temp != null) {
            System.out.print(temp.data.toString() + " ");
            temp = temp.next;
        }
    }
}
