class Node {
    Question data;
    Node prev;
    Node next;

    public Node(Question data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    private Node head;
    private Node current;

    public void addQuestion(Question question) {
        Node newNode = new Node(question);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public Question getNext() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.data;
        }
        return null;
    }

    public Question getPrevious() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return current.data;
        }
        return null;
    }

    public Question getCurrent() {
        return current != null ? current.data : null;
    }
}
